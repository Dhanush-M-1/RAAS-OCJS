#include <bits/stdc++.h>
inline long long read() {
  char c = getchar();
  while (c != '-' && (c < '0' || c > '9')) c = getchar();
  long long k = 0, kk = 1;
  if (c == '-') c = getchar(), kk = -1;
  while (c >= '0' && c <= '9') k = k * 10 + c - '0', c = getchar();
  return kk * k;
}
using namespace std;
void write(long long x) {
  if (x < 0) x = -x, putchar('-');
  if (x / 10) write(x / 10);
  putchar(x % 10 + '0');
}
void writeln(long long x) {
  write(x);
  puts("");
}
long long n, c[1000010], x, y, b[1000010], a[1000010][3], last[1000010],
    f[1000010], kk;
long double ff[1000010];
void dfs(long long x) {
  f[x] = ff[x] = c[x] - b[x];
  for (long long i = last[x]; i; i = a[i][0]) {
    dfs(a[i][1]);
    if (f[a[i][1]] >= 0)
      f[x] += f[a[i][1]], ff[x] += ff[a[i][1]];
    else
      f[x] += f[a[i][1]] * a[i][2], ff[x] += ff[a[i][1]] * a[i][2];
  }
}
void doit(long long x, long long y, long long z) {
  a[++kk][0] = last[x];
  a[kk][1] = y;
  a[kk][2] = z;
  last[x] = kk;
}
signed main() {
  n = read();
  for (long long i = 1; i <= n; i++) c[i] = read();
  for (long long i = 1; i <= n; i++) b[i] = read();
  for (long long i = 1; i < n; i++) x = read(), y = read(), doit(x, i + 1, y);
  dfs(1);
  if (ff[1] >= 1e15 || fabs(ff[1] - f[1]) <= 1e9 && f[1] >= 0)
    puts("YES");
  else
    puts("NO");
}
