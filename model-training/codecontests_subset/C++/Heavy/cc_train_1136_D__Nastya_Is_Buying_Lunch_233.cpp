#include <bits/stdc++.h>
using namespace std;
const int max_n = 300005;
int n, m;
int p[max_n];
int rk[max_n];
bool vis[max_n];
vector<int> G[max_n];
set<int> s;
void dfs(int u) {
  for (auto v : G[u]) s.erase(rk[v]);
  vector<int> can;
  for (auto v : s) {
    if (v < rk[u]) {
      v = p[v];
      can.push_back(v);
      vis[rk[v]] = true;
    } else
      break;
  }
  for (auto v : G[u])
    if (!vis[rk[v]]) s.insert(rk[v]);
  for (auto v : can) s.erase(rk[v]);
  for (auto v : can) dfs(v);
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", p + i), rk[p[i]] = i;
  for (int i = 0; i < m; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    G[v].push_back(u);
  }
  for (int i = 1; i <= n - 1; i++) s.insert(i);
  vis[n] = true;
  dfs(p[n]);
  printf("%d\n", s.size());
  return 0;
}
