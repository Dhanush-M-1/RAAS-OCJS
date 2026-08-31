#include <bits/stdc++.h>
using namespace std;
int a[1000], b[1000];
int main() {
  int t, m, k = 0;
  cin >> t >> m;
  for (; t > 0; t--) {
    string s;
    cin >> s;
    if (s == "alloc") {
      int n;
      cin >> n;
      bool pr = 0;
      for (int i = 0; i < m; i++)
        if (i + n <= m) {
          bool p = 1;
          for (int j = i; j < i + n; j++)
            if (a[j] > 0) p = 0;
          if (p) {
            k++;
            cout << k << endl;
            for (int j = i; j < i + n; j++) a[j] = k;
            pr = 1;
            break;
          }
        }
      if (!pr) cout << "NULL" << endl;
    } else if (s == "erase") {
      int x;
      cin >> x;
      bool pr = 0;
      if (x > 0)
        for (int i = 0; i < m; i++)
          if (a[i] == x) {
            pr = 1;
            a[i] = 0;
          }
      if (!pr) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
    } else {
      int x = 0;
      for (int i = 0; i < m; i++) {
        if (a[i] > 0) {
          b[x] = a[i];
          x++;
        }
        a[i] = 0;
      }
      for (int i = 0; i < x; i++) a[i] = b[i];
    }
  }
  return 0;
}
