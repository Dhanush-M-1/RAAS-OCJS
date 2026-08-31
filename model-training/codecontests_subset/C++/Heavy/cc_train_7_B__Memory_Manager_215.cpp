#include <bits/stdc++.h>
using namespace std;
int a[101];
int main() {
  int t, m, n, k, x, h, l = 1, i;
  string s;
  bool flag = true;
  cin >> t >> m;
  for (int y = 1; y <= t; y++) {
    cin >> s;
    if (s != "defragment") cin >> n;
    if (s == "alloc") {
      flag = true;
      k = 1;
      for (i = 1; i <= m; i++) {
        if (!a[i] && flag) k = i, flag = false;
        while (!a[i] && !flag) i++;
        if (!flag) {
          i--;
          if (i > m) i = m;
          if (i - k + 1 >= n) {
            for (int j = k; j <= k + n - 1; j++) a[j] = l;
            cout << l << endl;
            l++;
            break;
          } else
            flag = true;
        }
      }
      if (i == m + 1) {
        cout << "NULL" << endl;
      }
    }
    if (s == "erase") {
      flag = true;
      for (int i = 1; i <= m; i++)
        if (a[i] == n) a[i] = 0, flag = false;
      if (flag || !n) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    }
    if (s == "defragment") {
      flag = true;
      for (int i = 1; i <= m; i++)
        if (!a[i] && flag) x = i, flag = false;
      for (i = x + 1; i <= m; i++) {
        if (a[i] && x == 1) {
          a[x++] = a[i];
          a[i] = 0;
        } else if (a[i] && x > 1) {
          a[x++] = a[i];
          a[i] = 0;
        }
      }
    }
  }
  return 0;
}
