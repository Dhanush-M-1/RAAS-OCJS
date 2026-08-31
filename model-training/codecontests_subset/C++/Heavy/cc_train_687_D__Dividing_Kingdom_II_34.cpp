#include <bits/stdc++.h>
using namespace std;
int const M = 5e5 + 41;
int const N = 1e3 + 41;
int n, m, q, cost[M], from[M], to[M], par[N], sz[N], color[N];
vector<int> e[N];
pair<int, int> edges[M];
void clear() {
  for (int i = 0; i < n; ++i) {
    par[i] = i;
    e[i].clear();
    sz[i] = 1;
  }
}
void dfs(int u, int p, int newCol, int newPar) {
  color[u] = newCol;
  par[u] = newPar;
  for (int i = 0; i < e[u].size(); ++i) {
    int to = e[u][i];
    if (to == p) {
      continue;
    }
    dfs(to, u, 1 - newCol, newPar);
  }
}
void uni(int a, int b) {
  if (sz[b] > sz[a]) {
    swap(a, b);
  }
  sz[a] += sz[b];
  dfs(b, b, 1 - color[a], par[a]);
}
int solve(int li, int ri) {
  clear();
  int a, b;
  for (int i = m - 1; i >= 0; --i) {
    if (edges[i].second >= li && edges[i].second <= ri) {
      a = from[edges[i].second];
      b = to[edges[i].second];
      if (par[a] == par[b]) {
        if (color[a] == color[b]) {
          return edges[i].first;
        }
      } else {
        uni(a, b);
        e[a].push_back(b);
        e[b].push_back(a);
      }
    }
  }
  return -1;
}
int main() {
  scanf("%d%d%d", &n, &m, &q);
  for (int i = 0; i < m; ++i) {
    int f, s, c;
    scanf("%d%d%d", &f, &s, &c);
    --f;
    --s;
    from[i] = f;
    to[i] = s;
    cost[i] = c;
    edges[i] = make_pair(c, i);
  }
  sort(edges, edges + m);
  for (int i = 0; i < q; ++i) {
    int li, ri;
    scanf("%d%d", &li, &ri);
    --li;
    --ri;
    printf("%d\n", solve(li, ri));
  }
  return 0;
}
