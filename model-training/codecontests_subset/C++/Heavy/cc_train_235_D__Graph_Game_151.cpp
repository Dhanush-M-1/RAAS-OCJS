#include <bits/stdc++.h>
using namespace std;
const int N = 100010, M = 1000010, P = 1e9 + 7;
const int inf = 0x3f3f3f3f;
const int INF = 0xcfcfcfcf;
const double eps = 1e-9, pi = asin(1) * 2;
inline long long read();
inline int ADD(int a, int b) { return a + b >= P ? a + b - P : a + b; }
inline int MINUS(int a, int b) { return a - b < 0 ? a - b + P : a - b; }
int head[N], ver[M], nxt[M];
int n, m, tot = 1;
inline void add(int x, int y) {
  ver[++tot] = y, nxt[tot] = head[x], head[x] = tot;
}
int pos[N], sz = 0, ed = 0;
bool visit[N];
inline bool dfs(int x, int fa) {
  visit[x] = true;
  for (int i = head[x]; i; i = nxt[i]) {
    int y = ver[i];
    if (y == fa) continue;
    if (visit[y]) return ed = y, pos[x] = ++sz;
    if (dfs(y, x) && y != ed) return pos[x] = ++sz;
  }
  return visit[x] = false;
}
int f[N], d[N], size[N], son[N], top[N], rt[N], RT = 0;
inline void dfs1(int x, int fa) {
  f[x] = fa, d[x] = d[fa] + 1, size[x] = 1, rt[x] = RT;
  for (int i = head[x]; i; i = nxt[i]) {
    int y = ver[i];
    if (y == fa || pos[y]) continue;
    dfs1(y, x);
    size[x] += size[y];
    if (size[y] > size[son[x]]) son[x] = y;
  }
}
inline void dfs2(int x, int t) {
  top[x] = t;
  if (!son[x]) return;
  dfs2(son[x], t);
  for (int i = head[x]; i; i = nxt[i]) {
    int y = ver[i];
    if (y == f[x] || y == son[x] || pos[y]) continue;
    dfs2(y, y);
  }
}
inline int lca(int x, int y) {
  int fx = top[x], fy = top[y];
  while (fx != fy) {
    if (d[fx] < d[fy]) swap(x, y), swap(fx, fy);
    x = f[fx], fx = top[x];
  }
  if (d[x] > d[y]) return y;
  return x;
}
inline int dis(int x, int y) { return d[x] + d[y] - 2 * d[lca(x, y)]; }
inline long long read() {
  long long s = 0;
  bool flag = false;
  char ch = getchar();
  for (; ch < '0' || ch > '9'; ch = getchar())
    if (ch == '-') flag = true;
  for (; '0' <= ch && ch <= '9'; ch = getchar())
    s = (s << 3) + (s << 1) + (ch ^ '0');
  if (flag) return -s;
  return s;
}
int main() {
  n = read();
  for (int i = 1; i <= n; i++) {
    int x = read() + 1, y = read() + 1;
    add(x, y), add(y, x);
  }
  dfs(1, 0);
  for (int i = 1; i <= n; i++)
    if (pos[i]) RT = i, dfs1(i, 0), dfs2(i, i);
  double ans = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= n; j++) {
      if (rt[i] == rt[j]) {
        ans += 1.0 / (dis(i, j) + 1);
      } else {
        int x = d[i] + d[j], y = abs(pos[rt[i]] - pos[rt[j]]) - 1,
            z = sz - 2 - y;
        ans += 1.0 / (x + y) + 1.0 / (x + z) - 1.0 / (x + y + z);
      }
    }
  }
  printf("%.15lf\n", ans);
  return 0;
}
