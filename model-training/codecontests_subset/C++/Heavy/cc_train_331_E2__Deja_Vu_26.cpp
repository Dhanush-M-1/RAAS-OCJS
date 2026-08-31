#include <bits/stdc++.h>
using namespace std;
const int MaxN = 55, mod = 1e9 + 7;
int trans(int &x, int v) {
  x += v;
  return x >= mod ? x -= mod : x;
}
bool G[MaxN][MaxN];
int f[MaxN << 1][MaxN], g[MaxN << 1][MaxN][MaxN], s[MaxN << 1][MaxN][MaxN];
vector<int> edge[MaxN][MaxN];
vector<pair<int, int> > path[MaxN], ph[MaxN], pt[MaxN];
int n, m;
bool go_tail(vector<int> &vt) {
  for (unsigned int i = 0; i + 1 < vt.size(); ++i) {
    int x = vt[i], y = vt[i + 1];
    if (!G[x][y]) return 0;
    for (auto j : edge[x][y]) vt.push_back(j);
    if ((int)vt.size() > 2 * n) return 0;
  }
  return 1;
}
bool go_head(vector<int> &vh) {
  reverse(vh.begin(), vh.end());
  for (unsigned int i = 0; i + 1 < vh.size(); ++i) {
    int x = vh[i], y = vh[i + 1];
    if (!G[y][x]) return 0;
    for (int k = edge[y][x].size() - 1; k >= 0; --k)
      vh.push_back(edge[y][x][k]);
    if ((int)vh.size() > 2 * n) return 0;
  }
  return 1;
}
void work_cross(int u, int v) {
  vector<int> vt, vh;
  bool flag;
  flag = 0;
  for (unsigned int k = 1; k < edge[u][v].size(); ++k) {
    if (edge[u][v][k - 1] == u && edge[u][v][k] == v) flag = 1;
    if (flag) vt.push_back(edge[u][v][k]);
  }
  if (!go_tail(vt)) return;
  for (unsigned int k = 0; k + 1 < edge[u][v].size(); ++k) {
    vh.push_back(edge[u][v][k]);
    if (edge[u][v][k] == u && edge[u][v][k + 1] == v) break;
  }
  if (!go_head(vh)) return;
  int sz = vh.size() + vt.size() - 1;
  if (sz > 2 * n) return;
  int s = *vh.rbegin(), t = *vt.rbegin();
  path[s].push_back(make_pair(t, sz));
}
void work_tail(int u, int v) {
  vector<int> vt = edge[u][v];
  if (!go_tail(vt)) return;
  int sz = vt.size();
  if (sz > 2 * n) return;
  pt[u].push_back(make_pair(*vt.rbegin(), sz));
}
void work_head(int u, int v) {
  vector<int> vh = edge[u][v];
  if (!go_head(vh)) return;
  int sz = vh.size();
  if (sz > 2 * n) return;
  ph[*vh.rbegin()].push_back(make_pair(v, sz));
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= m; ++i) {
    int u, v, k;
    scanf("%d%d%d", &u, &v, &k);
    G[u][v] = 1;
    vector<int> &vec = edge[u][v];
    vec.resize(k);
    for (int j = 0; j < k; ++j) scanf("%d", &vec[j]);
  }
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      if (G[i][j] && edge[i][j].size()) {
        int cnt = 0;
        for (unsigned int k = 1; k < edge[i][j].size(); ++k)
          if (edge[i][j][k - 1] == i && edge[i][j][k] == j) ++cnt;
        if (cnt == 1) work_cross(i, j);
        if (*edge[i][j].begin() == j) work_tail(i, j);
        if (*edge[i][j].rbegin() == i) work_head(i, j);
      }
  for (int i = 1; i <= n; ++i) g[0][i][i] = 1;
  for (int l = 0; l < 2 * n; ++l)
    for (int i = 1; i <= n; ++i)
      for (int j = 1; j <= n; ++j)
        if (g[l][i][j])
          for (auto k : ph[j])
            if (l + k.second <= 2 * n)
              trans(g[l + k.second][i][k.first], g[l][i][j]);
  for (int l = 2 * n; l >= 0; --l) {
    for (int i = 1; i <= n; ++i)
      for (int j = 1; j <= n; ++j)
        if (g[l][i][j])
          for (auto k : path[j])
            if (l + k.second <= 2 * n)
              trans(g[l + k.second][i][k.first], g[l][i][j]);
    memset(g[l], 0, sizeof(g[l]));
  }
  for (int l = 0; l < 2 * n; ++l)
    for (int i = 1; i <= n; ++i)
      for (int j = 1; j <= n; ++j)
        if (g[l][i][j])
          for (auto k : pt[j])
            if (l + k.second <= 2 * n)
              trans(g[l + k.second][i][k.first], g[l][i][j]);
  for (int l = 1; l <= 2 * n; ++l)
    for (int i = 1; i <= n; ++i)
      for (int j = 1; j <= n; ++j) {
        trans(f[l][j], g[l][i][j]);
        for (int k = 1; k <= n; ++k)
          if (G[i][j] == 1 && !edge[i][j].size()) trans(s[l][i][k], g[l][j][k]);
      }
  for (int l = 0; l < 2 * n; ++l) {
    for (int i = 1; i <= n; ++i)
      if (f[l][i])
        for (int t = 1; t + l + 1 <= 2 * n; ++t)
          for (int k = 1; k <= n; ++k)
            trans(f[l + t + 1][k], 1ll * f[l][i] * s[t][i][k] % mod);
  }
  for (int l = 1; l <= 2 * n; ++l) {
    int ans = 0;
    for (int i = 1; i <= n; ++i) trans(ans, f[l][i]);
    printf("%d\n", ans);
  }
  return 0;
}
