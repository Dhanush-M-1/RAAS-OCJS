#include <bits/stdc++.h>
using namespace std;
struct road {
  int start, end, len, id;
} rd[500005];
int fa[2005];
inline bool cmp(road x, road y) { return x.len > y.len; }
inline int getf(int x) {
  if (fa[x] == x) return fa[x];
  return fa[x] = getf(fa[x]);
}
inline void con(int x, int y) {
  int f1, f2;
  f1 = getf(x), f2 = getf(y);
  if (f1 != f2) fa[f1] = f2;
}
long long read() {
  long long ret = 0, f = 1;
  char c = getchar();
  while (!isdigit(c)) f = c == '-' ? -1 : 1, c = getchar();
  while (isdigit(c)) ret = ret * 10 + c - '0', c = getchar();
  return ret * f;
}
int main() {
  register int n, m, q;
  n = read(), m = read(), q = read();
  for (register int i = 1; i <= m; i++) {
    rd[i].start = read();
    rd[i].end = read();
    rd[i].len = read();
    rd[i].id = i;
  }
  sort(rd + 1, rd + 1 + m, cmp);
  while (q--) {
    register int ans = -1, l, r;
    l = read(), r = read();
    for (register int i = 1; i <= n * 2; i++) {
      fa[i] = i;
    }
    for (register int i = 1; i <= m; i++) {
      if (rd[i].id >= l && rd[i].id <= r) {
        if (getf(rd[i].start) == getf(rd[i].end)) {
          ans = rd[i].len;
          break;
        } else {
          con(rd[i].start + n, rd[i].end);
          con(rd[i].start, rd[i].end + n);
        }
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
