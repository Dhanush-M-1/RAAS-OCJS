#include <bits/stdc++.h>
using namespace std;
using ld = long double;
const int N = 100005;
int n, m;
vector<int> g[N];
int vis[N];
int cnt;
int up[N];
bool dp[N];
int par[N];
bool dfs(int u) {
  vis[u] = 1;
  cnt++;
  for (int v : g[u]) {
    if (vis[v] == 2) return false;
    if (!vis[v]) {
      par[v] = u;
      if (!dfs(v)) return false;
      up[u] += up[v];
    } else
      up[u]++, up[v]--;
  }
  vis[u] = 2;
  return true;
}
multiset<int> edges[N];
int sv[N];
void f(int u) {
  vis[u] = 1;
  for (int v : g[u]) {
    if (!vis[v]) {
      f(v);
      if (edges[u].size() < edges[v].size())
        ;
      for (int x : edges[v]) edges[u].insert(x);
      edges[v].clear();
    } else
      edges[u].insert(v);
  }
  edges[u].erase(u);
  if (up[u] == 1) sv[u] = *edges[u].begin();
}
void prop(int u) {
  if (sv[u]) {
    dp[u] &= dp[sv[u]];
  }
  vis[u] = 1;
  for (int v : g[u])
    if (!vis[v]) prop(v);
}
mt19937 rng(58);
void solve() {
  int it = 100;
  vector<int> ids(n);
  iota(ids.begin(), ids.end(), 1);
  shuffle(ids.begin(), ids.end(), rng);
  for (int u : ids) {
    if (--it == 0) break;
    memset(vis, 0, (n + 2) * sizeof(vis[0]));
    memset(up, 0, (n + 2) * sizeof(up[0]));
    if (!dfs(u) or cnt < n) continue;
    for (int i = 1; i <= n; i++) dp[i] = up[i] == 1;
    dp[u] = 1;
    par[u] = -1;
    memset(vis, 0, (n + 2) * sizeof(vis[0]));
    memset(sv, 0, (n + 2) * sizeof(sv[0]));
    f(u);
    memset(vis, 0, (n + 2) * sizeof(vis[0]));
    prop(u);
    vector<int> ans;
    for (int i = 1; i <= n; i++)
      if (dp[i]) {
        ans.push_back(i);
      }
    if ((int)ans.size() * 5 < n) break;
    for (int x : ans) printf("%d ", x);
    printf("\n");
    return;
  }
  printf("-1\n");
}
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    scanf("%d %d", &n, &m);
    for (int i = 0; i < m; i++) {
      int u, v;
      scanf("%d %d", &u, &v);
      g[u].push_back(v);
    }
    solve();
    for (int i = 1; i <= n; i++) g[i].clear(), edges[i].clear();
  }
}
