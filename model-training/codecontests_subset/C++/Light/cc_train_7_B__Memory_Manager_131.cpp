#include <bits/stdc++.h>
using namespace std;
int t, m;
int v[105];
int main() {
  cin >> t >> m;
  string op;
  int i, j, n, k = 1;
  for (long long i = 0; i <= m; i++) v[i] = 0;
  while (t--) {
    cin >> op;
    if (op[0] == 'd') {
      for (i = 0, j = 0; i < m; i++)
        if (v[i]) v[j++] = v[i];
      for (; j < m; j++) v[j] = 0;
    } else {
      cin >> n;
      if (op[0] == 'a') {
        for (i = 0; i <= m - n; i++) {
          for (j = i; j < i + n; j++)
            if (v[j] != 0) break;
          if (j == i + n) break;
        }
        if (i <= m - n) {
          cout << k << endl;
          for (j = i; j < i + n; j++) v[j] = k;
          ;
          k++;
        } else
          cout << "NULL" << endl;
      } else {
        int f = 0;
        for (i = 0; i < m; i++)
          if (v[i] && v[i] == n) {
            v[i] = 0;
            f = 1;
          }
        if (!f) cout << "ILLEGAL_ERASE_ARGUMENT" << endl;
      }
    }
  }
  return 0;
}
