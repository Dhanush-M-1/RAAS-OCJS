#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
vector<vector<int> > g;
vector<array<int, 2> > b;
vector<int> ok, a, tin, tour, par;
void prepare(int n) {
  ok.assign(n, false), b.assign(n, {-1, -1}), g.assign(n, vector<int>());
}
bool check(int u) {
  a[u] = true, tin[u] = tour.size(), tour.push_back(u);
  for (int v : g[u]) {
    if (tin[v] == -1) {
      par[v] = u;
      if (!check(v)) return false;
    } else if (!a[v])
      return false;
  }
  a[u] = false;
  return true;
}
void add_edge(int u, int val) {
  if (b[u][0] > val)
    b[u][1] = b[u][0], b[u][0] = val;
  else if (b[u][1] > val)
    b[u][1] = val;
}
void dfs1(int u) {
  b[u][0] = b[u][1] = tin[u];
  for (int v : g[u]) {
    if (par[v] == u) {
      dfs1(v);
      add_edge(u, b[v][0]), add_edge(u, b[v][1]);
    } else if (tin[v] < tin[u])
      add_edge(u, tin[v]);
  }
  if (b[u][1] >= tin[u]) ok[u] = true;
}
void dfs2(int u) {
  ok[u] &= ok[tour[b[u][0]]];
  for (int v : g[u])
    if (par[v] == u) dfs2(v);
}
void solve() {
  int n, m;
  cin >> n >> m;
  prepare(n);
  for (int i = 0, a, b; i < m; i++) cin >> a >> b, g[--a].push_back(--b);
  vector<int> p;
  for (int i = 0; i < n; i++) p.push_back(i);
  shuffle(p.begin(), p.end(), rng);
  for (int i = 0; i < min(n, 100); i++) {
    a.assign(n, false), tin.assign(n, -1), tour.clear(), par.assign(n, -1);
    if (check(p[i])) {
      ok[p[i]] = true;
      dfs1(p[i]), dfs2(p[i]);
      break;
    }
  }
  if (count(ok.begin(), ok.end(), 1) * 5 < n) {
    cout << "-1\n";
    return;
  }
  for (int i = 0; i < n; i++)
    if (ok[i]) cout << i + 1 << " ";
  cout << "\n";
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) solve();
  return 0;
}
