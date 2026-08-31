#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    vector<int> a(n), b(m);
    vector<bool> was(1005, false);
    int ans = 0;
    for (int i = 0; i < n; ++i) cin >> a[i], was[a[i]] = true;
    for (int i = 0; i < m; ++i) {
      cin >> b[i];
      if (was[b[i]]) {
        ans = b[i];
      }
    }
    if (!ans) {
      cout << "NO\n";
      continue;
    }
    cout << "YES\n";
    cout << 1 << " " << ans << "\n";
  }
}
