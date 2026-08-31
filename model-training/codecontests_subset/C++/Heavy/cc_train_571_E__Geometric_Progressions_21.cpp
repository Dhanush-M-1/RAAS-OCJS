#include <bits/stdc++.h>
using namespace std;
const int N = 2111;
const int mod = 1e9 + 7;
int n;
int pri[N], tot;
long long a[N], b[N];
struct node {
  long long k, b;
  node(long long _k = 0, long long _b = 0) {
    k = _k;
    b = _b;
  }
} f[N], g[N];
long long gcd(long long x, long long y) { return y == 0 ? x : gcd(y, x % y); }
long long ksm(long long base, long long x) {
  long long ans = 1;
  while (x) {
    if (x & 1) ans = ans * base % mod;
    base = base * base % mod;
    x >>= 1;
  }
  return ans;
}
void get(int x) {
  for (int i = 2; i * i <= x; i++) {
    if (x % i == 0) {
      pri[++tot] = i;
      while (x % i == 0) x /= i;
    }
  }
  if (x > 1) pri[++tot] = x;
}
void get_g(int id) {
  for (int i = 1; i <= tot; i++) {
    g[i].b = g[i].k = 0;
    while (a[id] % pri[i] == 0) {
      g[i].b++;
      a[id] /= pri[i];
    }
    while (b[id] % pri[i] == 0) {
      g[i].k++;
      b[id] /= pri[i];
    }
  }
}
long long ex_gcd(long long A, long long B, long long &x, long long &y) {
  if (!B) {
    x = 1;
    y = 0;
    return A;
  }
  long long xx, yy;
  long long d = ex_gcd(B, A % B, xx, yy);
  x = yy;
  y = xx - A / B * yy;
  return d;
}
bool merge() {
  bool flag = 0;
  for (int t = 0; t < 3; t++) {
    for (int i = 1; i <= tot; i++) {
      long long fk = f[i].k, fb = f[i].b;
      long long gk = g[i].k, gb = g[i].b;
      bool fl = 0;
      if (!fk && !gk) {
        if (fb != gb) return 0;
      } else {
        if (!gk || !fk) {
          if (!fk) swap(fk, gk), swap(fb, gb), fl = 1;
          if (fb > gb || (gb - fb) % fk != 0) return 0;
          long long k = (gb - fb) / fk;
          if (fl)
            for (int j = 1; j <= tot; j++) g[j].b += g[j].k * k, g[j].k = 0;
          else
            for (int j = 1; j <= tot; j++) f[j].b += f[j].k * k, f[j].k = 0;
          flag = 1;
        }
      }
    }
  }
  if (flag) return 1;
  int fl = 0;
  long long A = 0, B = 0, C = 0;
  for (int i = 1; i <= tot; i++) {
    if (!f[i].k || !g[i].k) continue;
    if (!fl)
      A = f[i].k, B = -g[i].k, C = g[i].b - f[i].b, fl = 1;
    else if (fl == 1) {
      long long nA = f[i].k, nB = -g[i].k, nC = g[i].b - f[i].b;
      long long d = gcd(nA, A);
      A *= nA / d;
      B *= nA / d;
      C *= nA / d;
      nA *= A / d;
      nB *= A / d;
      nC *= A / d;
      if (B == nB) {
        if (C != nC) return 0;
        long long d = gcd(A, gcd(abs(B), abs(C)));
        A /= d;
        B /= d;
        C /= d;
        continue;
      } else {
        if ((C - nC) % (B - nB)) return 0;
        long long y = (C - nC) / (B - nB);
        if (y < 0) return 0;
        if ((C - B * y) % A) return 0;
        long long x = (C - B * y) / A;
        if (x < 0) return 0;
        for (int j = 1; j <= tot; j++) f[j].b += f[j].k * x, f[j].k = 0;
        for (int j = i + 1; j <= tot; j++) {
          nA = f[j].k, nB = -g[j].k, nC = g[j].b - f[j].b;
          if (nA * x + nB * y != nC) return 0;
        }
        return 1;
      }
    }
  }
  long long x = -1, y = -1;
  long long d = ex_gcd(A, -B, x, y);
  if (C % d) return 0;
  y *= -1;
  long long kx = (-B) / d;
  long long ky = A / d;
  x *= C / d, y *= C / d;
  long long tx = x < 0 ? -(-x + kx - 1) / kx : x / kx;
  long long ty = y < 0 ? -(-y + ky - 1) / ky : y / ky;
  x -= min(tx, ty) * kx;
  y -= min(tx, ty) * ky;
  for (int i = 1; i <= tot; i++) {
    f[i].b += f[i].k * x;
    f[i].k = f[i].k * kx;
  }
  return 1;
}
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    scanf("%d%d", &a[i], &b[i]);
    get(a[i]);
    get(b[i]);
  }
  sort(pri + 1, pri + 1 + tot);
  tot = unique(pri + 1, pri + 1 + tot) - (pri + 1);
  for (int i = 1; i <= tot; i++) {
    while (a[1] % pri[i] == 0) {
      f[i].b++;
      a[1] /= pri[i];
    }
    while (b[1] % pri[i] == 0) {
      f[i].k++;
      b[1] /= pri[i];
    }
  }
  for (int i = 2; i <= n; i++) {
    get_g(i);
    if (!merge()) {
      puts("-1");
      return 0;
    }
  }
  int ans = 1;
  for (int i = 1; i <= tot; i++) {
    ans = 1LL * ans * ksm(pri[i], f[i].b) % mod;
  }
  cout << ans << endl;
  return 0;
}
