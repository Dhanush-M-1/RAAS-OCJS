#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int x = 0, f = 1;
  char p = getchar();
  while (!isdigit(p)) {
    if (p == '-') f = -1;
    p = getchar();
  }
  while (isdigit(p)) x = (x << 3) + (x << 1) + (p ^ 48), p = getchar();
  return x * f;
}
const int maxn = 3e3 + 5;
int n, head[maxn], ver[maxn << 1], nxt[maxn << 1], f[maxn][14], tot;
int dep[maxn], d[maxn], a[maxn], col[maxn], cir[maxn];
int vis[maxn], cnt = 1, stk[maxn], top;
double ans;
inline void add(int x, int y) {
  nxt[++cnt] = head[x];
  head[x] = cnt;
  ver[cnt] = y;
}
inline bool find_circle(int x, int fr) {
  if (vis[x]) {
    int tmp = 0;
    do {
      a[++tot] = tmp = stk[top--];
    } while (x != tmp);
    return 1;
  }
  stk[++top] = x;
  vis[x] = 1;
  for (int i = head[x]; i; i = nxt[i]) {
    if (i == (fr ^ 1)) continue;
    int y = ver[i];
    if (find_circle(y, i)) return 1;
  }
  vis[stk[top--]] = 0;
  return 0;
}
inline int lca(int x, int y) {
  if (dep[x] < dep[y]) swap(x, y);
  for (int i = 13; i >= 0; i--)
    if ((dep[x] - dep[y]) >= 1 << i) x = f[x][i];
  if (x == y) return x;
  for (int i = 13; i >= 0; i--)
    if (f[x][i] != f[y][i]) x = f[x][i], y = f[y][i];
  return f[x][0];
}
inline int dis(int x, int y) { return dep[x] + dep[y] - 2 * dep[lca(x, y)]; }
inline void dfs(int x, int fa, int rt) {
  col[x] = rt;
  dep[x] = dep[fa] + 1;
  f[x][0] = fa;
  for (int i = head[x]; i; i = nxt[i]) {
    int y = ver[i];
    if (y == fa) continue;
    dfs(y, x, rt);
  }
}
inline void pre_work() {
  for (int j = 1; j <= 13; j++)
    for (int i = 1; i <= n; i++) f[i][j] = f[f[i][j - 1]][j - 1];
}
int main() {
  n = read();
  for (int i = 1, x, y; i <= n; i++)
    x = read() + 1, y = read() + 1, add(x, y), add(y, x);
  find_circle(1, -1);
  memset(vis, 0, sizeof(vis));
  for (int i = 1; i <= tot; i++) vis[a[i]] = 1;
  for (int j = 1; j <= tot; j++) {
    int x = a[j];
    for (int i = head[x]; i; i = nxt[i]) {
      int y = ver[i];
      if (vis[y]) continue;
      dfs(y, x, x);
    }
  }
  pre_work();
  for (int i = 1; i <= tot; i++) d[a[i]] = i - 1;
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++) {
      if (i == j) {
        ans += 1;
        continue;
      }
      int w = 0;
      if (vis[i]) w++;
      if (vis[j]) w++;
      if (w == 0) {
        if (col[i] == col[j]) {
          ans += 1.0 / (dis(i, j) + 1);
          continue;
        }
        int e = dep[i] + dep[j] + tot;
        int r = dep[i] + dep[j] + abs(d[col[i]] - d[col[j]]) + 1;
        int t = dep[i] + dep[j] + tot - abs(d[col[i]] - d[col[j]]) + 1;
        ans += 1.0 / r;
        ans += 1.0 / t;
        ans -= 1.0 / e;
      }
      if (w == 1) {
        int x = i, y = j;
        if (vis[j]) swap(x, y);
        if (col[y] == x) {
          ans += 1.0 / (dep[y] + 1);
          continue;
        }
        int e = dep[y] + tot;
        int r = dep[y] + abs(d[x] - d[col[y]]) + 1;
        int t = dep[y] + tot - abs(d[x] - d[col[y]]) + 1;
        ans += 1.0 / r;
        ans += 1.0 / t;
        ans -= 1.0 / e;
      }
      if (w == 2) {
        int e = tot;
        int r = abs(d[i] - d[j]) + 1;
        int t = tot - abs(d[i] - d[j]) + 1;
        ans += 1.0 / r;
        ans += 1.0 / t;
        ans -= 1.0 / e;
      }
    }
  printf("%.8f\n", ans);
  return 0;
}
