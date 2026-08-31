#include <bits/stdc++.h>
const int N = (int)3e5 + 228;
using namespace std;
int n, m, q, pr[N], d[N], sz[N];
vector<int> g[N];
void build() {
  for (int i = 1; i <= n; i++) pr[i] = i, sz[i] = 1, d[i] = 0;
}
int get(int v) {
  if (pr[v] == v) return v;
  return pr[v] = get(pr[v]);
}
void merge(int v, int u) {
  v = get(v), u = get(u);
  if (v == u) return;
  if (sz[v] > sz[u]) {
    d[v] = max({d[v], d[u], (d[v] + 1) / 2 + (d[u] + 1) / 2 + 1});
    sz[v] += sz[u];
    pr[u] = v;
  } else {
    d[u] = max({d[v], d[u], (d[v] + 1) / 2 + (d[u] + 1) / 2 + 1});
    pr[v] = u;
    sz[u] += sz[v];
  }
}
void dfs(int v, int depth, int pr, int& res, int& u) {
  if (depth > res) res = depth, u = v;
  for (auto to : g[v]) {
    if (to == pr) continue;
    dfs(to, depth + 1, v, res, u);
  }
}
int getDiag(int v) {
  int res = 0, u = v;
  dfs(v, 0, -1, res, u);
  res = 0, v = u;
  dfs(v, 0, -1, res, u);
  return res;
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  build();
  for (int i = 1; i <= m; i++) {
    int v, u;
    scanf("%d%d", &v, &u);
    merge(v, u);
    g[v].push_back(u);
    g[u].push_back(v);
  }
  for (int i = 1; i <= n; i++)
    if (pr[i] == i) d[i] = getDiag(i);
  for (int i = 1; i <= q; i++) {
    int type;
    scanf("%d", &type);
    if (type == 1) {
      int v;
      scanf("%d", &v);
      v = get(v);
      printf("%d\n", d[v]);
    } else {
      int v, u;
      scanf("%d%d", &v, &u);
      merge(v, u);
    }
  }
  return 0;
}
