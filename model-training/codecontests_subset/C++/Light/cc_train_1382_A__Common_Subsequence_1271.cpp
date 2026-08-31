#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int T;
  cin >> T;
  while (T--) {
    int n, m;
    cin >> n >> m;
    map<int, int> mp;
    for (int i = 0; i < n; i++) {
      int x;
      cin >> x;
      mp[x] = i + 1;
    }
    int ans = -1;
    for (int i = 0; i < m; i++) {
      int x;
      cin >> x;
      if (mp[x] != 0) ans = x;
    }
    if (ans != -1) {
      cout << "YES\n";
      cout << 1 << " " << ans << "\n";
    } else {
      cout << "NO\n";
    }
  }
  return 0;
}
