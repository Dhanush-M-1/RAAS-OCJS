#include <bits/stdc++.h>
using namespace std;
const int maxn = 3e5 + 10;
vector<int> e[maxn];
int dp[maxn], root[maxn], d[maxn], sz[maxn];
pair<int, int> dfs(int v, int st, int par) {
  if (root[v] == -1) sz[st]++;
  root[v] = st;
  pair<int, int> p = make_pair(0, -1);
  for (int i = 0; i < e[v].size(); i++)
    if (e[v][i] != par) p = max(p, dfs(e[v][i], st, v));
  if (par != -1) p.first++;
  if (p.second == -1) p.second = v;
  return p;
}
int get_root(int v) { return root[v] == v ? v : root[v] = get_root(root[v]); }
void merge(int v, int u) {
  v = get_root(v);
  u = get_root(u);
  if (sz[v] > sz[u]) swap(v, u);
  if (v == u) return;
  root[v] = u;
  sz[u] += sz[v];
  d[u] = max((d[v] + 1) / 2 + (d[u] + 1) / 2 + 1, max(d[v], d[u]));
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int n, m, q;
  cin >> n >> m >> q;
  memset(root, -1, sizeof root);
  for (int i = 0; i < m; i++) {
    int u, v;
    cin >> v >> u;
    v--;
    u--;
    e[v].push_back(u);
    e[u].push_back(v);
  }
  for (int i = 0; i < n; i++)
    if (root[i] == -1) d[i] = dfs(dfs(i, i, -1).second, i, -1).first;
  for (int i = 0; i < q; i++) {
    int t;
    cin >> t;
    if (t == 1) {
      int x;
      cin >> x;
      x--;
      cout << d[get_root(x)] << '\n';
    } else {
      int x, y;
      cin >> x >> y;
      x--;
      y--;
      merge(x, y);
    }
  }
  return 0;
}
