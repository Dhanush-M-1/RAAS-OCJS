#include <bits/stdc++.h>
using namespace std;
int n, a;
pair<int, int> dp[1000005];
int out[1000005], k;
int height[1000005];
vector<int> v[1000005];
void dfs1(int node, int prev) {
  dp[node] = {10000000, 0};
  if (v[node].size() == 1 and prev >= 0) {
    dp[node] = {height[node] - k, 1};
  }
  for (auto it : v[node]) {
    if (it == prev) continue;
    height[it] = height[node] + 1;
    dfs1(it, node);
    if (dp[it].first <= height[node]) {
      dp[node].first = min(dp[node].first, dp[it].first);
      dp[node].second += dp[it].second;
    }
  }
}
void dfs2(int node, int prev) {
  out[node] = 0;
  for (auto it : v[node]) {
    if (it == prev) continue;
    dfs2(it, node);
    int ha = dp[node].second;
    if (dp[it].first <= height[node]) ha -= dp[it].second;
    out[node] = max(out[node], ha + out[it]);
  }
  if (prev >= 0 and v[node].size() == 1) out[node] = 1;
}
int main() {
  cin >> n >> k;
  for (int i = 0; n - 1 > i; i++) {
    cin >> a;
    v[i + 2].push_back(a);
    v[a].push_back(i + 2);
  }
  dfs1(1, -1);
  dfs2(1, -1);
  cout << out[1];
  return 0;
}
