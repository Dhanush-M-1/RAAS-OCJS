#include <bits/stdc++.h>
using namespace std;
int n;
vector<vector<int>> g, dp;
bool dfs(int u, int p, int has_par) {
  int adj = has_par, any = 0;
  if (dp[u][has_par] != -1) return dp[u][has_par];
  for (int v : g[u]) {
    if (v == p) continue;
    bool before_par = dfs(v, u, 1);
    bool after_par = dfs(v, u, 0);
    adj += !before_par && after_par;
    any += before_par && after_par;
    if (!before_par && !after_par) return dp[u][has_par] = false;
  }
  return dp[u][has_par] = 1 - (adj & 1) || any;
}
void print_choice(int u, int p, int has_par) {
  int any = 0;
  vector<int> adj;
  for (int v : g[u]) {
    if (v == p) continue;
    if (!dp[v][1] && dp[v][0]) adj.push_back(v);
    if (dp[v][1] && dp[v][0]) any = v;
  }
  if ((has_par + adj.size()) & 1) adj.push_back(any);
  for (int v : g[u]) {
    if (v == p || (adj.size() > 0 && v == adj[adj.size() - 1])) continue;
    if (dp[v][1]) print_choice(v, u, 1);
  }
  cout << u + 1 << "\n";
  for (int v : adj) {
    print_choice(v, u, 0);
  }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> n;
  g.assign(n, vector<int>());
  dp.assign(n, vector<int>(2, -1));
  for (int i = 0, j; i < n; ++i) {
    cin >> j;
    if (j-- > 0) {
      g[i].push_back(j);
      g[j].push_back(i);
    }
  }
  if (dfs(0, -1, 0)) {
    cout << "YES\n";
    print_choice(0, -1, 0);
  } else {
    cout << "NO\n";
  }
}
