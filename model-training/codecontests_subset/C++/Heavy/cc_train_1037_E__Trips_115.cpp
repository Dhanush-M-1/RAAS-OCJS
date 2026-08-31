#include <bits/stdc++.h>
const int maxn = 2e5 + 3;
int n, m, k, rest, eu[maxn], ev[maxn], ans[maxn];
std::set<int> G[maxn];
bool poped[maxn];
std::queue<int> q;
void delEdge(int u, int v) {
  G[u].erase(v);
  G[v].erase(u);
  if (G[u].size() < k && !poped[u]) {
    poped[u] = true;
    --rest;
    q.push(u);
  }
  if (G[v].size() < k && !poped[v]) {
    poped[v] = true;
    --rest;
    q.push(v);
  }
}
void erase() {
  while (!q.empty()) {
    int u = q.front();
    q.pop();
    std::set<int> E = G[u];
    for (const auto v : E) {
      delEdge(u, v);
    }
  }
}
int main() {
  scanf("%d%d%d", &n, &m, &k);
  for (int i = 0; i < m; ++i) {
    scanf("%d%d", eu + i, ev + i);
    G[eu[i]].insert(ev[i]);
    G[ev[i]].insert(eu[i]);
  }
  rest = n;
  for (int i = 1; i <= n; ++i) {
    if (G[i].size() < k) {
      poped[i] = true;
      --rest;
      q.push(i);
    }
  }
  erase();
  for (int i = m - 1; i >= 0; --i) {
    ans[i] = rest;
    delEdge(eu[i], ev[i]);
    erase();
  }
  for (int i = 0; i < m; ++i) printf("%d\n", ans[i]);
  return 0;
}
