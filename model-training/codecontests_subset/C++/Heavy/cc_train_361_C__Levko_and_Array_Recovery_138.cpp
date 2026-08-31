#include <bits/stdc++.h>
using namespace std;
struct p {
  int t, a, b, c;
} op[5100];
int arr[5100];
int arr2[5100];
bool vis[6000];
int main() {
  int n, m;
  int t, a, b, c;
  cin >> n >> m;
  for (int i = 0; i < n; i++) vis[i] = false;
  for (int i = 0; i < m; i++) {
    cin >> t >> a >> b >> c;
    a--;
    b--;
    op[i].t = t;
    op[i].a = a;
    op[i].b = b;
    op[i].c = c;
  }
  for (int i = m - 1; i >= 0; i--) {
    t = op[i].t;
    a = op[i].a;
    b = op[i].b;
    c = op[i].c;
    if (t == 1) {
      for (int j = a; j <= b; j++)
        if (vis[j]) arr[j] -= c;
    } else {
      for (int j = a; j <= b; j++) {
        if (vis[j])
          arr[j] = min(arr[j], c);
        else {
          vis[j] = true;
          arr[j] = c;
        }
      }
    }
  }
  for (int i = 0; i < n; i++) {
    arr2[i] = arr[i];
  }
  bool flag = true;
  int temp;
  for (int i = 0; i < m && flag; i++) {
    if (op[i].t == 1) {
      for (int j = op[i].a; j <= op[i].b; j++) arr[j] += op[i].c;
    } else {
      temp = arr[op[i].a];
      for (int j = op[i].a; j <= op[i].b; j++) temp = max(arr[j], temp);
      if (temp != op[i].c) flag = false;
    }
  }
  if (!flag)
    cout << "NO\n";
  else {
    cout << "YES\n";
    for (int i = 0; i < n; i++) {
      if (i) cout << " ";
      if (vis[i])
        cout << arr2[i];
      else
        cout << "0";
      cout << "\n";
    }
  }
  return 0;
}
