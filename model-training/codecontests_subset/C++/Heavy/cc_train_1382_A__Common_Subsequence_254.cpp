#include <bits/stdc++.h>
using namespace std;
long long power(long long x, long long y, long long mod) {
  long long res = 1;
  while (y) {
    if (y & 1) res = (res * x) % mod;
    y = y >> 1;
    x = (x * x) % mod;
  }
  return res;
}
long long modInverse(long long a, long long m) {
  long long m0 = m;
  long long y = 0, x = 1;
  if (m == 1) return 0;
  while (a > 1) {
    long long q = a / m;
    long long t = m;
    m = a % m, a = t;
    t = y;
    y = x - q * y;
    x = t;
  }
  if (x < 0) x += m0;
  return x;
}
long long binomial(long long n, long long k) {
  long long res = 1;
  if (k > n - k) k = n - k;
  for (long long i = 0; i < k; ++i) {
    res *= (n - i);
    res /= (i + 1);
  }
  return res;
}
void doper() {}
int32_t main() {
  doper();
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  long long T;
  cin >> T;
  while (T--) {
    long long n, m, x;
    cin >> n >> m;
    map<long long, long long> mp;
    while (n--) {
      cin >> x;
      mp[x]++;
    }
    long long ans, f = 0;
    while (m--) {
      cin >> x;
      if (mp[x]) {
        f = 1;
        ans = x;
      }
    }
    if (f) {
      cout << "YES\n";
      cout << 1 << " " << ans;
      cout << "\n";
      ;
    } else
      cout << "NO\n";
  }
  return 0;
}
