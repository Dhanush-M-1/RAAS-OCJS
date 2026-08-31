#include <bits/stdc++.h>
using namespace std;
int n, k;
const int nax = 1e6 + 2;
vector<int> v[nax];
int h[nax];
pair<int, int> dp[nax];
void go(int u, int par) {
  if ((int)v[u].size() == 0 and u != 1) {
    dp[u] = {1, h[u] - k};
    return;
  }
  dp[u] = {0, nax + 5};
  for (auto it : v[u]) {
    h[it] = h[u] + 1;
    go(it, u);
    if (dp[it].second <= h[u]) {
      dp[u].first += dp[it].first;
      dp[u].second = min(dp[u].second, dp[it].second);
    }
  }
}
int ans = 0;
void dfs(int u, int par, int cur) {
  ans = max(ans, cur + ((int)v[u].size() == 0 and u != 1));
  for (auto it : v[u]) {
    int sum = dp[u].first;
    if (dp[it].second <= h[u]) sum -= dp[it].first;
    dfs(it, u, cur + sum);
  }
}
int main() {
  cin.tie(0);
  ios_base::sync_with_stdio(0);
  cin >> n >> k;
  for (int i = 2; n >= i; ++i) {
    int a;
    cin >> a;
    v[a].push_back(i);
  }
  go(1, -1);
  dfs(1, -1, 0);
  cout << ans;
  return 0;
}
