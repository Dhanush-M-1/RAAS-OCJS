#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 5, inf = 1e9;
int n, m, x, cnt, head[N], sz[N], low[N], dep[N], ans;
struct edge {
  int to, nxt;
} e[N << 1];
void adde(int x, int y) {
  e[++cnt].to = y;
  e[cnt].nxt = head[x];
  head[x] = cnt;
}
void dfs(int u, int par) {
  low[u] = 0;
  bool leaf = 1;
  for (int i = head[u], v; i; i = e[i].nxt)
    if (v = e[i].to, v != par) {
      leaf = 0;
      dep[v] = dep[u] + 1;
      dfs(v, u);
      if (dep[low[v]] - dep[u] <= m) sz[u] += sz[v], sz[v] = 0;
      if (dep[low[v]] < dep[low[u]]) low[u] = low[v];
    }
  if (leaf) low[u] = u, sz[u] = 1;
}
void dfs1(int u, int par, int val) {
  ans = max(ans, val);
  for (int i = head[u], v; i; i = e[i].nxt)
    if (v = e[i].to, v != par) dfs1(v, u, val + sz[v]);
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = (2); i <= (n); i++) scanf("%d", &x), adde(i, x), adde(x, i);
  dep[0] = inf;
  dfs(1, 0);
  dfs1(1, 0, sz[1]);
  printf("%d\n", ans);
  return 0;
}
