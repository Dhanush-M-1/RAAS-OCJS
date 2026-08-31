#include <bits/stdc++.h>
using namespace std;
using ll = long long;
const int mod = 1e9 + 7;
ll pwr(ll a, ll b);
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  vector<int> x(n), h(n);
  for (int i = 0; i < n; i++) cin >> x[i] >> h[i];
  if (n <= 2) {
    cout << n << "\n";
    return 0;
  }
  int dp[3][n + 5];
  memset(dp, 0, sizeof dp);
  for (int i = 1; i < n - 1; i++) {
    if (x[i - 1] + h[i - 1] < x[i] - h[i])
      dp[0][i] = 1 + max(dp[0][i - 1], max(dp[1][i - 1], dp[2][i - 1]));
    else if (x[i - 1] < x[i] - h[i])
      dp[0][i] = 1 + max(dp[0][i - 1], dp[1][i - 1]);
    dp[1][i] = max(dp[0][i - 1], max(dp[1][i - 1], dp[2][i - 1]));
    if (x[i] + h[i] < x[i + 1]) {
      dp[2][i] = dp[1][i] + 1;
    }
  }
  cout << 2 + max(dp[0][n - 2], max(dp[1][n - 2], dp[2][n - 2])) << "\n";
}
ll pwr(ll a, ll b) {
  a %= mod;
  ll res = 1;
  while (b > 0) {
    if (b & 1) res = res * a % mod;
    a = a * a % mod;
    b >>= 1;
  }
  return res;
}
