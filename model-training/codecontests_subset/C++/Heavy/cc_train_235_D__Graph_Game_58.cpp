#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const int maxn = 100005;
inline int read() {
  int res, ok = 1;
  char ch;
  for (ch = getchar(); ch < '0' || ch > '9'; ch = getchar())
    if (ch == '-') ok = -1;
  res = ch - '0';
  for (ch = getchar(); ch >= '0' && ch <= '9'; ch = getchar())
    res = res * 10 + ch - '0';
  return res * ok;
}
int tot, last[3005], n, pre[3005], c[3005], len, o[3005], dis[3005], b[3005],
    cnt, cur;
bool vis[3005];
double ans;
struct edge {
  int u, v, last;
} e[6005];
inline void link(int u, int v) {
  tot++;
  e[tot].u = u;
  e[tot].v = v;
  e[tot].last = last[u];
  last[u] = tot;
}
inline bool dfs(int u) {
  vis[u] = true;
  for (int i = last[u]; i; i = e[i].last) {
    int v = e[i].v;
    if (v != pre[u]) {
      if (!vis[v]) {
        pre[v] = u;
        if (dfs(v)) return true;
      } else {
        while (1) {
          len++;
          c[len] = u;
          o[u] = len;
          if (u == v) break;
          u = pre[u];
        }
        return true;
      }
    }
  }
  return false;
}
inline void dfs1(int u, int fa = -1) {
  b[u] = cnt;
  for (int i = last[u]; i; i = e[i].last) {
    int v = e[i].v;
    if (v != fa && !o[v]) {
      dis[v] = dis[u] + 1;
      dfs1(v, u);
    }
  }
}
inline void dfs2(int u, int fa, int d) {
  ans += 1.0 / d;
  for (int i = last[u]; i; i = e[i].last) {
    int v = e[i].v;
    if (e[i].v != fa && b[v] == cur) dfs2(v, u, d + 1);
  }
}
int main() {
  n = read();
  for (int i = 1; i <= n; i++) {
    int u, v;
    u = read();
    v = read();
    u++;
    v++;
    link(u, v);
    link(v, u);
  }
  dfs(1);
  for (int i = 1; i <= len; i++) {
    cnt++;
    dfs1(c[i]);
  }
  for (int i = 1; i <= n; i++) {
    cur = b[i];
    dfs2(i, -1, 1);
  }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      if (b[i] != b[j]) {
        int now = dis[i] + dis[j] + len, x, y;
        x = abs(b[i] - b[j]) - 1;
        y = len - 2 - x;
        ans += 1.0 / now * (1 + x * 1.0 / (now - x) + y * 1.0 / (now - y));
      }
  printf("%.10lf\n", ans);
  return 0;
}
