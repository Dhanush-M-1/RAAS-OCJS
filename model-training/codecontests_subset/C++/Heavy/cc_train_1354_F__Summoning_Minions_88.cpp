#include <bits/stdc++.h>
using namespace std;
const int N = 2 * 1e4 + 100, M = 81;
int T, n, k, a[M], b[M], ans, p[M], in[M];
int s, t, d[N], pe[N], pn[N], flow[N], vi[N];
int tot, first[N], nxt[N * 2], point[N * 2], data[N * 2], cost[N * 2];
inline int read() {
  int f = 1, x = 0;
  char s = getchar();
  while (s < '0' || s > '9') {
    if (s == '-') f = -1;
    s = getchar();
  }
  while (s >= '0' && s <= '9') {
    x = x * 10 + s - '0';
    s = getchar();
  }
  return x * f;
}
inline void add_edge(int x, int y, int z, int h) {
  nxt[++tot] = first[x], first[x] = tot;
  point[tot] = y, data[tot] = z, cost[tot] = h;
  nxt[++tot] = first[y], first[y] = tot;
  point[tot] = x, data[tot] = 0, cost[tot] = -h;
}
bool spfa(int t) {
  queue<int> q;
  for (int i = 0; i <= t; i++) d[i] = 0x3f3f3f3f, flow[i] = 0;
  d[s] = 0;
  vi[s] = 1;
  q.push(s);
  flow[s] = 0x3f3f3f3f;
  while (!q.empty()) {
    int x = q.front();
    q.pop();
    vi[x] = 0;
    for (int i = first[x]; i != -1; i = nxt[i]) {
      int u = point[i];
      if (data[i] && d[u] > d[x] + cost[i]) {
        d[u] = d[x] + cost[i];
        pn[u] = x, pe[u] = i, flow[u] = min(flow[x], data[i]);
        if (!vi[u]) vi[u] = 1, q.push(u);
      }
    }
  }
  if (!flow[t]) return 0;
  int x = t;
  while (x != s) {
    data[pe[x]] -= flow[t];
    data[pe[x] ^ 1] += flow[t];
    x = pn[x];
  }
  return 1;
}
signed main() {
  T = read();
  while (T--) {
    tot = -1;
    ans = 0;
    memset(first, -1, sizeof(first));
    n = read();
    k = read();
    for (int i = 1; i <= n; i++) a[i] = read(), b[i] = read();
    s = 0;
    t = n + k + 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= k; j++) add_edge(i, j + n, 1, (k - j) * b[i] - a[i]);
    }
    for (int i = 1; i <= n; i++) add_edge(s, i, 1, 0);
    for (int i = 1; i <= k; i++) add_edge(i + n, t, 1, 0);
    while (spfa(t))
      ;
    memset(p, 0, sizeof(p));
    memset(in, 0, sizeof(in));
    for (int i = 0; i <= tot; i += 2) {
      if (point[i] == s || point[i] == t || point[i ^ 1] == s ||
          point[i ^ 1] == t || data[i])
        continue;
      int u = point[i], v = point[i ^ 1];
      if (u > v) swap(u, v);
      v -= n;
      p[v] = u;
      in[u] = 1;
    }
    printf("%d\n", 2 * n - k);
    for (int i = 1; i < k; i++) printf("%d ", p[i]);
    for (int i = 1; i <= n; i++)
      if (!in[i]) printf("%d %d ", i, -i);
    printf("%d\n", p[k]);
  }
}
