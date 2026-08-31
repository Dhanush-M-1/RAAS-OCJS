#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e6 + 10;
vector<int> G[maxn];
int a[maxn], h[maxn], d[maxn], n, k, inf = 1e9;
void dfs(int u) {
  h[u] = inf;
  for (int i = 0; i < G[u].size(); i++) {
    int v = G[u][i];
    dfs(v);
    a[u] += a[v];
    h[u] = min(h[u], h[v] + 1);
    d[u] = max(d[u], d[v] - a[v]);
  }
  d[u] += a[u];
  if (h[u] == inf) d[u] = a[u] = 1, h[u] = 0;
  if (h[u] >= k) a[u] = 0;
}
int main() {
  int p;
  scanf("%d%d", &n, &k);
  for (int i = 2; i <= n; i++) {
    scanf("%d", &p);
    G[p].push_back(i);
  }
  dfs(1);
  printf("%d\n", d[1]);
}
