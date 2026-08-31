#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 5;
const long long MOD = 1e9 + 7;
int N, M, Q;
vector<int> graph[MAXN];
int dp[MAXN];
int vis[MAXN];
int a, b;
int go(int u, int target) {
  int& ret = dp[u];
  if (ret != -1) return ret;
  if (u == target) return dp[u] = 1;
  vis[u] = 1;
  ret = 0;
  for (int i = 0; i < graph[u].size(); ++i) {
    int v = graph[u][i];
    if (vis[v]) continue;
    ret = ((ret) > (go(v, target)) ? (ret) : (go(v, target)));
  }
  vis[u] = 0;
  return ret;
}
void solve(int t) {
  int i, j, u, v;
  scanf("%d%d%d%d", &N, &M, &a, &b);
  for (i = 1; i <= N; ++i) {
    graph[i].clear();
    dp[i] = -1;
  }
  for (i = 1; i <= M; ++i) {
    scanf("%d%d", &u, &v);
    graph[u].push_back(v);
    graph[v].push_back(u);
  }
  go(a, b);
  long long cnt1 = 0;
  long long cnt2 = 0;
  for (i = 1; i <= N; ++i) {
    if (dp[i] == -1) ++cnt1;
  }
  for (i = 1; i <= N; ++i) dp[i] = -1;
  go(b, a);
  for (i = 1; i <= N; ++i) {
    if (dp[i] == -1) ++cnt2;
  }
  long long tot = cnt1 * cnt2;
  printf("%lld\n", tot);
  return;
}
int main() {
  int T;
  scanf("%d", &T);
  for (int t = 1; t <= T; ++t) {
    solve(t);
  }
  return 0;
}
