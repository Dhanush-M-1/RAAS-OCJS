#include <bits/stdc++.h>
using namespace std;
int n, k;
vector<int> edge[1000000 + 10];
int deep[1000000 + 10], dp[1000000 + 10], low[1000000 + 10];
int res = 0;
void dfs(int rt, int first) {
  deep[rt] = deep[first] + 1;
  if (edge[rt].size() == 1 && rt != 1) {
    low[rt] = deep[rt];
    dp[rt] = 1;
    return;
  }
  int minn = 1e9;
  for (auto i : edge[rt]) {
    if (i == first) continue;
    dfs(i, rt);
    if (deep[rt] + k >= low[i]) {
      minn = min(minn, low[i]);
      dp[rt] += dp[i];
    }
  }
  low[rt] = minn;
}
void dfs1(int rt, int first, int ans) {
  res = max(res, ans);
  for (auto i : edge[rt]) {
    if (i == first) continue;
    if (deep[rt] + k >= low[i]) {
      dfs1(i, rt, ans);
    } else {
      dfs1(i, rt, ans + dp[i]);
    }
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> k;
  for (int i = (2); i < (n + 1); i++) {
    int x;
    cin >> x;
    edge[i].push_back(x);
    edge[x].push_back(i);
  }
  dfs(1, 0);
  dfs1(1, 0, dp[1]);
  cout << res << "\n";
  return 0;
}
