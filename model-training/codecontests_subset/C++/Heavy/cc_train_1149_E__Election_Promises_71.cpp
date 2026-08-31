#include <bits/stdc++.h>
using namespace std;
template <typename _tp>
inline void read(_tp& x) {
  char ch = getchar(), ob = 0;
  x = 0;
  while (ch != '-' && !isdigit(ch)) ch = getchar();
  if (ch == '-') ob = 1, ch = getchar();
  while (isdigit(ch)) x = x * 10 + ch - '0', ch = getchar();
  if (ob) x = -x;
}
const int N = 201000;
struct Edge {
  int v, nxt;
} a[N + N];
int head[N], Head[N];
int h[N], xr[N], deg[N], q[N];
int tng[N], sg[N];
int n, m, _;
inline void ad() {
  static int x, y;
  read(x), read(y), ++deg[x];
  a[++_].v = y, a[_].nxt = head[x], head[x] = _;
  a[++_].v = x, a[_].nxt = Head[y], Head[y] = _;
}
int main() {
  read(n), read(m);
  for (int i = 1; i <= n; ++i) read(h[i]);
  for (int i = 1; i <= m; ++i) ad();
  int he = 1, ta = 0;
  for (int x = 1; x <= n; ++x)
    if (!deg[x]) q[++ta] = x;
  while (he <= ta) {
    int x = q[he++];
    for (int i = head[x]; i; i = a[i].nxt) tng[sg[a[i].v]] = 1;
    for (int i = 0; !sg[x]; ++i)
      if (!tng[i]) sg[x] = i;
    for (int i = head[x]; i; i = a[i].nxt) tng[sg[a[i].v]] = 0;
    for (int i = Head[x]; i; i = a[i].nxt)
      if (!(--deg[a[i].v])) q[++ta] = a[i].v;
  }
  m = 0;
  for (int i = 1; i <= n; ++i) m = max(m, sg[i]);
  for (int i = 1; i <= n; ++i) xr[sg[i]] ^= h[i];
  int d = 0;
  for (int i = 1; i <= m; ++i)
    if (xr[i]) d = i;
  if (!d) return puts("LOSE"), 0;
  puts("WIN");
  for (int x = 1; x <= n; ++x)
    if (sg[x] == d and (xr[sg[x]] ^ h[x]) < h[x]) {
      h[x] = (xr[sg[x]] ^ h[x]);
      xr[sg[x]] = 0;
      for (int i = head[x]; i; i = a[i].nxt)
        if (xr[sg[a[i].v]]) {
          h[a[i].v] ^= xr[sg[a[i].v]];
          xr[sg[a[i].v]] = 0;
        }
      for (int i = 1; i <= n; ++i) printf("%d ", h[i]);
      putchar(10);
      return 0;
    }
}
