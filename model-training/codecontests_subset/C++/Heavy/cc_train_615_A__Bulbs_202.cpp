#include <bits/stdc++.h>
using namespace std;
int n, m, x, i, y;
bool f[110];
inline int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch <= '9' && ch >= '0') x = x * 10 + ch - '0', ch = getchar();
  return x * f;
}
inline void write(int x) {
  if (x < 0) putchar('-'), x = -x;
  if (x >= 10) write(x / 10);
  putchar(x % 10 + '0');
}
int main() {
  m = read();
  n = read();
  for (i = 1; i <= m; i++) {
    x = read();
    while (x) {
      x--;
      y = read();
      f[y] = 1;
    }
  }
  for (i = 1; i <= n; i++)
    if (!f[i]) {
      puts("NO");
      return 0;
    }
  puts("YES");
}
