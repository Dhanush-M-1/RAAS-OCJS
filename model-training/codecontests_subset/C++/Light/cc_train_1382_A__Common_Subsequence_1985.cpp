#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    vector<bool> seen(2000);
    for (int i = 0; i < n; i++) {
      int k;
      cin >> k;
      seen[k] = true;
    }
    int ans = -1;
    for (int j = 0; j < m; j++) {
      int k;
      cin >> k;
      if (seen[k]) {
        ans = k;
      }
    }
    if (ans == -1)
      cout << "NO"
           << "\n";
    else {
      cout << "YES"
           << "\n";
      cout << 1 << " " << ans << "\n";
    }
  }
  return 0;
}
