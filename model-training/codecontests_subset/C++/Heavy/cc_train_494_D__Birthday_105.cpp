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
} f[120000], g[120000], st[21][120000];
int w[120000], ff[21][120000], dis[21][120000], dep[120000], Q, n;
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
  f[x].x2 = f[x].x1 = 0;
  f[x].x0 = 1;
  for (int i = 0; i < E[x].size(); ++i)
    if (E[x][i].first != fa) {
      dep[E[x][i].first] = dep[x] + 1;
      w[E[x][i].first] = (w[x] + E[x][i].second) % mo;
      dfs(E[x][i].first, x);
      f[x] = f[x] + f[E[x][i].first] * E[x][i].second;
    }
}
void dp(int x, int fa) {
  Val tmp = {0, 0, 1};
  for (int i = 0; i < E[x].size(); ++i)
    if (E[x][i].first != fa) tmp = tmp + f[E[x][i].first] * E[x][i].second;
  for (int i = 0; i < E[x].size(); ++i)
    if (E[x][i].first != fa) {
      int y = E[x][i].first;
      ff[0][y] = x;
      st[0][y] = (tmp - f[y] * E[x][i].second) * E[x][i].second;
      dis[0][y] = E[x][i].second;
      g[y] = (tmp + g[x] - f[y] * E[x][i].second) * E[x][i].second;
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
  for (int i = 1; i <= 20; ++i)
    for (int j = 1; j <= n; ++j) {
      ff[i][j] = ff[i - 1][ff[i - 1][j]];
      dis[i][j] = (dis[i - 1][j] + dis[i - 1][ff[i - 1][j]]) % mo;
      st[i][j] = st[i - 1][j] + st[i - 1][ff[i - 1][j]] * dis[i - 1][j];
    }
  scanf("%d", &Q);
  for (int _ = 1; _ <= Q; ++_) {
    int u, v;
    scanf("%d%d", &u, &v);
    int lca = LCA(u, v), dist = ((long long)w[u] + w[v] - 2 * w[lca]) % mo, ans;
    if (lca == v) {
      int d = 0, x = u;
      Val tmp = f[u];
      for (int i = 20; i >= 0; --i)
        if (dep[u] - dep[v] >= 1 << i) {
          tmp = tmp + st[i][u] * d;
          d = (d + dis[i][u]) % mo;
          u = ff[i][u];
        }
      ans = (2ll * tmp.x2 - (f[x] + g[x]).x2) % mo;
    } else
      ans = (2ll * (f[v] * dist).x2 - (f[u] + g[u]).x2) % mo;
    printf("%d\n", (ans + mo) % mo);
  }
}
