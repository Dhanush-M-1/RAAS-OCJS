#include <bits/stdc++.h>
using namespace std;
const int MAXN = 100010;
int N, M;
vector<int> G[MAXN];
int color[MAXN], balance[MAXN], up[MAXN], vis[MAXN], bad[MAXN], lvl[MAXN];
int getInt(int a = INT_MIN, int b = INT_MAX) {
  static mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
  return uniform_int_distribution<int>(a, b)(rng);
}
void clear() {
  for (int i = 1; i <= N; i++) {
    G[i].assign(0, 0);
    color[i] = 0;
    balance[i] = 0;
    up[i] = 0;
    vis[i] = 0;
    bad[i] = 0;
    lvl[i] = 0;
  }
}
bool dfstree(int u) {
  color[u] = 1;
  for (int v : G[u]) {
    if (color[v] == 2) return false;
    if (color[v] == 0) {
      bool succ = dfstree(v);
      if (!succ) return false;
    }
  }
  color[u] = 2;
  return true;
}
int find_one() {
  int T = 100;
  while (T--) {
    int r = getInt(1, N);
    memset(color, 0, (N + 1) * sizeof(int));
    if (dfstree(r)) {
      return r;
    }
  }
  return -1;
}
int dfs(int u) {
  vis[u] = 1;
  up[u] = u;
  for (int v : G[u]) {
    if (vis[v]) {
      balance[v]--;
      balance[u]++;
      if (lvl[v] < lvl[up[u]]) up[u] = v;
    } else {
      lvl[v] = lvl[u] + 1;
      balance[u] += dfs(v);
      if (lvl[up[v]] < lvl[up[u]]) up[u] = up[v];
    }
  }
  return balance[u];
}
void mark_bad(int u) {
  vis[u] = 1;
  if (balance[u] > 1) bad[u] = 1;
  if (up[u] != u && bad[up[u]]) bad[u] = 1;
  for (int v : G[u]) {
    if (!vis[v]) mark_bad(v);
  }
}
void solve() {
  clear();
  cin >> N >> M;
  for (int i = 0; i < M; i++) {
    int U, V;
    cin >> U >> V;
    G[U].push_back(V);
  }
  int r = find_one();
  if (r == -1) {
    cout << "-1\n";
    return;
  }
  dfs(r);
  memset(vis, 0, (N + 1) * sizeof(int));
  mark_bad(r);
  vector<int> goods;
  for (int i = 1; i <= N; i++)
    if (!bad[i]) goods.push_back(i);
  if (5 * goods.size() < N) {
    cout << "-1\n";
    return;
  }
  for (int x : goods) cout << x << " ";
  cout << "\n";
}
int main() {
  cin.sync_with_stdio(0);
  cin.tie(0);
  cin.exceptions(cin.failbit);
  int T;
  cin >> T;
  while (T--) solve();
}
