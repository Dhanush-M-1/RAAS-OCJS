#include <bits/stdc++.h>
using namespace std;
int n, k, f[1000005], g[1000005], dep[1000005], x, dp[1000005];
vector<int> v[1000005];
void dfs1(int x, int y) {
  f[x] = 2e9;
  dep[x] = y;
  for (int i = 0; i < v[x].size(); i++)
    dfs1(v[x][i], y + 1), f[x] = min(f[x], f[v[x][i]]);
  if (v[x].size() == 0) f[x] = y;
}
void dfs2(int x) {
  g[x] = v[x].size() == 0;
  for (int i = 0; i < v[x].size(); i++) {
    int h = v[x][i];
    dfs2(h);
    if (f[h] - dep[x] <= k) g[x] += g[h], g[h] = 0;
  }
}
int dfs3(int x) {
  int nx = 0;
  for (int i = 0; i < v[x].size(); i++) {
    int h = v[x][i];
    nx = max(nx, dfs3(h));
  }
  return g[x] + nx;
}
signed main() {
  ios::sync_with_stdio(0);
  cin >> n >> k;
  for (int i = 2; i <= n; i++) cin >> x, v[x].push_back(i);
  dfs1(1, 1), dfs2(1);
  printf("%d", dfs3(1));
}
