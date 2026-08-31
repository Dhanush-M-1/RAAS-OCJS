#include <bits/stdc++.h>
using namespace std;
template <class T>
inline bool read(T &x) {
  int c = getchar();
  int sgn = 1;
  while (~c && c<'0' | c> '9') {
    if (c == '-') sgn = -1;
    c = getchar();
  }
  for (x = 0; ~c && '0' <= c && c <= '9'; c = getchar()) x = x * 10 + c - '0';
  x *= sgn;
  return ~c;
}
template <class T>
inline long long gcd(T a, T b) {
  a = abs(a);
  b = abs(b);
  while (b) {
    a = a % b;
    swap(a, b);
  }
  return a;
}
template <class T>
inline long long ext_gcd(T A, T B, T *X, T *Y) {
  T x2, y2, x1, y1, x, y, r2, r1, q, r;
  x2 = 1;
  y2 = 0;
  x1 = 0;
  y1 = 1;
  for (r2 = A, r1 = B; r1 != 0;
       r2 = r1, r1 = r, x2 = x1, y2 = y1, x1 = x, y1 = y) {
    q = r2 / r1;
    r = r2 % r1;
    x = x2 - (q * x1);
    y = y2 - (q * y1);
  }
  *X = x2;
  *Y = y2;
  return r2;
}
template <class T>
inline long long modInv(T a, T m) {
  T x, y;
  ext_gcd(a, m, &x, &y);
  x %= m;
  if (x < 0) x += m;
  return x;
}
template <class T>
inline long long power(T a, T p) {
  T res = 1, x = a;
  while (p) {
    if (p & 1) res = (res * x);
    x = (x * x);
    p >>= 1;
  }
  return res;
}
template <class T>
inline long long bigmod(T a, T p, T m) {
  T res = 1 % m, x = a % m;
  while (p) {
    if (p & 1) res = (res * x) % m;
    x = (x * x) % m;
    p >>= 1;
  }
  return res;
}
int main() {
  long long q;
  cin >> q;
  while (q--) {
    long long l, r, d;
    cin >> l >> r >> d;
    if (d < l || d > r) {
      cout << d << endl;
      continue;
    }
    long long add = r / d;
    cout << (d * (add + 1)) << endl;
  }
  return 0;
}
