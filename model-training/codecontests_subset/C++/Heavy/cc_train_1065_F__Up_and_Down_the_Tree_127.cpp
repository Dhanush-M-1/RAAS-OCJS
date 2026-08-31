#include <bits/stdc++.h>
using namespace std;
const int MOD = 998244353;
const int N = 2e6 + 6;
int n, k;
vector<int> g[N];
int h[N];
vector<pair<int, int> > c[N];
inline void merge(int v, int to) {
  pair<int, int> mx1 = {1e9, 0}, mx2 = {1e9, 0};
  for (auto &x : c[v]) {
    if (x.first - h[v] <= k) {
      mx1.first = min(mx1.first, x.first);
      mx1.second += x.second;
    } else {
      if (x.second > mx2.second) mx2 = x;
    }
  }
  int vg = 0, vh = 1e9;
  for (auto &x : c[to]) {
    if (x.first - h[v] <= k) {
      mx1.first = min(mx1.first, x.first);
      mx1.second += x.second;
    } else {
      vg += x.second;
      vh = x.first;
      if (x.second > mx2.second) mx2 = x;
    }
  }
  if (vg > mx2.second) mx2 = {vh, vg};
  c[v].clear();
  c[v].push_back(mx1);
  c[v].push_back(mx2);
}
inline void dfs(int v) {
  if (g[v].size() == 0) {
    c[v].push_back({h[v], 1});
  }
  for (int to : g[v]) {
    h[to] = h[v] + 1;
    dfs(to);
    merge(v, to);
  }
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> k;
  for (int i = 2; i <= n; ++i) {
    int x;
    cin >> x;
    g[x].push_back(i);
  }
  dfs(1);
  int ans = 0;
  for (auto &x : c[1]) ans += x.second;
  cout << ans;
}
