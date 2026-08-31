#include <bits/stdc++.h>
using namespace std;
int t, n;
int p = 0;
bool used[120];
int siz[120];
int id[120];
set<int> S;
int allo(int sz) {
  for (int i = 1; i + sz - 1 <= n; i++) {
    if (used[i]) continue;
    int f = 0;
    for (int j = i; j < i + sz; j++) {
      if (used[j]) f = 1;
    }
    if (!f) {
      siz[i] = sz;
      for (int j = i; j < i + sz; j++) {
        used[j] = 1;
      }
      id[i] = ++p;
      S.insert(p);
      return p;
    }
  }
  return -1;
}
void eras(int ID) {
  for (int i = 1; i <= n; i++) {
    if (id[i] == ID) {
      id[i] = 0;
      for (int j = i; j < i + siz[i]; j++) used[j] = 0;
      siz[i] = 0;
      break;
    }
  }
  S.erase(ID);
}
void defrag() {
  for (int i = 2; i <= n; i++) {
    if (used[i] && !used[i - 1]) {
      int pos = i - 1;
      for (int j = 1; j < i; j++) {
        if (!used[j]) {
          pos = j;
          break;
        }
      }
      swap(used[i], used[pos]);
      swap(siz[i], siz[pos]);
      swap(id[i], id[pos]);
    }
  }
}
int main() {
  scanf("%d %d", &t, &n);
  memset(used, false, sizeof(used));
  while (t--) {
    string s;
    int tmp;
    cin >> s;
    if (s[0] == 'a') {
      cin >> tmp;
      int pp = allo(tmp);
      if (pp == -1)
        printf("NULL\n");
      else
        printf("%d\n", pp);
    } else if (s[0] == 'd') {
      defrag();
    } else {
      cin >> tmp;
      if (S.find(tmp) == S.end())
        printf("ILLEGAL_ERASE_ARGUMENT\n");
      else {
        eras(tmp);
      }
    }
  }
  return 0;
}
