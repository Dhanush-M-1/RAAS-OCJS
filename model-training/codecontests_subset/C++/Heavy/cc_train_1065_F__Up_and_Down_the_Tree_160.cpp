#include <bits/stdc++.h>
using namespace std;
const double pi = acos(-1);
const double eps = 1e-6;
inline int lowbit(int x) { return x & (-x); }
inline int read() {
  int f = 1, x = 0;
  char ch;
  do {
    ch = getchar();
    if (ch == '-') f = -1;
  } while (ch < '0' || ch > '9');
  do {
    x = x * 10 + ch - '0';
    ch = getchar();
  } while (ch >= '0' && ch <= '9');
  return f * x;
}
template <typename T>
inline T max(T x, T y, T z) {
  return max(max(x, y), z);
}
template <typename T>
inline T min(T x, T y, T z) {
  return min(min(x, y), z);
}
template <typename T>
inline T sqr(T x) {
  return x * x;
}
template <typename T>
inline void checkmax(T &x, T y) {
  x = max(x, y);
}
template <typename T>
inline void checkmin(T &x, T y) {
  x = min(x, y);
}
template <typename T>
inline void read(T &x) {
  x = 0;
  T f = 1;
  char ch;
  do {
    ch = getchar();
    if (ch == '-') f = -1;
  } while (ch < '0' || ch > '9');
  do x = x * 10 + ch - '0', ch = getchar();
  while (ch <= '9' && ch >= '0');
  x *= f;
}
template <typename A, typename B, typename C>
inline A fpow(A x, B p, C yql) {
  A ans = 1;
  for (; p; p >>= 1, x = 1LL * x * x % yql)
    if (p & 1) ans = 1LL * x * ans % yql;
  return ans;
}
struct FastIO {
  static const int S = 1310720;
  int wpos;
  char wbuf[S];
  FastIO() : wpos(0) {}
  inline int xchar() {
    static char buf[S];
    static int len = 0, pos = 0;
    if (pos == len) pos = 0, len = fread(buf, 1, S, stdin);
    if (pos == len) return -1;
    return buf[pos++];
  }
  inline int read() {
    int c = xchar(), x = 0;
    while (c <= 32 && ~c) c = xchar();
    if (c == -1) return -1;
    for (; '0' <= c && c <= '9'; c = xchar()) x = x * 10 + c - '0';
    return x;
  }
} io;
const int N = 1e6 + 10;
int head[N], tot = 0, size[N], n, m, fa[N], dep[N], k, dp[N];
struct Edge {
  int u, v, next;
} G[N << 1];
inline void addedge(int u, int v) {
  G[++tot].u = u;
  G[tot].v = v;
  G[tot].next = head[u];
  head[u] = tot;
  G[++tot].u = v;
  G[tot].v = u;
  G[tot].next = head[v];
  head[v] = tot;
}
inline void dfs1(int u, int f) {
  int d0 = dep[u];
  for (int i = head[u]; i; i = G[i].next) {
    int v = G[i].v;
    if (v == f) continue;
    dfs1(v, u);
    size[u] += size[v];
    checkmin(dep[u], dep[v] + 1);
    checkmax(dp[u], dp[v] - size[v]);
  }
  dp[u] += size[u];
  if (dep[u] == d0) {
    dp[u] = 1;
    size[u] = 1;
    dep[u] = 0;
  }
  if (dep[u] >= k) size[u] = 0;
}
int main() {
  n = read();
  k = read();
  memset(dep, 127, sizeof(dep));
  for (int i = 2; i <= n; i++) {
    int u = i, v = read();
    fa[u] = v;
    addedge(u, v);
  }
  dfs1(1, 0);
  printf("%d\n", dp[1]);
}
