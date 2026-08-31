#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1);
const int mo = 1e9 + 7;
struct Val {
  int x2, x1, x0;
  friend Val operator+(const Val &a, const Val &b) {
    return Val{(a.x2 + b.x2) % mo, (a.x1 + b.x1) % mo, (a.x0 + b.x0) % mo};
  }
  friend Val operator-(const Val &a, const Val &b) {
    return Val{(a.x2 - b.x2) % mo, (a.x1 - b.x1) % mo, (a.x0 - b.x0) % mo};
  }
  friend Val operator*(const Val &a, const int d) {
    Val c;
    c.x2 = (a.x2 + 2ll * d * a.x1 + (long long)d * d % mo * a.x0) % mo;
    c.x1 = (a.x1 + 1ll * d * a.x0) % mo;
    c.x0 = a.x0;
    return c;
  }
} f[120000], g[120000], sum[120000];
int w[120000], ff[21][120000], dep[120000], Q, n;
vector<pair<int, int> > E[120000];
int LCA(int x, int y) {
  if (dep[x] < dep[y]) swap(x, y);
  for (int i = 20; i >= 0; --i)
    if (dep[x] - dep[y] >= 1 << i) x = ff[i][x];
  if (x == y) return x;
  for (int i = 20; i >= 0; --i)
    if (ff[i][x] != ff[i][y]) x = ff[i][x], y = ff[i][y];
  return ff[0][x];
}
void dfs(int x, int fa) {
  ff[0][x] = fa;
  for (int i = 1; i <= 20; ++i) ff[i][x] = ff[i - 1][ff[i - 1][x]];
  f[x].x2 = f[x].x1 = 0;
  f[x].x0 = 1;
  for (auto e : E[x])
    if (e.first != fa) {
      dep[e.first] = dep[x] + 1;
      w[e.first] = (w[x] + e.second) % mo;
      dfs(e.first, x);
      f[x] = f[x] + f[e.first] * e.second;
    }
}
void dp(int x, int fa) {
  Val tmp = {0, 0, 1};
  for (auto e : E[x])
    if (e.first != fa) tmp = tmp + f[e.first] * e.second;
  for (auto e : E[x])
    if (e.first != fa) {
      int y = e.first;
      sum[y] = (sum[x] + (tmp - f[y] * e.second)) * e.second;
      g[y] = (tmp + g[x] - f[y] * e.second) * e.second;
      dp(y, x);
    }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n - 1; ++i) {
    int x, y, k;
    scanf("%d%d%d", &x, &y, &k);
    E[x].push_back(make_pair(y, k));
    E[y].push_back(make_pair(x, k));
  }
  dfs(1, 0);
  dp(1, 0);
  scanf("%d", &Q);
  for (int _ = 1; _ <= Q; ++_) {
    int u, v;
    scanf("%d%d", &u, &v);
    int lca = LCA(u, v), dist = ((long long)w[u] + w[v] - 2 * w[lca]) % mo, ans;
    if (lca == v)
      ans = (2ll * (f[u].x2 + (sum[u] - sum[v] * dist).x2) - (f[u] + g[u]).x2) %
            mo;
    else
      ans = (2ll * (f[v] * dist).x2 - (f[u] + g[u]).x2) % mo;
    printf("%d\n", (ans + mo) % mo);
  }
}
