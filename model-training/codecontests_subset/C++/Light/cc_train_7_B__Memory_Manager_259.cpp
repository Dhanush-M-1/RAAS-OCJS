#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, m, x, p = 1;
  cin >> t >> m;
  vector<int> a(1000, 0);
  while (t--) {
    string s;
    cin >> s;
    if (s == "alloc") {
      cin >> x;
      bool d = 0;
      for (int i = 1; i + (x - 1) <= m; i++) {
        bool k = 1;
        for (int j = i; j <= i + x - 1; j++) {
          if (a[j] > 0) {
            k = 0;
            break;
          }
        }
        if (k) {
          d = 1;
          for (int j = i; j <= i + x - 1; j++) a[j] = p;
          break;
        }
      }
      if (d) {
        cout << p << endl;
        p++;
      } else {
        cout << "NULL" << endl;
      }
    } else if (s == "erase") {
      cin >> x;
      if (x < 1) {
        cout << "ILLEGAL_ERASE_ARGUMENT\n";
        continue;
      }
      bool o = 0;
      for (int i = 1; i <= m; i++) {
        if (a[i] == x) {
          a[i] = 0;
          o = 1;
        }
      }
      if (!o) {
        cout << "ILLEGAL_ERASE_ARGUMENT\n";
      }
    } else {
      int l = -1;
      for (int i = 1; i <= m; i++) {
        if (a[i] == 0) {
          l = i;
          break;
        }
      }
      if (l == -1) continue;
      for (int i = l; i <= m; i++) {
        if (a[i] > 0) {
          a[l] = a[i];
          a[i] = 0;
          l++;
        }
      }
    }
  }
  return 0;
}
