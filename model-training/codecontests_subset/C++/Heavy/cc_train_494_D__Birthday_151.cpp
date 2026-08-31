#include <bits/stdc++.h>
using namespace std;
const int maxn = 100005;
const int mod = 1000000007;
int df1[maxn], df2[maxn];
int a[maxn], b[maxn];
struct pi {
  int sum1, sum2;
  int lazy;
  int le, ri;
} pp[maxn << 2];
struct pppi {
  int to;
  int cost;
} pp2;
vector<pppi> g[maxn];
struct ppi {
  int to;
  int id;
} pp1;
vector<ppi> gg[maxn];
int cnt;
void dfs(int u, int pa, int w) {
  df1[u] = ++cnt;
  a[cnt] = w;
  int p = g[u].size();
  for (int i = 0; i < p; i++) {
    if (g[u][i].to != pa) {
      dfs(g[u][i].to, u, (w + g[u][i].cost) % mod);
    }
  }
  df2[u] = cnt;
}
void build(int tot, int l, int r) {
  pp[tot].le = l;
  pp[tot].ri = r;
  pp[tot].lazy = 0;
  if (l == r) {
    pp[tot].sum1 = a[l];
    pp[tot].sum2 = ((long long)a[l] * a[l]) % mod;
    return;
  }
  build(2 * tot, l, (l + r) / 2);
  build(2 * tot + 1, (l + r) / 2 + 1, r);
  pp[tot].sum1 = pp[2 * tot].sum1 + pp[2 * tot + 1].sum1;
  pp[tot].sum1 %= mod;
  pp[tot].sum2 = pp[2 * tot].sum2 + pp[2 * tot + 1].sum2;
  pp[tot].sum2 %= mod;
}
void update(int tot) {
  if (pp[tot].le != pp[tot].ri) {
    pp[2 * tot].lazy += pp[tot].lazy;
    pp[2 * tot + 1].lazy += pp[tot].lazy;
    pp[2 * tot].lazy %= mod;
    pp[2 * tot + 1].lazy %= mod;
  }
  pp[tot].sum2 = pp[tot].sum2 +
                 (2 * (((long long)pp[tot].lazy * pp[tot].sum1) % mod)) % mod;
  pp[tot].sum2 %= mod;
  pp[tot].sum2 += (((long long)pp[tot].lazy * pp[tot].lazy) % mod *
                   (pp[tot].ri - pp[tot].le + 1)) %
                  mod;
  pp[tot].sum2 %= mod;
  pp[tot].sum1 +=
      ((long long)pp[tot].lazy * (pp[tot].ri - pp[tot].le + 1)) % mod;
  pp[tot].sum1 %= mod;
  pp[tot].lazy = 0;
}
void merg(int tot, int l, int r, int p) {
  if (pp[tot].le >= l && pp[tot].ri <= r) {
    pp[tot].lazy += p;
    pp[tot].lazy %= mod;
    return;
  }
  pp[2 * tot].lazy += pp[tot].lazy;
  pp[2 * tot + 1].lazy += pp[tot].lazy;
  pp[2 * tot].lazy %= mod;
  pp[2 * tot + 1].lazy %= mod;
  pp[tot].lazy = 0;
  int mid = (pp[tot].le + pp[tot].ri) / 2;
  if (l <= mid) merg(2 * tot, l, r, p);
  if (r > mid) merg(2 * tot + 1, l, r, p);
  update(2 * tot);
  update(2 * tot + 1);
  pp[tot].sum1 = pp[2 * tot].sum1 + pp[2 * tot + 1].sum1;
  pp[tot].sum1 %= mod;
  pp[tot].sum2 = pp[2 * tot].sum2 + pp[2 * tot + 1].sum2;
  pp[tot].sum2 %= mod;
}
int n;
int query(int tot, int l, int r, int s) {
  s += pp[tot].lazy;
  s %= mod;
  if (pp[tot].le >= l && pp[tot].ri <= r) {
    int s1 = (((long long)pp[tot].sum1 * 2) % mod * s) % mod;
    s1 += (((long long)s * s) % mod * (pp[tot].ri - pp[tot].le + 1)) % mod;
    s1 %= mod;
    s1 += pp[tot].sum2;
    s1 %= mod;
    return s1;
  }
  int s1 = 0;
  int mid = (pp[tot].le + pp[tot].ri) / 2;
  if (l <= mid) s1 += query(2 * tot, l, r, s);
  if (r > mid) s1 += query(2 * tot + 1, l, r, s);
  s1 %= mod;
  return s1;
}
int work[maxn];
void dfs3(int u, int pa) {
  int p = (int)gg[u].size();
  int s, s1;
  s = query(1, 1, cnt, 0);
  for (int i = 0; i < p; i++) {
    s1 = query(1, df1[gg[u][i].to], df2[gg[u][i].to], 0);
    s1 = (2 * s1) % mod - s;
    s1 %= mod;
    s1 = (s1 + mod) % mod;
    work[gg[u][i].id] = s1;
  }
  p = (int)g[u].size();
  for (int i = 0; i < p; i++) {
    if (g[u][i].to != pa) {
      merg(1, df1[g[u][i].to], df2[g[u][i].to], -g[u][i].cost);
      if (df1[g[u][i].to] > 1) merg(1, 1, df1[g[u][i].to] - 1, g[u][i].cost);
      if (df2[g[u][i].to] < cnt)
        merg(1, df2[g[u][i].to] + 1, cnt, g[u][i].cost);
      dfs3(g[u][i].to, u);
      merg(1, df1[g[u][i].to], df2[g[u][i].to], g[u][i].cost);
      if (df1[g[u][i].to] > 1) merg(1, 1, df1[g[u][i].to] - 1, -g[u][i].cost);
      if (df2[g[u][i].to] < cnt)
        merg(1, df2[g[u][i].to] + 1, cnt, -g[u][i].cost);
    }
  }
}
int main() {
  int i, m;
  int a, b, c;
  cin >> n;
  for (i = 0; i < n - 1; i++) {
    scanf("%d%d%d", &a, &b, &c);
    pp2.to = b;
    pp2.cost = c;
    g[a].push_back(pp2);
    pp2.to = a;
    g[b].push_back(pp2);
  }
  cin >> m;
  for (i = 0; i < m; i++) {
    int a, b;
    scanf("%d%d", &a, &b);
    pp1.to = b;
    pp1.id = i;
    gg[a].push_back(pp1);
  }
  dfs(1, -1, 0);
  build(1, 1, cnt);
  dfs3(1, -1);
  for (i = 0; i < m; i++) printf("%d\n", work[i]);
}
