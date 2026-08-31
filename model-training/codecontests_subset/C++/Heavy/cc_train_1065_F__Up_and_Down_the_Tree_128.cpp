#include <bits/stdc++.h>
using namespace std;
int n, k, d[1000006];
pair<int, int> dp[1000006];
vector<int> g[1000006];
void dfs(int v) {
  dp[v].first = 1000000007ll;
  if (g[v].size() == 0) {
    dp[v] = make_pair(0, 1);
    d[v] = 1;
  } else {
    for (int i = 0; i < g[v].size(); i++) {
      int to = g[v][i];
      dfs(to);
      if (dp[to].first + 1 <= k) {
        dp[v].second += dp[to].second;
        dp[v].first = min(dp[v].first, 1 + dp[to].first);
      }
    }
    d[v] = dp[v].second;
    for (int i = 0; i < g[v].size(); i++)
      if (dp[g[v][i]].first + 1 <= k)
        d[v] = max(d[v], dp[v].second - dp[g[v][i]].second + d[g[v][i]]);
      else
        d[v] = max(d[v], dp[v].second + d[g[v][i]]);
  }
}
int main() {
  cin >> n >> k;
  for (int i = 1; i <= n - 1; i++) {
    int to;
    scanf(" %d", &to);
    g[to].push_back(i + 1);
  }
  dfs(1);
  cout << d[1] << endl;
  return 0;
}
