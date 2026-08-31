#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 1;
int h[N], f[N], g[N], cnt, n, m, dep[N], dp[N];
struct nod {
  int nxt, to;
} e[N];
inline bool isdigit(const char &ch) { return (ch >= '0' && ch <= '9'); }
inline int read() {
  register int s = 0;
  register bool m = false;
  register char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') m = true;
    ch = getchar();
  }
  while (isdigit(ch)) s = (s << 1) + (s << 3) + (ch ^ 48), ch = getchar();
  return m ? -s : s;
}
inline void add(const int &u, const int &v) {
  e[++cnt] = (nod){h[u], v};
  h[u] = cnt;
}
inline void _SOL(const int &u, const int &fa) {
  dep[u] = dep[fa] + 1;
  if (!h[u]) {
    g[u] = dep[u];
    f[u] = 1;
    return;
  }
  for (register int i = h[u]; i; i = e[i].nxt) {
    register int v = e[i].to;
    _SOL(v, u);
    if (!g[u])
      g[u] = g[v];
    else
      g[u] = min(g[v], g[u]);
    if (g[v] - dep[u] <= m) f[u] += f[v];
  }
}
inline void __SOL(const int &u) {
  dp[u] = f[u];
  for (register int i = h[u]; i; i = e[i].nxt) {
    register int v = e[i].to;
    __SOL(v);
    dp[u] = max(dp[u], dp[v] + f[u] - (g[v] - dep[u] <= m ? f[v] : 0));
  }
}
signed main(int _lzh, char const *__lzh[]) {
  n = read(), m = read();
  for (register int i = 2; i <= n; ++i) add(read(), i);
  _SOL(1, 0);
  __SOL(1);
  printf("%d\n", dp[1]);
  return 0;
}
