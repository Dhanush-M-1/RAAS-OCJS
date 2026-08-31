#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::high_resolution_clock::now().time_since_epoch().count());
template <typename T>
static T randint(T lo, T hi) {
  return uniform_int_distribution<T>(lo, hi)(rng);
}
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n, m;
    cin >> n >> m;
    vector<vector<int>> adj(n);
    for (int i = 0, u, v; i < m; ++i) {
      cin >> u >> v;
      --u, --v;
      adj[u].push_back(v);
    }
    vector<bool> mark(n), on_path(n);
    function<bool(int)> dfs = [&](int u) {
      mark[u] = true;
      on_path[u] = true;
      for (auto v : adj[u]) {
        if (!mark[v]) {
          if (!dfs(v)) return false;
        } else if (!on_path[v])
          return false;
      }
      on_path[u] = false;
      return true;
    };
    int root = -1;
    for (int it = 100; it--;) {
      int u = randint(0, n - 1);
      mark.assign(n, false), on_path.assign(n, false);
      if (dfs(u)) {
        root = u;
        break;
      }
    }
    if (root == -1) {
      cout << "-1\n";
      continue;
    }
    vector<int> go(n, -1), cnt(n), depth(n, -1);
    function<void(int)> dfs2 = [&](int u) {
      for (auto v : adj[u]) {
        if (depth[v] == -1) {
          depth[v] = depth[u] + 1;
          dfs2(v);
          cnt[u] += cnt[v];
          if (go[v] != -1 && (go[u] == -1 || depth[go[v]] < depth[go[u]]))
            go[u] = go[v];
        } else {
          ++cnt[u];
          --cnt[v];
          if (go[u] == -1 || depth[v] < depth[go[u]]) go[u] = v;
        }
      }
    };
    depth[root] = 0;
    dfs2(root);
    mark.assign(n, false);
    vector<int> ans = {root};
    vector<bool> ok(n);
    function<void(int)> dfs3 = [&](int u) {
      mark[u] = true;
      for (auto v : adj[u])
        if (!mark[v]) {
          if (cnt[v] == 1 && ok[go[v]]) {
            ok[v] = true;
            ans.push_back(v);
          }
          dfs3(v);
        }
    };
    ok[root] = true;
    dfs3(root);
    if (ans.size() * 5 < n) {
      cout << "-1\n";
      continue;
    }
    sort(ans.begin(), ans.end());
    for (auto &u : ans) cout << u + 1 << " \n"[&u == &ans.back()];
  }
  return 0;
}
