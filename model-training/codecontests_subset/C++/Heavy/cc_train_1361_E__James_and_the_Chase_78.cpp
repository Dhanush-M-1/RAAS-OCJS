#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 6;
mt19937 rnd(0);
int dfn[N], low[N], id[N], vis[N], dc, cnt;
vector<int> G[N];
bool dfs1(int u) {
  dfn[u] = low[u] = ++dc, id[dc] = u, vis[u] = -1, ++cnt;
  for (int i = 0, iend = G[u].size(); i < iend; ++i) {
    int v = G[u][i];
    if (!dfn[v]) {
      if (dfs1(v)) return true;
      low[u] = min(low[u], low[v]);
    } else if (vis[v] == -1)
      low[u] = min(low[u], dfn[v]);
    else
      return true;
  }
  vis[u] = 1;
  return false;
}
int tg[N];
void dfs2(int u) {
  for (int i = 0, iend = G[u].size(); i < iend; ++i) {
    int v = G[u][i];
    if (dfn[v] > dfn[u]) dfs2(v), tg[u] += tg[v];
  }
}
int k, ok[N];
void solve(int u) {
  if (ok[u]) ++k;
  for (int i = 0, iend = G[u].size(); i < iend; ++i) {
    int v = G[u][i];
    if (dfn[v] > dfn[u]) {
      if (tg[v] >= 2)
        ok[v] = false, solve(v);
      else if (!tg[v])
        continue;
      else
        ok[v] = ok[id[low[v]]], solve(v);
    }
  }
}
int main() {
  int T;
  scanf("%d", &T);
  while (T--) {
    int n, m;
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; ++i) G[i].clear(), tg[i] = 0;
    for (int i = 1; i <= m; ++i) {
      int u, v;
      scanf("%d%d", &u, &v);
      G[u].push_back(v);
    }
    int rt = 0;
    for (int t = 1; t <= 100; ++t) {
      int u = rnd() % n + 1;
      for (int i = 1; i <= n; ++i) dfn[i] = 0;
      dc = cnt = 0;
      if (!dfs1(u) && cnt == n) {
        rt = u;
        break;
      }
    }
    for (int u = 1; u <= n; ++u)
      for (int i = 0, iend = G[u].size(); i < iend; ++i)
        if (dfn[G[u][i]] < dfn[u]) ++tg[u], --tg[G[u][i]];
    k = 0;
    dfs2(rt), ok[rt] = true, solve(rt);
    if (!rt || 5 * k < n)
      puts("-1");
    else {
      for (int i = 1; i <= n; ++i)
        if (ok[i]) printf("%d ", i);
      putchar('\n');
    }
  }
  return 0;
}
