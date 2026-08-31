#include <bits/stdc++.h>
using namespace std;
long long n, a[101], b[101];
vector<vector<long long>> dp(101, vector<long long>(10001, -10000000000));
signed main() {
  cin.tie(0);
  cout.tie(0);
  ios_base::sync_with_stdio(false);
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    cin >> a[i];
  }
  for (long long i = 1; i <= n; i++) {
    cin >> b[i];
  }
  dp[0][0] = 0;
  vector<vector<long long>> dp_new(101, vector<long long>(10001));
  dp_new = dp;
  dp[1][b[1]] = a[1];
  for (long long i = 2; i <= n; i++) {
    for (long long j = 1; j <= n; j++) {
      for (long long k = 1; k <= 10000; k++) {
        dp_new[j][k] = dp[j][k];
        if (k > b[i]) {
          dp_new[j][k] = max(dp_new[j][k], dp[j - 1][k - b[i]] + a[i]);
        }
      }
    }
    dp_new[1][b[i]] = max(dp_new[1][b[i]], a[i]);
    dp = dp_new;
  }
  sort(b + 1, b + n + 1);
  long long sm = 0;
  for (long long i = 1; i <= n; i++) sm += a[i];
  long long k;
  for (long long i = n; i >= 0; i--) {
    if (sm <= 0) {
      k = n - i;
      break;
    }
    sm -= b[i];
  }
  sm = 0;
  for (long long i = 1; i <= n; i++) sm += a[i];
  long long ans = 10000000000;
  for (long long i = sm; i <= 10000; i++) {
    ans = min(ans, sm - dp[k][i]);
  }
  cout << k << " " << ans << '\n';
}
