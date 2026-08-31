#include <bits/stdc++.h>
using namespace std;
const int N = 5010;
int head[N], from[N], to[N << 2], nxt[N << 2], dep[N], q[N], vis[N], bel[N],
    num[N << 2], cnt;
double ans;
int tot, x, y, n, m;
int f[N][25];
inline int read() {
  int x = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = x * 10 + (ch ^ 48);
    ch = getchar();
  }
  return x * f;
}
inline void add(int u, int v, int w) {
  nxt[++cnt] = head[u];
  head[u] = cnt;
  to[cnt] = v;
  num[cnt] = w;
}
bool dfs(int u, int fa) {
  vis[u] = 1;
  for (int i = head[u]; i; i = nxt[i]) {
    if (num[i] != fa) {
      if (vis[to[i]]) {
        for (int j = u; j != to[i]; j = from[j]) q[++tot] = j;
        q[++tot] = to[i];
        return true;
      } else {
        from[to[i]] = u;
        if (dfs(to[i], num[i])) return true;
      }
    }
  }
  return false;
}
void find(int u, int fa, int rt) {
  bel[u] = rt;
  dep[u] = dep[fa] + 1;
  f[u][0] = fa;
  for (int i = 1; i <= 15; i++) f[u][i] = f[f[u][i - 1]][i - 1];
  for (int i = head[u]; i; i = nxt[i])
    if (to[i] != fa && !vis[to[i]]) find(to[i], u, rt);
}
int lca(int x, int y) {
  if (dep[x] < dep[y]) swap(x, y);
  int dis = dep[x] - dep[y];
  for (int i = 0; i <= 15; i++)
    if (dis & (1 << i)) x = f[x][i];
  if (x == y) return x;
  for (int i = 15; i >= 0; i--)
    if (f[x][i] != f[y][i]) x = f[x][i], y = f[y][i];
  return f[x][0];
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d%d", &x, &y);
    x++;
    y++;
    add(x, y, i);
    add(y, x, i);
  }
  dfs(1, 0);
  memset(vis, 0, sizeof(vis));
  for (int i = 1; i <= tot; i++) vis[q[i]] = 1;
  for (int i = 1; i <= tot; i++) find(q[i], 0, i);
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      if (bel[i] == bel[j])
        ans += (double)1 / (dep[i] + dep[j] - 2 * dep[lca(i, j)] + 1);
      else {
        int X = dep[i] + dep[j];
        int Y = abs(bel[i] - bel[j]) - 1;
        int Z = tot - Y - 2;
        ans +=
            (double)1 / (X + Y) + (double)1 / (X + Z) - (double)1 / (X + Y + Z);
      }
  printf("%.7f", ans);
  return 0;
}
