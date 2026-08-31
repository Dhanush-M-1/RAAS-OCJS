#include <bits/stdc++.h>
using namespace std;
struct node_ {
  int v, next;
} node[6005];
int head[3005], e, fa[3005][14], gf[3005];
int bj[3005], bjj = 0;
bool b[3005];
void addnode(int u, int v) {
  e++;
  node[e].v = v;
  node[e].next = head[u];
  head[u] = e;
}
int flag = 0;
int n;
int dep[3005];
void dfs(int t, int u) {
  b[t] = 1;
  for (register int i = head[t]; i; i = node[i].next) {
    if (u == node[i].v) continue;
    if (b[node[i].v]) {
      flag = node[i].v;
      gf[t] = t;
      bj[t] = bjj;
      bjj++;
      dep[t] = 1;
      return;
    }
    dfs(node[i].v, t);
    if (flag > 0) {
      gf[t] = t;
      bj[t] = bjj;
      bjj++;
      dep[t] = 1;
      if (t == flag) flag = -flag;
      return;
    } else if (flag < 0)
      return;
  }
}
void dfs_(int t) {
  for (register int i = head[t]; i; i = node[i].next) {
    if (gf[node[i].v]) continue;
    gf[node[i].v] = gf[t];
    fa[node[i].v][0] = t;
    for (register int j = 1; j <= 11; ++j)
      fa[node[i].v][j] = fa[fa[node[i].v][j - 1]][j - 1];
    dep[node[i].v] = dep[t] + 1;
    dfs_(node[i].v);
  }
}
int log_[3005];
int lca(int u, int v) {
  if (dep[v] > dep[u]) swap(u, v);
  while (dep[u] > dep[v]) {
    u = fa[u][log_[dep[u] - dep[v]]];
  }
  if (u == v) return u;
  for (register int i = 11; i >= 0; --i) {
    if (fa[u][i] != fa[v][i]) {
      u = fa[u][i];
      v = fa[v][i];
    }
  }
  return fa[u][0];
}
double ans = 0;
int main() {
  scanf("%d", &n);
  for (register int i = 2; i <= n; ++i) {
    log_[i] = log_[i / 2] + 1;
  }
  for (register int i = 1; i <= n; ++i) {
    int u, v;
    scanf("%d%d", &u, &v);
    u++;
    v++;
    addnode(u, v);
    addnode(v, u);
  }
  dfs(1, 1);
  for (register int i = 1; i <= n; ++i) {
    if (gf[i] == i) {
      dfs_(i);
    }
  }
  for (register int i = 1; i <= n; ++i) {
    for (register int j = 1; j <= n; ++j) {
      if (gf[i] == gf[j]) {
        ans += (1 / (double)(dep[i] + dep[j] - 2 * dep[lca(i, j)] + 1));
      } else {
        int x = dep[i] + dep[j], y = abs(bj[gf[i]] - bj[gf[j]]) - 1,
            z = bjj - 1 - abs(bj[gf[i]] - bj[gf[j]]);
        ans = ans + 1 / (double)(x + z) + 1 / (double)(x + y) -
              1 / (double)(x + z + y);
      }
    }
  }
  printf("%.9lf", ans);
  return 0;
}
