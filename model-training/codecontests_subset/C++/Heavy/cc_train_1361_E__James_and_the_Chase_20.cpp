#include <bits/stdc++.h>
using namespace std;
long long ksm(long long a, long long b) {
  if (!b) return 1;
  long long ns = ksm(a, b >> 1);
  ns = ns * ns % 998244353;
  if (b & 1) ns = ns * a % 998244353;
  return ns;
}
int t;
int fa[100010];
int dfn[100010], low[100010], sz[100010];
int dfcnt;
vector<int> eg[100010];
int n, m;
int ans = 0;
void dfs1(int a) {
  dfn[a] = ++dfcnt;
  sz[a] = 1;
  for (auto v : eg[a]) {
    if (dfn[v]) continue;
    fa[v] = a;
    dfs1(v);
    sz[a] += sz[v];
  }
}
int fe[100010][2];
bool check(int v) {
  for (int i = 1; i <= n; i++) fa[i] = 0, sz[i] = 0, dfn[i] = 0;
  dfcnt = 0;
  dfs1(v);
  for (int i = 1; i <= n; i++)
    for (auto v : eg[i]) {
      if (fa[v] == i) continue;
      if (dfn[i] >= dfn[v] && dfn[i] < dfn[v] + sz[v]) continue;
      return 0;
    }
  for (int i = 1; i <= n; i++)
    if (!dfn[i]) return 0;
  return 1;
}
int tp[100010], to[100010];
int bk[100010];
void ins(int id, int t) {
  if (t <= fe[id][0])
    fe[id][1] = fe[id][0], fe[id][0] = t;
  else if (t <= fe[id][1])
    fe[id][1] = t;
}
void dfs2(int a) {
  fe[a][0] = fe[a][1] = dfn[a];
  low[a] = dfn[a];
  for (auto v : eg[a])
    if (dfn[v] < dfn[a]) {
      low[a] = min(low[a], dfn[v]);
      ins(a, dfn[v]);
    } else {
      dfs2(v);
      low[a] = min(low[a], low[v]);
      for (int j = 0; j < 2; j++) ins(a, fe[v][j]);
    }
}
void work(int pl) {
  for (int i = 1; i <= n; i++) bk[dfn[i]] = i;
  dfs2(pl);
  for (int i = 1; i <= n; i++) {
    int id = bk[i];
    tp[id] = 1;
    if (fe[id][1] < dfn[id]) tp[id] = 0;
    if (fe[id][0] < dfn[id] && !tp[bk[fe[id][0]]]) tp[id] = 0;
  }
  for (int i = 1; i <= n; i++) {
    int id = bk[i];
    if (i == 1)
      to[id] = 1;
    else {
      to[id] = 0;
      int e = bk[fe[id][0]];
      if (to[e]) to[id] = 1;
    }
  }
}
int main() {
  int t;
  cin >> t;
  while (t--) {
    scanf("%d%d", &n, &m);
    for (int i = 1; i <= n; i++) eg[i].clear();
    for (int i = 1; i <= m; i++) {
      int u, v;
      scanf("%d%d", &u, &v);
      eg[u].push_back(v);
    }
    int pl = 0, fl = 0;
    for (int t = 0; t < 80; t++) {
      pl = (rand() % 32768) * 32768 + rand() % 32768;
      pl = pl % n + 1;
      if (check(pl)) {
        fl = 1;
        break;
      }
    }
    if (!fl)
      cout << -1 << endl;
    else {
      work(pl);
      int ans = 0;
      for (int i = 1; i <= n; i++)
        if (tp[i] && to[i]) ans++;
      if (ans * 5 < n)
        cout << -1 << endl;
      else {
        for (int i = 1; i <= n; i++)
          if (tp[i] && to[i]) {
            printf("%d ", i);
          }
        printf("\n");
      }
    }
  }
  return 0;
}
