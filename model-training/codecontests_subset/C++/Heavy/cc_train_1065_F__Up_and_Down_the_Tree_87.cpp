#include <bits/stdc++.h>
using namespace std;
int power(int x, int y) {
  int res = 1;
  while (y) {
    if (y & 1) res = (res * x) % 1000000007;
    y = y / 2, x = (x * x) % 1000000007;
  }
  return res % 1000000007;
}
pair<int, int> dp[1000001];
int ans[1000001];
int n, k;
vector<vector<int> > arr(1000001);
int depth[1000001];
void dfs(int u, int par) {
  dp[u] = make_pair(n + 1, 0);
  int i;
  bool poss = true;
  for (i = 0; i < arr[u].size(); i++) {
    int v = arr[u][i];
    if (v != par) {
      depth[v] = 1 + depth[u];
      dfs(v, u);
      if (dp[v].first <= depth[u]) {
        dp[u].first = min(dp[u].first, dp[v].first);
        dp[u].second += dp[v].second;
      }
      poss = false;
    }
  }
  if (poss) dp[u] = make_pair(depth[u] - k, 1);
}
void dfs1(int u, int par) {
  bool poss = true;
  int i;
  for (i = 0; i < arr[u].size(); i++) {
    int v = arr[u][i];
    if (v != par) {
      dfs1(v, u);
      int temp = dp[u].second;
      if (dp[v].first <= depth[u]) temp -= dp[v].second;
      ans[u] = max(ans[u], temp + ans[v]);
      poss = false;
    }
  }
  if (poss) ans[u] = 1;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cin >> n >> k;
  int i;
  if (n == 1) {
    cout << 0;
    return 0;
  }
  for (i = 0; i < n - 1; i++) {
    int p;
    cin >> p;
    arr[p].push_back(i + 2);
    arr[i + 2].push_back(p);
  }
  dfs(1, 0);
  dfs1(1, 0);
  cout << ans[1];
}
