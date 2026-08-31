#include <bits/stdc++.h>
using namespace std;
long long a[1009], b[1009], n, m, t, ans;
int main() {
  cin >> t;
  while (t--) {
    cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> a[i];
    for (int i = 0; i < m; i++) cin >> b[i];
    ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i] == b[j]) ans = a[i];
      }
    }
    if (!ans)
      cout << "NO\n";
    else
      cout << "YES\n1 " << ans << "\n";
  }
  return 0;
}
