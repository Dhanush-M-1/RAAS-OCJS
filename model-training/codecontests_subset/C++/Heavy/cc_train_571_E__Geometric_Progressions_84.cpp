#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
inline int ksm(int x, long long y) {
  int res = 1;
  while (y > 0) {
    if (y & 1) res = 1ll * res * x % MOD;
    x = 1ll * x * x % MOD;
    y >>= 1;
  }
  return res;
}
long long exgcd(long long a, long long b, long long &x, long long &y) {
  if (b == 0) {
    x = 1, y = 0;
    return a;
  }
  long long gcd1 = exgcd(b, a % b, x, y);
  long long t = x;
  x = y, y = t - a / b * y;
  return gcd1;
}
long long gcd(long long x, long long y) { return y == 0 ? x : gcd(y, x % y); }
int n, a[105], b[105], pri[2005], m;
struct node {
  long long a[2005], b[2005];
  bool merge(node x) {
    long long sum1 = 0, sum2 = 0;
    for (int i = 1; i <= m; i++) sum1 += b[i], sum2 += x.b[i];
    if (sum1 == 0 && sum2 == 0) {
      for (int i = 1; i <= m; i++)
        if (a[i] != x.a[i]) return 0;
      return 1;
    }
    if (sum1 == 0 || sum2 == 0) {
      if (sum2 == 0) {
        swap(a, x.a);
        swap(b, x.b);
        swap(sum1, sum2);
      }
      long long res = 0;
      for (int i = 1; i <= m; i++)
        if (x.b[i] != 0) {
          res = ((a[i] >= x.a[i]) && ((a[i] - x.a[i]) % x.b[i] == 0))
                    ? (a[i] - x.a[i]) / x.b[i]
                    : -1;
          break;
        } else if (a[i] != x.a[i])
          return 0;
      if (res == -1) return 0;
      for (int i = 1; i <= m; i++)
        if ((x.a[i] + res * x.b[i]) != a[i]) return 0;
      return 1;
    }
    long long sta = -1;
    for (int i = 1; i <= m; i++)
      if (b[i] * sum2 != x.b[i] * sum1) {
        sta = i;
        break;
      }
    if (sta == -1) {
      long long b1 = 0, b2 = 0, gcd1;
      for (int i = 1; i <= m; i++)
        if (b[i] != 0) {
          gcd1 = gcd(b[i], x.b[i]);
          b1 = b[i] / gcd1;
          b2 = x.b[i] / gcd1;
          break;
        }
      long long res = 0;
      for (int i = 1; i <= m; i++)
        if (b[i] != 0) {
          if ((a[i] - x.a[i]) % gcd1) return 0;
          res = (a[i] - x.a[i]) / gcd1;
          break;
        }
      for (int i = 1; i <= m; i++)
        if ((x.a[i] + res * gcd1) != a[i]) return 0;
      if (res < 0) {
        swap(a, x.a);
        swap(b, x.b);
        swap(b1, b2);
        res = -res;
      }
      long long xx, yy;
      exgcd(b1, b2, xx, yy);
      res = -res;
      xx = (xx * res % b2 + b2) % b2;
      for (int i = 1; i <= m; i++) a[i] += xx * b[i], b[i] *= b2;
    } else {
      long long p1 = sta, p2 = 0;
      for (int i = 1; i <= m; i++)
        if (b[p1] * x.b[i] != x.b[p1] * b[i]) {
          p2 = i;
          break;
        }
      long long xx = x.b[p2] * (x.a[p1] - a[p1]) - x.b[p1] * (x.a[p2] - a[p2]);
      long long yy = b[p2] * (x.a[p1] - a[p1]) - b[p1] * (x.a[p2] - a[p2]);
      long long fenm = x.b[p2] * b[p1] - b[p2] * x.b[p1];
      if (fenm < 0) xx = -xx, yy = -yy, fenm = -fenm;
      if (xx < 0 || yy < 0 || xx % fenm != 0 || yy % fenm != 0) return 0;
      xx /= fenm, yy /= fenm;
      for (int i = 1; i <= m; i++) {
        if ((a[i] + xx * b[i]) != (x.a[i] + yy * x.b[i])) return 0;
        a[i] += xx * b[i];
        b[i] = 0;
      }
    }
    return 1;
  }
} s[105];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d%d", &a[i], &b[i]);
    int a1 = a[i], b1 = b[i];
    for (int j = 2; j * j <= a[i]; j++)
      if (a1 % j == 0) {
        pri[++m] = j;
        while (a1 % j == 0) a1 /= j;
      }
    if (a1 != 1) pri[++m] = a1;
    for (int j = 2; j * j <= b[i]; j++)
      if (b1 % j == 0) {
        pri[++m] = j;
        while (b1 % j == 0) b1 /= j;
      }
    if (b1 != 1) pri[++m] = b1;
  }
  sort(pri + 1, pri + m + 1);
  m = unique(pri + 1, pri + m + 1) - pri - 1;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= m; j++)
      while (a[i] % pri[j] == 0) a[i] /= pri[j], s[i].a[j]++;
    for (int j = 1; j <= m; j++)
      while (b[i] % pri[j] == 0) b[i] /= pri[j], s[i].b[j]++;
  }
  for (int i = 2; i <= n; i++)
    if (!s[i].merge(s[i - 1])) return printf("-1"), 0;
  int ans = 1;
  for (int i = 1; i <= m; i++) ans = 1ll * ans * ksm(pri[i], s[n].a[i]) % MOD;
  printf("%d", ans);
  return 0;
}
