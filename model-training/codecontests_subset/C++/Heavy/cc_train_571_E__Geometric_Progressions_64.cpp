#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
int n, top;
long long maxn, a[110], b[110], sa[110][410], sb[110][410], q[410];
inline int mo(int x) {
  if (x >= MOD) return x - MOD;
  return x;
}
inline long long gcd(long long x, long long y) {
  if (x < 0) return gcd(-x, y);
  if (y < 0) return gcd(x, -y);
  if (!y) return x;
  return gcd(y, x % y);
}
inline void exgcd(long long a, long long b, long long &x, long long &y) {
  if (!b) {
    x = 1;
    y = 0;
    return;
  }
  exgcd(b, a % b, y, x);
  y -= a / b * x;
}
inline int power(int x, long long y) {
  int ans = 1, t = x;
  while (y) {
    if (y % 2) ans = 1ll * ans * t % MOD;
    t = 1ll * t * t % MOD;
    y /= 2;
  }
  return ans;
}
long long solve(long long a, long long b, long long c) {
  if (!a) return 0;
  if (!b) return c / a;
  if (a < 0) a = -a;
  if (b < 0) b = -b;
  long long x, y;
  exgcd(a, b, x, y);
  x = x * c;
  x = (x % b + b) % b;
  y = (c - a * x) / (-b);
  long long t = (y >= 0 ? 0 : (-y + a - 1) / a);
  x += t * b;
  return x;
}
inline int read() {
  int ans = 0;
  char ch = getchar();
  while (ch < '0' || ch > '9') ch = getchar();
  while (ch >= '0' && ch <= '9')
    ans = (ans << 1) + (ans << 3) + ch - '0', ch = getchar();
  return ans;
}
void gofail() {
  printf("-1\n");
  exit(0);
}
int main() {
  n = read();
  for (int i = 1; i <= n; i++)
    a[i] = read(), b[i] = read(), maxn = max(maxn, a[i]),
    maxn = max(maxn, b[i]);
  maxn = sqrt(maxn);
  for (int i = 2; i <= maxn; i++)
    if (a[1] % i == 0 || b[1] % i == 0) {
      q[++top] = i;
      while (a[1] % i == 0) sa[1][top]++, a[1] /= i;
      while (b[1] % i == 0) sb[1][top]++, b[1] /= i;
    }
  if (a[1] != 1) {
    q[++top] = a[1];
    sa[1][top] = 1;
    if (b[1] == a[1]) sb[1][top] = 1, b[1] = 1;
    a[1] = 1;
  }
  if (b[1] != 1) {
    q[++top] = b[1];
    sb[1][top] = 1;
  }
  for (int j = 2; j <= n; j++) {
    for (int i = 1; i <= top; i++) {
      while (a[j] % q[i] == 0) a[j] /= q[i], sa[j][i]++;
      while (b[j] % q[i] == 0) b[j] /= q[i], sb[j][i]++;
    }
    if (a[j] != 1) {
      q[++top] = a[j], sa[j][top] = 1;
      if (b[j] == a[j]) sb[j][top] = 1, b[j] = 1;
      a[j] = 1;
    }
    if (b[j] != 1) q[++top] = b[j], sb[j][top] = 1;
  }
  if (!top) {
    printf("1\n");
    return 0;
  }
  for (int i = 2; i <= n; i++) {
    long long l = 0, la = 0, lb = 0, lc = 0;
    long long p = 0, px = 0, py = 0;
    for (int j = 1; j <= top; j++) {
      long long A = sb[1][j], B = -sb[i][j], C = sa[i][j] - sa[1][j],
                G = gcd(A, B);
      if (A == 0 && B == 0) {
        if (C) gofail();
        continue;
      }
      if (C % G) gofail();
      A /= G;
      B /= G;
      C /= G;
      if (A < 0 || (A == 0 && B < 0)) A = -A, B = -B, C = -C;
      if (p) {
        if (px * A + py * B != C) gofail();
      } else if (l) {
        if (la == A && lb == B) {
          if (lc != C) gofail();
        } else {
          long long X0 = A * lb - B * la, X1 = C * lb - B * lc;
          long long Y0 = B * la - A * lb, Y1 = C * la - A * lc;
          if (X1 % X0 || Y1 % Y0) gofail();
          l = 0;
          p = 1;
          px = X1 / X0;
          py = Y1 / Y0;
          if (px < 0 || py < 0) gofail();
        }
      } else
        l = 1, la = A, lb = B, lc = C;
    }
    if (l) {
      for (int j = 1; j <= top; j++)
        sa[1][j] = sa[1][j] + sb[1][j] * solve(la, lb, lc), sb[1][j] *= (-lb);
    } else if (p) {
      for (int j = 1; j <= top; j++) sa[1][j] += sb[1][j] * px, sb[1][j] = 0;
    }
  }
  int ans = 1;
  for (int i = 1; i <= top; i++) ans = 1ll * ans * power(q[i], sa[1][i]) % MOD;
  printf("%d\n", ans);
}
