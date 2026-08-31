#include <bits/stdc++.h>
using namespace std;
long long read() {
  long long xx = 0, flagg = 1;
  char ch = getchar();
  while ((ch < '0' || ch > '9') && ch != '-') ch = getchar();
  if (ch == '-') {
    flagg = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    xx = xx * 10 + ch - '0';
    ch = getchar();
  }
  return xx * flagg;
}
void pus(long long xx, long long flagg) {
  if (xx < 0) {
    putchar('-');
    xx = -xx;
  }
  if (xx >= 10) pus(xx / 10, 0);
  putchar(xx % 10 + '0');
  if (flagg == 1) putchar(' ');
  if (flagg == 2) putchar('\n');
  return;
}
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long exgcd(long long a, long long b, long long &x, long long &y) {
  if (b == 0) {
    x = 1;
    y = 0;
    return a;
  }
  long long g = exgcd(b, a % b, x, y), t = x;
  x = y;
  y = t - a / b * y;
  return g;
}
long long ksm(long long u, long long v) {
  long long o = 1;
  u %= 1000000007;
  while (v) {
    if (v & 1) o = o * u % 1000000007;
    u = u * u % 1000000007;
    v >>= 1;
  }
  return o;
}
long long n, p[2005], pn, a[105][2005], b[105][2005];
struct equation {
  long long A, B, C;
  equation() : A(0), B(0), C(0) {}
  equation(long long newA, long long newB, long long newC)
      : A(newA), B(newB), C(newC) {}
};
long long empty(equation &t) {
  if (t.A == 0 && t.B == 0) return t.C;
  long long g = gcd(abs(t.A), abs(t.B));
  if (t.C % g) return 1;
  t.A /= g;
  t.B /= g;
  t.C /= g;
  return 0;
}
long long merge(equation p, equation q, long long &x, long long &y) {
  long long D = p.A * q.B - p.B * q.A;
  x = p.C * q.B - q.C * p.B, y = p.A * q.C - p.C * q.A;
  if (D) {
    if (x % D || y % D) {
      x = -1;
      y = -1;
      return -1;
    }
    x /= D;
    y /= D;
    return 1;
  }
  if (x || y) {
    x = -1;
    y = -1;
    return -1;
  }
  return 0;
}
long long check(long long x) {
  if (x < 0) return -1;
  long long ans = 1, i, u, z;
  for (i = 2; i <= n; i++) {
    vector<long long> s;
    s.clear();
    for (u = 1; u <= pn; u++) {
      z = a[1][u] * x + b[1][u] - b[i][u];
      if (a[i][u]) {
        if (z % a[i][u]) return -1;
        s.push_back(z / a[i][u]);
      } else if (z)
        return -1;
    }
    sort(s.begin(), s.end());
    s.erase(unique(s.begin(), s.end()), s.end());
    if (s.size() > 1 || (s.size() == 1 && s.front() < 0)) return -1;
  }
  for (i = 1; i <= pn; i++)
    ans = ans * ksm(p[i], a[1][i] * x + b[1][i]) % 1000000007;
  return ans;
}
long long i, j, x, y, u[105], v[105], c[105], d[105], m, minx, A, B, C, g, t,
    flag;
int main() {
  n = read();
  for (i = 1; i <= n; i++) {
    u[i] = read();
    v[i] = read();
    for (x = u[i], y = 2; y <= x / y; y++)
      if (x % y == 0)
        for (p[++pn] = y; x % y == 0; x /= y)
          ;
    if (x != 1) p[++pn] = x;
    for (x = v[i], y = 2; y <= x / y; y++)
      if (x % y == 0)
        for (p[++pn] = y; x % y == 0; x /= y)
          ;
    if (x != 1) p[++pn] = x;
  }
  if (n == 1) {
    pus(u[1], 2);
    return 0;
  }
  sort(p + 1, p + pn + 1);
  pn = unique(p + 1, p + pn + 1) - p - 1;
  memset(a, 0, sizeof(a));
  memset(b, 0, sizeof(b));
  for (i = 1; i <= n; i++) {
    for (j = 1; j <= pn; j++)
      while (u[i] % p[j] == 0) {
        b[i][j]++;
        u[i] /= p[j];
      }
    for (j = 1; j <= pn; j++)
      while (v[i] % p[j] == 0) {
        a[i][j]++;
        v[i] /= p[j];
      }
  }
  x = 0;
  y = 0;
  long long u, v;
  for (i = 2; flag == 0 && i <= n; i++)
    for (u = 1; flag == 0 && u <= pn; u++) {
      equation p(a[1][u], -a[i][u], b[i][u] - b[1][u]);
      if (empty(p)) {
        pus(-1, 2);
        return 0;
      }
      if (p.B == 0 && p.A) {
        x = p.C / p.A;
        flag = 1;
        break;
      }
      for (v = u + 1; v <= pn; v++) {
        equation q(a[1][v], -a[i][v], b[i][v] - b[1][v]);
        t = merge(p, q, x, y);
        if (t == 1) {
          flag = 1;
          break;
        }
        if (t == -1) {
          pus(-1, 2);
          return 0;
        }
      }
    }
  if (flag) {
    pus(check(x), 2);
    return 0;
  }
  for (i = 2; i <= n; i++)
    for (u = 1; u <= pn; u++)
      if (a[1][u]) {
        A = a[1][u];
        B = a[i][u];
        C = b[i][u] - b[1][u];
        g = exgcd(A, B, x, y);
        m++;
        minx = max(minx, (long long)ceil(1.0 * C / A));
        c[m] = (C / g) * x % B;
        d[m] = B / g;
        break;
      }
  for (i = 2; i <= m; i++) {
    A = d[1];
    B = d[i];
    C = c[i] - c[1];
    g = exgcd(A, B, x, y);
    if (C % g) {
      pus(-1, 2);
      return 0;
    }
    x = x * (C / g) % B;
    c[1] = c[1] + x * A;
    d[1] = A / g * B;
    c[1] %= d[1];
    if (c[1] < 0) c[1] += d[1];
  }
  c[1] += ceil(1.0 * (minx - c[1]) / d[1]);
  pus(check(c[1]), 2);
  return 0;
}
