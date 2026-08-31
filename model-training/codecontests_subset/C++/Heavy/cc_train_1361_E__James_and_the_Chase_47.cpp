#include <bits/stdc++.h>
inline int rint() {
  int x = 0, f = 1;
  char s = getchar();
  for (; s < '0' || '9' < s; s = getchar()) f = s == '-' ? -f : f;
  for (; '0' <= s && s <= '9'; s = getchar()) x = x * 10 + (s ^ '0');
  return x * f;
}
template <typename Tp>
inline void wint(Tp x) {
  if (x < 0) putchar('-'), x = ~x + 1;
  if (9 < x) wint(x / 10);
  putchar(x % 10 ^ '0');
}
const int MAXN = 1e5, MAXM = 2e5;
int n, m, ecnt, head[MAXN + 5], vtag[MAXN + 5], upc[MAXN + 5], top[MAXN + 5];
bool bad[MAXN + 5];
std::mt19937 rnd(20050913);
struct Edge {
  int to, nxt;
} graph[MAXM + 5];
inline void link(const int s, const int t) {
  graph[++ecnt] = {t, head[s]};
  head[s] = ecnt;
}
inline bool check(const int u) {
  vtag[u] = 1;
  for (int i = head[u], v; i; i = graph[i].nxt) {
    if (!vtag[v = graph[i].to]) {
      if (!check(v)) return false;
    } else if (vtag[v] == 2) {
      return false;
    }
  }
  vtag[u] = 2;
  return true;
}
inline void mark(const int u) {
  top[u] = u;
  for (int i = head[u], v; i; i = graph[i].nxt) {
    if (!vtag[v = graph[i].to]) {
      vtag[v] = vtag[u] + 1;
      mark(v), upc[u] += upc[v];
      if (vtag[top[v]] < vtag[top[u]]) top[u] = top[v];
    } else {
      ++upc[u], --upc[v];
      if (vtag[v] < vtag[top[u]]) top[u] = v;
    }
  }
}
inline int spread(const int u) {
  vtag[u] = 1, bad[u] = upc[u] > 1;
  int ret = !(bad[u] |= bad[top[u]]);
  for (int i = head[u], v; i; i = graph[i].nxt) {
    if (!vtag[v = graph[i].to]) {
      ret += spread(v);
    }
  }
  return ret;
}
inline void clear() {
  ecnt = 0;
  for (int i = 1; i <= n; ++i) {
    head[i] = vtag[i] = upc[i] = top[i] = bad[i] = 0;
  }
}
int main() {
  for (int T = rint(); T--;) {
    clear();
    n = rint(), m = rint();
    for (int i = 1, u, v; i <= m; ++i) {
      u = rint(), v = rint();
      link(u, v);
    }
    int rt = 0;
    for (int i = 1; i <= 100 && !rt; ++i) {
      int u = rnd() % n + 1;
      for (int i = 1; i <= n; ++i) vtag[i] = 0;
      if (check(u)) rt = u;
    }
    if (!rt) {
      puts("-1");
      continue;
    }
    for (int i = 1; i <= n; ++i) vtag[i] = 0;
    vtag[rt] = 1, mark(rt);
    for (int i = 1; i <= n; ++i) vtag[i] = 0;
    int cnt = spread(rt);
    if (cnt * 5 < n) {
      puts("-1");
      continue;
    }
    for (int i = 1, f = 0; i <= n; ++i) {
      if (!bad[i]) {
        if (f) putchar(' ');
        f = 1, printf("%d", i);
      }
    }
    putchar('\n');
  }
  return 0;
}
