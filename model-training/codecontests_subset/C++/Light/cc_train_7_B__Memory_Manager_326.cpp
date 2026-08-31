#include <bits/stdc++.h>
using namespace std;
int a[115];
int t, m;
int main() {
  cin >> t >> m;
  int cnt = 1;
  while (t--) {
    string s;
    cin >> s;
    if (s == "alloc") {
      int n;
      cin >> n;
      int id = -1;
      for (int i = 0; i <= m - n; i++) {
        bool ok = true;
        for (int j = 0; j < n; j++)
          if (a[i + j] != 0) {
            ok = false;
            break;
          }
        if (ok) {
          id = i;
          break;
        }
      }
      if (id == -1)
        puts("NULL");
      else {
        cout << cnt << endl;
        for (int i = 0; i < n; i++) a[id + i] = cnt;
        cnt++;
      }
    }
    if (s == "erase") {
      int x;
      cin >> x;
      if (x == 0) {
        puts("ILLEGAL_ERASE_ARGUMENT");
        continue;
      }
      bool ok = false;
      for (int i = 0; i < m; i++)
        if (a[i] == x) {
          ok = true;
          a[i] = 0;
        }
      if (!ok) puts("ILLEGAL_ERASE_ARGUMENT");
    }
    if (s == "defragment") {
      int w = 0;
      for (int i = 0; i < m; i++)
        if (a[i] != 0) a[w++] = a[i];
      for (int i = w; i < m; i++) a[i] = 0;
    }
  }
  return 0;
}
