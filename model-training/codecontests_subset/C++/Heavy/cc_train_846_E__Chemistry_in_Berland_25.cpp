#include <bits/stdc++.h>
const int inf = 0x3f3f3f3f;
using namespace std;
template <typename IO>
inline void write(IO x) {
  if (x == 0) return (void)putchar('0');
  if (x < 0) putchar('-'), x = -x;
  static char buf[30];
  char *p = buf;
  while (x) {
    *(p++) = x % 10 + '0';
    x /= 10;
  }
  while (p > buf) putchar(*(--p));
}
inline void writestr(const char *s) {
  while (*s != 0) putchar(*(s++));
}
template <typename IO>
inline void writeln(IO x) {
  write(x), putchar('\n');
}
template <typename IO>
inline void writesp(IO x) {
  write(x), putchar(' ');
}
inline int readstr(char *s) {
  char *begin = s, c = getchar();
  while (c < 33 || c > 127) {
    c = getchar();
  }
  while (c >= 33 && c <= 127) {
    *(s++) = c;
    c = getchar();
  }
  *s = 0;
  return s - begin;
}
template <typename IO>
inline IO read() {
  IO x = 0;
  register bool w = 0;
  register char c = getchar();
  while (c > '9' || c < '0') {
    if (c == '-') w = 1;
    c = getchar();
  }
  while (c >= '0' && c <= '9') {
    x = (x << 3) + (x << 1) + (c ^ 48);
    c = getchar();
  }
  return w ? -x : x;
}
template <>
inline double read<double>() {
  double x = 0;
  int w = 0, y = 0;
  long long z = 1;
  register char c = getchar();
  while (c > '9' || c < '0') {
    if (c == '-') w = 1;
    c = getchar();
  }
  while (c >= '0' && c <= '9' || c == '.') {
    if (c == '.') {
      y = 1, c = getchar();
      continue;
    }
    x = x * 10 + (c ^ 48);
    if (y) z *= 10;
    c = getchar();
  }
  return (w ? -x : x) / z;
}
vector<long long> ve[100001], rat[100001];
long long a[100001];
inline void dfs(long long x) {
  for (register long long i = 0, siz = ve[x].size(), y; i < siz; i++) {
    dfs(y = ve[x][i]);
    if (a[y] >= 0) {
      a[x] += a[y];
    } else {
      if (log10(-a[y] + 1) + log10(rat[x][i] + 1) > 18)
        writestr("NO\n"), exit(0);
      a[x] += a[y] * rat[x][i];
    }
    if (a[x] < -1e18) writestr("NO\n"), exit(0);
  }
}
signed main() {
  register long long n = read<long long>(), x;
  for (register long long i = 1; i <= n; i++) a[i] = read<long long>();
  for (register long long i = 1; i <= n; i++) a[i] = a[i] - read<long long>();
  for (register long long i = 2; i <= n; i++)
    x = read<long long>(), ve[x].push_back(i),
    rat[x].push_back(read<long long>());
  dfs(1), writestr(a[1] < 0 ? "NO\n" : "YES\n");
}
