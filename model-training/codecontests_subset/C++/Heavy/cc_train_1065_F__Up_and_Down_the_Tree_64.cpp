#include <bits/stdc++.h>
using namespace std;
inline int gi() {
  int x = 0, f = 1;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') f = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    x = (x << 3) + (x << 1) + ch - 48;
    ch = getchar();
  }
  return x * f;
}
template <typename T>
inline bool Max(T &a, T b) {
  return a < b ? a = b, 1 : 0;
}
template <typename T>
inline bool Min(T &a, T b) {
  return b < a ? a = b, 1 : 0;
}
const int N = 1e6 + 7, inf = 0x3f3f3f3f;
int n, edc, K;
int head[N], len[N], f[N], g[N];
struct edge {
  int last, to;
  edge() {}
  edge(int last, int to) : last(last), to(to) {}
} e[N * 2];
void Add(int a, int b) {
  e[++edc] = edge(head[a], b), head[a] = edc;
  e[++edc] = edge(head[b], a), head[b] = edc;
}
void dfs(int u, int fa) {
  len[u] = inf;
  int fg = 1;
  for (int i = head[u], v = e[i].to; i; i = e[i].last, v = e[i].to)
    if (v ^ fa) {
      fg = 0;
      dfs(v, u);
      Min(len[u], len[v] + 1);
      if (len[v] + 1 > K) g[v] = 0;
      g[u] += g[v];
      Max(f[u], f[v] - g[v]);
    }
  if (fg)
    len[u] = 0, g[u] = f[u] = 1;
  else
    f[u] += g[u];
}
int main() {
  n = gi(), K = gi();
  for (int i = 2; i <= n; ++i) Add(i, gi());
  dfs(1, 0);
  printf("%d\n", f[1]);
  return 0;
}
