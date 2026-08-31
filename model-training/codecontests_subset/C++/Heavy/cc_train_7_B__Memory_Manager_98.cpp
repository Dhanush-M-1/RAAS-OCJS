#include <bits/stdc++.h>
using namespace std;
int arr[1005];
struct node {
  int l = 0, r = 0;
  int num = 0;
};
int n, m, id = 0;
map<int, node> mp;
void state() {
  for (int i = 1; i <= m; i++) {
    cout << arr[i] << " ";
  }
  cout << endl;
}
int alloc(int insertlen) {
  for (int i = 1; i <= m; i++) {
    if (arr[i] == -1) {
      int len = 0;
      int j;
      for (j = i; j <= m; j++) {
        if (arr[j] != -1) {
          break;
        }
        len++;
        if (len >= insertlen) {
          break;
        }
      }
      if (len >= insertlen) {
        ++id;
        for (j = i; j <= i + len - 1; j++) {
          arr[j] = id;
        }
        int start = i;
        int end = start + insertlen - 1;
        node now;
        now.l = start, now.r = end;
        mp[id] = now;
        return id;
      } else {
        i = j;
      }
    }
  }
  return -1;
}
int erase(int idd) {
  node now = mp[idd];
  int l = now.l;
  int r = now.r;
  if (l == 0 && r == 0) return -1;
  for (int i = l; i <= r; i++) {
    arr[i] = -1;
  }
  mp[idd].l = mp[idd].r = mp[idd].num = 0;
  return 1;
}
void deflagment() {
  vector<node> q;
  for (int i = 1; i <= m; i++) {
    if (arr[i] != -1) {
      int j;
      for (j = i; j <= m; j++) {
        if (arr[j + 1] == -1 || arr[j + 1] != arr[j]) {
          break;
        }
      }
      int idd = arr[i];
      node now;
      now.l = mp[idd].l;
      now.r = mp[idd].r;
      now.num = idd;
      q.push_back(now);
      i = j + 1;
    }
  }
  memset(arr, -1, sizeof(arr));
  mp.clear();
  int lenid = 0;
  for (int i = 0; i < q.size(); i++) {
    node now = q[i];
    int idd = now.num;
    for (int j = now.l; j <= now.r; j++) {
      arr[++lenid] = idd;
    }
    int len = now.r - now.l + 1;
    int start = lenid - len + 1;
    now.l = start, now.r = lenid;
    mp[idd] = now;
  }
}
int main() {
  cin >> n >> m;
  memset(arr, -1, sizeof(arr));
  for (int i = 1; i <= n; i++) {
    string act;
    cin >> act;
    if (act[0] == 'a') {
      int n;
      cin >> n;
      int result = alloc(n);
      if (result == -1) {
        cout << "NULL" << endl;
      } else {
        cout << result << endl;
      }
    } else if (act[0] == 'e') {
      int n;
      cin >> n;
      int result = erase(n);
      if (result == -1) {
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      }
    } else {
      deflagment();
    }
  }
  return 0;
}
