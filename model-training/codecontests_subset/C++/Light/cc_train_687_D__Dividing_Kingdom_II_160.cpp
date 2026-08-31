#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int w = 0, x = 0;
  char c = getchar();
  while (!isdigit(c)) w |= c == '-', c = getchar();
  while (isdigit(c)) x = x * 10 + (c ^ 48), c = getchar();
  return w ? -x : x;
}
namespace star {
const int maxn = 1005;
int n, m, q, fa[maxn << 1];
struct edge {
  int u, v, dis, id;
  inline bool operator<(const edge &zp) const { return dis > zp.dis; }
} a[maxn * maxn];
int find(int x) { return fa[x] == x ? x : fa[x] = find(fa[x]); }
inline void onion(int x, int y) { fa[find(x)] = find(y); }
inline void work() {
  n = read(), m = read(), q = read();
  for (int i = 1; i <= m; i++)
    a[i].u = read(), a[i].v = read(), a[i].dis = read(), a[i].id = i;
  sort(a + 1, a + 1 + m);
  while (q--) {
    int l = read(), r = read(), ans = -1;
    for (int i = 1; i <= n << 1; i++) fa[i] = i;
    for (int i = 1; i <= m; i++) {
      if (a[i].id > r or a[i].id < l) continue;
      if (find(a[i].u) == find(a[i].v)) {
        ans = a[i].dis;
        break;
      } else
        onion(a[i].u, a[i].v + n), onion(a[i].v, a[i].u + n);
    }
    printf("%d\n", ans);
  }
}
}  // namespace star
signed main() {
  star::work();
  return 0;
}
