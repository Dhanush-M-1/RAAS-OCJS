#include <bits/stdc++.h>
using namespace std;
int t, m;
int a[128], id = 1;
int main() {
  cin >> t >> m;
  for (int i = 0; i < t; ++i) {
    string q;
    cin >> q;
    switch (q[0]) {
      case 'a': {
        int k;
        bool ok = false;
        cin >> k;
        for (int i = 0; i + k <= m; ++i) {
          int j = 0;
          for (j = 0; j < k && a[i + j] == 0; ++j)
            ;
          if (j == k) {
            ok = true;
            for (int j = 0; j < k; ++j) a[i + j] = id;
            break;
          }
        }
        if (ok)
          cout << id++ << endl;
        else
          puts("NULL");
        break;
      }
      case 'e': {
        bool ok = false;
        int x;
        cin >> x;
        if (x > 0) {
          for (int i = 0; i < m; ++i)
            if (a[i] == x) ok = true, a[i] = 0;
        }
        if (!ok) puts("ILLEGAL_ERASE_ARGUMENT");
        break;
      }
      case 'd':
        for (int i = remove(a, a + m, 0) - a; i < m; ++i) a[i] = 0;
        break;
    }
  }
  return 0;
}
