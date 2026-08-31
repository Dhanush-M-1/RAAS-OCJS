#include <bits/stdc++.h>
using namespace std;
const int N = 1000010;
int depth[N];
vector<int> g[N];
int k, n;
int minleaf[N];
bool leaf(int u) { return u != 1 and g[u].size() == 0; }
void dfs(int u, int d) {
  depth[u] = d;
  if (leaf(u))
    minleaf[u] = d;
  else
    minleaf[u] = 0x3f3f3f3f;
  for (int v : g[u]) {
    dfs(v, d + 1);
    minleaf[u] = min(minleaf[u], minleaf[v]);
  }
}
int cnt[N];
void dfs2(int u) {
  if (leaf(u)) {
    cnt[u] = 1;
    return;
  }
  for (int v : g[u]) dfs2(v);
  if (minleaf[u] - depth[u] >= k) return;
  for (int v : g[u]) cnt[u] += cnt[v];
}
int solve(int u) {
  if (leaf(u)) return 1;
  int sum = 0;
  for (int v : g[u]) sum += cnt[v];
  int ans = 0;
  for (int v : g[u]) ans = max(ans, sum - cnt[v] + solve(v));
  return ans;
}
int main() {
  scanf("%d %d", &n, &k);
  for (int i = 2; i <= n; i++) {
    int p;
    scanf("%d", &p);
    g[p].push_back(i);
  }
  dfs(1, 0);
  dfs2(1);
  printf("%d\n", solve(1));
  return 0;
}
