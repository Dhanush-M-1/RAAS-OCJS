#include <bits/stdc++.h>
using namespace std;
void INIT() { ios ::sync_with_stdio(false); }
const int N = 1001000;
int n, k;
vector<int> g[N];
int dep[N], ans[N], mndep[N], dp[N];
void dfs1(int u, int pre) {
  for (auto v : g[u]) {
    if (v == pre) continue;
    dep[v] = dep[u] + 1;
    dfs1(v, u);
  }
  if (g[u].size() == 1 && u != 1) {
    mndep[u] = dep[u];
    ans[u] = 1;
    return;
  }
  for (auto v : g[u]) {
    if (v == pre) continue;
    if (!mndep[u])
      mndep[u] = mndep[v];
    else
      mndep[u] = min(mndep[u], mndep[v]);
    if (mndep[v] - dep[u] <= k) ans[u] += ans[v], ans[v] = 0;
  }
}
void dfs2(int u, int pre) {
  for (auto v : g[u]) {
    if (v == pre) continue;
    dfs2(v, u);
    dp[u] = max(dp[u], dp[v]);
  }
  dp[u] += ans[u];
}
int main() {
  INIT();
  cin >> n >> k;
  for (register int i = 2; i <= n; i++) {
    int u;
    cin >> u;
    g[u].push_back(i), g[i].push_back(u);
  }
  dfs1(1, 0), dfs2(1, 0);
  cout << dp[1] << endl;
  return 0;
}
