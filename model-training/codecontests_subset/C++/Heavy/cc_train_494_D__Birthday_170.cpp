#include <bits/stdc++.h>
using namespace std;
namespace FGF {
long long n, m;
const int N = 1e5 + 5;
const int mo = 1e9 + 7;
long long fa[N][25], dep[N], dis[N], siz[N], sumd[N], sums[N], sq[N], d[N], ans;
int head[N], cnt;
struct edg {
  int to, nxt;
  long long w;
} e[N << 1];
void add(int u, int v, int w) {
  cnt++;
  e[cnt].to = v;
  e[cnt].nxt = head[u];
  head[u] = cnt;
  e[cnt].w = w;
}
void dfs1(int u, int f) {
  siz[u] = 1, dep[u] = dep[f] + 1, fa[u][0] = f;
  for (int i = 1; i <= 18; i++) fa[u][i] = fa[fa[u][i - 1]][i - 1];
  for (int i = head[u]; i; i = e[i].nxt) {
    int v = e[i].to;
    if (v != f) {
      d[v] = (d[u] + e[i].w) % mo;
      dfs1(v, u);
      dis[u] = (dis[u] + (e[i].w * siz[v] % mo + dis[v]) % mo) % mo;
      sq[u] = ((sq[u] + sq[v]) % mo + 2LL * e[i].w % mo * dis[v] % mo +
               siz[v] * e[i].w % mo * e[i].w % mo) %
              mo;
      siz[u] += siz[v];
    }
  }
}
void dfs2(int u, int f) {
  for (int i = head[u]; i; i = e[i].nxt) {
    int v = e[i].to;
    if (v != f) {
      long long sd = (sq[v] + 2LL * e[i].w % mo * dis[v] % mo +
                      siz[v] * e[i].w % mo * e[i].w % mo) %
                     mo;
      long long d = (sumd[u] - dis[v] - siz[v] * e[i].w % mo + mo) % mo;
      sums[v] = ((sums[u] - sd + 2LL * d * e[i].w % mo +
                  (n - siz[v]) * e[i].w % mo * e[i].w + sq[v]) %
                     mo +
                 mo) %
                mo;
      sumd[v] = (d + (n - siz[v]) * e[i].w % mo + dis[v]) % mo;
      dfs2(v, u);
    }
  }
}
int getlca(int u, int v) {
  if (dep[u] < dep[v]) swap(u, v);
  int d = dep[u] - dep[v];
  for (int i = 18; i >= 0; i--)
    if (d & (1 << i)) u = fa[u][i];
  if (u == v) return u;
  for (int i = 18; i >= 0; i--)
    if (fa[u][i] != fa[v][i]) u = fa[u][i], v = fa[v][i];
  return fa[u][0];
}
void work() {
  scanf("%lld", &n);
  int u, v, w;
  for (int i = 1; i < n; i++) {
    scanf("%d%d%d", &u, &v, &w);
    add(u, v, w), add(v, u, w);
  }
  dfs1(1, 0);
  sumd[1] = dis[1], sums[1] = sq[1];
  dfs2(1, 0);
  scanf("%lld", &m);
  while (m--) {
    scanf("%d%d", &u, &v);
    int lca = getlca(u, v);
    long long disuv = ((d[u] + d[v] - 2 * d[lca]) % mo + mo) % mo;
    if (lca != v) {
      long long suv =
          (sq[v] + 2 * dis[v] * disuv % mo + siz[v] * disuv % mo * disuv % mo) %
          mo;
      ans = (2 * suv - sums[u] + mo) % mo;
    } else {
      long long outvs = (sums[v] - sq[v] + mo) % mo, outvd = sumd[v] - dis[v];
      long long outs = (outvs + (n - siz[v]) * disuv % mo * disuv % mo +
                        2 * disuv * outvd % mo) %
                       mo;
      ans = ((sums[u] - outs - outs) % mo + mo) % mo;
    }
    printf("%lld\n", ans);
  }
}
}  // namespace FGF
int main() {
  FGF::work();
  return 0;
}
