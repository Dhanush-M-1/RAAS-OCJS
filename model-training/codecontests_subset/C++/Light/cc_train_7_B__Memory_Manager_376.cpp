#include <bits/stdc++.h>
using namespace std;
int xot[101];
int main() {
  int n, m, t, d, i, j, tart = 0, bor, joy;
  string s;
  cin >> n >> m;
  for (t = 1; t <= n; t++) {
    cin >> s;
    if (s == "alloc") {
      cin >> d;
      bor = 0;
      for (i = 1; i <= m - d + 1 && bor == 0; i++) {
        joy = 0;
        for (j = i; j <= i + d - 1; j++)
          if (xot[j] == 0) joy++;
        if (joy == d) {
          bor = 1;
          tart++;
          for (j = i; j <= i + d - 1; j++) xot[j] = tart;
        }
      }
      if (bor == 0)
        cout << "NULL" << endl;
      else
        cout << tart << endl;
    }
    if (s == "erase") {
      cin >> d;
      if (d <= 0)
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      else {
        bor = 0;
        for (i = 1; i <= m && bor == 0; i++)
          if (xot[i] == d) bor = i;
        if (bor == 0)
          cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
        else {
          j = bor;
          while (xot[j] == d) {
            xot[j] = 0;
            j++;
          }
        }
      }
    }
    if (s == "defragment") {
      for (i = 1; i <= m; i++)
        if (xot[i] == 0) {
          bor = 0;
          for (j = i; j <= m && bor == 0; j++)
            if (xot[j] > 0) {
              bor = 1;
              xot[i] = xot[j];
              xot[j] = 0;
            }
          if (bor == 0) i = m;
        }
    }
  }
  return 0;
}
