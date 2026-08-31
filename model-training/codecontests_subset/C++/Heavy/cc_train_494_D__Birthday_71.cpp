#include <bits/stdc++.h>
using namespace std;
const int inf = 987654321;
const long long int INF = 123456789987654321;
const long long int mod = 1000000007;
int N;
vector<vector<pair<int, int> > > adj;
vector<vector<int> > par;
vector<int> dep, sz;
vector<long long int> dist, dsum, ddsum;
void dfs(int now, int bf) {
  if (bf != -1) dep[now] = dep[bf] + 1;
  if (bf != -1) par[0][now] = bf;
  for (int i = 1; i < 19; i++) {
    int t = par[i - 1][now];
    if (t == -1) break;
    par[i][now] = par[i - 1][t];
  }
  sz[now] = 1;
  dsum[now] = dist[now];
  ddsum[now] = dist[now] * dist[now] % mod;
  for (int i = 0; i < adj[now].size(); i++) {
    int nxt = adj[now][i].first;
    int d = adj[now][i].second;
    if (nxt == bf) continue;
    dist[nxt] = dist[now] + (long long int)d;
    dist[nxt] %= mod;
    dfs(nxt, now);
    sz[now] += sz[nxt];
    dsum[now] += dsum[nxt];
    dsum[now] %= mod;
    ddsum[now] += ddsum[nxt];
    ddsum[now] %= mod;
  }
}
void get_tree_info() {
  dep = vector<int>(N, 0);
  sz = vector<int>(N, 0);
  par = vector<vector<int> >(19, vector<int>(N, -1));
  dist = vector<long long int>(N, 0);
  dsum = vector<long long int>(N, 0);
  ddsum = vector<long long int>(N, 0);
  dfs(0, -1);
}
int lca(int a, int b) {
  if (dep[a] < dep[b]) swap(a, b);
  int diff = dep[a] - dep[b];
  for (int i = 0; i < 19; i++) {
    if ((diff >> i) & 1) a = par[i][a];
  }
  if (a == b) return a;
  for (int i = 19; i--;) {
    if (par[i][a] != par[i][b]) {
      a = par[i][a];
      b = par[i][b];
    }
  }
  return par[0][a];
}
vector<long long int> dp, dp2, dp3;
void dfs2(int now, int bf) {
  for (int i = 0; i < adj[now].size(); i++) {
    int nxt = adj[now][i].first;
    int d = adj[now][i].second;
    if (nxt == bf) continue;
    dp[nxt] = (dp[now] - dist[now] * (long long int)sz[nxt] % mod +
               dist[nxt] * (long long int)sz[nxt] % mod) %
              mod;
    dp[nxt] = (dp[nxt] + mod) % mod;
    dp2[nxt] = (dp2[now] -
                (dist[now] * dist[now] % mod) * (long long int)sz[nxt] % mod +
                (dist[nxt] * dist[nxt] % mod) * (long long int)sz[nxt] % mod) %
               mod;
    dp2[nxt] = (dp2[nxt] + mod) % mod;
    dp3[nxt] =
        (dp3[now] - dist[now] * dsum[nxt] % mod + dist[nxt] * dsum[nxt] % mod) %
        mod;
    dp3[nxt] = (dp3[nxt] + mod) % mod;
    dfs2(nxt, now);
  }
}
void get_dp() {
  dp = vector<long long int>(N, 0);
  dp2 = vector<long long int>(N, 0);
  dp3 = vector<long long int>(N, 0);
  dfs2(0, -1);
}
int main() {
  scanf("%d", &N);
  adj.resize(N);
  for (int i = 0; i < N - 1; i++) {
    int a, b, c;
    scanf("%d %d %d", &a, &b, &c);
    a--;
    b--;
    adj[a].push_back(pair<int, int>(b, c));
    adj[b].push_back(pair<int, int>(a, c));
  }
  get_tree_info();
  get_dp();
  int Q;
  scanf("%d", &Q);
  for (int i = 0; i < Q; i++) {
    int u, v;
    scanf("%d %d", &u, &v);
    u--;
    v--;
    int x = lca(u, v);
    long long int t2 = ((long long int)sz[0] * dist[u] % mod) * dist[u] % mod;
    t2 += ddsum[0];
    t2 %= mod;
    t2 += 4 * (dp2[u] - dp2[0] +
               ((long long int)sz[0] * dist[0] % mod) * dist[0] % mod);
    t2 %= mod;
    t2 += 2 * dist[u] * dsum[0] % mod;
    t2 %= mod;
    t2 -= 4 * dist[u] * (dp[u] - dp[0] + (long long int)sz[0] * dist[0] % mod) %
          mod;
    t2 %= mod;
    t2 -= 4 * (dp3[u] - dp3[0] + dsum[0] * dist[0] % mod) % mod;
    t2 %= mod;
    t2 = (t2 + mod) % mod;
    if (x == v) {
      long long int t = ((long long int)sz[v] * dist[u] % mod) * dist[u] % mod;
      t += ddsum[v];
      t %= mod;
      t += 4 * (dp2[u] - dp2[v] +
                ((long long int)sz[v] * dist[v] % mod) * dist[v] % mod);
      t %= mod;
      t += 2 * dist[u] * dsum[v] % mod;
      t %= mod;
      t -= 4 * dist[u] *
           (dp[u] - dp[v] + (long long int)sz[v] * dist[v] % mod) % mod;
      t %= mod;
      t -= 4 * (dp3[u] - dp3[v] + dsum[v] * dist[v] % mod) % mod;
      t %= mod;
      t = (t + mod) % mod;
      long long int ans = (2 * t - t2) % mod;
      ans = (ans + mod) % mod;
      printf("%I64d\n", ans);
    } else {
      long long int t = ((long long int)sz[v] * dist[u] % mod) * dist[u] % mod;
      t += ddsum[v];
      t %= mod;
      t += (4 * (long long int)sz[v] * dist[x] % mod) * dist[x] % mod;
      t %= mod;
      t += 2 * dist[u] * dsum[v] % mod;
      t %= mod;
      t -= (4 * (long long int)sz[v] * dist[u] % mod) * dist[x] % mod;
      t %= mod;
      t -= 4 * dsum[v] * dist[x] % mod;
      t %= mod;
      t = (t + mod) % mod;
      long long int ans = (2 * t - t2) % mod;
      ans = (ans + mod) % mod;
      printf("%I64d\n", ans);
    }
  }
}
