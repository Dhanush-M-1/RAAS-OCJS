#include <bits/stdc++.h>
using namespace std;
int n, k;
std::vector<int> G[1000005];
int dp[1000005];
int dep[1000005];
int low[1000005];
int ans[1000005];
void dfs1(int v, int p) {
  dep[v] = dep[p] + 1;
  if (G[v].empty()) {
    low[v] = dep[v];
    dp[v] = 1;
  } else {
    int h = 0x3f3f3f3f;
    int val = 0;
    for (int u : G[v]) {
      dfs1(u, v);
      if (low[u] - dep[v] <= k) {
        val += dp[u];
        h = min(h, low[u]);
      }
    }
    dp[v] = val;
    low[v] = h;
  }
}
void dfs(int v) {
  ans[v] = dp[v];
  for (int u : G[v]) {
    dfs(u);
    int tmp = dp[v];
    if (low[u] - dep[v] <= k) tmp -= dp[u];
    ans[v] = max(ans[v], tmp + ans[u]);
  }
}
int main(int argc, char const *argv[]) {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> k;
  for (int i = 2; i <= n; ++i) {
    int p;
    cin >> p;
    G[p].push_back(i);
  }
  dep[0] = 0;
  dfs1(1, 0);
  dfs(1);
  std::cout << ans[1] << '\n';
  return 0;
}
