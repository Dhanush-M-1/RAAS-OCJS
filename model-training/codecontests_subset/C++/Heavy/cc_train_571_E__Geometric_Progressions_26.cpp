#include <bits/stdc++.h>
using std::cerr;
using std::endl;
const int N = 1145141, P = 1e9 + 7;
inline long long fpow(long long x, long long y) {
  long long ret = 1;
  for (; y; y >>= 1, x = x * x % P)
    if (y & 1) ret = ret * x % P;
  return ret;
}
int n, A[N], B[N];
int pr[N], tot;
long long a[N], b[N], c[N], d[N];
inline void init(int x) {
  for (int i = 2; i * i <= x; ++i) {
    if (x % i) continue;
    pr[++tot] = i;
    while (!(x % i)) x /= i;
  }
  if (x > 1) pr[++tot] = x;
}
inline void work(int x, long long f[]) {
  for (int i = 1; i <= tot; ++i) {
    int p = pr[i];
    f[i] = 0;
    while (!(x % p)) x /= p, ++f[i];
  }
}
long long gcd(long long x, long long y) { return !y ? x : gcd(y, x % y); }
inline long long lcm(long long x, long long y) {
  if (!x && !y) return 0;
  return x / gcd(x, y) * y;
}
long long exgcd(long long x, long long y, long long &a, long long &b) {
  if (!y) return a = 1, b = 0, x;
  int g = exgcd(y, x % y, b, a);
  return b -= x / y * a, g;
}
inline int merge(int kase) {
  long long sumb = 0, sumd = 0;
  for (int i = 1; i <= tot; ++i) sumb += b[i], sumd += d[i];
  if (!sumb && !sumd) {
    for (int i = 1; i <= tot; ++i)
      if (a[i] != c[i]) return 0;
    return 1;
  }
  if (!sumb || !sumd) {
    if (!sumd) {
      std::swap(sumb, sumd);
      std::swap(a, c);
      std::swap(b, d);
    }
    long long y = 0;
    for (int i = 1; i <= tot; ++i) {
      if (!d[i]) {
        if (a[i] != c[i]) return 0;
      } else {
        if (a[i] < c[i] || (a[i] - c[i]) % d[i]) return 0;
        y = (a[i] - c[i]) / d[i];
        break;
      }
    }
    for (int i = 1; i <= tot; ++i)
      if (a[i] != c[i] + y * d[i]) return 0;
    return 1;
  }
  int flag = 0;
  for (int i = 1; i <= tot; ++i)
    if (b[i] * sumd != d[i] * sumb) {
      flag = i;
      break;
    }
  if (flag) {
    int pi = flag, pj = 0;
    for (int i = 1; i <= tot; ++i)
      if (b[i] * d[pi] != d[i] * b[pi]) {
        pj = i;
        break;
      }
    long long t1 = d[pj] * (c[pi] - a[pi]) - d[pi] * (c[pj] - a[pj]),
              t2 = b[pj] * (c[pi] - a[pi]) - b[pi] * (c[pj] - a[pj]),
              t3 = b[pi] * d[pj] - b[pj] * d[pi];
    if (t3 == 0 || t1 % t3 || t2 % t3) return 0;
    long long x = t1 / t3, y = t2 / t3;
    if (x < 0 || y < 0) return 0;
    for (int i = 1; i <= tot; ++i) {
      if (a[i] + x * b[i] != c[i] + y * d[i]) return 0;
      a[i] = a[i] + x * b[i], b[i] = 0;
    }
    return 1;
  }
  long long x, y, tb = 0, td = 0, t = 0, g = 0;
  for (int i = 1; i <= tot; ++i)
    if (b[i]) {
      g = gcd(b[i], d[i]);
      tb = b[i] / g, td = d[i] / g;
      if ((a[i] - c[i]) % g) return 0;
      t = (a[i] - c[i]) / g;
      break;
    }
  for (int i = 1; i <= tot; ++i)
    if (c[i] + t * g != a[i]) return 0;
  if (t < 0) {
    std::swap(a, c);
    std::swap(b, d);
    std::swap(tb, td);
    t = -t;
  }
  exgcd(tb, td, x, y);
  x = (x * -t % td + td) % td;
  for (int i = 1; i <= tot; ++i) {
    a[i] += x * b[i];
    b[i] *= td;
  }
  return 1;
}
int main() {
  std::cin >> n;
  for (int i = 1; i <= n; ++i) {
    std::cin >> A[i] >> B[i];
    init(A[i]), init(B[i]);
  }
  std::sort(pr + 1, pr + tot + 1);
  tot = std::unique(pr + 1, pr + tot + 1) - pr - 1;
  work(A[1], a), work(B[1], b);
  for (int i = 2; i <= n; ++i) {
    work(A[i], c), work(B[i], d);
    if (!merge(i)) return puts("-1"), 0;
  }
  long long ans = 1;
  for (int i = 1; i <= tot; ++i) ans = ans * fpow(pr[i], a[i]) % P;
  std::cout << ans << std::endl;
  return 0;
}
