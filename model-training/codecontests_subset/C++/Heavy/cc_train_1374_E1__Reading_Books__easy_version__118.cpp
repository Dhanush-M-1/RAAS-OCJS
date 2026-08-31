#include <bits/stdc++.h>
using namespace std;
const long long int INF = (long long int)1e18;
const long long int MOD = 1000 * 1000 * 1000 + 7;
const long long int maxn = (long long int)1e5 + 10, L = 23;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long int T = 1;
  while (T--) {
    long long int n, k;
    cin >> n >> k;
    vector<vector<long long int>> tp(3);
    for (long long int i = 0; i < n; ++i) {
      long long int t, a, b;
      cin >> t >> a >> b;
      if (!a && !b) continue;
      if (!a && b) tp[0].push_back(t);
      if (a && !b) tp[1].push_back(t);
      if (a && b) tp[2].push_back(t);
    }
    for (long long int i = 0; i < 3; ++i) sort(tp[i].begin(), tp[i].end());
    vector<long long int> dp(tp[2].size(), 0);
    for (long long int i = 0; i < tp[2].size(); ++i) {
      dp[i] = (!i ? tp[2][i] : dp[i - 1] + tp[2][i]);
    }
    long long int ans = INF, mn = min({k, (long long int)tp[0].size(),
                                       (long long int)tp[1].size()});
    if (dp.size() >= k) {
      ans = dp[k - 1];
    }
    long long int a = 0, b = 0;
    for (long long int i = 0; i < mn; ++i) {
      a += tp[0][i];
      b += tp[1][i];
      long long int want = k - i - 2;
      if (want >= dp.size()) continue;
      ans = min(ans, (want >= 0 ? dp[want] : 0ll) + a + b);
    }
    if (ans == INF) ans = -1;
    cout << ans << '\n';
  }
  return 0;
}
