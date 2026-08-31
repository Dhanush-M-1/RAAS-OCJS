#include <bits/stdc++.h>
using namespace std;
const int N = 100005, LG = 18, Mod = 1e9 + 7;
int n, q, ts, sz[N], st[N], en[N], H[N], P[N][LG];
long long D[N], dp[N], sum[N], dp2[N], sum2[N];
vector<pair<int, long long> > Adj[N];
inline int Fix(long long a) {
  a %= Mod;
  if (a < 0) a += Mod;
  return (a);
}
void DFS(int v, int p) {
  P[v][0] = p;
  sz[v] = 1;
  st[v] = ts++;
  for (int i = 1; i < LG; i++) P[v][i] = P[P[v][i - 1]][i - 1];
  for (auto &u : Adj[v])
    if (u.first != p) {
      H[u.first] = H[v] + 1;
      D[u.first] = (D[v] + u.second) % Mod;
      DFS(u.first, v);
      sz[v] += sz[u.first];
      sum[v] = Fix(sum[v] + sum[u.first] + sz[u.first] * u.second);
      dp[v] += Fix(dp[u.first] + u.second * u.second % Mod * sz[u.first] % Mod);
      dp[v] = Fix(dp[v] + sum[u.first] * u.second * 2);
    }
  en[v] = ts;
}
void DFS2(int v, int p) {
  for (auto &u : Adj[v])
    if (u.first != p) {
      sum2[u.first] = Fix(sum2[v] + sum[v] - sum[u.first] -
                          u.second * (sz[u.first] * 2 - n));
      dp2[u.first] = Fix(dp2[v] + dp[v] - dp[u.first] -
                         u.second * u.second % Mod * sz[u.first]);
      dp2[u.first] += Fix(sum[u.first] * u.second * (-2) % Mod +
                          u.second * u.second % Mod * (n - sz[u.first]));
      dp2[u.first] += Fix(
          u.second *
          Fix(sum2[v] + sum[v] - sum[u.first] - sz[u.first] * u.second) * 2);
      dp2[u.first] = Fix(dp2[u.first]);
      DFS2(u.first, v);
    }
}
inline int LCA(int v, int u) {
  if (H[v] < H[u]) return (LCA(u, v));
  for (int i = LG - 1; ~i; i--)
    if ((H[v] - H[u]) & (1 << i)) v = P[v][i];
  if (v == u) return (v);
  for (int i = LG - 1; ~i; i--)
    if (P[v][i] != P[u][i]) v = P[v][i], u = P[u][i];
  return (P[v][0]);
}
inline int Dist(int v, int u) { return Fix(D[v] + D[u] - D[LCA(u, v)] * 2); }
inline bool Sub(int v, int u) { return (st[u] <= st[v] && en[v] <= en[u]); }
int main() {
  scanf("%d", &n);
  for (int i = 1, v, u, w; i < n; i++)
    scanf("%d%d%d", &v, &u, &w), Adj[v].push_back({u, w}),
        Adj[u].push_back({v, w});
  DFS(1, 0);
  DFS2(1, 0);
  scanf("%d", &q);
  for (; q; q--) {
    int v, u;
    scanf("%d%d", &u, &v);
    long long tot = 0, d = Dist(u, v);
    if (Sub(u, v) && u != v) {
      tot = dp2[v] + d * d % Mod * (n - sz[v]);
      tot = Fix(tot + sum2[v] * d * 2);
      printf("%d\n", Fix(dp[u] + dp2[u] - tot * 2));
    } else {
      tot = dp[v] + d * d % Mod * sz[v];
      tot = Fix(tot + d * sum[v] * 2);
      printf("%d\n", Fix(tot * 2 - dp[u] - dp2[u]));
    }
  }
  return (0);
}
