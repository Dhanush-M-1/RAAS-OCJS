#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:1024000000,1024000000")
using namespace std;
long long tot[100010];
int sz[100010], p[100010][20], d[100010], a[100010], b[100010], f[100010],
    h[100010], l[100010], aa[100010], bb[100010];
vector<pair<int, int> > g[100010];
void dfs(int u, int fa, int w = 0) {
  sz[u] = 1;
  p[u][0] = fa;
  d[u] = (d[fa] + w) % 1000000007;
  l[u] = l[fa] + 1;
  for (int i = 0; i < g[u].size(); i++) {
    int j = g[u][i].first, w = g[u][i].second;
    if (j == fa) continue;
    dfs(j, u, w);
    sz[u] += sz[j];
    long long v = (a[j] + 1LL * sz[j] * w % 1000000007 * w % 1000000007 +
                   1LL * w * b[j] % 1000000007 * 2) %
                  1000000007;
    a[u] = (a[u] + v) % 1000000007;
    f[j] = v;
    v = b[j] + 1LL * sz[j] * w % 1000000007;
    v %= 1000000007;
    b[u] = (b[u] + v) % 1000000007;
    h[j] = v;
  }
}
void go(int u, int fa, int w = 0, int first = 0, int second = 0) {
  if (u > 1) {
    first = (a[fa] - f[u] + first) % 1000000007;
    if (first < 0) first += 1000000007;
    second = (b[fa] - h[u] + second) % 1000000007;
    if (second < 0) second += 1000000007;
    tot[u] = (first + 1LL * (sz[1] - sz[u]) * w % 1000000007 * w % 1000000007 +
              1LL * w * second % 1000000007 * 2) %
             1000000007;
    first = tot[u];
    second = (second + 1LL * (sz[1] - sz[u]) * w % 1000000007) % 1000000007;
    tot[u] = (tot[u] + a[u]) % 1000000007;
    aa[u] = first, bb[u] = second;
  } else
    tot[1] = a[1];
  for (int i = 0; i < g[u].size(); i++) {
    int j = g[u][i].first, w = g[u][i].second;
    if (j == fa) continue;
    go(j, u, w, first, second);
  }
}
int lca(int a, int b) {
  if (l[a] < l[b]) swap(a, b);
  int h = l[a] - l[b];
  for (int i = 0; i < 18; i++)
    if (h >> i & 1) a = p[a][i];
  if (a == b) return a;
  for (int i = 17; i >= 0; i--)
    if (p[a][i] != p[b][i]) a = p[a][i], b = p[b][i];
  return p[a][0];
}
int main() {
  int T, i, j, m, n, ca = 0, k, now = 0;
  scanf("%d", &n);
  for (i = 1; i < n; i++) {
    int w;
    scanf("%d%d%d", &j, &k, &w);
    g[j].push_back(make_pair(k, w));
    g[k].push_back(make_pair(j, w));
  }
  dfs(1, 0);
  go(1, 0);
  for (i = 1; i < 19; i++)
    for (j = 1; j <= n; j++) p[j][i] = p[p[j][i - 1]][i - 1];
  scanf("%d", &m);
  while (m--) {
    int u, v, t = 1;
    scanf("%d%d", &u, &v);
    int fa = lca(u, v);
    long long ans = 0;
    if (v == fa) {
      long long w = d[u] - d[v], first = aa[v], second = bb[v],
                z = sz[1] - sz[v];
      if (w < 0) w += 1000000007;
      ans = first + z * w % 1000000007 * w % 1000000007 +
            w * second % 1000000007 * 2;
      ans %= 1000000007;
      t = -1;
    } else {
      long long w = d[u] - d[fa] + d[v] - d[fa], first = a[v], second = b[v],
                z = sz[v];
      w %= 1000000007;
      if (w < 0) w += 1000000007;
      ans = first + z * w % 1000000007 * w % 1000000007 +
            w * second % 1000000007 * 2;
      ans %= 1000000007;
    }
    if (ans < 0) ans += 1000000007;
    ans = 2LL * ans - tot[u];
    ans *= t;
    ans %= 1000000007;
    if (ans < 0) ans += 1000000007;
    printf("%d\n", ans);
  }
}
