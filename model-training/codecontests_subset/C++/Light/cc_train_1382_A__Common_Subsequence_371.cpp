#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
const int MOD = 1e9 + 7, MAX = 1e6 + 5;
const long long INF = 1e18 + 5;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    set<int> S;
    for (int i = 0; i < n; i++) {
      int x;
      cin >> x;
      S.insert(x);
    }
    int ans = -1;
    for (int i = 0; i < m; i++) {
      int x;
      cin >> x;
      if (S.count(x)) {
        ans = x;
      }
    }
    if (ans != -1) {
      cout << "YES" << endl;
      cout << 1 << " " << ans << endl;
    } else
      cout << "NO" << endl;
  }
}
