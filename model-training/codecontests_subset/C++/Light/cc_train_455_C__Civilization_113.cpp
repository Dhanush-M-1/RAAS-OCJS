#include <bits/stdc++.h>
using namespace std;
int n, m, q, pa[300005], d[300005];
vector<int> adj[300005];
int Find(int x) { return pa[x] == x ? x : pa[x] = Find(pa[x]); }
void Union(int u, int v, bool f) {
  int ru = Find(u), rv = Find(v);
  if (ru == rv) return;
  pa[ru] = rv;
  if (!f) return;
  d[rv] = max(max(d[ru], d[rv]), (d[ru] + 1) / 2 + (d[rv] + 1) / 2 + 1);
}
int dfs(int p, int v) {
  int ans = v, i, u, x;
  for (i = 0; i < (adj[v].size()); i++) {
    u = adj[v][i];
    if (u == p) continue;
    d[u] = d[v] + 1;
    x = dfs(v, u);
    if (d[ans] < d[x]) ans = x;
  }
  return ans;
}
int main() {
  int i, u, v, flag;
  scanf("%d%d%d", &n, &m, &q);
  for (i = 1; i <= (n); i++) pa[i] = i;
  for (i = 0; i < (m); i++) {
    scanf("%d%d", &u, &v);
    Union(u, v, false);
    adj[u].push_back(v);
    adj[v].push_back(u);
  }
  memset(d, 0, sizeof(d));
  for (i = 1; i <= (n); i++) {
    if (Find(i) == i) {
      u = dfs(0, i);
      d[u] = 0;
      d[i] = d[dfs(0, u)];
    }
  }
  while (q--) {
    scanf("%d", &flag);
    if (flag == 1) {
      scanf("%d", &u);
      printf("%d\n", d[Find(u)]);
    } else {
      scanf("%d%d", &u, &v);
      Union(u, v, true);
    }
  }
  return 0;
}
