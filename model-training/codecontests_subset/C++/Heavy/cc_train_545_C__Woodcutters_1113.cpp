#include <bits/stdc++.h>
using namespace std;
long long int n, xc[300001], h[300001], dp[300001][3];
int solve(int pos, int last, int las) {
  if (pos == n) return 1;
  if (dp[pos][last] != -1) return dp[pos][last];
  if (las < xc[pos] - h[pos]) {
    return dp[pos][last] =
               max(1 + solve(pos + 1, 0, xc[pos]), solve(pos + 1, 1, xc[pos]));
  } else {
    int ans = solve(pos + 1, 1, xc[pos]);
    if (xc[pos + 1] > xc[pos] + h[pos])
      ans = max(ans, 1 + solve(pos + 1, 2, xc[pos] + h[pos]));
    return dp[pos][last] = ans;
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n;
  memset(dp, -1, sizeof(dp));
  for (int i = 1; i <= n; ++i) cin >> xc[i] >> h[i];
  if (n <= 2) {
    cout << n;
    return 0;
  }
  int ans = 1 + solve(2, 0, xc[1]);
  cout << ans;
}
