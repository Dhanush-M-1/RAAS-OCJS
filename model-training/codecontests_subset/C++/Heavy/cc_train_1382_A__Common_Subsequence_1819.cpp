#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
long long power(long long a, long long n) {
  a %= 1000000007;
  if (n == 1) return a;
  if (n == 0) return 1;
  if (n % 2)
    return (a * (power((a * a) % 1000000007, n / 2) % 1000000007)) % 1000000007;
  return power((a * a) % 1000000007, n / 2) % 1000000007;
}
const long long inf = (long long)1e18;
long long inverse(long long x) { return power(x, 1000000007 - 2) % 1000000007; }
void solve() {
  long long n, m;
  cin >> n >> m;
  vector<long long> a(n + 5), b(m + 5), c1(1005), c2(1005);
  for (long long i = 1; i < n + 1; ++i) cin >> a[i], c1[a[i]] = 1;
  for (long long i = 1; i < m + 1; ++i) cin >> b[i], c2[b[i]] = 1;
  for (long long i = 1; i < 1001; ++i)
    if (c1[i] > 0 && c2[i] > 0) {
      cout << "YES\n" << 1 << " " << i << "\n";
      return;
    }
  cout << "NO\n";
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  long long T = 1;
  cin >> T;
  for (long long t = 1; t < T + 1; ++t) {
    solve();
  }
  return 0;
}
