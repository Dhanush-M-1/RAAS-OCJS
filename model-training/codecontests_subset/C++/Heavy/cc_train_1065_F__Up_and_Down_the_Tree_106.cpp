#include <bits/stdc++.h>
using namespace std;
const int maxn = 1000010;
const int inf = 0x3f3f3f3f;
vector<int> g[maxn];
int n, k;
pair<int, int> dp_ret[maxn];
int dp_to[maxn], dep[maxn], ans;
void dfs(int u) {
  dp_ret[u] = pair<int, int>(0, inf);
  dp_to[u] = 0;
  if (g[u].size() == 0) {
    dp_ret[u] = pair<int, int>(1, dep[u]);
    dp_to[u] = 1;
  }
  for (int i = 0; i < (int)g[u].size(); i++) {
    int v = g[u][i];
    dep[v] = dep[u] + 1;
    dfs(v);
    if (dp_ret[v].second - k <= dep[u]) {
      dp_ret[u].first += dp_ret[v].first;
      dp_ret[u].second = min(dp_ret[u].second, dp_ret[v].second);
    }
  }
  dp_to[u] = dp_ret[u].first;
  int sum = dp_ret[u].first;
  for (int i = 0; i < (int)g[u].size(); i++) {
    int v = g[u][i];
    if (dp_ret[v].second - k <= dep[u]) {
      dp_to[u] = max(dp_to[u], sum - dp_ret[v].first + dp_to[v]);
    } else {
      dp_to[u] = max(dp_to[u], sum + dp_to[v]);
    }
  }
  ans = max(ans, dp_to[u]);
}
int main() {
  int p;
  scanf("%d%d", &n, &k);
  for (int i = 2; i <= n; i++) {
    scanf("%d", &p);
    g[p].push_back(i);
  }
  dfs(1);
  printf("%d\n", ans);
  return 0;
}
