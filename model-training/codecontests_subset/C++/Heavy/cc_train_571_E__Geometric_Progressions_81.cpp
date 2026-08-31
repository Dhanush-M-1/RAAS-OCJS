#include <bits/stdc++.h>
template <class T1, class T2>
inline bool cmin(T1 &a, const T2 &b) {
  return b < a ? (a = b, true) : false;
}
template <class T1, class T2>
inline bool cmax(T1 &a, const T2 &b) {
  return a < b ? (a = b, true) : false;
}
template <class Type>
Type read() {
  Type a;
  bool b;
  unsigned char c;
  while (c = getchar() - 48, (c > 9) & (c != 253))
    ;
  for (a = (b = c == 253) ? 0 : c; (c = getchar() - 48) <= 9; a = a * 10 + c)
    ;
  return b ? -a : a;
}
auto rd = read<int>;
void gg() {
  puts("-1");
  exit(0);
}
long long exgcd(long long a, long long b, long long &x, long long &y) {
  if (b == 0) {
    x = 1, y = 0;
    return a;
  }
  long long d = exgcd(b, a % b, y, x);
  y -= a / b * x;
  return d;
}
struct Rem {
  long long r, d;
  Rem &operator&=(const Rem &o) {
    long long x, y, g = exgcd(d, o.d, x, y), rhs = o.r - r;
    if (rhs % g != 0) gg();
    r += rhs * x % o.d * (d / g);
    d *= o.d / g;
    if (r < 0) r += d;
    return *this;
  }
};
const int N = 100;
int m, aval[N], bval[N];
std::valarray<long long> a[N], b[N];
std::vector<int> prime;
void gl(std::valarray<long long> x) {
  const unsigned P = 1e9 + 7;
  unsigned ans = 1;
  for (int i = 0; i < m; ++i) {
    unsigned long long b = prime[i];
    for (int e = x[i] % (P - 1); e; b = b * b % P, e >>= 1)
      if (e & 1) ans = ans * b % P;
  }
  printf("%u\n", ans);
  exit(0);
}
long long ddiv(long long a, long long b) {
  if (b == 0) {
    if (a != 0) gg();
    return -1;
  }
  if (a % b != 0) gg();
  a /= b;
  if (a < 0) gg();
  return a;
}
long long ddiv(std::valarray<long long> a, std::valarray<long long> b) {
  long long res = -1;
  for (int i = 0; i < m; ++i) {
    long long v = ddiv(a[i], b[i]);
    if (v == -1) continue;
    if (res != v && res != -1) gg();
    res = v;
  }
  return res;
}
void extract(int n) {
  for (auto p : prime)
    while (n % p == 0) n /= p;
  for (int p = 2; 1ll * p * p <= n; ++p)
    if (n % p == 0) {
      while (n % p == 0) n /= p;
      prime.push_back(p);
    }
  if (n > 1) prime.push_back(n);
}
std::valarray<long long> factor(int n) {
  std::valarray<long long> res(m);
  for (int i = 0; i < m; ++i) {
    int p = prime[i];
    while (n % p == 0) ++res[i], n /= p;
  }
  return res;
}
int main() {
  int n = rd();
  for (int i = 0; i < n; ++i) extract(aval[i] = rd()), extract(bval[i] = rd());
  m = prime.size();
  for (int i = 0; i < n; ++i) a[i] = factor(aval[i]), b[i] = factor(bval[i]);
  for (int i = 0; i < m; ++i)
    for (int j = 0; j < n; ++j)
      if (b[j][i] == 0) {
        for (int k = 0; k < n; ++k) {
          long long nk = ddiv(a[j][i] - a[k][i], b[k][i]);
          if (nk != -1) {
            std::valarray<long long> x = a[k] + nk * b[k];
            for (int l = 0; l < n; ++l) ddiv(x - a[l], b[l]);
            gl(x);
          }
        }
        break;
      }
  int k = 0;
  while (k < m && b[0][k] == 0) ++k;
  if (k == m) gl(a[0]);
  for (int i = k + 1; i < m; ++i)
    if (b[0][i] != 0)
      for (int j = 1; j < n; ++j) {
        long long n0 =
            ddiv((a[j][i] - a[0][i]) * b[j][k] - (a[j][k] - a[0][k]) * b[j][i],
                 b[0][i] * b[j][k] - b[0][k] * b[j][i]);
        if (n0 != -1) {
          std::valarray<long long> x = a[0] + n0 * b[0];
          for (int l = 0; l < n; ++l) ddiv(x - a[l], b[l]);
          gl(x);
        }
      }
  Rem ans = {0, 1};
  for (int i = 0; i < n; ++i) ans &= {a[i][k] % b[i][k], b[i][k]};
  for (int i = 0; i < n; ++i)
    if (ans.r < a[i][k]) ans.r += ((a[i][k] - ans.r - 1) / ans.d + 1) * ans.d;
  gl(a[0] + (ans.r - a[0][k]) / b[0][k] * b[0]);
  return 0;
}
