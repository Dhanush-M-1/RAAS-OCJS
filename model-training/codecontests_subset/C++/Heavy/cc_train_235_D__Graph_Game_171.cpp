#include <bits/stdc++.h>
template <typename T>
inline void read(T &x) {
  x = 0;
  char c = getchar();
  bool flag = false;
  while (!isdigit(c)) {
    if (c == '-') flag = true;
    c = getchar();
  }
  while (isdigit(c)) {
    x = (x << 1) + (x << 3) + (c ^ 48);
    c = getchar();
  }
  if (flag) x = -x;
}
using namespace std;
int n;
struct edge {
  int nxt;
  int to;
} e[4223 << 1];
int head[4223], ecnt = 1;
inline void addedge(int from, int to) {
  e[++ecnt] = (edge){head[from], to};
  head[from] = ecnt;
}
int d[4223];
int que[4223 << 1], front, rear;
bool notcir[4223];
bool incir[4223 << 1];
inline void topo() {
  for (register int i = 1; i <= n; ++i)
    if (d[i] == 1) que[++rear] = i, notcir[i] = true;
  while (front < rear) {
    int cur = que[++front];
    for (register int i = head[cur]; i; i = e[i].nxt) {
      int to = e[i].to;
      if (notcir[to]) continue;
      --d[to];
      if (d[to] == 1) {
        notcir[to] = true;
        que[++rear] = to;
      }
    }
  }
  for (register int p = 1; p <= n; ++p)
    if (!notcir[p]) {
      for (register int i = head[p]; i; i = e[i].nxt) {
        int to = e[i].to;
        if (notcir[to]) continue;
        incir[i] = true;
      }
    }
}
double f[4223][4223];
void dfs_in_tree(int u, int cur, int depp, int faa) {
  f[u][cur] = f[cur][u] = 1.0 / depp;
  for (register int i = head[cur]; i; i = e[i].nxt) {
    int to = e[i].to;
    if (incir[i] || to == faa) continue;
    dfs_in_tree(u, to, depp + 1, cur);
  }
}
int h[4223], htot;
bool vis[4223];
void find_cir(int cur) {
  h[++htot] = cur;
  vis[cur] = true;
  for (register int i = head[cur]; i; i = e[i].nxt)
    if (incir[i]) {
      int to = e[i].to;
      if (!vis[to]) find_cir(to);
    }
}
void dfs3(int cur, int u, int y, int z, int x, int faa) {
  f[cur][u] = f[u][cur] = 1.0 / (x + y) + 1.0 / (x + z) - 1.0 / (x + y + z);
  for (register int i = head[cur]; i; i = e[i].nxt)
    if (!incir[i]) {
      int to = e[i].to;
      if (to == faa) continue;
      dfs3(to, u, y, z, x + 1, cur);
    }
}
void dfs2(int cur, int v, int y, int z, int x, int faa) {
  dfs3(v, cur, y, z, x + 1, 0);
  for (register int i = head[cur]; i; i = e[i].nxt)
    if (!incir[i]) {
      int to = e[i].to;
      if (to == faa) continue;
      dfs2(to, v, y, z, x + 1, cur);
    }
}
inline void Cir() {
  for (register int i = 1; i <= n; ++i) {
    if (!notcir[i]) {
      find_cir(i);
      break;
    }
  }
  for (register int i = 1; i <= htot; ++i) {
    for (register int j = i + 1; j <= htot; ++j) {
      dfs2(h[i], h[j], j - i - 1, htot - j + i - 1, 1, 0);
    }
  }
}
int main() {
  read(n);
  for (register int i = 1; i <= n; ++i) {
    int u, v;
    read(u), read(v);
    ++u, ++v;
    addedge(u, v), addedge(v, u);
    ++d[u], ++d[v];
  }
  topo();
  for (register int i = 1; i <= n; ++i) {
    dfs_in_tree(i, i, 1, 0);
  }
  Cir();
  double res = 0;
  for (register int i = 1; i <= n; ++i) {
    for (register int j = 1; j <= n; ++j) {
      res += f[i][j];
    }
  }
  printf("%.10lf\n", res);
  return 0;
}
