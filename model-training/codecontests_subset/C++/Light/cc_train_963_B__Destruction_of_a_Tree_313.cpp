#include <bits/stdc++.h>
using namespace std;
const int N = (int)2e5 + 7;
int n;
vector<int> g[N];
bool deg[N], dp[N], mark[N];
vector<int> result;
void dfs_pre(int v, int p) {
  dp[v] = (deg[v] % 2 == 0);
  for (auto u : g[v]) {
    if (u == p) continue;
    dfs_pre(u, v);
    dp[v] ^= dp[u];
  }
}
void solve(int v) {
  mark[v] = true;
  for (auto u : g[v]) {
    if (mark[u]) continue;
    if (dp[u] == 1) {
      solve(u);
    }
  }
  result.push_back(v + 1);
  for (auto u : g[v]) {
    if (mark[u]) continue;
    solve(u);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr), cout.tie(nullptr);
  int root = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    x--;
    if (x == -1) {
      root = i;
      continue;
    }
    g[x].push_back(i), g[i].push_back(x);
    deg[x] ^= 1, deg[i] ^= 1;
  }
  if (n % 2 == 0)
    return cout << "NO" << endl, 0;
  else
    cout << "YES" << endl;
  dfs_pre(root, root);
  solve(root);
  for (auto v : result) cout << v << endl;
  return 0;
}
