#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 2;
int k, dp[N][3], minleaf[N], level[N];
vector<int> adj[N];
void dfs(int x) {
  if (adj[x].size() == 0) {
    dp[x][0] = 1;
    dp[x][1] = 1;
    minleaf[x] = x;
    return;
  }
  for (int i = 0; i < adj[x].size(); i++) {
    level[adj[x][i]] = level[x] + 1;
    dfs(adj[x][i]);
    if (level[minleaf[adj[x][i]]] - k <= level[x]) {
      dp[x][0] += dp[adj[x][i]][0];
    }
    if (level[minleaf[adj[x][i]]] < level[minleaf[x]]) {
      minleaf[x] = minleaf[adj[x][i]];
    }
  }
  for (int i = 0; i < adj[x].size(); i++) {
    if (level[minleaf[adj[x][i]]] - k <= level[x]) {
      dp[x][1] = max(dp[x][0] + dp[adj[x][i]][1] - dp[adj[x][i]][0], dp[x][1]);
    } else {
      dp[x][1] = max(dp[x][1], dp[x][0] + dp[adj[x][i]][1]);
    }
  }
}
int main() {
  level[0] = N;
  int n, i, j;
  cin >> n >> k;
  for (i = 2; i <= n; i++) {
    cin >> j;
    adj[j].push_back(i);
  }
  dfs(1);
  cout << max(dp[1][0], dp[1][1]);
}
