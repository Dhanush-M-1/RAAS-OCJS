#include <bits/stdc++.h>
using namespace std;
const int M = 1e9 + 7;
const int Maxn = 100010;
vector<pair<int, int> > G[Maxn];
int n;
int hh[Maxn], h[Maxn], pre[Maxn], fin[Maxn], sz[Maxn];
int f[Maxn][20];
int dfs_t;
inline void up(int &x, int y) {
  x += y;
  if (x >= M) x -= M;
}
inline int sqr(int x) { return x * (long long)x % M; }
int sum[Maxn << 2], ssum[Maxn << 2];
int toall[Maxn], upp[Maxn], down[Maxn], uupp[Maxn], ddown[Maxn];
void add(int tar, int w, int l, int r, int x) {
  if (l == r) {
    sum[x] = w;
    ssum[x] = w * (long long)w % M;
    return;
  }
  int mid = (l + r) >> 1;
  if (tar <= mid)
    add(tar, w, l, mid, x << 1);
  else
    add(tar, w, mid + 1, r, x << 1 | 1);
  sum[x] = sum[x << 1];
  up(sum[x], sum[x << 1 | 1]);
  ssum[x] = ssum[x << 1];
  up(ssum[x], ssum[x << 1 | 1]);
}
int query(int *tree, int L, int R, int l, int r, int x) {
  if (L <= l && R >= r) return tree[x];
  int mid = (l + r) >> 1;
  int ret = 0;
  if (L <= mid) up(ret, query(tree, L, R, l, mid, x << 1));
  if (R > mid) up(ret, query(tree, L, R, mid + 1, r, x << 1 | 1));
  return ret;
}
void dfs(int u, int fa) {
  pre[u] = ++dfs_t;
  add(dfs_t, hh[u], 1, n, 1);
  f[u][0] = fa;
  sz[u] = 1;
  for (int i = 1; f[u][i - 1]; i++) f[u][i] = f[f[u][i - 1]][i - 1];
  for (int i = 0; i < G[u].size(); i++) {
    int v = G[u][i].first, w = G[u][i].second;
    if (v == fa) continue;
    hh[v] = hh[u];
    up(hh[v], w);
    h[v] = h[u] + 1;
    dfs(v, u);
    sz[u] += sz[v];
  }
  fin[u] = dfs_t;
}
void dfs2(int u, int fa) {
  for (int i = 0; i < G[u].size(); i++) {
    int v = G[u][i].first, w = G[u][i].second;
    if (v == fa) continue;
    dfs2(v, u);
    int t = down[v];
    up(t, sz[v] * (long long)w % M);
    up(down[u], t);
    t = ddown[v];
    up(t, sz[v] * (long long)w % M * w % M);
    up(t, 2 * (long long)w * down[v] % M);
    up(ddown[u], t);
  }
}
void dfs3(int u, int fa) {
  for (int i = 0; i < G[u].size(); i++) {
    int v = G[u][i].first, w = G[u][i].second;
    if (v == fa) continue;
    int t = ((down[u] - down[v] + M) % M - sz[v] * (long long)w % M + M) % M;
    upp[v] = upp[u];
    up(upp[v], t);
    up(upp[v], (n - sz[v]) * (long long)w % M);
    toall[v] = toall[u];
    t = n * (long long)w % M * w % M;
    t = (M - t) % M;
    up(toall[v], t);
    t = (upp[v] - down[v] + M) % M;
    t = t * (long long)w * 2 % M;
    up(toall[v], t);
    dfs3(v, u);
  }
}
void prepare() {
  dfs(1, 0);
  toall[1] = ssum[1];
  dfs2(1, 0);
  dfs3(1, 0);
}
int getlca(int u, int v) {
  if (h[u] < h[v]) swap(u, v);
  int t = h[u] - h[v];
  for (int i = 18; i >= 0; i--)
    if (t >= (1 << i)) {
      t -= (1 << i);
      u = f[u][i];
    }
  for (int i = 18; i >= 0; i--)
    if (f[u][i] != f[v][i]) {
      u = f[u][i];
      v = f[v][i];
    }
  return u == v ? u : f[u][0];
}
void solve() {
  int m;
  scanf("%d", &m);
  while (m--) {
    int u, v;
    scanf("%d%d", &v, &u);
    int lca = getlca(u, v);
    int c1 = ((hh[v] - 2 * (long long)hh[lca]) % M + M) % M;
    int c2 = M - hh[v];
    if (c2 < 0) c2 += M;
    int ans = query(ssum, pre[u], fin[u], 1, n, 1);
    int t1 = query(sum, pre[u], fin[u], 1, n, 1);
    int t2 = query(sum, pre[v], fin[v], 1, n, 1);
    int t3 = t1 - t2;
    if (t3 < 0) t3 += M;
    if (lca != u) {
      up(ans, t1 * (long long)2 * c1 % M);
      up(ans, c1 * (long long)c1 % M * sz[u] % M);
    } else {
      ans = toall[v];
      up(ans, ddown[u]);
      up(ans, (M - toall[u]) % M);
      up(ans, (M - 2 * (long long)(hh[v] - hh[u]) * upp[u] % M) % M);
      up(ans, (M - (n - sz[u]) * (long long)sqr(hh[v] - hh[u]) % M) % M);
    }
    up(ans, ans);
    up(ans, (M - toall[v]) % M);
    printf("%d\n", ans);
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i < n; i++) {
    int u, v, w;
    scanf("%d%d%d", &u, &v, &w);
    G[u].push_back(pair<int, int>(v, w));
    G[v].push_back(pair<int, int>(u, w));
  }
  prepare();
  solve();
}
