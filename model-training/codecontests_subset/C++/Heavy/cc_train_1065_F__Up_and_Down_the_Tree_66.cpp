#include <bits/stdc++.h>
using namespace std;
const int N = 1000005;
const int inf = numeric_limits<int>::max();
vector<int> t[N];
int dp[N][2], mn[N], d[N], n, k, v;
int dfs0(int v, int dt) {
  d[v] = dt;
  mn[v] = inf;
  if (t[v].empty()) return mn[v] = dt;
  for (auto u : t[v]) mn[v] = min(mn[v], dfs0(u, dt + 1));
  return mn[v];
}
void dfs1(int v) {
  if (t[v].empty()) return void(dp[v][0] = dp[v][1] = 1);
  int sum = 0, ans = 0;
  for (auto u : t[v]) {
    dfs1(u);
    if (mn[u] - d[v] <= k) {
      sum += dp[u][0];
      ans = max(ans, dp[u][1] - dp[u][0]);
    } else
      ans = max(ans, dp[u][1]);
  }
  dp[v][0] = sum;
  dp[v][1] = sum + ans;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n >> k;
  for (int i = 2; i <= n; i++) {
    cin >> v;
    t[v].push_back(i);
  }
  dfs0(1, 0);
  dfs1(1);
  cout << dp[1][1] << endl;
}
