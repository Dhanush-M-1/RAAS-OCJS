#include <bits/stdc++.h>
using namespace std;
long long n, x[100005], h[100005];
long long dp[100005][3];
long long go(long long i, long long pichla) {
  if (i > n) return 0;
  if (dp[i][pichla] != -1) return dp[i][pichla];
  long long ans = go(i + 1, 0);
  long long add = 0;
  if (pichla == 2) add = h[i - 1];
  if (x[i] - h[i] > x[i - 1] + add) ans = max(ans, 1 + go(i + 1, 1));
  if (x[i] + h[i] < x[i + 1]) ans = max(ans, 1 + go(i + 1, 2));
  return dp[i][pichla] = ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long i, j;
  memset(dp, -1, sizeof dp);
  cin >> n;
  for (i = 1; i <= n; i++) {
    cin >> x[i] >> h[i];
  }
  x[0] = -1e17;
  h[0] = 0;
  x[n + 1] = 1e17;
  h[n + 1] = 0;
  cout << go(1, 0);
  return 0;
}
