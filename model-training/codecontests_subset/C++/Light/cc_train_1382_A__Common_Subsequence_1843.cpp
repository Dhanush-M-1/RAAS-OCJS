#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m, k = 0;
    cin >> n >> m;
    int a[n + 2];
    int b[m + 2];
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < m; i++) cin >> b[i];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          cout << "YES" << endl;
          cout << "1"
               << " " << a[i] << endl;
          k++;
          break;
        }
      }
      if (k > 0) break;
    }
    if (k == 0) cout << "NO" << endl;
  }
  return 0;
}
