#include <bits/stdc++.h>
using namespace std;
int n, m, x, y, head[200010], num, from, to, T;
int read() {
  int x = 0;
  char ch = getchar();
  while (ch < '0' || ch > '9') ch = getchar();
  while (ch >= '0' && ch <= '9') {
    x = (x << 3) + (x << 1) + ch - '0';
    ch = getchar();
  }
  return x;
}
struct xx {
  int next, to;
} way[1000010];
void add(int from, int to) {
  way[++num].next = head[from];
  way[num].to = to;
  head[from] = num;
}
int dfn[200010], s, c[200010], size[200010], t, o, low[200010];
bool vis[200010];
void dfs(int x, int fa, int d) {
  size[d]++;
  c[x] = d;
  dfn[x] = low[x] = ++t;
  for (int i = head[x]; i; i = way[i].next) {
    int y = way[i].to;
    if (y == fa) continue;
    if (!dfn[y]) {
      dfs(y, x, d);
    } else
      low[x] = min(low[x], dfn[y]);
  }
}
int si, minl;
void search(int x, int fa) {
  vis[x] = 1;
  si++;
  minl = min(minl, low[x]);
  for (int i = head[x]; i; i = way[i].next) {
    int y = way[i].to;
    if (y == fa) continue;
    if (dfn[y] < dfn[x]) continue;
    if (!vis[y]) {
      search(y, x);
    }
  }
}
int main() {
  T = read();
  while (T--) {
    n = read();
    m = read();
    x = read();
    y = read();
    for (int i = 1; i <= n; ++i) head[i] = 0;
    num = 0;
    for (int i = 1; i <= m; ++i) {
      from = read();
      to = read();
      add(from, to);
      add(to, from);
    }
    dfn[x] = 1;
    t = 1;
    int co = 0;
    o = y;
    for (int i = head[x]; i; i = way[i].next) {
      int y = way[i].to;
      if (dfn[y]) continue;
      co++;
      dfs(y, x, co);
    }
    int gg = n - 1 - size[c[y]];
    long long ans = 0;
    for (int i = head[y]; i; i = way[i].next) {
      int g = way[i].to;
      if (dfn[g] < dfn[y]) continue;
      if (vis[g]) continue;
      si = 0;
      minl = n + 10;
      search(g, y);
      if (minl >= dfn[y]) ans += 1ll * gg * si;
    }
    printf("%lld\n", ans);
    for (int i = 1; i <= co; ++i) size[i] = 0;
    for (int i = 1; i <= n; ++i) dfn[i] = low[i] = vis[i] = 0;
  }
  return 0;
}
