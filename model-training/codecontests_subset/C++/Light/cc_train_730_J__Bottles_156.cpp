#include <bits/stdc++.h>
using namespace std;
long long dp[2][101][10001];
signed main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  ;
  memset(dp, -1, sizeof(dp));
  long long n, tot = 0;
  cin >> n;
  long long a[n], b[n], c[n];
  for (long long i = 0; i < n; i++) cin >> a[i], tot += a[i];
  for (long long i = 0; i < n; i++) cin >> b[i], c[i] = b[i];
  sort(c, c + n, greater<long long>());
  long long mx = -1;
  long long sum = 0;
  for (long long i = 0;; i++) {
    sum += c[i];
    if (sum >= tot) {
      mx = i + 1;
      cout << mx << ' ';
      break;
    }
  }
  dp[1][0][0] = 0;
  for (long long i = 0; i < n; i++) {
    long long cur = i & 1;
    long long prev = cur ^ 1;
    for (long long j = 0; j <= mx; j++) {
      for (long long k = 0; k <= 10000; k++) {
        dp[cur][j][k] = dp[prev][j][k];
        if (j && k >= b[i] && dp[prev][j - 1][k - b[i]] != -1)
          dp[cur][j][k] = max(dp[cur][j][k], dp[prev][j - 1][k - b[i]] + a[i]);
      }
    }
  }
  long long cur = ((n - 1) & 1);
  long long mx2 = 0;
  for (long long i = tot; i <= 10000; i++) mx2 = max(mx2, dp[cur][mx][i]);
  cout << tot - mx2;
}
