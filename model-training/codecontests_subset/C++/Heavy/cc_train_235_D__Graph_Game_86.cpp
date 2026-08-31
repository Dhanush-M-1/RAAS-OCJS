#include <bits/stdc++.h>
using namespace std;
const int N = 3000 + 3;
struct Edge {
  int to, nxt;
} e[N << 1];
int n, cnt;
int hd[N], top, q[N], tail, cur[N], c[N], pos[N], belong[N], fa[N][13], dep[N];
bool vis[N], used[N];
long double ans;
inline void addedge(int x, int y) {
  e[++top].to = y;
  e[top].nxt = hd[x];
  hd[x] = top;
  e[++top].to = x;
  e[top].nxt = hd[y];
  hd[y] = top;
}
inline void find_cycle(void) {
  int tail, now;
  for (int i = 1; i <= n; ++i) cur[i] = hd[i];
  for (vis[q[tail = 1] = 1] = 1; tail;)
    for (int& p = cur[now = q[tail]]; ~p; p = e[p].nxt)
      if (!used[p >> 1]) {
        used[p >> 1] = 1;
        if (vis[e[p].to]) {
          do c[++cnt] = q[tail--];
          while (c[cnt] != e[p].to);
          return;
        }
        vis[q[++tail] = e[p].to] = 1;
        p = e[p].nxt;
        break;
      } else if (!~e[p].nxt) {
        --tail;
        break;
      }
}
inline void init(void) {
  find_cycle();
  memset(vis, 0, sizeof vis);
  for (int i = 1; i <= cnt; ++i) vis[c[i]] = 1;
  for (int i = 1, l, r, now, p; i <= cnt; ++i) {
    pos[c[i]] = i;
    for (fa[q[l = r = 1] = c[i]][0] = -1; l <= r; ++l) {
      for (p = hd[now = q[l]]; ~p; p = e[p].nxt)
        if (!vis[e[p].to])
          vis[q[++r] = e[p].to] = 1,
                       dep[e[p].to] = dep[fa[e[p].to][0] = now] + 1;
    }
    for (int j = 1; j <= r; belong[q[j++]] = c[i])
      for (int k = 0; k < 12; ++k)
        fa[q[j]][k + 1] = ~fa[q[j]][k] ? fa[fa[q[j]][k]][k] : -1;
  }
}
inline int lca(int x, int y) {
  if (dep[x] > dep[y]) swap(x, y);
  for (int k = 12; ~k && dep[x] != dep[y]; --k)
    if (~fa[y][k] && dep[fa[y][k]] >= dep[x]) y = fa[y][k];
  for (int k = 12; ~k && x != y; --k)
    if (~fa[x][k] && ~fa[y][k] && fa[x][k] != fa[y][k])
      x = fa[x][k], y = fa[y][k];
  return x == y ? x : fa[x][0];
}
inline void solve(int x, int y) {
  if (belong[x] == belong[y]) {
    int z = lca(x, y);
    ans += 1.0 / (dep[x] + dep[y] - dep[z] * 2 + 1);
  } else {
    int a = dep[x] + dep[y], b = abs(pos[belong[x]] - pos[belong[y]]) - 1,
        c = cnt - 2 - b;
    ans += 1.0 / (a + b + 2) + 1.0 / (a + c + 2) - 1.0 / (a + cnt);
  }
}
int main(int argc, char** argv) {
  int x, y;
  memset(hd, -1, sizeof hd);
  top = -1;
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) scanf("%d%d", &x, &y), addedge(x + 1, y + 1);
  init();
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j) solve(i, j);
  printf("%.10lf\n", (double)ans);
  return 0;
}
