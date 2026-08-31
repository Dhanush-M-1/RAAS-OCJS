#include <bits/stdc++.h>
using namespace std;
template <class _T>
inline void ina(_T a[], int n) {
  for (int i = 0; i < n; i++) In(a[i]);
}
int TEST_CASE = 0;
template <class _T>
inline _T pow(_T a, _T b, _T m) {
  a %= m;
  _T ans = 1 % m;
  while (b) {
    if (b & 1) ans *= a, ans %= m;
    a *= a;
    a %= m;
    b >>= 1;
  }
  return ans;
}
template <class _T>
inline _T pow(_T a, _T b) {
  _T ans = 1;
  while (b) {
    if (b & 1) ans *= a;
    a *= a;
    b >>= 1;
  }
  return ans;
}
template <class _T>
inline _T add(_T a, _T b, _T m) {
  return a >= m - b ? a - (m - b) : a + b;
}
template <class _T>
inline _T multiply(_T a, _T b, _T m) {
  _T ans = 0;
  if (b > a) swap(a, b);
  while (b) {
    if (b & 1) ans = add(ans, a, m);
    b >>= 1;
    a = add(a, a, m);
  }
  return ans;
}
template <class _T>
inline _T bigpow(_T a, _T b, _T m) {
  a %= m;
  _T ans = 1 % m;
  while (b) {
    if (b & 1) ans = multiply(ans, a, m);
    a = multiply(a, a, m);
    b >>= 1;
  }
  return ans;
}
template <class _T>
inline _T modinvers(_T a, _T m) {
  return m > 2000000000LL ? bigpow(a, m - 2, m) : pow(a, m - 2, m);
}
template <class _T>
_T _egcd(_T a, _T b, _T &x, _T &y) {
  if (!b) {
    x = 1, y = 0;
    return a;
  }
  _T _g = _egcd(b, a % b, x, y);
  _T xt = x;
  x = y, y = xt - (a / b) * y;
  return _g;
}
template <class _T>
inline _T fmodinvers(_T a, _T m) {
  _T x, y;
  _egcd(a, m, x, y);
  x %= m;
  if (x < 0) x += m;
  return x;
}
template <class _T>
inline _T _lcm(_T a, _T b) {
  return (a * b) / __gcd(a, b);
}
template <class T>
inline T SQ(T a) {
  return a * a;
}
long long SQRT(long long n) {
  long long e = sqrt(n * 1.0);
  long long l = max(0LL, e - 2), r = min(n, e + 2);
  long long ans = 0;
  while (l <= r) {
    long long m = ((l + r) >> 1);
    if (m * m <= n)
      ans = m, l = m + 1;
    else
      r = m - 1;
  }
  return ans;
}
long long CBRT(long long n) {
  long long e = cbrt(n * 1.0);
  long long l = max(0LL, e - 2), r = min(n, e + 2);
  long long ans = 0;
  while (l <= r) {
    long long m = ((l + r) >> 1);
    if (m * m * m <= n)
      ans = m, l = m + 1;
    else
      r = m - 1;
  }
  return ans;
}
const long double EPS = 1e-9;
const long double PI = acos(-1.0);
const int SIZE = 1e6;
long long mod = 1e9 + 7;
int mem[5][20], ch4[5][20], ch7[5][20];
char N[22];
int dp(int i, int c) {
  if (c < 0 || c > 4) return 0;
  if (i == 19) return !c;
  int &res = mem[c][i];
  if (~res) return res;
  res = 0;
  for (int f = 0; f <= 6; f++) {
    for (int s = 0; s + f <= 6; s++) {
      res = res | dp(i + 1, c * 10 + N[i] - '0' - 4 * f - 7 * s);
      if (res) {
        ch4[c][i] = f, ch7[c][i] = s;
        return res = 1;
      }
    }
  }
  return res;
}
char NM[6][20];
int main() {
  int tc;
  long long n;
  cin >> tc;
  while (tc--) {
    cin >> n;
    sprintf(N, "%019lld", n);
    memset(mem, -1, sizeof(mem));
    bool res = dp(0, 0);
    if (res) {
      for (int i = 0, c = 0; i < 19; i++) {
        int j = 0;
        for (; j < ch4[c][i]; j++) NM[j][i] = '4';
        for (; j < ch4[c][i] + ch7[c][i]; j++) NM[j][i] = '7';
        for (; j < 6; j++) NM[j][i] = '0';
        c = c * 10 + N[i] - '0' - ch4[c][i] * 4 - ch7[c][i] * 7;
      }
      for (int j = 0; j < 6; j++) {
        sscanf(NM[j], "%lld\n", &n);
        cout << n << " ";
      }
      cout << '\n';
    } else
      cout << -1 << '\n';
  }
  return 0;
}
