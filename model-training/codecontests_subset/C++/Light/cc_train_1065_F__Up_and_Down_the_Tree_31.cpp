#include <bits/stdc++.h>
using namespace std;
const int MX = 1e6 + 10;
int n, k;
int dp[MX], f[MX], num[MX];
vector<int> G[MX];
void dfs(int u) {
  if (!G[u].size()) {
    f[u] = 0;
    num[u] = 1;
    return;
  }
  int MIN = 1e9, MAX = 0;
  for (auto v : G[u]) {
    dfs(v);
    if (f[v] < k) num[u] += num[v];
    MAX = max(MAX, dp[v] - (f[v] < k ? num[v] : 0));
    MIN = min(MIN, f[v] + 1);
  }
  f[u] = MIN;
  dp[u] = num[u] + MAX;
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n >> k;
  for (int i = 2, p; i <= n; i++) {
    cin >> p;
    G[p].push_back(i);
  }
  dfs(1);
  cout << dp[1] << endl;
  return 0;
}
