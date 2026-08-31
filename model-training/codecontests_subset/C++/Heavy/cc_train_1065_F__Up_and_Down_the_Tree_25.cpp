#include <bits/stdc++.h>
using namespace std;
const int MAX = 1000005;
vector<int> g[MAX];
int p[MAX], cont[MAX], par_k[MAX], d[MAX];
int n, k;
bool cmp(int a, int b) { return d[a] < d[b]; }
void go_down(int u, int dis = 0) {
  d[u] = dis;
  for (auto v : g[u]) {
    go_down(v, dis + 1);
  }
}
int go_up(int u, int k) {
  if (par_k[u] != -1) return par_k[u];
  if (k == 0) return par_k[u] = u;
  return par_k[u] = go_up(p[u], k - 1);
}
int dfs(int u) {
  int ans = 0;
  for (auto v : g[u]) {
    ans = max(ans, dfs(v));
  }
  return cont[u] + ans;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> k;
  memset(par_k, -1, sizeof(par_k));
  for (int i = 1; i < n; i++) {
    cin >> p[i];
    p[i]--;
    g[p[i]].push_back(i);
  }
  vector<int> level(n);
  iota(level.begin(), level.end(), 0);
  go_down(0);
  sort(level.begin(), level.end(), cmp);
  for (auto u : level) {
    if (g[u].size()) continue;
    cont[go_up(u, k)]++;
  }
  cout << dfs(0) << "\n";
}
