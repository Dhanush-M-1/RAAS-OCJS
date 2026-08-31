#include <bits/stdc++.h>
using namespace std;
constexpr int INF = 1e9 + 1;
constexpr long long LLINF = 1e18 + 1;
template <typename T>
T gcd(T a, T b) {
  return b ? gcd(b, a % b) : a;
}
template <typename T>
T lcm(T a, T b) {
  return a / gcd(a, b) * b;
}
map<long long, pair<int, long long> > dp;
pair<int, long long> rec(long long n) {
  if (dp.find(n) != dp.end()) return dp[n];
  long long sq = ceil(sqrt(n));
  int cnt = 0;
  pair<int, long long> ret;
  for (int i = 2; i < n && i <= sq; i++)
    if (n % i == 0) {
      ;
      ret = rec(i);
      cnt++;
      if (ret.first == 0) return dp[n] = pair<int, long long>(1, i);
      ret = rec(n / i);
      cnt++;
      if (ret.first == 0) return dp[n] = pair<int, long long>(1, n / i);
    }
  return dp[n] =
             (cnt ? pair<int, long long>(0, -1) : pair<int, long long>(1, 0));
}
int main() {
  ios_base::sync_with_stdio(false), cin.tie(0), cout.tie(0);
  long long n;
  while (cin >> n) {
    pair<int, long long> ans = rec(n);
    ans.first ? printf("1\n") : printf("2\n");
    if (ans.first) printf("%lld\n", ans.second);
  }
}
