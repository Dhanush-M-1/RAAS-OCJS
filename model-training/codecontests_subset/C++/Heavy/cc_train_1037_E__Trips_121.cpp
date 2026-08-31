#include <bits/stdc++.h>
using namespace std;
const int max6 = 1e6 + 6;
const int oo = 2e9 + 9;
const long long inf = 2e18 + 18;
vector<pair<int, int> > g[max6];
pair<int, int> a[max6];
int q[max6];
int block[max6];
int deg[max6];
int del[max6];
int res[max6];
int n, m, need;
int main() {
  cin >> n >> m >> need;
  for (int i = 1; i <= m; ++i) {
    int u, v;
    cin >> u >> v;
    g[u].push_back({v, i});
    g[v].push_back({u, i});
    a[i] = {u, v};
    deg[u]++, deg[v]++;
  }
  int l = 1, r = 0;
  for (int i = 1; i <= n; ++i)
    if (deg[i] < need) q[++r] = i, del[i] = 1;
  int maxMem = n;
  for (int i = m; i >= 1; --i) {
    while (l <= r) {
      int u = q[l++];
      maxMem--;
      for (auto it : g[u]) {
        int id = it.second;
        int v = it.first;
        if (block[id]) continue;
        if (del[v]) continue;
        block[id] = 1;
        deg[v]--;
        if (deg[v] < need) {
          del[v] = 1;
          q[++r] = v;
        }
      }
    }
    res[i] = maxMem;
    int u = a[i].first;
    int v = a[i].second;
    if (del[u] || del[v]) continue;
    deg[u]--;
    deg[v]--;
    block[i] = 1;
    if (deg[u] < need) {
      q[++r] = u;
      del[u] = 1;
    }
    if (deg[v] < need) {
      q[++r] = v;
      del[v] = 1;
    }
  }
  for (int i = 1; i <= m; ++i) cout << res[i] << "\n";
}
