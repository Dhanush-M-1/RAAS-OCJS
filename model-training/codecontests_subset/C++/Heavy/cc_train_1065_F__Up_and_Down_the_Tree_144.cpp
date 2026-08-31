#include <bits/stdc++.h>
using namespace std;
const int MOD = 1e9 + 7;
const double PI = acos(-1.);
const double eps = 1e-10;
const int INF = 0x3f3f3f3f;
const long long INFLL = 0x3f3f3f3f3f3f3f3f;
const int MAXN = 1e6 + 5;
vector<int> G[MAXN];
int dep[MAXN];
int fa[MAXN][22];
pair<int, int> mi[MAXN];
void dfs1(int now, int d, int par) {
  fa[now][0] = par;
  dep[now] = d;
  if (G[now].size())
    mi[now] = {INF, 0};
  else
    mi[now] = {d, now};
  for (int i = 0; i <= 20; i++) fa[now][i + 1] = fa[fa[now][i]][i];
  for (int i : G[now]) {
    dfs1(i, d + 1, now);
    mi[now] = min(mi[now], mi[i]);
  }
}
int lca(int x, int dis) {
  for (int i = 20; i >= 0; i--)
    if ((dis >> i) & 1) x = fa[x][i];
  return x;
}
int v[MAXN];
int n, k;
int dfs2(int now) {
  int maxn = 0;
  for (int i : G[now]) maxn = max(maxn, dfs2(i));
  return maxn + v[now];
}
int p[MAXN];
pair<int, int> w[MAXN];
int main() {
  scanf("%d %d", &n, &k);
  for (int i = 2; i <= n; i++) {
    int p;
    scanf("%d", &p);
    G[p].push_back(i);
  }
  dfs1(1, 0, 0);
  for (int i = 1; i <= n; i++) {
    if (!G[i].size()) p[i] = lca(i, min(dep[i], k));
    w[i] = {dep[i], i};
  }
  sort(w + 1, w + 1 + n);
  for (int i = 1; i <= n; i++) {
    int u = w[i].second;
    if (!G[u].size()) {
      if (mi[p[u]].second != u) p[u] = p[mi[p[u]].second];
      v[p[u]]++;
    }
  }
  int ret = dfs2(1);
  printf("%d\n", ret);
  return 0;
}
