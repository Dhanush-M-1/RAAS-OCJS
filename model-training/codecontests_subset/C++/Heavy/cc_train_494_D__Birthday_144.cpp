#include <bits/stdc++.h>
using namespace std;
bool debug = 1;
int n, m, k;
int dx[4] = {0, 1, 0, -1}, dy[4] = {1, 0, -1, 0};
long long ln, lk, lm;
vector<pair<int, int>> mp[100005];
int d[100005], p[100005][20];
void init() {
  for (int j = 1; (1 << j) <= n; j++)
    for (int i = 1; i <= n; i++) p[i][j] = p[p[i][j - 1]][j - 1];
}
int lca(int a, int b) {
  if (d[a] > d[b]) swap(a, b);
  int f = d[b] - d[a];
  for (int i = 0; (1 << i) <= f; i++)
    if ((1 << i) & f) b = p[b][i];
  if (a != b) {
    for (int i = (int)log2(n); i >= 0; i--)
      if (p[a][i] != p[b][i]) {
        a = p[a][i];
        b = p[b][i];
      }
    a = p[a][0];
  }
  return a;
}
long long dsum[100005], tsum[100005], dsum2[100005], tsum2[100005], dis[100005];
int sz[100005];
void dfs(int x, int pa) {
  d[x] = d[pa] + 1;
  sz[x] = 1;
  p[x][0] = pa;
  for (auto p : mp[x])
    if (p.first != pa) {
      int v = p.first, w = p.second;
      dis[v] = dis[x] + w;
      dfs(v, x);
      sz[x] += sz[v];
      dsum[x] += (dsum[v] + (long long)sz[v] * w % 1000000007) % 1000000007;
      dsum[x] %= 1000000007;
      dsum2[x] += dsum2[v] +
                  (long long)w * w % 1000000007 * sz[v] % 1000000007 +
                  2LL * w % 1000000007 * dsum[v] % 1000000007;
      dsum2[x] %= 1000000007;
    }
}
void dfs2(int x, int pa, long long s, long long s2) {
  for (auto p : mp[x])
    if (p.first != pa) {
      int v = p.first;
      long long w = p.second;
      long long dsumv =
          (dsum[v] + (long long)sz[v] * w % 1000000007) % 1000000007;
      long long other = (dsum[x] - dsumv + 1000000007) % 1000000007 + s;
      other %= 1000000007;
      tsum[v] = other + w * (n - sz[v]) % 1000000007;
      tsum[v] %= 1000000007;
      long long dsum2v = dsum2[v] +
                         (long long)w * w % 1000000007 * sz[v] % 1000000007 +
                         2LL * w % 1000000007 * dsum[v] % 1000000007;
      long long tmp = (dsum2[x] - dsum2v + 1000000007) % 1000000007 + s2;
      tsum2[v] = tmp + w * w % 1000000007 * (n - sz[v]) % 1000000007 +
                 2LL * w % 1000000007 * other % 1000000007;
      dfs2(v, x, tsum[v], tsum2[v]);
    }
}
int main() {
  scanf("%d", &n);
  for (int i = 0, u, v, w; i < n - 1; i++) {
    scanf("%d%d%d", &u, &v, &w);
    mp[u].push_back({v, w});
    mp[v].push_back({u, w});
  }
  dfs(1, 0);
  init();
  dfs2(1, 0, 0, 0);
  int q;
  scanf("%d", &q);
  for (int i = 0, u, v; i < q; i++) {
    scanf("%d%d", &u, &v);
    int fa = lca(u, v);
    long long ans = 0;
    if (fa == v) {
      long long w = dis[u] - dis[v];
      w %= 1000000007;
      long long z =
          tsum2[v] +
          (long long)w * w % 1000000007 * (n - sz[v] + 1) % 1000000007 +
          2LL * w % 1000000007 * tsum[v] % 1000000007;
      z %= 1000000007;
      z += 1000000007 - w * w % 1000000007;
      z %= 1000000007;
      ans = (dsum2[u] + tsum2[u] - z) - z;
    } else {
      long long w = dis[v] + dis[u] - 2 * dis[fa];
      w %= 1000000007;
      long long z = dsum2[v] +
                    (long long)w * w % 1000000007 * sz[v] % 1000000007 +
                    2LL * w % 1000000007 * dsum[v] % 1000000007;
      z %= 1000000007;
      ans = z - (dsum2[u] + tsum2[u] - z);
    }
    ans = ans % 1000000007 + 1000000007;
    ans %= 1000000007;
    printf("%lld\n", ans);
  }
  return 0;
}
