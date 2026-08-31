#include <bits/stdc++.h>
using namespace std;
const int N = 3e5 + 5;
int S, R, maxi;
vector<int> adj[N];
int par[N], d[N];
void dfs(int ind, int p, int anc) {
  int i, u;
  d[ind] = d[p] + 1;
  if (d[ind] > maxi) R = ind, maxi = d[ind];
  par[ind] = anc;
  for (i = 0; i < adj[ind].size(); ++i) {
    u = adj[ind][i];
    if (u != p) {
      dfs(u, ind, anc);
    }
  }
}
int get(int u) {
  if (u == par[u]) return u;
  return par[u] = get(par[u]);
}
void merge(int u, int v) {
  u = get(u), v = get(v);
  if (u == v) return;
  if (d[u] < d[v]) swap(u, v);
  par[v] = u;
  d[u] = max(d[u], (d[v] - d[v] / 2) + (d[u] - d[u] / 2) + 1);
}
int main() {
  int type, x, y, n, m, q, i, j, a, b;
  cin >> n >> m >> q;
  for (i = 1; i <= n; ++i) par[i] = i;
  d[0] = -1;
  for (i = 0; i < m; ++i)
    scanf("%d%d", &a, &b), adj[a].push_back(b), adj[b].push_back(a);
  for (i = 1; i <= n; ++i) {
    if (par[i] == i) {
      S = i;
      R = i;
      maxi = 0;
      dfs(S, 0, i);
      maxi = 0;
      S = R;
      dfs(S, 0, i);
      d[i] = maxi;
    }
  }
  while (q--) {
    scanf("%d%d", &type, &x);
    if (type == 1) {
      printf("%d\n", d[get(x)]);
    } else {
      scanf("%d", &y);
      merge(x, y);
    }
  }
}
