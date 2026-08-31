#include <bits/stdc++.h>
using namespace std;
int e[100005 * 2], h[100005], pre[100005 * 2], cou;
long long d[100005 * 2];
inline void Addedge(int from, int to, int ds) {
  cou++;
  e[cou] = to, d[cou] = ds;
  pre[cou] = h[from];
  h[from] = cou;
}
int fa[100005][20], dep[100005], maxd, lg;
int n;
void initlca() {
  int i, j;
  lg = 18;
  for (j = 1; j <= lg; j++)
    for (i = 1; i <= n; i++) fa[i][j] = fa[fa[i][j - 1]][j - 1];
}
inline int lca(int u, int v) {
  if (dep[u] > dep[v]) swap(u, v);
  int i;
  for (i = lg; i >= 0; i--)
    if (dep[fa[v][i]] >= dep[u]) v = fa[v][i];
  if (u == v) return u;
  for (i = lg; i >= 0; i--)
    if (fa[v][i] != fa[u][i]) u = fa[u][i], v = fa[v][i];
  return fa[v][0];
}
long long up[100005], dn[100005], su[100005], sd[100005], dis[100005],
    sz[100005], s1[100005], s2[100005];
inline long long cal(long long a, long long b, long long c, long long d) {
  return (a + 2 * b * c + c * c % 1000000007 * d) % 1000000007;
}
void dfs1(int x) {
  int i, v;
  for (i = h[x]; i; i = pre[i]) {
    v = e[i];
    if (fa[x][0] != v) {
      fa[v][0] = x;
      dis[v] = (dis[x] + d[i]) % 1000000007;
      dep[v] = dep[x] + 1;
      dfs1(v);
      sz[x] += sz[v];
      sd[x] = (sd[x] + sd[v] + sz[v] * d[i]) % 1000000007;
      dn[x] = (dn[x] + cal(dn[v], sd[v], d[i], sz[v])) % 1000000007;
    }
  }
  sz[x]++;
}
void dfs2(int x) {
  int i, v;
  s1[x] = (up[x] + dn[x]) % 1000000007;
  s2[x] = (su[x] + sd[x]) % 1000000007;
  for (i = h[x]; i; i = pre[i]) {
    v = e[i];
    if (fa[x][0] != v) {
      su[v] = ((s2[x] - sd[v] - sz[v] * d[i]) % 1000000007 + 1000000007) %
              1000000007;
      up[v] = cal(
          ((s1[x] - cal(dn[v], sd[v], d[i], sz[v])) % 1000000007 + 1000000007) %
              1000000007,
          su[v], d[i], n - sz[v]);
      su[v] = (su[v] + d[i] * (n - sz[v])) % 1000000007;
      dfs2(v);
    }
  }
}
int main() {
  int i, t1, t2, t3, q;
  long long ds, ans;
  cin >> n;
  for (i = 1; i < n; i++) {
    scanf("%d%d%d", &t1, &t2, &t3);
    Addedge(t1, t2, t3);
    Addedge(t2, t1, t3);
  }
  dep[1] = 1, fa[1][0] = 1;
  dfs1(1);
  dfs2(1);
  initlca();
  cin >> q;
  while (q--) {
    scanf("%d%d", &t1, &t2);
    t3 = lca(t1, t2);
    if (t3 != t2) {
      ds = ((dis[t1] - dis[t3] + dis[t2] - dis[t3]) + 1000000007) % 1000000007;
      ans = ((s1[t1] - 2 * cal(dn[t2], sd[t2], ds, sz[t2])) + 1000000007) %
            1000000007;
      printf("%I64d\n", (-ans + 1000000007) % 1000000007);
    } else {
      ds = (dis[t1] - dis[t2] + 1000000007) % 1000000007;
      ans = ((cal(up[t2], su[t2], ds, n - sz[t2]) * 2 - s1[t1]) + 1000000007) %
            1000000007;
      printf("%I64d\n", (-ans + 1000000007) % 1000000007);
    }
  }
  return 0;
}
