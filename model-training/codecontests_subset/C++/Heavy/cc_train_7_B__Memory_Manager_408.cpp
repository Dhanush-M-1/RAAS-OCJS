#include <bits/stdc++.h>
using namespace std;
int c[110];
int t, m, sum;
int main() {
  cin >> t >> m;
  for (int i = 1; i <= m; i++) c[i] = -1;
  bool flag;
  while (t--) {
    string x;
    cin >> x;
    int y;
    if (x == "alloc") {
      bool f = false;
      cin >> y;
      flag = false;
      for (int i = 1; i <= m - y + 1; i++) {
        if (c[i] == -1) {
          flag = true;
          for (int j = i; j <= i + y - 1; j++)
            if (c[j] != -1) flag = false;
          if (flag) {
            sum++;
            for (int j = i; j <= i + y - 1; j++) c[j] = sum;
            cout << sum << endl;
            f = true;
          }
        }
        if (flag) break;
      }
      if (!f) cout << "NULL" << endl;
    } else if (x == "erase") {
      cin >> y;
      bool f = false;
      if (y > 0) {
        for (int i = 1; i <= m; i++)
          if (c[i] == y) {
            c[i] = -1;
            f = true;
          }
        if (!f) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      } else
        cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    } else {
      int l = 1;
      for (int i = 1; i <= m; i++) {
        if (c[i] != -1) {
          c[l++] = c[i];
          if (i != l - 1) c[i] = -1;
        }
      }
    }
  }
  return 0;
}
