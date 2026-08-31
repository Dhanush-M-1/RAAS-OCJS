#include <bits/stdc++.h>
using namespace std;
vector<int> adj[100005];
vector<long long> vals[100005];
long long sdp[100005], sum[100005], dp[100005], upper[100005], upsum[100005];
long long ssum[100005];
int sz[100005];
long long dist[100005];
int depth[100005];
long long dist_to_p[100005];
int pa[100005][21] = {0};
void dfs(int x, int p) {
  int omar = adj[x].size();
  sz[x] = 1;
  sum[0] = 0;
  sdp[0] = 0;
  for (int i = 0; i < omar; ++i) {
    if (adj[x][i] == p) continue;
    int u = adj[x][i];
    depth[u] = depth[x] + 1;
    pa[u][0] = x;
    dist[u] = dist[x] + vals[x][i];
    dist_to_p[u] = vals[x][i];
    dfs(u, x);
    sum[x] += sz[u] * vals[x][i] + sum[u];
    sum[x] %= 1000000007;
    sz[x] += sz[u];
    sdp[x] += (sz[u] * ((vals[x][i] * vals[x][i]) % 1000000007)) % 1000000007 +
              2 * sum[u] * vals[x][i] % 1000000007 + sdp[u];
    sdp[x] %= 1000000007;
  }
}
void solve(int x, int p) {
  dp[x] = sdp[x];
  ssum[x] = sum[x];
  if (x != 1) {
    int szupper = sz[1] - sz[x];
    dp[x] +=
        (szupper * ((dist_to_p[x] * dist_to_p[x]) % 1000000007)) % 1000000007 +
        2 * upsum[x] * dist_to_p[x] % 1000000007 + upper[x];
    dp[x] %= 1000000007;
    sum[x] += upsum[x] + szupper * dist_to_p[x];
    sum[x] %= 1000000007;
  }
  int omar = adj[x].size();
  for (int i = 0; i < omar; ++i) {
    if (adj[x][i] == p) continue;
    int u = adj[x][i];
    upsum[u] = sum[x] - sz[u] * vals[x][i] - sum[u];
    upsum[u] %= 1000000007;
    if (upsum[u] < 0) upsum[u] += 1000000007;
    upper[u] = dp[x];
    upper[u] -=
        (sz[u] * ((vals[x][i] * vals[x][i]) % 1000000007)) % 1000000007 +
        2 * sum[u] * vals[x][i] % 1000000007 + sdp[u];
    upper[u] %= 1000000007;
    if (upper[u] < 0) upper[u] += 1000000007;
  }
  for (int i = 0; i < omar; ++i) {
    if (adj[x][i] == p) continue;
    int u = adj[x][i];
    solve(u, x);
  }
}
int mxlog = 0;
int n;
void blca() {
  while ((1 << mxlog) <= n) mxlog++;
  for (int j = 1; j < mxlog; ++j)
    for (int i = 1; i <= n; ++i) pa[i][j] = pa[pa[i][j - 1]][j - 1];
}
int lca(int x, int y) {
  if (depth[x] < depth[y]) return lca(y, x);
  int diff = depth[x] - depth[y];
  for (int i = 0; i < mxlog; ++i)
    if ((diff & (1 << i))) x = pa[x][i];
  if (x == y) return x;
  for (int i = mxlog - 1; i >= 0; --i)
    if (pa[x][i] != pa[y][i]) x = pa[x][i], y = pa[y][i];
  return pa[x][0];
}
int go_up(int x, int diff) {
  for (int i = 0; i < mxlog; ++i)
    if ((diff & (1 << i))) x = pa[x][i];
  return x;
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n - 1; ++i) {
    int u, v, val;
    scanf("%d%d%d", &u, &v, &val);
    adj[u].push_back(v);
    adj[v].push_back(u);
    vals[u].push_back(val);
    vals[v].push_back(val);
  }
  dfs(1, -1);
  solve(1, -1);
  blca();
  int q;
  scanf("%d", &q);
  while (q--) {
    int u, v;
    scanf("%d%d", &u, &v);
    long long in;
    int lc = lca(u, v);
    long long dis =
        (dist[u] + dist[v]) % 1000000007 - 2 * dist[lc] % 1000000007;
    dis %= 1000000007;
    if (dis < 0) dis += 1000000007;
    long long omar = 0;
    in = (sz[v] * ((dis * dis) % 1000000007)) % 1000000007 +
         2 * ssum[v] * dis % 1000000007 + sdp[v];
    in %= 1000000007;
    if (v != u && lc == v) {
      int c = go_up(u, depth[u] - depth[v] - 1);
      long long dis2 = dist_to_p[c];
      dis += dis2;
      omar = (sz[c] * ((dis * dis) % 1000000007)) % 1000000007 +
             2 * (ssum[c]) * dis % 1000000007 + sdp[c];
      omar %= 1000000007;
      in -= omar;
      if (in < 0) in += 1000000007;
      int szupper = sz[1] - sz[c];
      dis -= dis2;
      in += dp[u];
      in %= 1000000007;
      in -= (((szupper * ((dis * dis) % 1000000007)) % 1000000007 +
              2 * upsum[c] * dis % 1000000007) %
                 1000000007 +
             upper[c]) %
            1000000007;
      in %= 1000000007;
      omar %= 1000000007;
      dis -= dis2;
    }
    if (in < 0) in += 1000000007;
    in %= 1000000007;
    in *= 2;
    in %= 1000000007;
    in -= dp[u];
    if (in < 0) in += 1000000007;
    cout << in << endl;
  }
}
