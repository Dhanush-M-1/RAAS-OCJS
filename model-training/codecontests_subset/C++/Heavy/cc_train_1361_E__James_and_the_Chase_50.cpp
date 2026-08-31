#include <bits/stdc++.h>
#pragma GCC optimize("Ofast,unroll-loops")
using namespace std;
mt19937 rng((int)std::chrono::steady_clock::now().time_since_epoch().count());
const int N = 1e5 + 2;
int ok[N], tsz[N], dep[N];
vector<int> adj[N], g[N];
multiset<int> mset[N];
int vis[N];
bool flag;
void dfs2(int u) {
  vis[u] = 1;
  for (auto v : adj[u]) {
    if (vis[v] == 2) flag = false;
    if (!vis[v]) dfs2(v);
  }
  vis[u] = 2;
}
void dfs(int u, int keep) {
  vis[u] = 1;
  int bigchild = -1, high = -1;
  for (auto v : adj[u]) {
    if (!vis[v] and tsz[v] > high) {
      high = tsz[v];
      bigchild = v;
    }
  }
  multiset<int> backEdge;
  for (auto v : adj[u]) {
    if (!vis[v] and v != bigchild)
      dfs(v, 0);
    else if (vis[v] == 1)
      backEdge.insert(v);
  }
  if (bigchild != -1) {
    dfs(bigchild, 1);
    swap(mset[u], mset[bigchild]);
  }
  for (auto x : backEdge) mset[u].insert(x);
  for (auto v : adj[u]) {
    if (v != bigchild) {
      for (auto x : mset[v]) {
        mset[u].insert(x);
      }
    }
  }
  mset[u].erase(u);
  if (int(mset[u].size()) == 1) {
    g[*mset[u].begin()].push_back(u);
  }
  vis[u] = 2;
}
bool interesting(int u) {
  flag = true;
  dfs2(u);
  return flag;
}
void dfs4(int u) {
  vis[u] = 1;
  ok[u] = 1;
  for (int v : g[u]) {
    if (!vis[v]) dfs4(v);
  }
  vis[u] = 2;
}
int dfs3(int u, int d = 0) {
  vis[u] = 1;
  dep[u] = d;
  for (auto v : adj[u]) {
    if (!vis[v]) tsz[u] += dfs3(v, d + 1);
  }
  vis[u] = 2;
  return tsz[u] + 1;
}
void solve() {
  int n, m;
  cin >> n >> m;
  for (int i = 1; i <= n; ++i)
    adj[i].clear(), tsz[i] = 0, mset[i].clear(), ok[i] = 0, g[i].clear();
  for (int i = 0; i < m; ++i) {
    int a, b;
    cin >> a >> b;
    adj[a].push_back(b);
  }
  int root = -1;
  for (int t = 0; t < 100; ++t) {
    int u = rng() % n + 1;
    if (interesting(u)) {
      root = u;
    }
    for (int i = 1; i <= n; ++i) vis[i] = 0;
    if (root != -1) break;
  }
  if (root == -1) {
    cout << -1 << endl;
    return;
  }
  dfs3(root);
  for (int i = 1; i <= n; ++i) vis[i] = 0;
  dfs(root, 0);
  for (int i = 1; i <= n; ++i) vis[i] = 0;
  dfs4(root);
  vector<int> ans;
  for (int i = 1; i <= n; ++i)
    if (ok[i]) ans.push_back(i);
  if (5 * int(ans.size()) < n)
    cout << -1 << endl;
  else {
    for (auto x : ans) cout << x << " ";
    cout << endl;
  }
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t;
  cin >> t;
  while (t--) solve();
  return 0;
}
