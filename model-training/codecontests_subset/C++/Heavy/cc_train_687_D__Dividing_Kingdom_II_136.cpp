#include <bits/stdc++.h>
using namespace std;
int fr[1000005], to[1000005], par[1005];
pair<int, int> cost[1000005];
set<int> s[2][1005];
int s1[1005];
bool ok;
int parent(int x) {
  if (x == par[x]) return x;
  return par[x] = parent(par[x]);
}
void merg(int x, int i, int y, int j) {
  if (s[0][x].size() + s[1][x].size() > s[0][y].size() + s[1][y].size()) {
    merg(y, j, x, i);
    return;
  }
  par[x] = y;
  int i1 = (i ^ 1), j1 = (j ^ 1);
  for (auto u : s[i][x]) {
    s[j1][y].insert(u);
    s1[u] = j1;
  }
  for (auto u : s[i1][x]) {
    s[j][y].insert(u);
    s1[u] = j;
  }
  s[0][x].clear();
  s[1][x].clear();
}
int main() {
  int n, m, q;
  cin >> n >> m >> q;
  for (int i = 1; i <= m; ++i) {
    scanf("%d%d%d", fr + i, to + i, &cost[i].first);
    cost[i].second = i;
  }
  int l, r;
  sort(cost + 1, cost + m + 1);
  while (q--) {
    scanf("%d%d", &l, &r);
    int ans = -1;
    for (int i = 0; i <= n; ++i) {
      par[i] = i;
      s[0][i].clear();
      s[1][i].clear();
      s[0][i].insert(i);
      s1[i] = 0;
    }
    for (int j = m; j >= 1; --j) {
      int i = cost[j].second;
      if (i > r || i < l) continue;
      int u = fr[i], v = to[i];
      u = parent(u);
      v = parent(v);
      if (u == v) {
        if (s1[fr[i]] != s1[to[i]]) continue;
        ans = cost[j].first;
        break;
      }
      int x = 0, y = 0;
      if (s[1][u].count(fr[i])) x = 1;
      if (s[1][v].count(to[i])) y = 1;
      merg(u, x, v, y);
    }
    printf("%d\n", ans);
  }
}
