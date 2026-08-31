#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long xyp(long long x, long long y) {
  long long res = 1;
  while (y > 0) {
    if (y % 2 == 1) res = (res * x) % 1000000007;
    x = (x * x) % 1000000007;
    y /= 2;
  }
  return res % 1000000007;
}
long long inv(long long x) { return xyp(x, 1000000007 - 2); }
long long inv_euclid(long long a, long long m = 1000000007) {
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
bool isp(long long a) {
  if (a == 2) return true;
  if (a == 1) return false;
  for (long long x = 2; x <= sqrt(a) + 1; x++)
    if (a % x == 0) return false;
  return true;
}
long long add(long long a, long long b) {
  return (a % 1000000007 + b % 1000000007 +
          ((8000000000000000064LL) / 1000000007) * 1000000007) %
         1000000007;
}
long long sub(long long a, long long b) {
  return (a % 1000000007 - b % 1000000007 +
          ((8000000000000000064LL) / 1000000007) * 1000000007) %
         1000000007;
}
long long mul(long long a, long long b) {
  return ((a % 1000000007) * (b % 1000000007) +
          ((8000000000000000064LL) / 1000000007) * 1000000007) %
         1000000007;
}
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long _o_;
  cin >> _o_;
  while (_o_--) {
    long long n;
    cin >> n;
    long long a[n];
    for (auto &z : a) cin >> z;
    if (a[0] + a[1] <= a[n - 1]) {
      cout << 1 << ' ' << 2 << ' ' << n << '\n';
    } else
      cout << -1 << '\n';
  }
}
