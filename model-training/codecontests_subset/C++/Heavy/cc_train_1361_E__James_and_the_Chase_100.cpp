#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 5;
int n, m;
int vis[MAXN], parent[MAXN], cnt[MAXN], rest[MAXN];
int level[MAXN];
bool is_inter[MAXN];
vector<vector<int>> adj;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
bool is_interesting(int u) {
  vis[u] = 1;
  for (auto v : adj[u]) {
    if (vis[v] == 2) {
      return false;
    } else if (vis[v] == 1)
      continue;
    else if (!is_interesting(v))
      return false;
  }
  vis[u] = 2;
  return true;
}
int find_root() {
  uniform_int_distribution<> dis(0, n - 1);
  for (int i = 0; i < 100; i++) {
    int u = dis(rng);
    fill(vis, vis + n, 0);
    if (is_interesting(u)) return u;
  }
  return -1;
}
pair<int, int> dfs(int u) {
  vis[u] = 1;
  cnt[u] = 0;
  parent[u] = u;
  for (auto v : adj[u]) {
    if (vis[v] == 1) {
      cnt[u]++;
      rest[v]++;
      if (level[v] < level[parent[u]]) parent[u] = v;
    } else {
      level[v] = level[u] + 1;
      int _cnt, p;
      tie(_cnt, p) = dfs(v);
      cnt[u] += _cnt;
      if (level[p] < level[parent[u]]) {
        parent[u] = p;
      }
    }
  }
  cnt[u] -= rest[u];
  return {cnt[u], parent[u]};
}
int get_ans(int u) {
  vis[u] = 1;
  int ans = 0;
  if (cnt[u] == 0) {
    ans++;
    is_inter[u] = true;
  }
  if (cnt[u] == 1) {
    if (is_inter[parent[u]]) {
      ans++;
      is_inter[u] = true;
    }
  }
  int p = -1;
  for (auto v : adj[u]) {
    if (vis[v])
      p = v;
    else
      ans += get_ans(v);
  }
  return ans;
}
int main() {
  ;
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  int t;
  cin >> t;
  while (t--) {
    cin >> n >> m;
    adj.clear();
    adj.resize(n);
    fill(is_inter, is_inter + n, false);
    fill(cnt, cnt + n, 0);
    fill(rest, rest + n, 0);
    for (int i = 0; i < m; i++) {
      int u, v;
      cin >> u >> v;
      u--;
      v--;
      adj[u].push_back(v);
    }
    int root = find_root();
    if (root == -1) {
      cout << "-1\n";
      continue;
    }
    fill(vis, vis + n, 0);
    level[root] = 0;
    dfs(root);
    fill(vis, vis + n, 0);
    int cnt = get_ans(root);
    if (5 * cnt < n)
      cout << "-1\n";
    else {
      for (int u = 0; u < n; u++)
        if (is_inter[u]) cout << u + 1 << ' ';
      cout << '\n';
    }
  }
  return 0;
}
