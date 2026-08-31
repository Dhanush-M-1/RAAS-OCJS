#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 111;
long long a[MAXN], b[MAXN];
pair<long long, long long> dp[MAXN][MAXN * MAXN];
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long n, s = 0;
  cin >> n;
  for (long long i = 0; i < n; i++) cin >> a[i], s += a[i];
  for (long long i = 0; i < n; i++) cin >> b[i];
  dp[n - 1][0] = {0, 0};
  for (long long i = 1; i <= b[n - 1]; i++) dp[n - 1][i] = {1, -a[n - 1]};
  for (long long i = b[n - 1] + 1; i <= s; i++) dp[n - 1][i] = {1e18, a[n - 1]};
  for (long long i = n - 2; i > -1; i--) {
    dp[i][0] = {0, 0};
    for (long long j = 1; j <= s; j++) {
      dp[i][j] = dp[i + 1][j];
      pair<long long, long long> p = dp[i + 1][max(0ll, j - b[i])];
      p.first++;
      p.second -= a[i];
      dp[i][j] = min(dp[i][j], p);
    }
  }
  cout << dp[0][s].first << ' ' << s + dp[0][s].second;
}
