#include <bits/stdc++.h>
using namespace std;
int ts, kk = 1;
long long MOD;
template <class T>
inline T _abs(T n) {
  return (n < 0 ? -n : n);
}
template <class T>
inline T _max(T a, T b) {
  return (a > b ? a : b);
}
template <class T>
inline T _min(T a, T b) {
  return (a < b ? a : b);
}
template <class T>
inline T _sq(T x) {
  return x * x;
}
template <class T>
inline T _sqrt(T x) {
  return (T)sqrt((double)x);
}
template <class T>
inline T _pow(T x, T y) {
  T z = 1;
  for (int i = 1; i <= y; i++) {
    z *= x;
  }
  return z;
}
template <class T>
inline T _gcd(T a, T b) {
  a = _abs(a);
  b = _abs(b);
  if (!b) return a;
  return _gcd(b, a % b);
}
template <class T>
inline T _lcm(T a, T b) {
  a = _abs(a);
  b = _abs(b);
  return (a / _gcd(a, b)) * b;
}
template <class T>
inline T _extended(T a, T b, T &x, T &y) {
  a = _abs(a);
  b = _abs(b);
  T g, x1, y1;
  if (!b) {
    x = 1;
    y = 0;
    g = a;
    return g;
  }
  g = _extended(b, a % b, x1, y1);
  x = y1;
  y = x1 - (a / b) * y1;
  return g;
}
template <class T>
inline T getbit(T x, T i) {
  T t = 1;
  return (x & (t << i));
}
template <class T>
inline T setbit(T x, T i) {
  T t = 1;
  return (x | (t << i));
}
template <class T>
inline T resetbit(T x, T i) {
  T t = 1;
  return (x & (~(t << i)));
}
template <class T>
inline T _bigmod(T n, T m) {
  T ans = 1, mult = n % MOD;
  while (m) {
    if (m & 1) ans = (ans * mult) % MOD;
    m >>= 1;
    mult = (mult * mult) % MOD;
  }
  ans %= MOD;
  return ans;
}
template <class T>
inline T _modinv(T x) {
  return _bigmod(x, (T)(MOD - 2)) % MOD;
}
int num[500];
int main() {
  string s;
  int sl;
  cin >> sl >> s;
  for (int i = 0; i <= sl - 1; i++) {
    num[s[i]]++;
  }
  int ans = 0;
  for (int i = 0; i <= sl - 1; i++) {
    if (s[i] == 'F') continue;
    int tot = num['A'] + num['F'];
    if (s[i] == 'A') tot--;
    if (tot == sl - 1) ans++;
  }
  cout << ans << endl;
  return 0;
}
