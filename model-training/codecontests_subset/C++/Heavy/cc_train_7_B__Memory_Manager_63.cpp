#include <bits/stdc++.h>
using namespace std;
int t, n;
int a[100];
int cnt;
int main() {
  cin >> t >> n;
  string s;
  while (t--) {
    cin >> s;
    int x;
    if (s != "defragment") cin >> x;
    if (s == "alloc") {
      int tt = 0;
      int en = -1;
      for (int i = 0; i < n; i++) {
        if (a[i])
          tt = 0;
        else {
          tt++;
          if (tt == x) {
            en = i;
            break;
          }
        }
      }
      if (en == -1) {
        cout << "NULL\n";
        continue;
      }
      cnt++;
      for (int i = en - x + 1; i <= en; i++) {
        a[i] = cnt;
      }
      cout << cnt << "\n";
    }
    if (s == "erase") {
      if (x == 0) {
        cout << "ILLEGAL_ERASE_ARGUMENT\n";
        continue;
      }
      bool f = false;
      for (int i = 0; i < n; i++)
        if (a[i] == x) {
          f = true;
          a[i] = 0;
        }
      if (!f) {
        cout << "ILLEGAL_ERASE_ARGUMENT\n";
        continue;
      }
    }
    if (s == "defragment") {
      bool f[101];
      memset(f, 0, sizeof(f));
      for (int i = 1; i <= cnt; i++) {
        int aa = -1, j = 0, tt = 0;
        for (; j < n; j++) {
          if (aa != -1 && a[j] != aa) break;
          if (aa == -1 && a[j] && !f[a[j]])
            aa = a[j], tt++, a[j] = 0;
          else if (aa != -1 && aa == a[j])
            tt++, a[j] = 0;
        }
        if (aa == -1) break;
        f[aa] = true;
        for (int k = 0; k < n; k++) {
          if (a[k] == 0) {
            for (int i1 = k; i1 < k + tt; i1++) a[i1] = aa;
            break;
          }
        }
      }
    }
  }
  return 0;
}
