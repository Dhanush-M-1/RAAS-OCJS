#include <bits/stdc++.h>
using namespace std;
int n, k, h[1000100], ret[1000100], nonret[1000100], up[1000100];
vector<int> child[1000100];
void dfs(int u) {
  int ok = 1;
  nonret[u] = 0;
  ret[u] = 0;
  up[u] = h[u];
  for (int i = 0; i < child[u].size(); i++) {
    int v = child[u][i];
    ok = 0;
    h[v] = h[u] + 1;
    dfs(v);
    up[u] = min(up[u], up[v]);
    if (up[v] <= h[u])
      ret[u] += ret[v], nonret[u] = max(nonret[u], nonret[v]);
    else
      nonret[u] = max(nonret[u], ret[v] + nonret[v]);
  }
  if (ok) up[u] = h[u] - k, ret[u] = 1;
}
int main() {
  scanf("%d%d", &n, &k);
  h[1] = 0;
  for (int i = 2; i <= n; i++) {
    int a;
    scanf("%d", &a);
    child[a].push_back(i);
  }
  dfs(1);
  printf("%d\n", ret[1] + nonret[1]);
}
