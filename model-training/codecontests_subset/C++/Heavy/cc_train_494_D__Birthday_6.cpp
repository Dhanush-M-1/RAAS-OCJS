#include <bits/stdc++.h>
using namespace std;
int read() {
  char x = getchar();
  int ans = 0, flag = 1;
  while (!isdigit(x))
    if (x == '-')
      flag = -1, x = getchar();
    else
      x = getchar();
  while (isdigit(x)) ans = ans * 10 + x - '0', x = getchar();
  return ans * flag;
}
long long head[100005], nxt[200005], pnt[200005], len[200005], E, DEP[100005],
    dep[100005];
long long bz[100005][20], siz[100005], dp1[100005], dp2[100005], dp[100005],
    dis[100005];
long long dist[100005], n, dp3[100005];
const long long mod = 1e9 + 7;
long long mo(long long x) {
  if (x >= mod) x -= mod;
  if (x < 0) x += mod;
  return x;
}
void add_edge(long long u, long long v, long long w) {
  pnt[E] = v;
  nxt[E] = head[u];
  len[E] = w;
  head[u] = E++;
}
void dfs(long long u, long long pre) {
  DEP[u] = DEP[pre] + 1;
  bz[u][0] = pre;
  for (long long i = 1; i <= 16; i++) bz[u][i] = bz[bz[u][i - 1]][i - 1];
  siz[u] = 1;
  for (long long i = head[u]; i != -1; i = nxt[i]) {
    long long v = pnt[i];
    if (v == pre) continue;
    dep[v] = mo(dep[u] + len[i]);
    dfs(v, u);
    siz[u] += siz[v];
    dis[u] = mo(dis[u] + dis[v]);
    dis[u] = mo(dis[u] + siz[v] * len[i] % mod);
    dp1[u] = mo(dp1[u] + dp1[v]);
    dp1[u] = mo(dp1[u] + 2 * dis[v] * len[i] % mod);
    dp1[u] = mo(dp1[u] + len[i] * len[i] % mod * siz[v] % mod);
    dp2[u] = mo(dp2[u] + len[i] * siz[v] % mod);
    dp2[u] = mo(dp2[u] + dp2[v]);
  }
}
void dfs1(long long u, long long pre) {
  for (long long i = head[u]; i != -1; i = nxt[i]) {
    long long v = pnt[i];
    if (v == pre) continue;
    dp3[v] = mo(dp3[u] - siz[v] * len[i] % mod);
    dp3[v] = mo(dp3[v] + (siz[1] - siz[v]) * len[i] % mod);
    dp[v] = mo(dp[u] + len[i] * len[i] % mod * siz[1] % mod);
    dp[v] =
        mo(dp[v] - 2 * len[i] % mod * ((dis[v] + siz[v] * len[i]) % mod) % mod);
    long long tmp = mo(dis[u] - dis[v]);
    tmp = mo(tmp - siz[v] * len[i] % mod);
    dp[v] = mo(dp[v] + 2 * len[i] % mod * mo(tmp + dist[u]) % mod);
    dist[v] = mo(dist[u] + tmp);
    dist[v] = mo(dist[v] + (siz[1] - siz[v]) * len[i] % mod);
    dfs1(v, u);
  }
}
long long lca(long long x, long long y) {
  if (DEP[x] < DEP[y]) swap(x, y);
  for (long long i = 16; i >= 0; i--)
    if (DEP[bz[x][i]] >= DEP[y]) x = bz[x][i];
  if (x == y) return x;
  for (long long i = 16; i >= 0; i--)
    if (bz[x][i] != bz[y][i]) x = bz[x][i], y = bz[y][i];
  return bz[x][0];
}
signed main() {
  memset(head, -1, sizeof(head));
  scanf("%lld", &n);
  for (long long i = 1; i < n; i++) {
    long long u, v, w;
    scanf("%lld%lld%lld", &u, &v, &w);
    add_edge(u, v, w);
    add_edge(v, u, w);
  }
  dfs(1, 0);
  dp[1] = dp1[1], dp3[1] = dp2[1];
  dfs1(1, 0);
  long long q;
  scanf("%lld", &q);
  while (q--) {
    long long u, v;
    scanf("%d%d", &u, &v);
    long long LCA = lca(u, v), ans = 0;
    if (LCA == v) {
      long long tmp = mo(dp[LCA] - dp1[LCA]);
      tmp = mo(tmp +
               mo(dep[u] - dep[LCA]) * 2 % mod * mo(dp3[LCA] - dp2[LCA]) % mod);
      tmp = mo(tmp + (dep[u] - dep[LCA]) * (dep[u] - dep[LCA]) % mod *
                         (siz[1] - siz[v]) % mod);
      ans = mo(dp[u] - tmp);
      ans = mo(ans * 2 - dp[u]);
    } else {
      long long diss = dep[u] + dep[v] - 2 * dep[LCA];
      diss %= mod;
      if (diss < 0) diss += mod;
      ans = mo(dp1[v] + 2 * diss % mod * dp2[v] % mod);
      ans = mo(ans + diss * diss % mod * siz[v] % mod);
      ans = mo(mo(ans * 2) - dp[u]);
    }
    cout << ans << '\n';
  }
  return 0;
}
