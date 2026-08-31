#include <bits/stdc++.h>
using namespace std;
inline int read() {
  int ret = 0, w = 1;
  char ch = getchar();
  while (ch < '0' || ch > '9') {
    if (ch == '-') w = -1;
    ch = getchar();
  }
  while (ch >= '0' && ch <= '9') ret = ret * 10 + ch - '0', ch = getchar();
  return w * ret;
}
int n, m, a, b;
int tot = 1;
int edge[1000010];
int nxt[1000010];
int hd[200010];
inline void add_edge(int u, int v) {
  edge[tot] = v;
  nxt[tot] = hd[u];
  hd[u] = tot++;
}
int book[200010];
int dfs(int p, int root) {
  if ((root == a && p == b) || (root == b && p == a)) return -9999999;
  book[p] = 1;
  int subtree = 0;
  int sz = 1;
  int cnt = 0;
  for (int i = hd[p]; i; i = nxt[i])
    if (!book[edge[i]]) {
      subtree++;
      int x = dfs(edge[i], root);
      if (p == root && x > 0) cnt += x;
      if (p != root) sz += x;
    }
  if (p == root && subtree <= 1)
    return 0;
  else if (p == root)
    return cnt;
  else
    return sz;
}
int main() {
  int t = read();
  while (t--) {
    tot = 1;
    n = read(), m = read(), a = read(), b = read();
    for (int i = 0; i <= 2 * m; i++) edge[i] = 0;
    for (int i = 0; i <= 2 * m; i++) nxt[i] = 0;
    for (int i = 0; i <= n; i++) hd[i] = 0;
    for (int i = 0; i <= n; i++) book[i] = 0;
    for (int i = 1; i <= m; i++) {
      int u = read(), v = read();
      add_edge(u, v);
      add_edge(v, u);
    }
    long long s1 = (long long)dfs(a, a);
    for (int i = 0; i <= n; i++) book[i] = 0;
    long long s2 = (long long)dfs(b, b);
    printf("%lld\n", s1 * s2);
  }
  return 0;
}
