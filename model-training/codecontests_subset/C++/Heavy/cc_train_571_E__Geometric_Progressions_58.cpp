#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  long long x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = (x << 3) + (x << 1) + (ch ^ 48);
    ch = getchar();
  }
  return x * f;
}
const long long N = 5100, mod = 1e9 + 7;
long long n, cnt;
long long a[N], b[N], p[N << 1];
void getp(long long x) {
  long long t = x;
  for (long long i = 2; i * i <= x; i++) {
    if (t % i == 0) {
      p[++cnt] = i;
      while (t % i == 0) t /= i;
    }
  }
  if (t > 1) p[++cnt] = t;
}
long long gcd(long long x, long long y) { return y == 0 ? x : gcd(y, x % y); }
long long ksm(long long x, long long y) {
  long long res = 1;
  for (; y; y >>= 1, x = x * x % mod)
    if (y & 1) res = res * x % mod;
  return res;
}
long long exgcd(long long a, long long b, long long &x, long long &y) {
  if (!b) {
    x = 1;
    y = 0;
    return a;
  }
  long long d = exgcd(b, a % b, y, x);
  y -= a / b * x;
  return d;
}
struct node {
  long long k, b;
  node() {}
  node(long long k, long long b) : k(k), b(b) {}
} f[N << 1], g[N << 1];
struct Func {
  long long a, b, c;
  Func() {}
  Func(long long a, long long b, long long c) : a(a), b(b), c(c){};
};
long long vis = 0;
long long solve(long long b, long long k) {
  for (long long i = 1; i <= cnt; i++) g[i] = node{0, 0};
  for (long long i = 1; i <= cnt; i++) {
    while (k % p[i] == 0) k /= p[i], ++g[i].k;
    while (b % p[i] == 0) b /= p[i], ++g[i].b;
  }
  if (!vis) {
    for (long long i = 1; i <= cnt; i++) f[i] = g[i];
    return vis = 1;
  }
  for (long long t = 1; t <= 3; t++) {
    for (long long i = 1; i <= cnt; i++) {
      long long fb = f[i].b, fk = f[i].k;
      long long gb = g[i].b, gk = g[i].k;
      if (!fk && !gk) {
        if (fb != gb) return 0;
      } else if (!fk || !gk) {
        long long tag = 0;
        if (!fk) swap(fk, gk), swap(fb, gb), tag = 1;
        if (gb < fb || (gb - fb) % fk) return 0;
        long long k = (gb - fb) / fk;
        if (tag)
          for (long long j = 1; j <= cnt; j++) g[j].b += g[j].k * k, g[j].k = 0;
        else
          for (long long j = 1; j <= cnt; j++) f[j].b += f[j].k * k, f[j].k = 0;
      }
    }
  }
  Func F;
  long long flag = 0;
  long long X = -1, Y = -1;
  for (long long i = 1; i <= cnt; i++) {
    long long fb = f[i].b, fk = f[i].k;
    long long gb = g[i].b, gk = g[i].k;
    if (fk && gk) {
      if (!flag)
        F = Func(fk, -gk, gb - fb), flag = 1;
      else if (flag == 1) {
        long long A = fk, B = -gk, C = gb - fb;
        long long d = gcd(F.a, A);
        long long m1 = A / d, m2 = F.a / d;
        F.a *= m1, F.b *= m1, F.c *= m1;
        A *= m2, B *= m2, C *= m2;
        if (F.a == A && F.b == B) {
          if (F.c != C)
            return 0;
          else {
            long long d = gcd(gcd(F.a, abs(F.b)), abs(F.c));
            F.a /= d, F.b /= d, F.c /= d;
            continue;
          }
        } else {
          C -= F.c, B -= F.b;
          if (C < 0) C *= -1, B *= -1;
          if (B < 0 || C % B) return 0;
          Y = C / B;
          X = (F.c - F.b * Y) / F.a;
          if (X < 0 || (F.c - F.b * Y) % F.a) return 0;
          flag = 2;
        }
      } else if (flag == 2) {
        long long A = fk, B = -gk, C = gb - fb;
        if (A * X + B * Y != C) return 0;
      }
    }
  }
  if (flag == 2) {
    for (long long i = 1; i <= N; i++) f[i].b += f[i].k * X, f[i].k = 0;
  }
  if (flag == 1) {
    long long x, y;
    long long d = exgcd(F.a, -F.b, x, y);
    y = -y;
    if (F.c % d) return 0;
    long long kx = -F.b / d, ky = F.a / d;
    x *= F.c / d;
    y *= F.c / d;
    long long tx = 0, ty = 0;
    if (x < 0)
      tx = -((-x + kx - 1) / kx);
    else
      tx = x / kx;
    if (y < 0)
      ty = -((-y + ky - 1) / ky);
    else
      ty = y / ky;
    x -= kx * min(tx, ty);
    y -= ky * min(tx, ty);
    for (long long i = 1; i <= N; i++) f[i].b += f[i].k * x, f[i].k *= kx;
  }
  return 1;
}
signed main() {
  n = read();
  for (long long i = 1; i <= n; i++) {
    getp(a[i] = read());
    getp(b[i] = read());
  }
  sort(p + 1, p + 1 + cnt);
  cnt = unique(p + 1, p + 1 + cnt) - p - 1;
  for (long long i = 1; i <= n; i++)
    if (!solve(a[i], b[i])) {
      puts("-1");
      return 0;
    }
  long long res = 1;
  for (long long i = 1; i <= cnt; i++)
    res = 1ll * res * ksm(p[i], f[i].b) % mod;
  cout << res << "\n";
  return 0;
}
