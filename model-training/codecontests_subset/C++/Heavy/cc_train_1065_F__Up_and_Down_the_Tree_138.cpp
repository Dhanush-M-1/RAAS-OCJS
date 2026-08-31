#include <bits/stdc++.h>
using namespace std;
const long long inf = 9.2e18;
const int maxn = 1e6 + 70;
const int INF = 2.1e9;
const int maxm = 1e6 + 70;
const int MOD = 1e9 + 7;
const double eps = 1e-7;
const double PI = acos(-1.0);
int n, m, k;
vector<int> G[maxn];
int dep[maxn], mind[maxn], dp[maxn];
int dfs(int u) {
  if (!G[u].size()) {
    mind[u] = dep[u] - k;
    dp[u] = 1;
    return 1;
  } else {
    int mx = 0;
    mind[u] = dep[u];
    dp[u] = 0;
    for (int i = 0; i < G[u].size(); i++) {
      int v = G[u][i];
      dep[v] = dep[u] + 1;
      int val = dfs(v);
      mind[u] = min(mind[u], mind[v]);
      if (mind[v] <= dep[u]) {
        dp[u] += dp[v];
        mx = max(mx, val - dp[v]);
      } else {
        mx = max(mx, val);
      }
    }
    return dp[u] + mx;
  }
}
int main() {
  while (cin >> n >> k) {
    for (int i = 1; i <= n; i++) G[i].clear();
    for (int i = 2; i <= n; i++) {
      int f;
      scanf("%d", &f);
      G[f].push_back(i);
    }
    dep[1] = 0;
    int ans = dfs(1);
    cout << ans << endl;
  }
  return 0;
}
