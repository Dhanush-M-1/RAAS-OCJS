#include <bits/stdc++.h>
using namespace std;
template <class T>
inline bool In(T &a) {
  return (bool)(cin >> a);
}
template <class T1, class T2>
inline bool In(T1 &a, T2 &b) {
  return (bool)(cin >> a >> b);
}
template <class T1, class T2, class T3>
inline bool In(T1 &a, T2 &b, T3 &c) {
  return (bool)(cin >> a >> b >> c);
}
template <class T1, class T2, class T3, class T4>
inline bool In(T1 &a, T2 &b, T3 &c, T4 &d) {
  return (bool)(cin >> a >> b >> c >> d);
}
inline bool Line(string &a) { return (bool)(getline(cin, a)); }
template <class _T>
inline void ina(_T a[], int n) {
  int i;
  for (i = 0; i < n; i++) In(a[i]);
}
template <class T>
inline bool Pr(T a) {
  return (bool)(cout << a);
}
template <class T1, class T2>
inline bool Pr(T1 a, T2 b) {
  return (bool)(cout << a << " " << b);
}
template <class T1, class T2, class T3>
inline bool Pr(T1 a, T2 b, T3 c) {
  return (bool)(cout << a << " " << b << " " << c);
}
template <class T1, class T2, class T3, class T4>
inline bool Pr(T1 a, T2 b, T3 c, T4 d) {
  return (bool)(cout << a << " " << b << " " << c << " " << d);
}
template <class T>
inline void Cr(T a) {
  cerr << a << endl;
}
template <class T1, class T2>
inline void Cr(T1 a, T2 b) {
  cerr << a << " " << b << endl;
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
int a[100099];
int main() {
  int n, m;
  In(n);
  ina(a, n);
  sort(a, a + n);
  m = 1e6 + 1;
  m /= 2;
  int *x = upper_bound(a, a + n, m) - 1;
  int *y = x + 1;
  int ans = x == a + n ? 0 : *x - 1;
  ans = max(ans, y == a + n ? 0 : 1000000 - *y);
  Pr(ans);
  cout << "\n";
  return 0;
}
