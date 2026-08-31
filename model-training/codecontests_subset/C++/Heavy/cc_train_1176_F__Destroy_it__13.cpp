#include <bits/stdc++.h>
using namespace std;
const long long N = 200005;
long long dp[N][10];
long long p, cur;
void solve() {
  long long n;
  cin >> n;
  for (long long i = 0; i < n + 1; i++) {
    for (long long j = 0; j < 10; j++) dp[i][j] = -1000000000000000007LL;
  }
  dp[0][0] = 0;
  for (long long i = 1; i < n + 1; i++) {
    long long k;
    cin >> k;
    vector<long long> vect[4];
    for (long long j = 0; j < k; j++) {
      long long c, d;
      cin >> c >> d;
      vect[c].push_back(d);
    }
    sort(vect[1].begin(), vect[1].end());
    sort(vect[2].begin(), vect[2].end());
    sort(vect[3].begin(), vect[3].end());
    long long mx1 = 0, mx2 = 0, mx3 = 0;
    if ((long long)vect[1].size()) mx1 = vect[1].back();
    if ((long long)vect[2].size()) mx2 = vect[2].back();
    if ((long long)vect[3].size()) mx3 = vect[3].back();
    if ((long long)vect[1].size() >= 3) {
      long long tot = 0;
      for (long long j = 1; j <= 3; j++) {
        tot += vect[1][(long long)vect[1].size() - j];
      }
      for (long long j = 0; j < 10; j++) {
        p = ((j - 3) + 10) % 10;
        cur = dp[i - 1][p] + tot;
        if (j <= 2) {
          cur += mx1;
        }
        dp[i][j] = max(dp[i][j], cur);
      }
    }
    if ((long long)vect[1].size() >= 2) {
      long long tot = 0;
      for (long long j = 1; j <= 2; j++) {
        tot += vect[1][(long long)vect[1].size() - j];
      }
      for (long long j = 0; j < 10; j++) {
        p = ((j - 2) + 10) % 10;
        cur = dp[i - 1][p] + tot;
        if (j <= 1) {
          cur += mx1;
        }
        dp[i][j] = max(dp[i][j], cur);
      }
    }
    if ((long long)vect[2].size() && (long long)vect[1].size()) {
      long long tot = mx1 + mx2;
      for (long long j = 0; j < 10; j++) {
        p = ((j - 2) + 10) % 10;
        cur = dp[i - 1][p] + tot;
        if (j <= 1) {
          cur += max(mx1, mx2);
        }
        dp[i][j] = max(dp[i][j], cur);
      }
    }
    long long tot = max(max(mx1, mx2), mx3);
    for (long long j = 0; j < 10; j++) {
      p = ((j - 1) + 10) % 10;
      cur = dp[i - 1][p] + tot;
      if (j == 0) {
        cur += tot;
      }
      dp[i][j] = max(dp[i][j], cur);
      dp[i][j] = max(dp[i][j], dp[i - 1][j]);
      if (dp[i][j] < 0) dp[i][j] = -1000000000000000007LL;
    }
  }
  long long ans = 0;
  for (long long i = 0; i < 10; i++) {
    ans = max(ans, dp[n][i]);
  }
  cout << ans;
}
signed main() {
  std::ios::sync_with_stdio(false);
  cin.tie(NULL);
  solve();
  return 0;
}
