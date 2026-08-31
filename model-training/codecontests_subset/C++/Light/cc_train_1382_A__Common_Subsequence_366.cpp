#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    int a[n], b[m];
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < m; i++) cin >> b[i];
    int ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (b[j] == a[i]) {
          ans = a[i];
          break;
        }
      }
      if (ans != 0) break;
    }
    if (ans == 0)
      cout << "NO" << '\n';
    else {
      cout << "YES" << '\n';
      cout << 1 << " " << ans << '\n';
    }
  }
  return 0;
}
