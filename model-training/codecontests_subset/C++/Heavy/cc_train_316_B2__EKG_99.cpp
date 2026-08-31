#include <bits/stdc++.h>
using namespace std;
int visit[1001];
int par[1001], sz[1001];
vector<int> ss;
int dfs(int &u) {
  int ever = visit[u] ^ 1;
  visit[u] = 1;
  if (par[u] == 0) return ever;
  u = par[u];
  return ever + dfs(u);
}
int dp[1005], temp[1005];
int main() {
  int n, x, a, b, i, j;
  cin >> n >> x;
  for (i = 1; i <= n; ++i) par[i] = i;
  for (i = 1; i <= n; ++i) cin >> par[i];
  int k = x, u, ret;
  int pos = dfs(k);
  sz[k] += pos;
  for (i = 1; i <= n; ++i) {
    if (!visit[i]) {
      u = i;
      ret = dfs(u);
      sz[u] += ret;
    }
  }
  for (i = 1; i <= n; ++i)
    if (par[i] == 0 && i != k) ss.push_back(sz[i]);
  dp[0] = 1;
  for (i = 0; i < ss.size(); ++i) {
    memcpy(temp, dp, sizeof(dp));
    for (j = 0; j < n; ++j)
      if (dp[j]) temp[j + ss[i]] = 1;
    memcpy(dp, temp, sizeof(temp));
  }
  for (i = 0; i < n; ++i)
    if (dp[i] == 1) cout << i + pos << endl;
}
