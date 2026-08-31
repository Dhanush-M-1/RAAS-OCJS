#include <bits/stdc++.h>
using namespace std;
int n, m, q, fa[300050], len[300050], vis[300050];
vector<int> adj[300050];
pair<int, int> res;
int get(int u) { return u == fa[u] ? u : fa[u] = get(fa[u]); }
void dfs(int u, int fa, int d) {
  vis[u] = 1;
  res = max(res, make_pair(d, u));
  for (auto v : adj[u])
    if (v != fa) dfs(v, u, d + 1);
}
int go(int u) {
  res = make_pair(0, 0), dfs(u, 0, 0), u = res.second, res = make_pair(0, 0),
  dfs(u, 0, 0);
  return res.first;
}
int main() {
  int opt, u, v;
  scanf("%d%d%d", &n, &m, &q);
  for (register int i = 1; i <= n; ++i) fa[i] = i;
  for (register int i = 1; i <= m; ++i)
    scanf("%d%d", &u, &v), fa[get(u)] = get(v), adj[u].push_back(v),
                           adj[v].push_back(u);
  for (register int i = 1; i <= n; ++i)
    if (!vis[i]) len[get(i)] = go(i);
  while (q--) {
    scanf("%d%d", &opt, &u);
    if (opt == 1)
      printf("%d\n", len[get(u)]);
    else {
      scanf("%d", &v), u = get(u), v = get(v);
      if (u != v) {
        fa[u] = v,
        len[v] = max(max(len[u], len[v]),
                     len[u] / 2 + (len[u] & 1) + len[v] / 2 + (len[v] & 1) + 1);
      }
    }
  }
  return 0;
}
