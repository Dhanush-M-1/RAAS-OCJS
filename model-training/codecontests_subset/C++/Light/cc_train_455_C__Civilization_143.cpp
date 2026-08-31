#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0);
  int n, m, q;
  cin >> n >> m >> q;
  vector<vector<int>> adj(n);
  for (int u, v; m--;) {
    cin >> u >> v;
    --u, --v;
    adj[u].push_back(v);
    adj[v].push_back(u);
  }
  int mx, who;
  vector<int> d(n), par(n, -1);
  function<void(int, int)> dfs = [&](int u, int p) {
    if (d[u] > mx) mx = d[u], who = u;
    for (auto v : adj[u])
      if (v != p) {
        d[v] = d[u] + 1;
        par[v] = u;
        dfs(v, u);
      }
  };
  vector<int> l(n);
  for (int i = 0; i < n; ++i)
    if (par[i] == -1) {
      mx = -1;
      d[i] = 0;
      dfs(i, -1);
      mx = -1;
      d[who] = 0;
      dfs(who, -1);
      int v = who;
      int dist = d[v];
      for (int it = d[v] / 2; it--;) v = par[v];
      mx = -1;
      par[v] = -2;
      d[v] = 0;
      dfs(v, -1);
      d[v] = mx;
      l[v] = dist;
    }
  function<int(int)> find = [&](int u) {
    if (par[u] <= -1) return u;
    return par[u] = find(par[u]);
  };
  auto merge = [&](int u, int v) {
    u = find(u);
    v = find(v);
    if (u == v) return;
    if (d[v] > d[u]) swap(u, v);
    par[v] = u;
    l[u] = max({l[u], l[v], d[u] + d[v] + 1});
    d[u] = max(d[u], d[v] + 1);
  };
  for (int t, x, y; q--;) {
    cin >> t >> x;
    if (t == 1) {
      --x;
      x = find(x);
      cout << l[x] << "\n";
    } else {
      cin >> y;
      --x, --y;
      merge(x, y);
    }
  }
  return 0;
}
