#include <bits/stdc++.h>
using namespace std;
int n;
int read();
int fsp(long long bs, int p) {
  int rt = 1;
  while (p) {
    if (p & 1) rt = bs * rt % 1000000007;
    bs = bs * bs % 1000000007, p >>= 1;
  }
  return rt;
}
int p[10004], cnt;
int a[202], b[202];
struct Q {
  long long x[1003], y[1003];
} q[202];
void solve1(int x) {
  for (int t = 2; t * t <= x; ++t) {
    if (x % t) continue;
    for (p[++cnt] = t; x % t == 0;) x /= t;
  }
  if (x > 1) p[++cnt] = x;
}
void solve2(int x, long long* q) {
  for (int t = 2; t * t <= x; ++t) {
    if (x % t) continue;
    int tp = lower_bound(p + 1, p + 1 + cnt, t) - p;
    while (x % t == 0) x /= t, ++q[tp];
  }
  if (x > 1) ++q[lower_bound(p + 1, p + 1 + cnt, x) - p];
}
void fail() { puts("-1"), exit(0); }
void prt() {
  int res = 1;
  for (int j = 1; j <= cnt; ++j)
    res = 1ll * res * fsp(p[j], q[1].x[j] % (1000000007 - 1)) % 1000000007;
  printf("%d\n", res), exit(0);
}
void check(long long k, int st) {
  for (int j = 1; j <= cnt; ++j) q[1].x[j] += q[1].y[j] * k;
  for (int i = st; i <= n; ++i) {
    long long tk = -1, ttk;
    for (int j = 1; j <= cnt; ++j) {
      long long A1 = q[1].x[j], A2 = q[i].x[j];
      long long B2 = q[i].y[j];
      if (B2 == 0 && A1 != A2) fail();
      if (B2) {
        if (A2 > A1 || (A1 - A2) % B2) fail();
        ttk = (A1 - A2) / B2;
        if (tk == -1) tk = ttk;
        if (tk != ttk) fail();
      }
    }
  }
  prt();
}
long long gcd(long long a, long long b) {
  while (b ^= a ^= b ^= a %= b) void();
  return a;
}
struct T {
  long long a, b, c;
  bool operator==(T x) { return a == x.a && b == x.b && c == x.c; }
} t;
long long solve3(T s, T t) {
  long long K = s.a * t.b - t.a * s.b, B = s.c * t.b - t.c * s.b;
  if (!B) return 0;
  if (!K || B % K || ((K > 0) ^ (B > 0))) fail();
  return B / K;
}
long long exgcd(long long a, long long b, long long& x, long long& y) {
  if (b == 0) return x = 1, y = 0, a;
  long long d = exgcd(b, a % b, y, x);
  return y -= a / b * x, d;
}
void solve4(long long B1, long long B2, long long A, long long& x,
            long long& y) {
  long long tx, ty, d = exgcd(B1, B2, tx, ty), t1 = B2 / d, t2 = B1 / d;
  if (A % d) fail();
  tx *= A / d, ty *= -A / d;
  x = (tx < 0 ? -tx + t1 - 1 : -tx) / t1;
  y = (ty < 0 ? -ty + t2 - 1 : -ty) / t2;
  x = tx + max(x, y) * t1, y = t1;
}
void work() {
  for (int i = 2; i <= n; ++i) {
    int tc = 0;
    for (int j = 1; j <= cnt; ++j) {
      long long A1 = q[1].x[j], A2 = q[i].x[j];
      long long B1 = q[1].y[j], B2 = q[i].y[j];
      if (B1 == 0 && B2 == 0) {
        if (A1 != A2) fail();
      } else if (B1 == 0) {
        if (A1 < A2 || (A1 - A2) % B2) fail();
        check((A1 - A2) / B2, i);
      } else if (B2 == 0) {
        if (A2 < A1 || (A2 - A1) % B1) fail();
        check((A2 - A1) / B1, i);
      }
    }
    long long tK = -1, ttK;
    for (int j = 1; j <= cnt; ++j) {
      long long A1 = q[1].x[j], A2 = q[i].x[j];
      long long B1 = q[1].y[j], B2 = q[i].y[j];
      if (B1 == 0) continue;
      long long d = gcd(B1, B2), C = A2 - A1;
      if (C % d) fail();
      B1 /= d, B2 /= d, C /= d;
      if (tc) {
        if (t == (T){B1, B2, C}) continue;
        ttK = solve3(t, (T){B1, B2, C});
        if (tK == -1) tK = ttK;
        if (tK != ttK) fail();
      } else {
        t = (T){B1, B2, C}, tc = 1;
      }
    }
    if (tK != -1) check(tK, i);
    long long N, M;
    solve4(t.a, t.b, t.c, N, M);
    for (int j = 1; j <= cnt; ++j) {
      if (q[1].y[j] == 0) continue;
      q[1].x[j] += N * q[1].y[j], q[1].y[j] *= M;
    }
  }
}
int main() {
  n = read();
  for (int i = 1; i <= n; ++i) solve1(a[i] = read()), solve1(b[i] = read());
  sort(p + 1, p + 1 + cnt), cnt = unique(p + 1, p + 1 + cnt) - p - 1;
  for (int i = 1; i <= n; ++i) solve2(a[i], q[i].x), solve2(b[i], q[i].y);
  work(), prt();
  return 0;
}
int read() {
  int x = 0, f = 1;
  char c = getchar();
  while (c < '0' || c > '9') f = (c == '-') ? -1 : f, c = getchar();
  while (c >= '0' && c <= '9') x = x * 10 + c - '0', c = getchar();
  return x * f;
}
