#include <bits/stdc++.h>
using namespace std;
const int N = 3005;
int n, fa[N], dfn[N], ord, mark[N], len, vis[N];
vector<int> G[N];
void dfs(int u) {
  dfn[u] = ++ord;
  for (auto& v : G[u])
    if (v ^ fa[u]) {
      if (!dfn[v]) {
        fa[v] = u;
        dfs(v);
      } else if (dfn[v] < dfn[u]) {
        for (int p = u; p != fa[v]; p = fa[p]) mark[p] = 1, ++len;
      }
    }
}
double ans;
void dfs1(int u, int x, int y) {
  vis[u] = 1;
  ++x;
  if (!y)
    ans += 1.0 / x;
  else {
    ans += 1.0 / x;
    ans += 1.0 / (len - y - y + x);
    ans -= 1.0 / (x + len - y - 1);
  }
  for (auto& v : G[u])
    if (!vis[v]) dfs1(v, x, y + (mark[u] && mark[v]));
}
int main() {
  scanf("%d", &n);
  for (int i = 1, a, b; i <= n; i++) {
    scanf("%d%d", &a, &b);
    ++a;
    ++b;
    G[a].push_back(b);
    G[b].push_back(a);
  }
  dfs(1);
  for (int i = 1; i <= n; i++) {
    fill(vis, vis + 1 + n, 0);
    dfs1(i, 0, 0);
  }
  printf("%.9f", ans);
  return 0;
}
