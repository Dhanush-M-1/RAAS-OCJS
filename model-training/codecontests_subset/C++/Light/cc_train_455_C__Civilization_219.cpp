#include <bits/stdc++.h>
using namespace std;
const int Maxn = 300005;
int n, m, queries, now;
vector<int> g[Maxn];
int par[Maxn], d[Maxn];
inline int fnd(int x) { return x == par[x] ? x : par[x] = fnd(par[x]); }
void dfs(int u, int fa) {
  par[u] = fa;
  for (auto &v : g[u]) {
    if (par[v]) continue;
    dfs(v, fa);
    now = max(now, d[u] + d[v] + 1);
    d[u] = max(d[u], d[v] + 1);
  }
}
int main(int argc, const char *argv[]) {
  ios_base ::sync_with_stdio(false);
  cin.tie(nullptr), cout.tie(nullptr);
  cout << fixed << setprecision(12);
  cin >> n >> m >> queries;
  for (int i = 1; i <= m; ++i) {
    int u, v;
    cin >> u >> v;
    g[u].push_back(v);
    g[v].push_back(u);
  }
  for (int i = 1; i <= n; ++i)
    if (!par[i]) now = 0, dfs(i, i), d[i] = now;
  while (queries--) {
    int op, x;
    cin >> op >> x;
    if (op == 1)
      cout << d[fnd(x)] << endl;
    else {
      int y;
      cin >> y;
      x = fnd(x), y = fnd(y);
      if (x != y)
        d[par[y] = x] =
            max((d[x] + 1 >> 1) + (d[y] + 1 >> 1) + 1, max(d[x], d[y]));
    }
  }
  return 0;
}
