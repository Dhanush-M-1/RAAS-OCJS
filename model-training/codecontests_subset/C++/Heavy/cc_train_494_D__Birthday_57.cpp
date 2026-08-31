#include <bits/stdc++.h>
using namespace std;
int m, tot;
long long n;
int head[100010], to[300010], net[300010];
long long val[300010], mod = 1000000007;
void add(int x, int y, int c) {
  net[++tot] = head[x], head[x] = tot, to[tot] = y, val[tot] = c;
}
int deep[100010], son[100010], fa[100010], top[100010];
struct your {
  long long dis, sqr, tre;
} dp[100010], sum[100010], all[100010];
long long dis[100010], size[100010];
void dfs(int x) {
  deep[x] = deep[fa[x]] + 1, size[x] = 1;
  for (int i = head[x]; i; i = net[i])
    if (to[i] != fa[x]) {
      dis[to[i]] = (dis[x] + val[i]) % mod, fa[to[i]] = x, dfs(to[i]),
      size[x] += size[to[i]];
      if (size[to[i]] > size[son[x]]) son[x] = to[i];
      dp[x].dis =
          (dp[x].dis + dp[to[i]].dis % mod + size[to[i]] * val[i] % mod) % mod;
      long long tmp = size[to[i]] * val[i] % mod * val[i] % mod;
      long long nmp = (dp[to[i]].sqr + 2 * val[i] * dp[to[i]].dis % mod) % mod;
      dp[x].sqr = (dp[x].sqr + tmp + nmp) % mod;
    }
}
void dfs2(int x) {
  for (int i = head[x]; i; i = net[i]) {
    if (to[i] == fa[x]) continue;
    long long tmp = (sum[x].dis + (n - 2 * size[to[i]]) * val[i]) % mod;
    long long nmp = (dp[x].dis - dp[to[i]].dis + mod) % mod;
    sum[to[i]].dis = (tmp + nmp) % mod;
    tmp = (sum[x].sqr + 2 * sum[x].dis * val[i] % mod +
           (n - size[x]) * val[i] % mod * val[i] % mod) %
          mod;
    long long dx, dy, dc;
    dx = ((dp[x].sqr - dp[to[i]].sqr - 2 * val[i] * dp[to[i]].dis % mod -
           size[to[i]] * val[i] % mod * val[i] % mod) %
              mod +
          mod) %
         mod;
    dy = (size[x] - size[to[i]]) * val[i] % mod * val[i] % mod;
    dc = (2 * val[i] *
              (dp[x].dis - dp[to[i]].dis - val[i] * size[to[i]] % mod) % mod +
          mod) %
         mod;
    sum[to[i]].sqr = (tmp + dx + dy + dc) % mod;
    dfs2(to[i]);
  }
}
void dfs3(int x, int temp) {
  top[x] = temp;
  if (son[x]) dfs3(son[x], temp);
  for (int i = head[x]; i; i = net[i])
    if (to[i] != fa[x] && to[i] != son[x]) dfs3(to[i], to[i]);
}
int lca(int x, int y) {
  while (top[x] != top[y]) {
    if (deep[top[x]] < deep[top[y]]) swap(x, y);
    x = fa[top[x]];
  }
  return deep[x] < deep[y] ? x : y;
}
void check(int x, int y);
int main() {
  scanf("%lld", &n);
  for (int x, y, c, i = 1; i < n; i++)
    scanf("%d%d%d", &x, &y, &c), add(x, y, c), add(y, x, c);
  dfs(1), dfs2(1), dfs3(1, 1);
  for (int i = 1; i <= n; i++) {
    all[i].dis = (sum[i].dis + dp[i].dis) % mod;
    all[i].sqr = (sum[i].sqr + dp[i].sqr) % mod;
    all[i].tre = (sum[i].tre + dp[i].tre) % mod;
  }
  scanf("%d", &m);
  for (int x, y, i = 1; i <= m; i++) scanf("%d%d", &x, &y), check(x, y);
  return 0;
}
void check(int x, int y) {
  int l = lca(x, y);
  if (l != x && l != y) {
    long long c = ((dis[x] + dis[y] - 2 * dis[l]) % mod + mod) % mod;
    long long tmp = (dp[y].sqr + (long long)c * c % mod * size[y] % mod +
                     2 * c * dp[y].dis % mod) %
                    mod;
    printf("%lld\n", (2 * tmp % mod - all[x].sqr + mod) % mod);
  } else if (l == x) {
    long long c = ((dis[x] + dis[y] - 2 * dis[l]) % mod + mod) % mod;
    long long tmp = (dp[y].sqr + (long long)c * c % mod * size[y] % mod +
                     2 * c * dp[y].dis % mod) %
                    mod;
    printf("%lld\n", (2 * tmp % mod - all[x].sqr + mod) % mod);
  } else if (l == y) {
    long long c = ((dis[x] + dis[y] - 2 * dis[l]) % mod + mod) % mod;
    long long tmp = (sum[y].sqr + (long long)c * c % mod * (n - size[y]) % mod +
                     2 * c * sum[y].dis % mod) %
                    mod;
    printf("%lld\n", ((all[x].sqr - 2 * tmp) % mod + mod) % mod);
  }
}
