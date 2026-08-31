#include <bits/stdc++.h>
using namespace std;
int n, x, y, z, num;
const int MAXN = 100005;
const int mod = 1e9 + 7;
int b[MAXN];
int nxt[2 * MAXN], cost[2 * MAXN], a[2 * MAXN];
int fa[MAXN][25];
int be[MAXN], en[MAXN];
long long sum, len, m, dep[MAXN];
int dist[MAXN], sumx[MAXN];
int ans, ans1, ans2;
int sum1[MAXN], sum2[MAXN], siz1[MAXN], siz2[MAXN], sum21[MAXN], sum22[MAXN];
void add(int x, int y, int z) {
  ++num;
  a[num] = y;
  nxt[num] = b[x];
  cost[num] = z;
  b[x] = num;
}
int lca(int x, int y) {
  if (dep[x] > dep[y]) swap(x, y);
  for (int i = 20; i >= 0; --i) {
    if ((1 << i) & (dep[y] - dep[x])) y = fa[y][i];
  }
  if (x == y) return x;
  for (int i = 20; i >= 0; --i) {
    if (fa[x][i] != fa[y][i]) {
      x = fa[x][i];
      y = fa[y][i];
    }
  }
  return fa[x][0];
}
void dfs(int x, int ga) {
  ++sum;
  be[x] = sum;
  fa[x][0] = ga;
  dep[x] = dep[ga] + 1;
  for (int i = 1; i <= 20; ++i) fa[x][i] = fa[fa[x][i - 1]][i - 1];
  for (int i = b[x]; i != 0; i = nxt[i]) {
    int y = a[i];
    if (y == ga) continue;
    dist[y] = dist[x] + cost[i];
    dist[y] %= mod;
    dfs(y, x);
  }
  en[x] = sum;
}
void worksub(int x) {
  int dq;
  siz1[x] = 1;
  sum1[x] = 0;
  sum21[x] = 0;
  for (int i = b[x]; i != 0; i = nxt[i]) {
    int y = a[i];
    if (y == fa[x][0]) continue;
    worksub(y);
    dq = sum21[y];
    dq += 2LL * cost[i] * sum1[y] % mod;
    dq %= mod;
    dq += 1LL * cost[i] * cost[i] % mod * siz1[y] % mod;
    dq %= mod;
    sum21[x] += dq;
    sum21[x] %= mod;
    sum1[x] += sum1[y];
    sum1[x] %= mod;
    sum1[x] += 1LL * cost[i] * siz1[y] % mod;
    sum1[x] %= mod;
    siz1[x] += siz1[y];
    siz1[x] %= mod;
  }
}
void workout(int x) {
  int dq;
  for (int i = b[x]; i != 0; i = nxt[i]) {
    int y = a[i];
    if (y == fa[x][0]) continue;
    siz2[y] = siz2[x] + siz1[x] - siz1[y];
    sum2[y] =
        sum2[x] +
        (sum1[x] - sum1[y] + mod - 1LL * siz1[y] * cost[i] % mod + mod) % mod;
    sum2[y] %= mod;
    sum2[y] += 1LL * cost[i] * siz2[x] % mod;
    sum2[y] %= mod;
    sum2[y] += 1LL * cost[i] * (siz1[x] - siz1[y]) % mod;
    sum2[y] %= mod;
    sum22[y] = sum22[x];
    sum22[y] += 1LL * cost[i] * cost[i] % mod * siz2[x] % mod;
    sum22[y] %= mod;
    sum22[y] += 2LL * cost[i] * sum2[x] % mod;
    sum22[y] %= mod;
    sum22[y] += sum21[x];
    sum22[y] %= mod;
    sum22[y] = (sum22[y] - sum21[y] + mod) % mod;
    sum22[y] =
        (sum22[y] - 1LL * cost[i] * cost[i] % mod * siz1[y] % mod + mod) % mod;
    sum22[y] = (sum22[y] - 2LL * cost[i] * sum1[y] % mod + mod) % mod;
    sum22[y] =
        (sum22[y] + 1LL * cost[i] * cost[i] % mod * (siz1[x] - siz1[y]) % mod) %
        mod;
    sum22[y] = (sum22[y] + 2LL * cost[i] *
                               (sum1[x] - sum1[y] + mod -
                                1LL * siz1[y] * cost[i] % mod + mod) %
                               mod) %
               mod;
    workout(y);
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i < n; ++i) {
    scanf("%d%d%d", &x, &y, &z);
    add(x, y, z);
    add(y, x, z);
  }
  dfs(1, 0);
  worksub(1);
  workout(1);
  for (int i = 1; i <= n; ++i) sumx[i] = (sum21[i] + sum22[i]) % mod;
  scanf("%d", &m);
  while (m--) {
    scanf("%d%d", &x, &y);
    if (be[x] >= be[y] && be[x] <= en[y]) {
      ans = sum22[y];
      len = dist[x] - dist[y] + mod;
      len %= mod;
      ans += 1LL * len * len % mod * siz2[y] % mod;
      ans %= mod;
      ans += 2LL * len * sum2[y] % mod;
      ans %= mod;
      ans1 = sumx[x] - ans + mod;
      ans1 %= mod;
      ans2 = ans;
      ans = ans1 - ans2 + mod;
      ans %= mod;
    } else {
      ans = sum21[y];
      z = lca(x, y);
      len = dist[x] - dist[z];
      len = (len + mod) % mod;
      len += dist[y] - dist[z];
      len = (len + mod) % mod;
      ans += 1LL * len * len % mod * siz1[y] % mod;
      ans %= mod;
      ans += 2LL * len * sum1[y] % mod;
      ans %= mod;
      ans1 = ans;
      ans2 = sumx[x] - ans + mod;
      ans2 %= mod;
      ans = ans1 - ans2 + mod;
      ans %= mod;
    }
    printf("%d\n", ans);
  }
  return 0;
}
