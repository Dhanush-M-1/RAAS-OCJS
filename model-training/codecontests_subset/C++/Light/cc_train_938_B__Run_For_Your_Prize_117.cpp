#include <bits/stdc++.h>
using namespace std;
long long be(long long a, long long b, long long mod) {
  if (b == 0) return 1;
  if (b % 2 == 1)
    return (a * be(a, b - 1, mod)) % mod;
  else
    return (be(a, b / 2, mod) * be(a, b / 2, mod)) % mod;
}
const long long mod = 998244353;
const long long siz = 2 * (1e5 + 1);
const long long logi = 21;
const double epsilon = 1e-6;
long long prime[siz];
bool cmp(const long long &a, const long long &b) { return (abs(a - b) > 1); }
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t;
  t = 1;
  while (t--) {
    long long n;
    cin >> n;
    long long a[n];
    for (long long i = 0; i < n; i++) {
      cin >> a[i];
    }
    long long f = 1e6;
    long long ans = INT_MAX;
    for (long long i = 0; i < n; i++) {
      long long d1 = INT_MIN;
      long long d2 = INT_MIN;
      d1 = a[i] - 1;
      if (i + 1 < n) {
        d2 = f - a[i];
      }
      ans = min(ans, max(d1, d2));
    }
    for (long long i = n - 1; i >= 0; i--) {
      long long d1 = INT_MIN;
      long long d2 = INT_MIN;
      if (i - 1 >= 0) {
        d1 = a[i - 1] - 1;
      }
      d2 = f - a[i];
      ans = min(ans, max(d1, d2));
    }
    cout << ans << "\n";
  }
}
