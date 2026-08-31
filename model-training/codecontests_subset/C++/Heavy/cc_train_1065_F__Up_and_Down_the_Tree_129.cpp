#include <bits/stdc++.h>
using namespace std;
template <class T>
inline bool read(T &x) {
  x = 0;
  bool f = 0;
  char ch;
  for (ch = getchar(); !isdigit(ch); ch = getchar()) {
    if (ch == EOF) return 0;
    f |= ch == '-';
  }
  for (; isdigit(ch); ch = getchar()) x = (x << 1) + (x << 3) + (ch ^ 48);
  if (f) x = -x;
  return 1;
}
template <class T>
void write(T x) {
  if (x < 0) {
    putchar('-');
    write(-x);
    return;
  }
  if (x > 9) write(x / 10);
  putchar(x % 10 | 48);
}
template <class T>
inline void writeln(T x) {
  write(x);
  putchar('\n');
}
template <class T>
inline void writespace(T x) {
  write(x);
  putchar(' ');
}
const string taskname = "zero";
long long n, k;
long long dep[1000010], fa[1000010], f[1000010], g[1000010];
long long low[1000010];
long long tot, h[1000010], ver[1000010], nxt[1000010];
bool leaf[1000010];
inline void add(long long u, long long v) {
  ++tot;
  ver[tot] = v;
  leaf[u] = 0;
  nxt[tot] = h[u];
  h[u] = tot;
}
void dfs(long long u) {
  dep[u] = dep[fa[u]] + 1;
  if (leaf[u])
    g[u] = 1, low[u] = dep[u];
  else
    low[u] = 1e9;
  for (register long long i = h[u]; i; i = nxt[i]) {
    long long v = ver[i];
    dfs(v);
    low[u] = min(low[v], low[u]);
  }
  for (register long long i = h[u]; i; i = nxt[i]) {
    long long v = ver[i];
    if (low[v] - dep[u] <= k) g[u] += g[v], g[v] = 0;
  }
}
void dp(long long u) {
  for (register long long i = h[u]; i; i = nxt[i]) {
    long long v = ver[i];
    dp(v);
    f[u] = max(f[u], f[v]);
  }
  f[u] += g[u];
}
signed main() {
  srand(20050210);
  read(n);
  read(k);
  for (register long long i = 1; i <= n; ++i) leaf[i] = 1;
  for (register long long i = 2; i <= n; ++i) {
    read(fa[i]);
    add(fa[i], i);
  }
  dfs(1);
  dp(1);
  write(f[1]);
  return 0;
}
