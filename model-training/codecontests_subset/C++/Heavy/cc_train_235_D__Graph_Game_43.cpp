#include <bits/stdc++.h>
#pragma GCC optimize("Ofast,no-stack-protector,unroll-loops,fast-math")
#pragma GCC target( \
    "sse,sse2,sse3,ssse3,sse4.1,sse4.2,avx,avx2,popcnt,tune=native")
using namespace std;
namespace _c {
const double pi = acos(-1.0);
namespace min {
const int i8 = -128;
const int i16 = -32768;
const int i = -2147483647 - 1;
const long long l = -9223372036854775807LL - 1;
}  // namespace min
namespace max {
const int i8 = 127;
const int i16 = 32767;
const int i = 2147483647;
const long long l = 9223372036854775807LL;
}  // namespace max
}  // namespace _c
namespace _f {
template <typename T>
inline const T gcd(T m, T n) {
  while (n != 0) {
    T t = m % n;
    m = n;
    n = t;
  }
  return m;
}
template <typename T>
inline const T max(const T &a, const T &b) {
  return a > b ? a : b;
}
template <typename T>
inline const T min(const T &a, const T &b) {
  return a < b ? a : b;
}
template <typename T>
inline const T abs(const T &a) {
  return a > 0 ? a : -a;
}
template <typename T>
inline T pow(T a, T b) {
  T res = 1;
  while (b > 0) {
    if (b & 1) {
      res = res * a;
    }
    a = a * a;
    b >>= 1;
  }
  return res;
}
template <typename T>
inline T pow(T a, T b, const T &mod) {
  a %= mod;
  T res = 1;
  while (b > 0) {
    if (b & 1) {
      res = res * a % mod;
    }
    a = a * a % mod;
    b >>= 1;
  }
  return res % mod;
}
}  // namespace _f
namespace io {
template <typename T>
inline void read(T &t) {
  register T res = 0, neg = 1;
  char c = getchar();
  for (; !isdigit(c); c = getchar()) {
    if (c == '-') {
      neg = -1;
    }
  }
  for (; isdigit(c); c = getchar()) {
    res = res * 10 + c - '0';
  }
  t = res * neg;
}
inline int in() {
  register int T;
  read(T);
  return T;
}
inline long long in_ll() {
  register long long T;
  read(T);
  return T;
}
}  // namespace io
int i, j, k, n, m, t, r, flag, chang, num, x, y;
int a[6010], nxt[6010], head[6010], F[6010], f[6010], g[6010];
double an;
inline void add(int x, int y) {
  a[++t] = y, nxt[t] = head[x], head[x] = t;
  a[++t] = x, nxt[t] = head[y], head[y] = t;
}
void dfs(int x, int y) {
  int v;
  if (flag) {
    return;
  }
  f[x] = 1;
  g[++r] = x;
  for (v = head[x]; v; v = nxt[v]) {
    int A = a[v];
    if (A == y) {
      continue;
    }
    if (flag) {
      return;
    }
    if (f[A]) {
      for (; g[r] != A; r--) {
        F[g[r]] = 1, chang++;
      }
      F[A] = 1;
      chang++;
      flag = 1;
      return;
    }
    dfs(A, x);
  }
  r--;
}
inline void get(double y, double z) {
  if (z <= 1) {
    an += 1 / y;
  } else {
    double x = y - z + chang;
    an -= 1 / x;
    if (z >= 2) {
      an += 1 / (x - (z - 2));
    }
    if (z <= chang) {
      an += 1 / (x - (chang - z));
    }
  }
}
void Dfs(int x, int y, int z) {
  int v;
  f[x] = num;
  get(y, z);
  for (v = head[x]; v; v = nxt[v]) {
    if (f[a[v]] != num) {
      Dfs(a[v], y + 1, z + F[a[v]]);
    }
  }
}
int main() {
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d%d", &x, &y), add(x + 1, y + 1);
  }
  dfs(1, 0);
  num = 1;
  for (i = 1; i <= n; i++) {
    num++;
    Dfs(i, 1, F[i]);
  }
  printf("%.12lf\n", an);
  return 0;
}
