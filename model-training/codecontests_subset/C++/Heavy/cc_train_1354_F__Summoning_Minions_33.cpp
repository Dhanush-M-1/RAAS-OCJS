#include <bits/stdc++.h>
using namespace std;
const long long buf_size = 1e5 + 5;
char buf[buf_size], *S, *T;
inline char read_char() {
  if (S == T) T = (S = buf) + fread(buf, 1, buf_size, stdin);
  return S != T ? *(S++) : EOF;
}
inline long long read_int() {
  long long x = 0, f = 1;
  char c = read_char();
  while (c < '0' || c > '9') {
    if (c == '-') f = -1;
    c = read_char();
  }
  while (c >= '0' && c <= '9') x = x * 10 + c - 48, c = read_char();
  return x * f;
}
const long long N = 80;
long long t, n, k;
struct node {
  long long a, b, id;
  bool operator<(const node& x) const { return b < x.b; }
} a[N];
long long f[N][N];
bool g[N][N];
bool mark[N];
signed main() {
  t = read_int();
  while (t--) {
    n = read_int(), k = read_int();
    for (long long i = 1; i <= n; i++)
      a[i].a = read_int(), a[i].b = read_int(), a[i].id = i;
    sort(a + 1, a + n + 1);
    for (long long i = 0; i <= n; i++)
      for (long long j = 0; j <= k; j++) f[i][j] = -10000000000, g[i][j] = 0;
    f[0][0] = 0;
    for (long long i = 1; i <= n; i++) {
      for (long long j = 0; j <= min(i, k); j++) {
        if (f[i - 1][j] + a[i].b * (k - 1) > f[i][j])
          f[i][j] = f[i - 1][j] + a[i].b * (k - 1);
        if (j > 0 && f[i - 1][j - 1] + a[i].a + a[i].b * (j - 1) > f[i][j])
          f[i][j] = f[i - 1][j - 1] + a[i].a + a[i].b * (j - 1), g[i][j] = 1;
      }
    }
    for (long long i = n, j = k; i >= 1; i--) {
      mark[a[i].id] = g[i][j];
      j -= g[i][j];
    }
    printf("%lld\n", 2 * n - k);
    long long p = 1;
    for (long long i = 1; i <= n; i++) {
      if (mark[a[i].id] && p < k) {
        p++;
        printf("%lld ", a[i].id);
      }
    }
    for (long long i = 1; i <= n; i++) {
      if (!mark[a[i].id]) printf("%lld %lld ", a[i].id, -a[i].id);
    }
    for (long long i = n; i >= 1; i--)
      if (mark[a[i].id]) {
        printf("%lld\n", a[i].id);
        break;
      }
  }
  return 0;
}
