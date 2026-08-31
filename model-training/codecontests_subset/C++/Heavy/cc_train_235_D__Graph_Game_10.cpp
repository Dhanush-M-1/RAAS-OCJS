#include <bits/stdc++.h>
const int N = 3e3 + 10;
int n, vis[N], px, py, dep[N], fa[12][N], id[N], flag[N], lg[N];
std::vector<int> e[N], x, y;
int main() {
  scanf("%d", &n);
  for (int i(2); i < N; ++i) {
    lg[i] = lg[i / 2] + 1;
  }
  for (int i(1), x, y; i <= n; ++i) {
    scanf("%d %d", &x, &y);
    ++x;
    ++y;
    e[x].push_back(y);
    e[y].push_back(x);
  }
  std::function<void(int, int)> dfs = [&](int u, int f) {
    vis[u] = 1;
    dep[u] = dep[fa[0][u] = f] + 1;
    for (int i : e[u]) {
      if (i ^ f) {
        if (vis[i]) {
          px = i;
          py = u;
        } else {
          dfs(i, u);
        }
      }
    }
    return;
  };
  dfs(1, 0);
  while (dep[px] > dep[py]) {
    x.push_back(px);
    px = fa[0][px];
  }
  while (px != py) {
    x.push_back(px);
    px = fa[0][px];
    y.push_back(py);
    py = fa[0][py];
  }
  reverse(y.begin(), y.end());
  x.push_back(px);
  for (int &i : y) {
    x.push_back(i);
  }
  int cir = x.size();
  for (int i(0); i < x.size(); ++i) {
    flag[x[i]] = 1;
    id[x[i]] = i + 1;
  }
  std::function<void(int, int)> dfs1 = [&](int u, int f) {
    dep[u] = dep[fa[0][u] = f] + 1;
    if (f) {
      id[u] = id[f];
    }
    for (int &to : e[u]) {
      if (to != f && !id[to]) {
        dfs1(to, u);
      }
    }
  };
  for (int i(0); i < x.size(); ++i) {
    dfs1(x[i], 0);
  }
  for (int i(1); i < 12; ++i) {
    for (int j(1); j <= n; ++j) {
      fa[i][j] = fa[i - 1][fa[i - 1][j]];
    }
  }
  std::function<int(int, int)> LCA = [&](int a, int b) {
    if (dep[a] < dep[b]) {
      std::swap(a, b);
    }
    while (dep[a] > dep[b]) {
      a = fa[lg[dep[a] - dep[b]]][a];
    }
    if (a == b) {
      return a;
    }
    for (int i(11); ~i; --i) {
      if (fa[i][a] != fa[i][b]) {
        a = fa[i][a];
        b = fa[i][b];
      }
    }
    return fa[0][a];
  };
  double ans(0);
  for (int i(1); i <= n; ++i) {
    for (int j(1); j <= n; ++j) {
      if (id[i] == id[j]) {
        int l = LCA(i, j), len = dep[i] + dep[j] - 2 * dep[l];
        ans += 1.0 / (len + 1);
      } else {
        int x = dep[i] + dep[j],
            y = std::max(id[i], id[j]) - std::min(id[i], id[j]) - 1,
            z = cir - 2 - y;
        ans += 1.0 / (x + y) + 1.0 / (z + x) - 1.0 / (x + y + z);
      }
    }
  }
  printf("%.10lf\n", ans);
  return 0;
}
