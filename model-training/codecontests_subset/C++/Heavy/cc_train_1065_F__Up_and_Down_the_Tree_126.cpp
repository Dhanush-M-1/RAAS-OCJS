#include <bits/stdc++.h>
using namespace std;
const int N = 1000100;
const int M = 20;
vector<int> g[N];
vector<int> gr[N];
vector<int> ord;
int sp[N][M];
int tin[N];
int tout[N];
int timer;
void pre_dfs(int v, int p = -1) {
  sp[v][0] = (p == -1 ? v : p);
  for (int i = 1; i < M; i++) {
    sp[v][i] = sp[sp[v][i - 1]][i - 1];
  }
  tin[v] = timer++;
  for (int to : g[v]) {
    pre_dfs(to, v);
  }
  tout[v] = timer++;
}
inline bool anc(int u, int v) {
  return (tin[u] <= tin[v] && tout[u] >= tout[v]);
}
int get_par(int v, int k) {
  for (int i = 0; i < M; i++) {
    if ((k >> i) & 1) {
      v = sp[v][i];
    }
  }
  return v;
}
bool mark[N];
void dfs1(int v) {
  mark[v] = 1;
  for (int to : g[v]) {
    if (!mark[to]) {
      dfs1(to);
    }
  }
  ord.push_back(v);
}
bool good[N];
int comp[N];
int val[N];
int cur;
void dfs2(int v) {
  comp[v] = cur;
  val[cur] += good[v];
  for (int to : gr[v]) {
    if (comp[to] == -1) {
      dfs2(to);
    }
  }
}
int dp[N];
int dfs_end(int v) {
  if (dp[v] != -1) return dp[v];
  dp[v] = val[v];
  for (int to : g[v]) {
    dp[v] = max(dp[v], dfs_end(to) + val[v]);
  }
  return dp[v];
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n, k;
  cin >> n >> k;
  vector<pair<int, int>> ed;
  for (int i = 1; i < n; i++) {
    int p;
    cin >> p;
    --p;
    g[p].push_back(i);
    gr[i].push_back(p);
    ed.emplace_back(p, i);
  }
  pre_dfs(0);
  for (int i = 0; i < n; i++) {
    good[i] = g[i].empty();
    if (!good[i]) continue;
    int up = get_par(i, k);
    g[i].push_back(up);
    gr[up].push_back(i);
  }
  for (int i = 0; i < n; i++) {
    if (!mark[i]) {
      dfs1(i);
    }
  }
  memset(comp, -1, sizeof(comp));
  for (int i = n - 1; i >= 0; i--) {
    int v = ord[i];
    if (comp[v] == -1) {
      dfs2(v);
      ++cur;
    }
  }
  for (int i = 0; i < n; i++) {
    g[i].clear();
    gr[i].clear();
  }
  for (auto u : ed) {
    int x = comp[u.first];
    int y = comp[u.second];
    if (x != y) {
      g[x].push_back(y);
    }
  }
  memset(dp, -1, sizeof(dp));
  cout << dfs_end(comp[0]) << endl;
  return 0;
}
