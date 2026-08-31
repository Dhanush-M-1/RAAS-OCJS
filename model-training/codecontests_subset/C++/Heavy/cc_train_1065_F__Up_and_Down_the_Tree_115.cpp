#include <bits/stdc++.h>
using namespace std;
inline long long read() {
  long long x = 0;
  char ch = getchar();
  bool f = 0;
  for (; !isdigit(ch); ch = getchar())
    if (ch == '-') f = 1;
  for (; isdigit(ch); ch = getchar()) x = x * 10 + ch - '0';
  return f ? -x : x;
}
void write(long long x) {
  if (x < 0) putchar('-'), x = -x;
  if (x >= 10) write(x / 10);
  putchar(x % 10 + '0');
}
void writeln(long long x) {
  write(x);
  puts("");
}
void writep(long long x) {
  write(x);
  putchar(' ');
}
long long const N = 1e6 + 3;
long long const inf = 1e9;
long long n, k, cnt, ans, vis[N], h[N], dep[N], sz[N], mn[N];
struct edge {
  long long nt, to;
} e[N];
void add(long long x, long long y) {
  e[++cnt] = (edge){h[x], y};
  h[x] = cnt;
}
void dfs1(long long x, long long d) {
  dep[x] = d;
  mn[x] = inf;
  if (!vis[x]) mn[x] = d;
  for (long long i = h[x]; i; i = e[i].nt) {
    long long v = e[i].to;
    dfs1(v, d + 1);
    mn[x] = min(mn[x], mn[v]);
  }
}
void dfs2(long long x) {
  if (!vis[x]) sz[x] = 1;
  for (long long i = h[x]; i; i = e[i].nt) {
    long long v = e[i].to;
    dfs2(v);
    if (mn[v] - dep[x] <= k) {
      sz[x] += sz[v];
      sz[v] = 0;
    }
  }
}
long long dfs(long long x) {
  long long res = 0;
  for (long long i = h[x]; i; i = e[i].nt) {
    long long v = e[i].to;
    res = max(res, dfs(v));
  }
  return res + sz[x];
}
signed main() {
  n = read();
  k = read();
  for (long long i = 2; i <= n; i++) {
    long long x = read();
    add(x, i);
    vis[x] = 1;
  }
  dfs1(1, 0);
  dfs2(1);
  writeln(dfs(1));
  return 0;
}
