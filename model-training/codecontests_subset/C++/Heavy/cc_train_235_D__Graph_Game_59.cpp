#include <bits/stdc++.h>
const int maxn = 3005;
const int maxm = 6005;
const int inf = 999999999;
struct edge {
  int to, next;
};
int n;
edge e[maxm];
int head[maxn], tot;
int stn[maxn], stk[maxn], top = 1;
int cir[maxn], circ;
int cirr[maxn];
bool vis[maxn];
int dis[maxn][maxn];
bool vis2[maxn][maxn];
void dfs2(int u, int p) {
  vis[u] = true;
  for (int t = head[u]; t; t = e[t].next) {
    int v = e[t].to;
    if (v == p || vis[v]) continue;
    cirr[v] = cirr[u];
    dfs2(v, u);
  }
}
void dfs3(int u, int p, int r) {
  vis2[r][u] = true;
  for (int t = head[u]; t; t = e[t].next) {
    int v = e[t].to;
    if (v == p || vis2[r][v]) continue;
    dis[r][v] = dis[r][u] + 1;
    dfs3(v, u, r);
  }
}
bool dfs1(int u, int p) {
  stk[top] = u;
  stn[u] = top++;
  for (int t = head[u]; t; t = e[t].next) {
    int v = e[t].to;
    if (v == p) continue;
    if (stn[v]) {
      for (int i = stn[v]; i < top; i++) vis[cir[circ++] = stk[i]] = true;
      return true;
    }
    if (dfs1(v, u)) return true;
  }
  top--;
  return false;
}
void add_edge(int from, int to) {
  e[++tot] = (edge){to, head[from]};
  head[from] = tot;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    x++, y++;
    add_edge(x, y);
    add_edge(y, x);
  }
  dfs1(1, 0);
  for (int i = 0; i < circ; i++) cirr[cir[i]] = cir[i], dfs2(cir[i], 0);
  for (int i = 1; i <= n; i++) dis[i][i] = 0, dfs3(i, 0, i);
  double ans = 0.0;
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++) {
      if (cirr[i] == cirr[j])
        ans += 1.0 / (dis[i][j] + 1);
      else
        ans += 1.0 / (dis[i][j] + 1) +
               1.0 / (dis[i][j] + circ - dis[cirr[i]][cirr[j]] * 2 + 1) -
               1.0 / (dis[i][j] + circ - dis[cirr[i]][cirr[j]]);
    }
  printf("%0.8lf\n", ans);
  return 0;
}
