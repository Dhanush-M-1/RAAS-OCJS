#include <bits/stdc++.h>
int read() {
  int r = 0, t = 1, c = getchar();
  while (c < '0' || c > '9') {
    t = c == '-' ? -1 : 1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    r = (r << 3) + (r << 1) + (c ^ 48);
    c = getchar();
  }
  return r * t;
}
const long long mod = 1000000007, inf = 1ll << 60, N = 110;
long long power(long long a, long long b, long long p) {
  long long r = 1;
  for (; b; b >>= 1, a = a * a % p)
    if (b & 1) r = r * a % p;
  return r;
}
long long calc(long long a, int b) {
  long long s = (long long)(pow(a, 1. / b) + 0.5);
  return power(s, b, inf) == a ? s : 0;
}
long long n, a[N], b[N], c[N], d[N];
long long v[N];
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long split(long long a, long long p) {
  for (int i = (1), end_i = (p); i <= end_i; i++) {
    long long g;
    if (v[i] != 1 && (g = gcd(a, v[i])) != 1) {
      v[i] /= g;
      a /= g;
    }
    if (a == 1) return 1;
  }
  return 0;
}
long long checkv(long long p) {
  for (int i = (1), end_i = (p); i <= end_i; i++)
    if (v[i] != 1) return 0;
  return 1;
}
long long check(long long a, long long b, long long p, long long A,
                long long B) {
  p++;
  v[1] = a;
  for (int i = (2), end_i = (p); i <= end_i; i++) v[i] = b;
  if (!split(A, p)) return 0;
  if (!checkv(p) && B == 1) return 0;
  while (!checkv(p))
    if (!split(B, p)) return 0;
  return 1;
}
long long check(long long A, long long B, long long p) {
  for (int i = (1), end_i = (n); i <= end_i; i++)
    if (!check(A, B, p, a[i], b[i])) return 0;
  return 1;
}
int main() {
  n = read();
  for (int i = (1), end_i = (n); i <= end_i; i++) {
    a[i] = read();
    b[i] = read();
  }
  int flag = 0;
  for (int i = (1), end_i = (n); i <= end_i; i++)
    if (b[i] == 1) flag = 1;
  if (flag) {
    for (int i = (1), end_i = (n); i <= end_i; i++)
      if (b[i] == 1) {
        if (check(a[i], b[i], 0))
          printf("%I64d\n", a[i]);
        else
          printf("-1\n");
        return 0;
      }
  }
  for (int i = (1), end_i = (n); i <= end_i; i++) {
    for (int j = (29), end_j = (0); j >= end_j; j--)
      if (calc(b[i], j)) {
        d[i] = j;
        b[i] = calc(b[i], j);
        break;
      }
    while (a[i] % b[i] == 0) {
      a[i] /= b[i];
      c[i]++;
    }
  }
  for (int i = (2), end_i = (n); i <= end_i; i++)
    if (b[i] != b[1]) {
      for (int j = (1), end_j = (n); j <= end_j; j++) {
        a[j] = a[j] * power(b[j], c[j], inf);
        b[j] = power(b[j], d[j], inf);
      }
      for (int j = (0), end_j = (100); j <= end_j; j++)
        if (check(a[1], b[1], j, a[i], b[i])) {
          if (check(a[1], b[1], j))
            printf("%I64d\n", power(b[1], j, mod) * a[1] % mod);
          else
            printf("-1\n");
          return 0;
        }
      printf("-1\n");
      return 0;
    }
  for (int i = (2), end_i = (n); i <= end_i; i++)
    if (a[i] != a[1]) {
      printf("-1\n");
      return 0;
    }
  long long ans = c[1], Ans = d[1];
  for (int i = (2), end_i = (n); i <= end_i; i++) {
    int flag = 0;
    for (int j = (0), end_j = (1000); j <= end_j; j++)
      if (ans + Ans * j >= c[i] && (ans + Ans * j - c[i]) % d[i] == 0) {
        ans += Ans * j;
        flag = 1;
        break;
      }
    if (!flag) {
      printf("-1\n");
      return 0;
    }
    Ans = Ans * d[i] / gcd(Ans, d[i]);
  }
  printf("%I64d\n", a[1] * power(b[1], ans, mod) % mod);
  return 0;
}
