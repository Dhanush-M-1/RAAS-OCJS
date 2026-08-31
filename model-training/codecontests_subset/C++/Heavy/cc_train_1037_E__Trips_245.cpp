#include <bits/stdc++.h>
const int N = 200005;
int n, m, k, ans[N], in[N], cnt;
std::map<int, bool> vis[N];
std::vector<int> G[N];
std::vector<std::pair<int, int> > e;
std::queue<int> q;
void topo() {
  while (!q.empty()) {
    int u = q.front();
    q.pop();
    in[u] = 0;
    for (int i = 0; i < (signed)G[u].size(); i++) {
      int v = G[u][i];
      if (vis[u][v]) continue;
      vis[u][v] = vis[v][u] = 1, in[v]--;
      if (in[v] == k - 1) cnt--, q.push(v);
    }
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 1, x, y; i <= m; i++) {
    scanf("%d%d", &x, &y);
    e.push_back(std::make_pair(x, y));
    G[x].push_back(y), G[y].push_back(x);
    in[x]++, in[y]++;
  }
  cnt = n;
  for (int i = 1; i <= n; i++)
    if (in[i] < k) cnt--, q.push(i);
  topo(), ans[m] = cnt;
  for (int i = m; i >= 2; i--) {
    int u = e[i - 1].first, v = e[i - 1].second;
    if (vis[u][v]) {
      ans[i - 1] = ans[i];
      continue;
    }
    vis[u][v] = vis[v][u] = 1;
    in[u]--, in[v]--;
    if (in[u] == k - 1) cnt--, q.push(u);
    if (in[v] == k - 1) cnt--, q.push(v);
    topo(), ans[i - 1] = cnt;
  }
  for (int i = 1; i <= m; i++) printf("%d\n", ans[i]);
  return 0;
}
