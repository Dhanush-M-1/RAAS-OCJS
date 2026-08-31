#include <bits/stdc++.h>
using namespace std;
int n, mark[((int)3030)], pos[((int)3030)], dp[((int)12)][((int)3030)],
    dis[((int)3030)];
long double ans;
vector<int> e[((int)3030)], now, cycle;
bool dead[((int)3030)];
void dfs_cycle(int x, int par = 0) {
  mark[x] = 1;
  now.push_back(x);
  for (auto u : e[x]) {
    if (u == par || mark[u] == 2) continue;
    if (mark[u]) {
      for (int i = (int)now.size() - 1; i >= 0; i--) {
        dead[now[i]] = 1;
        pos[now[i]] = cycle.size();
        cycle.push_back(now[i]);
        if (now[i] == u) break;
      }
      continue;
    }
    dfs_cycle(u, x);
  }
  mark[x] = 2;
}
void pre_dfs(int x, int id) {
  pos[x] = id;
  for (int i = 1; i < ((int)12); i++) dp[i][x] = dp[i - 1][dp[i - 1][x]];
  for (auto u : e[x])
    if (!dead[u] && u != dp[0][x])
      dis[u] = dis[x] + 1, dp[0][u] = x, pre_dfs(u, id);
}
int iPar(int x, int num) {
  for (int i = 0; i < ((int)12); i++)
    if ((num & (1 << i))) x = dp[i][x];
  return x;
}
int lca(int x, int y) {
  if (dis[x] < dis[y]) swap(x, y);
  x = iPar(x, dis[x] - dis[y]);
  if (x == y) return x;
  for (int i = ((int)12) - 1; i >= 0; i--)
    if (dp[i][x] != dp[i][y]) x = dp[i][x], y = dp[i][y];
  return dp[0][x];
}
int main() {
  cin >> n;
  for (int i = 0; i < n; i++) {
    int v, u;
    cin >> v >> u;
    v++;
    u++;
    e[v].push_back(u);
    e[u].push_back(v);
  }
  dfs_cycle(1);
  for (auto u : cycle) pre_dfs(u, pos[u]);
  for (int i = 1; i <= n; i++)
    for (int j = i + 1; j <= n; j++) {
      if (pos[i] == pos[j]) {
        ans += (long double)1 / (dis[i] + dis[j] - 2 * dis[lca(i, j)] + 1);
        continue;
      }
      int p = abs(pos[i] - pos[j]), q = (int)cycle.size() - p;
      ans += (long double)1 / (dis[i] + dis[j] + p + 1) +
             (long double)1 / (dis[i] + dis[j] + q + 1) -
             (long double)1 / (dis[i] + dis[j] + p + q);
    }
  ans *= 2;
  ans += n;
  cout << fixed << setprecision(15) << ans << "\n";
  return 0;
}
