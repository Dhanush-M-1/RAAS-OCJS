#include <bits/stdc++.h>
using namespace std;
const int MAXN = 3005;
struct Node {
  int to, id;
  Node() = default;
  Node(int a, int b) : to(a), id(b) {}
};
vector<Node> v[MAXN];
int vis[MAXN], st[MAXN], tt, flag;
int siz[MAXN], dep[MAXN], fa[MAXN];
int top[MAXN], son[MAXN], col[MAXN];
inline int read() {
  int x = 0;
  char ch = getchar();
  while (!isdigit(ch)) ch = getchar();
  while (isdigit(ch)) {
    x = x * 10 + ch - '0';
    ch = getchar();
  }
  return x;
}
void dfs_cir(int x, int fa) {
  vis[x] = 1;
  for (auto y : v[x]) {
    if (y.id == fa) continue;
    if (vis[y.to]) {
      flag = y.to;
      st[++tt] = x;
      return;
    }
    dfs_cir(y.to, y.id);
    if (flag == -1) {
      vis[x] = 0;
      return;
    }
    if (flag) {
      st[++tt] = x;
      flag == x && (flag = -1);
      return;
    }
  }
}
void dfs_son(int x, int fath) {
  siz[x] = 1;
  fa[x] = fath;
  col[x] = col[fath];
  dep[x] = dep[fath] + 1;
  for (auto y : v[x]) {
    if (vis[y.to]) continue;
    if (y.to == fath) continue;
    dfs_son(y.to, x), siz[x] += siz[y.to];
    if (siz[y.to] > siz[son[x]]) son[x] = y.to;
  }
}
void dfs_chain(int x, int tp) {
  top[x] = tp;
  if (son[x]) dfs_chain(son[x], tp);
  for (auto y : v[x]) {
    if (vis[y.to]) continue;
    if (y.to == fa[x] || y.to == son[x]) continue;
    dfs_chain(y.to, y.to);
  }
}
inline int query_lca(int x, int y) {
  while (top[x] != top[y]) {
    if (dep[top[x]] < dep[top[y]]) swap(x, y);
    x = fa[top[x]];
  }
  return dep[x] < dep[y] ? x : y;
}
inline int query_dis(int x, int y) {
  int lca = query_lca(x, y);
  return dep[x] + dep[y] - dep[lca] * 2 + 1;
}
int main() {
  int n = read();
  for (int i = 1; i <= n; i++) {
    int x = read() + 1, y = read() + 1;
    v[x].push_back(Node(y, i));
    v[y].push_back(Node(x, i));
  }
  dfs_cir(1, 0);
  for (int i = 1; i <= tt; i++)
    col[0] = i, dfs_son(st[i], 0), dfs_chain(st[i], st[i]);
  double ans = 0;
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++) {
      if (col[i] == col[j])
        ans += 1.0 / query_dis(i, j);
      else {
        int x = dep[i] + dep[j], y = abs(col[i] - col[j]) - 1, z = tt - y - 2;
        ans += 1.0 / (x + y) + 1.0 / (x + z) - 1.0 / (x + y + z);
      }
    }
  printf("%.15lf\n", ans);
  return 0;
}
