#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long lcm(long long a, long long b) { return a * b / gcd(a, b); }
const int mod = 1e9 + 7;
int add(int x, int y) { return x + y < mod ? x + y : x + y - mod; }
void ade(int& x, int y) {
  x += y;
  if (x >= mod) x -= mod;
}
int qpow(int x, long long k) {
  int r = 1;
  while (k) {
    if (k & 1) r = 1ll * r * x % mod;
    k >>= 1;
    x = 1ll * x * x % mod;
  }
  return r;
}
int n;
int pri[100100], m;
int a_[110], b_[110];
void pia(int x) {
  for (int i = 2; i * i <= x; ++i)
    if (x % i == 0) {
      while (x % i == 0) x /= i;
      pri[++m] = i;
    }
  if (x != 1) pri[++m] = x;
}
int c[110][2020], d[110][2020];
void build(int id, int a, int b) {
  int p;
  for (int i = 1; i <= m; ++i) {
    p = pri[i];
    while (a % p == 0) a /= p, c[id][i]++;
    while (b % p == 0) b /= p, d[id][i]++;
  }
}
bool ign[2020];
long long pro = 1;
long long ans[2020];
void CheckAns() {
  for (int j = 1; j <= m; ++j)
    for (int i = 1; i <= n; ++i) {
      if (ign[j]) continue;
      if (!d[i][j]) {
        if (ans[j] - c[i][j]) puts("-1"), exit(0);
      } else if (ans[j] < c[i][j] || (ans[j] - c[i][j]) % d[i][j])
        puts("-1"), exit(0);
    }
  int out = pro;
  for (int i = 1; i <= m; ++i)
    if (!ign[i]) out = 1ll * out * qpow(pri[i], ans[i]) % mod;
  printf("%d\n", out);
}
void Equa(int a1, int b1, int c1, int a2, int b2, int c2) {
  int lc = lcm(a1, a2), p1 = lc / a1, p2 = lc / a2;
  a1 = a2 = lc;
  b1 *= p1, c1 *= p1;
  b2 *= p2, c2 *= p2;
  int b, nc;
  int x, y;
  b = b2 - b1, nc = c2 - c1;
  if (nc % b) puts("-1"), exit(0);
  y = nc / b;
  c1 -= b1 * y;
  if (c1 % a1) puts("-1"), exit(0);
  x = c1 / a1;
  if (x < 0 || y < 0) puts("-1"), exit(0);
  for (int i = 1; i <= m; ++i) ans[i] = c[1][i] + x * d[1][i];
  CheckAns();
}
void exgcd(long long a, long long b, long long& x, long long& y) {
  if (!b) {
    x = 1, y = 0;
    return;
  }
  exgcd(b, a % b, y, x);
  y -= (a / b) * x;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d%d", &a_[i], &b_[i]);
    pia(a_[i]);
    pia(b_[i]);
  }
  sort(pri + 1, pri + m + 1);
  m = unique(pri + 1, pri + m + 1) - pri - 1;
  for (int i = 1; i <= n; ++i) build(i, a_[i], b_[i]);
  for (int j = 1; j <= m; ++j) {
    int fl1 = 0, fl2 = 0;
    for (int u = 1; u <= n; ++u)
      if (!d[u][j])
        fl1 = u;
      else
        fl2 = u;
    if (!fl1) continue;
    if (!fl2) {
      for (int i = 1; i <= n; ++i)
        if (c[i][j] != c[1][j]) puts("-1"), exit(0);
      (pro *= qpow(pri[j], c[1][j])) %= mod;
      ign[j] = 1;
    } else {
      int k = c[fl1][j] - c[fl2][j];
      if (k % d[fl2][j] || k < 0) puts("-1"), exit(0);
      k /= d[fl2][j];
      for (int i = 1; i <= m; ++i) ans[i] = k * d[fl2][i] + c[fl2][i];
      CheckAns();
      return 0;
    }
  }
  int pos = 1;
  while (ign[pos]) pos++;
  if (pos > m) {
    printf("%lld\n", pro);
    return 0;
  }
  swap(pri[1], pri[pos]);
  swap(ign[1], ign[pos]);
  for (int i = 1; i <= n; ++i)
    swap(c[i][1], c[i][pos]), swap(d[i][1], d[i][pos]);
  for (int j = 2; j <= m; ++j) {
    for (int i = 2; i <= n; ++i) {
      if (d[1][1] * d[i][j] != d[1][j] * d[i][1]) {
        Equa(d[1][1], -d[i][1], c[i][1] - c[1][1], d[1][j], -d[i][j],
             c[i][j] - c[1][j]);
        return 0;
      } else if ((c[i][j] - c[1][j]) * d[1][1] != (c[i][1] - c[1][1]) * d[1][j])
        puts("-1"), exit(0);
    }
  }
  long long A = c[1][1], M = d[1][1];
  long long a, g, x, y, t;
  for (int i = 2; i <= n; ++i) {
    a = c[i][1] - A;
    g = gcd(M, d[i][1]);
    if (a % g) puts("-1"), exit(0);
    t = d[i][1] / g;
    exgcd(M, d[i][1], x, y);
    x = (x % t + t) % t;
    x *= a / g;
    x = (x % t + t) % t;
    A += x * M;
    M = lcm(M, d[i][1]);
    A = (A % M + M) % M;
  }
  for (int i = 1; i <= n; ++i)
    while (A < c[i][1]) A += M;
  long long k;
  if (!d[1][1])
    k = 0;
  else
    k = (A - c[1][1]) / d[1][1];
  for (int i = 1; i <= m; ++i) ans[i] = c[1][i] + k * d[1][i];
  CheckAns();
  return 0;
}
