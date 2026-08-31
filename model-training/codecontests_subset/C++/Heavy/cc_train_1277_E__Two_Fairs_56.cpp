#include <bits/stdc++.h>
using namespace std;
inline char gc() {
  static char now[1 << 16], *S, *T;
  if (T == S) {
    T = (S = now) + fread(now, 1, 1 << 16, stdin);
    if (T == S) return EOF;
  }
  return *S++;
}
inline long long read() {
  long long x = 0, f = 1;
  char ch = gc();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = gc();
  }
  while (isdigit(ch)) x = x * 10 + ch - '0', ch = gc();
  return x * f;
}
struct edge {
  long long to, nxt;
} g[1000001];
long long head[1000001], sum, N, n, m, A, B, tot, id, low[1000001],
    dfn[1000001];
stack<long long> S;
inline void made(long long from, long long to) {
  g[++tot].to = to;
  g[tot].nxt = head[from];
  head[from] = tot;
}
namespace RST {
struct edge {
  long long to, nxt;
} g[1000001];
long long head[1000001], sz[1000001], a[1000001], tot;
long long ANS;
inline void made(long long from, long long to) {
  g[++tot].to = to;
  g[tot].nxt = head[from];
  head[from] = tot;
}
bool dfs(long long u, long long fa) {
  sz[u] = (u <= n);
  long long xxxx = 0;
  bool fff = (u == B);
  for (long long i = head[u]; i; i = g[i].nxt) {
    long long v = g[i].to;
    if (v == fa) continue;
    bool xxx = dfs(v, u);
    sz[u] += sz[v];
    if (xxx) xxxx = sz[v], fff = 1;
  }
  if (u == A) {
    ANS = 1ll * (sz[B] - 1) * (sz[A] - xxxx - 1);
  }
  return fff;
}
}  // namespace RST
inline void mading(long long u, long long v) {
  RST::made(u, v);
  RST::made(v, u);
}
void tarjan(long long u, long long fa) {
  dfn[u] = low[u] = ++id;
  S.push(u);
  RST::a[u] = -1;
  N++;
  for (long long i = head[u]; i; i = g[i].nxt) {
    long long v = g[i].to;
    if (!dfn[v]) {
      tarjan(v, u);
      low[u] = min(low[u], low[v]);
      if (low[v] >= dfn[u]) {
        sum++;
        long long x;
        do {
          x = S.top();
          S.pop();
          mading(sum, x);
          RST::a[sum]++;
        } while (x != v);
        mading(sum, u);
        RST::a[sum]++;
      }
    }
    low[u] = min(low[u], dfn[v]);
  }
}
signed main() {
  long long T = read();
  while (T--) {
    n = read(), m = read(), A = read(), B = read();
    tot = 0;
    for (long long i = 1; i <= n; i++) head[i] = 0;
    while (!S.empty()) S.pop();
    for (long long i = 1; i <= 2 * n; i++) {
      RST::head[i] = 0;
      dfn[i] = 0;
      low[i] = 0;
    }
    RST::tot = 0, id = 0;
    RST::ANS = 0;
    for (long long i = 1; i <= m; i++) {
      long long x = read(), y = read();
      made(x, y);
      made(y, x);
    }
    sum = n;
    N = 0;
    tarjan(A, A);
    S.pop();
    RST::dfs(A, 0);
    printf("%lld\n", RST::ANS);
  }
}
