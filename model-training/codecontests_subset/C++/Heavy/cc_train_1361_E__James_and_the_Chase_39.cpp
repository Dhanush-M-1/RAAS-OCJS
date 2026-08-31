#include <bits/stdc++.h>
using namespace std;
int n, m, x[100010], y[100010], lvl[100010], q[100010], vis[100010],
    res[100010], pre[100010], cn;
vector<int> G[100010];
void clear() {
  for (int i = 1; i <= n; i++) G[i].clear();
  for (int i = 0; i < n; i++) q[i] = i + 1;
  random_shuffle(q, q + n);
}
void add(int u, int k) {
  if (x[u] > k) {
    y[u] = x[u];
    x[u] = k;
  } else if (y[u] > k)
    y[u] = k;
}
bool dfs(int u) {
  cn++;
  vis[u] = 1;
  x[u] = y[u] = 100003;
  for (int v : G[u]) {
    if (vis[v] == 2) return false;
    if (vis[v]) {
      add(u, lvl[v]);
      continue;
    }
    lvl[v] = lvl[u] + 1;
    if (!dfs(v)) return false;
    add(u, x[v]);
    add(u, y[v]);
  }
  if (x[u] == lvl[u]) x[u] = 100003;
  if (y[u] == lvl[u]) y[u] = 100003;
  if (y[u] < 100003) res[u] = 0;
  vis[u] = 2;
  return true;
}
void dfs2(int u) {
  vis[u] = 1;
  pre[lvl[u]] = u;
  if (res[u] == -1 && lvl[u]) {
    if (x[u] < 100003)
      res[u] = res[pre[x[u]]];
    else
      res[u] = 0;
  }
  for (int v : G[u])
    if (!vis[v]) dfs2(v);
}
void solve() {
  cin >> n >> m;
  clear();
  for (int i = 0; i < m; i++) {
    int a, b;
    cin >> a >> b;
    G[a].push_back(b);
  }
  for (int i = 0; i < min(n, 80); i++) {
    for (int j = 0; j < n; j++) vis[j + 1] = 0, res[j + 1] = -1;
    lvl[q[i]] = 0;
    cn = 0;
    if (!dfs(q[i]) || cn < n) continue;
    res[q[i]] = 1;
    for (int j = 0; j < n; j++) vis[j + 1] = 0;
    dfs2(q[i]);
    vector<int> r;
    for (int j = 1; j <= n; j++)
      if (res[j] == 1) r.push_back(j);
    if (5 * r.size() < n)
      cout << -1 << endl;
    else {
      for (int x : r) cout << x << ' ';
      cout << endl;
    }
    return;
  }
  cout << -1 << endl;
}
int main() {
  srand(20021117);
  ios_base::sync_with_stdio(false);
  int T;
  cin >> T;
  while (T--) solve();
  return 0;
}
