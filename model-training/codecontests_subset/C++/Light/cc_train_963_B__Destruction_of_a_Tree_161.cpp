#include <bits/stdc++.h>
using namespace std;
const int N = 200002;
int dp[N];
vector<int> ans;
vector<int> g[N];
void dfs(int s, int p) {
  for (auto u : g[s]) {
    if (u != p) {
      dfs(u, s);
      dp[s] += dp[u];
    }
  }
  dp[s] = !(dp[s] % 2);
}
void dfs2(int s, int p) {
  for (auto u : g[s]) {
    if (u != p) {
      if (!dp[u]) dfs2(u, s);
    }
  }
  ans.push_back(s);
  for (auto u : g[s]) {
    if (u != p) {
      if (dp[u]) dfs2(u, s);
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int a;
    cin >> a;
    if (!a) continue;
    g[a].push_back(i);
    g[i].push_back(a);
  }
  dfs(1, 1);
  dfs2(1, 1);
  if (!dp[1])
    cout << "NO";
  else {
    cout << "YES" << endl;
    for (int i = 0; i < n; i++) cout << ans[i] << endl;
  }
  return 0;
}
