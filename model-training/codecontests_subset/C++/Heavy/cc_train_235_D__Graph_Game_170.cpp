#include <bits/stdc++.h>
using namespace std;
int head[100005];
struct edge {
  int vet, next;
} E[200005];
int i, j, k, n, m, s, t, tot, L;
int top[100005];
int fa[100005];
int dep[100005];
int a[100005];
int dist[3005][3005];
double ans;
int X, Y, all;
int cyc[100005];
int getf(int x) {
  if (x != fa[x]) fa[x] = getf(fa[x]);
  return fa[x];
}
void add(int u, int v) {
  E[++tot] = (edge){v, head[u]};
  head[u] = tot;
}
void getroad(int u, int dad) {
  if (u == Y) {
    L = cyc[u] = 1;
    return;
  }
  for (int e = head[u]; e != -1; e = E[e].next)
    if (e != dad) {
      getroad(E[e].vet, e ^ 1);
      if (cyc[E[e].vet] > 0) {
        cyc[u] = cyc[E[e].vet] + 1;
        L = max(L, cyc[u]);
      }
    }
}
void dfs(int u, const int &anc, int dad, int deep) {
  dep[u] = deep;
  top[u] = anc;
  for (int e = head[u]; e != -1; e = E[e].next)
    if (e != dad && cyc[E[e].vet] == 0) dfs(E[e].vet, anc, e ^ 1, deep + 1);
}
void getdis(int u, const int &anc, int dad, int D) {
  dist[anc][u] = D;
  for (int e = head[u]; e != -1; e = E[e].next)
    if (e != dad) getdis(E[e].vet, anc, e ^ 1, D + 1);
}
void DO() {
  for (int i = 1; i <= n; i++) getdis(i, i, -1, 0);
}
int main() {
  tot = -1;
  memset(head, -1, sizeof(head));
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) fa[i] = i;
  for (int i = 1; i <= n; i++) {
    int x, y;
    scanf("%d%d", &x, &y);
    x++;
    y++;
    if (getf(x) == getf(y)) {
      X = x;
      Y = y;
      continue;
    }
    add(x, y);
    add(y, x);
    fa[getf(x)] = getf(y);
  }
  DO();
  getroad(X, -1);
  for (int i = 1; i <= n; i++)
    if (cyc[i] > 0) dfs(i, i, -1, 0);
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      if (i != j) {
        if (top[i] == top[j])
          ans += 1.0 / (dist[i][j] + 1);
        else {
          int x = dep[i] + dep[j];
          int y = abs(cyc[top[i]] - cyc[top[j]]);
          int z = L - y;
          ans += 1.0 / (x + y + 1) + 1.0 / (x + z + 1) - 1.0 / (x + L);
        }
      }
  ans += n;
  printf("%.14f\n", ans);
  return 0;
}
