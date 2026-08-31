#include <bits/stdc++.h>
using namespace std;
long long n, m, q, fa[1000010], ans, l, r;
struct lujing {
  long long u, v, c, id;
} f[1000010];
inline long long read() {
  register long long w = 0, e = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    e = ch == '-' ? -1 : 1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    w = (w << 3) + (w << 1) + (ch ^ 48);
    ch = getchar();
  }
  return w * e;
}
long long find(long long x) { return (fa[x] == x) ? x : (fa[x] = find(fa[x])); }
inline void add(long long x, long long y) {
  register long long xx = find(x), yy = find(y);
  if (xx != yy) fa[xx] = yy;
}
inline bool pd(long long x, long long y) {
  register long long xx = find(x), yy = find(y);
  if (xx == yy) return true;
  return false;
}
inline bool cmp(lujing x, lujing y) { return x.c > y.c; }
int main() {
  n = read();
  m = read();
  q = read();
  for (register int i = 1; i <= m; ++i)
    f[i].u = read(), f[i].v = read(), f[i].c = read(), f[i].id = i;
  sort(f + 1, f + 1 + m, cmp);
  while (q--) {
    l = read(), r = read();
    ans = -1;
    for (register int i = 1; i <= n * 2; ++i) fa[i] = i;
    for (register int i = 1; i <= m; ++i) {
      if (f[i].id >= l && f[i].id <= r) {
        if (pd(f[i].u, f[i].v)) {
          ans = f[i].c;
          break;
        } else {
          add(f[i].u + n, f[i].v);
          add(f[i].u, f[i].v + n);
        }
      }
    }
    cout << ans << endl;
  }
  return 0;
}
