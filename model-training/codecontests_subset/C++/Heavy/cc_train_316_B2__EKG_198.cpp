#include <bits/stdc++.h>
using namespace std;
vector<int> ad[2009];
int vis[2009];
int cnt;
vector<int> cp;
int p, X;
void dfs(int u) {
  vis[u] = 1;
  cnt++;
  if (u == X) p = 1;
  for (auto x : ad[u]) {
    if (vis[x]) continue;
    dfs(x);
  }
}
int dp[20009];
int main() {
  int i, j, k, l, m, n, x;
  cin >> n >> x;
  X = x;
  int br[n + 10];
  for (i = 1; i <= n; i++) {
    cin >> l;
    br[i] = l;
    if (l == 0) continue;
    ad[l].push_back(i);
    ad[i].push_back(l);
  }
  p = 0;
  int ex;
  for (i = 1; i <= n; i++) {
    if (vis[i] == 0) {
      cnt = 0;
      dfs(i);
      if (!p)
        cp.push_back(cnt);
      else
        ex = cnt, p = 0;
    }
  }
  ex = 1;
  while (br[x] != 0) {
    x = br[x];
    ex++;
  }
  for (i = 1; i <= n; i++) dp[i] = 1e9;
  dp[0] = 0;
  for (j = 0; j < cp.size(); j++) {
    for (i = n - ex; i >= 1; i--) {
      if (cp[j] <= i) dp[i] = min(dp[i], 1 + dp[i - cp[j]]);
    }
  }
  cout << ex << '\n';
  for (i = 1; i <= n - ex; i++) {
    if (dp[i] != 1e9) {
      cout << i + ex << '\n';
    }
  }
}
