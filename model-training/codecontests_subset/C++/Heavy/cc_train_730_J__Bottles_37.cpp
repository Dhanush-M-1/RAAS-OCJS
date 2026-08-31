#include <bits/stdc++.h>
using namespace std;
int scan(int *buf_tar) {
  char buf_c = 0;
  bool is_rev = 0;
  while (buf_c != '-' && (buf_c < '0' || buf_c > '9')) {
    buf_c = getchar();
    if (buf_c == EOF) return EOF;
  }
  if (buf_c == '-') is_rev = 1, buf_c = getchar();
  *buf_tar = 0;
  while (buf_c >= '0' && buf_c <= '9') {
    *buf_tar *= 10;
    *buf_tar += buf_c - '0';
    buf_c = getchar();
  }
  if (is_rev) *buf_tar = -*buf_tar;
  return 0;
}
int scan(long long *buf_tar) {
  char buf_c = 0;
  bool is_rev = 0;
  while (buf_c != '-' && (buf_c < '0' || buf_c > '9')) {
    buf_c = getchar();
    if (buf_c == EOF) return EOF;
  }
  if (buf_c == '-') is_rev = 1, buf_c = getchar();
  *buf_tar = 0;
  while (buf_c >= '0' && buf_c <= '9') {
    *buf_tar *= 10;
    *buf_tar += buf_c - '0';
    buf_c = getchar();
  }
  if (is_rev) *buf_tar = -*buf_tar;
  return 0;
}
int n;
int a[110], b[110], sb[110];
int limit[110];
int f[110][10010];
inline bool cp(const int &, const int &);
int main() {
  register int suma = 0, max_cnt, ans = 0;
  scan(&n);
  for (int i = 1; i <= n; ++i) {
    scan(&a[i]);
    suma += a[i];
  }
  for (int i = 1; i <= n; ++i) {
    scan(&b[i]);
    sb[i] = b[i];
  }
  sort(sb + 1, sb + 1 + n, cp);
  for (int i = 1; i <= n; ++i) limit[i] = limit[i - 1] + sb[i];
  for (int i = 1; i <= n; ++i)
    if (limit[i] >= suma) {
      printf("%d ", max_cnt = i);
      break;
    }
  memset(f, -1, sizeof(f));
  f[0][0] = 0;
  for (int i = 1; i <= n; ++i)
    for (int j = max_cnt; j; --j)
      for (int t = limit[j - 1] + b[i]; t >= b[i]; --t)
        if (f[j - 1][t - b[i]] >= 0)
          f[j][t] = max(f[j][t], f[j - 1][t - b[i]] + a[i]);
  for (int i = suma; i <= limit[max_cnt]; ++i) ans = max(ans, f[max_cnt][i]);
  printf("%d\n", suma - ans);
  return 0;
}
inline bool cp(const int &_a, const int &_b) { return _a > _b; }
