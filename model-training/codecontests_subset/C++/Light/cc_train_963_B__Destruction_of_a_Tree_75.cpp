#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
const int N = 200100;
vector<int> g[N];
int n, deg[N], tin[N];
int timer;
void dfs(int u = 1, int par = 0) {
  tin[u] = ++timer;
  for (auto& v : g[u])
    if (v != par) {
      dfs(v, u);
    }
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  srand(time(0));
  int root;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    int p;
    cin >> p;
    if (p != 0) {
      g[p].emplace_back(i);
      g[i].emplace_back(p);
    } else
      root = i;
  }
  timer = 0;
  dfs(root);
  set<pair<int, int>> x[2];
  for (int i = 1; i <= n; i++) {
    deg[i] = g[i].size();
    x[deg[i] % 2].emplace(-tin[i], i);
  }
  if (x[0].size() % 2 == 0) {
    cout << "NO" << endl;
    return 0;
  }
  cout << "YES" << '\n';
  while (x[0].size() > 0) {
    int u = x[0].begin()->second;
    x[0].erase(x[0].begin());
    cout << u << '\n';
    for (auto& v : g[u]) {
      if (deg[v] == 0) continue;
      x[deg[v] % 2].erase({-tin[v], v});
      deg[v]--;
      x[deg[v] % 2].emplace(-tin[v], v);
    }
    deg[u] = 0;
  }
  return 0;
}
