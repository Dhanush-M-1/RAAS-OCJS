#include <bits/stdc++.h>
using namespace std;
int const MAXN = 2e6 + 9;
vector<int> g[MAXN];
int n, k;
int dp[MAXN], minDepth[MAXN], depth[MAXN], leaf[MAXN];
void dfs(int node, int par) {
  if (node != par) depth[node] = 1 + depth[par];
  if (node != par && g[node].size() == 1) {
    minDepth[node] = depth[node] - k, leaf[node]++;
  }
  int mx = 0;
  for (auto child : g[node]) {
    if (child == par) continue;
    dfs(child, node);
    if (minDepth[child] <= depth[node]) {
      minDepth[node] = min(minDepth[node], minDepth[child]);
      leaf[node] += leaf[child];
    }
  }
}
void solve(int node, int par) {
  dp[node] = (node != par && g[node].size() == 1);
  for (auto child : g[node]) {
    if (child == par) continue;
    solve(child, node);
    int tmp = leaf[node];
    if (minDepth[child] <= depth[node]) {
      tmp -= leaf[child];
    }
    dp[node] = max(dp[node], tmp + dp[child]);
  }
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0);
  cin >> n >> k;
  for (int u = 2; u <= n; u++) {
    int v;
    cin >> v;
    g[u].push_back(v);
    g[v].push_back(u);
  }
  for (int i = 0; i <= n + 9; i++) minDepth[i] = 1e9;
  dfs(1, 1);
  solve(1, 1);
  cout << dp[1];
}
