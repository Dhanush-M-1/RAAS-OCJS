#include <bits/stdc++.h>
using namespace std;
const long long maxn = 2e5 + 888;
long long dp[maxn][12];
void solve() {
  long long n;
  scanf("%lld", &n);
  memset(dp, -1, sizeof(dp));
  dp[0][1] = 0;
  vector<long long> v[4];
  for (long long i = 1; i <= n; i++) {
    for (long long j = 0; j < 4; j++) v[j].clear();
    long long k;
    scanf("%lld", &k);
    while (k--) {
      long long c, d;
      scanf("%lld %lld", &c, &d);
      v[c].push_back(d);
    }
    for (long long j = 1; j <= 3; j++) {
      sort(v[j].begin(), v[j].end());
      reverse(v[j].begin(), v[j].end());
    }
    for (long long prec = 0; prec <= 9; prec++) {
      if (dp[i - 1][prec] < 0) continue;
      long long val = LLONG_MIN / 10;
      if (!v[1].empty()) val = max(val, v[1][0]);
      if (!v[2].empty()) val = max(val, v[2][0]);
      if (!v[3].empty()) val = max(val, v[3][0]);
      if (prec == 0) val *= 2;
      if (val > 0)
        dp[i][(prec + 1) % 10] =
            max(dp[i][(prec + 1) % 10], dp[i - 1][prec] + val);
      val = LLONG_MIN / 10;
      if (!v[1].empty() && !v[2].empty()) {
        long long temp = v[1][0] + v[2][0];
        long long mx = max(v[1][0], v[2][0]);
        if (prec == 0 || prec == 9) temp += mx;
        val = max(val, temp);
      }
      if (v[1].size() >= 2) {
        long long temp = v[1][0] + v[1][1];
        long long mx = max(v[1][0], v[1][1]);
        if (prec == 0 || prec == 9) temp += mx;
        val = max(val, temp);
      }
      if (val > 0)
        dp[i][(prec + 2) % 10] =
            max(dp[i][(prec + 2) % 10], dp[i - 1][prec] + val);
      val = LLONG_MIN / 10;
      if (v[1].size() >= 3) {
        long long temp = v[1][0] + v[1][1] + v[1][2];
        long long mx = max(v[1][0], max(v[1][2], v[1][1]));
        if (prec == 0 || prec == 9 || prec == 8) temp += mx;
        val = max(val, temp);
      }
      if (val > 0)
        dp[i][(prec + 3) % 10] =
            max(dp[i][(prec + 3) % 10], dp[i - 1][prec] + val);
      dp[i][prec] = max(dp[i][prec], dp[i - 1][prec]);
    }
  }
  long long ans = 0;
  for (long long i = 0; i <= 9; i++) ans = max(ans, dp[n][i]);
  cout << ans << endl;
}
signed main() { solve(); }
