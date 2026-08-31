#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') {
    x = (x << 3) + (x << 1) + (ch ^ 48);
    ch = getchar();
  }
  return x * f;
}
const int N = 3005;
int n, top, root, tot;
struct Edge {
  int to;
  Edge *nxt;
  Edge(int to = 0, Edge *nxt = NULL) : to(to), nxt(nxt) {}
} * head[N], pool[N << 1], *tail = pool;
inline void add(int u, int v) { head[u] = new (tail++) Edge(v, head[u]); }
bool vis[N];
int st[N], pos[N], dep[N], anc[N], fa[N][13];
bool flag;
void find_circle(int x, int fa) {
  vis[x] = 1;
  st[++top] = x;
  for (Edge *i = head[x]; i; i = i->nxt) {
    int to = i->to;
    if (to == fa) continue;
    if (vis[to]) return (void)(root = to, flag = 1);
    find_circle(to, x);
    if (flag) return;
  }
  vis[x] = 0;
  top--;
}
void get(int x, int rot) {
  anc[x] = rot;
  dep[x] = dep[fa[x][0]] + 1;
  for (int i = 1; i <= 12; i++) fa[x][i] = fa[fa[x][i - 1]][i - 1];
  for (Edge *i = head[x]; i; i = i->nxt) {
    int to = i->to;
    if (to == fa[x][0] || pos[to]) continue;
    fa[to][0] = x;
    get(to, rot);
  }
}
inline int LCA(int x, int y) {
  if (dep[x] < dep[y]) swap(x, y);
  for (int i = 12; i >= 0; i--)
    if (dep[fa[x][i]] >= dep[y]) x = fa[x][i];
  if (x == y) return x;
  for (int i = 12; i >= 0; i--)
    if (fa[x][i] != fa[y][i]) x = fa[x][i], y = fa[y][i];
  return fa[x][0];
}
inline int dis(int x, int y) {
  return dep[x] + dep[y] - (dep[LCA(x, y)] << 1) + 1;
}
int main() {
  n = read();
  double ans = 0;
  for (int i = 1, u, v; i <= n; i++)
    u = read() + 1, v = read() + 1, add(u, v), add(v, u);
  find_circle(1, 0);
  pos[root] = ++tot;
  while (st[top] != root) pos[st[top--]] = ++tot;
  for (int i = 1; i <= n; i++)
    if (pos[i]) get(i, i);
  for (int i = 1, x, y, z; i <= n; i++)
    for (int j = 1; j <= n; j++) {
      if (anc[i] != anc[j]) {
        x = dep[i] - dep[anc[i]] + dep[j] - dep[anc[j]] + 2;
        y = (pos[anc[i]] - pos[anc[j]] - 1 + tot) % tot;
        z = (pos[anc[j]] - pos[anc[i]] - 1 + tot) % tot;
        ans += 1.0 / (double)(x + y) + 1.0 / (double)(x + z) -
               1.0 / (double)(x + y + z);
      } else
        ans += 1.0 / (double)dis(i, j);
    }
  printf("%.10f\n", ans);
  return 0;
}
