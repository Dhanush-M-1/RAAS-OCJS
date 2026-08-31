#include <bits/stdc++.h>
using namespace std;
long long int min(long long int a, long long int b) { return (a < b) ? a : b; }
long long int max(long long int a, long long int b) { return (a > b) ? a : b; }
long long int fp(long long int a, long long int b) {
  if (b == 0) return 1;
  long long int x = fp(a, b / 2);
  x = (x * x) % 1000000007;
  if (b & 1) x = (x * a) % 1000000007;
  return x;
}
long long int factorial(long long int n) {
  long long int fact = 1;
  for (long long int i = 2; i <= n; i++) fact = fact * i;
  return fact;
}
long long int ncr(long long int n, long long int r) {
  return factorial(n) / (factorial(r) * factorial(n - r));
}
long long int binomialCoeff(long long int n, long long int k) {
  long long int dp[k + 1];
  memset(dp, 0, sizeof(dp));
  dp[0] = 1;
  for (long long int i = 1; i <= n; i++) {
    for (long long int j = min(i, k); j > 0; j--)
      dp[j] = (dp[j] + dp[j - 1]) % 1000000007;
  }
  return dp[k] % 1000000007;
}
void c_p_c() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
}
signed main() {
  c_p_c();
  long long int t;
  cin >> t;
  while (t--) {
    long long int n, m;
    cin >> n >> m;
    long long int a[n];
    for (long long int i = 0; i < n; i++) cin >> a[i];
    long long int b[m];
    for (long long int i = 0; i < m; i++) cin >> b[i];
    long long int f = 0;
    for (long long int i = 0; i < n; i++) {
      for (long long int j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          f = 1;
          cout << "YES"
               << "\n";
          cout << 1 << " " << a[i] << "\n";
          break;
        }
      }
      if (f) break;
    }
    if (!f)
      cout << "NO"
           << "\n";
  }
}
