#include <bits/stdc++.h>
using namespace std;
template <typename T1, typename T2>
istream& operator>>(istream& in, pair<T1, T2>& a) {
  in >> a.first >> a.second;
  return in;
}
template <typename T1, typename T2>
ostream& operator<<(ostream& out, pair<T1, T2> a) {
  out << a.first << " " << a.second;
  return out;
}
template <typename T, typename T1>
T amax(T& a, T1 b) {
  if (b > a) a = b;
  return a;
}
template <typename T, typename T1>
T amin(T& a, T1 b) {
  if (b < a) a = b;
  return a;
}
const long long INF = 1e18;
const int32_t M = 1e9 + 7;
const int32_t MM = 998244353;
long long int pw(long long int a, long long int p = M - 2,
                 long long int MOD = M) {
  long long int result = 1;
  while (p > 0) {
    if (p & 1) result = a * result % MOD;
    a = a * a % MOD;
    p >>= 1;
  }
  return result;
}
const long long int N = 100005;
long long int x[N], h[N];
long long int dp[N][2];
void richierich() {
  long long int n;
  cin >> n;
  for (long long int i = 1; i < n + 1; i++) {
    cin >> x[i] >> h[i];
  }
  dp[1][0] = 1;
  dp[1][1] = (x[1] + h[1]) < x[2] ? 1 : 0;
  for (long long int i = 2; i < n + 1; i++) {
    dp[i][0] = max(dp[i - 1][0] + ((x[i] - h[i]) > x[i - 1]),
                   dp[i - 1][1] + ((x[i] - h[i]) > (x[i - 1] + h[i - 1])));
    if (i == n) continue;
    dp[i][1] = max(dp[i - 1][0] + ((x[i] + h[i]) < (x[i + 1])),
                   dp[i - 1][1] + ((x[i] + h[i]) < (x[i + 1])));
  }
  dp[n][1] = max(dp[n - 1][0] + 1, dp[n - 1][1] + 1);
  cout << max(dp[n][0], dp[n][1]) << "\n";
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long int t = 1;
  while (t--) richierich();
  return 0;
}
