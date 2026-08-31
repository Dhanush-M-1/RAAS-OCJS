#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m, check = 0;
    cin >> n >> m;
    int a[n], b[m];
    for (int i = 0; i < n; ++i) cin >> a[i];
    for (int i = 0; i < m; ++i) cin >> b[i];
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (a[i] == b[j]) {
          cout << "YES\n";
          cout << 1 << " " << a[i] << endl;
          check++;
          break;
        }
      }
      if (check == 1) break;
    }
    if (check != 1) cout << "NO\n";
  }
  return 0;
}
