#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
inline int read() {
  int w = 1, s = 0;
  char ch = getchar();
  while (!isdigit(ch)) {
    if (ch == '-') w = -1;
    ch = getchar();
  }
  while (isdigit(ch)) {
    s = s * 10 + ch - '0';
    ch = getchar();
  }
  return w * s;
}
struct node {
  int to, next, w;
} e[1000100];
struct data {
  long long a, b, c;
} Sub[200010], All[200010];
int n, h[1000100], tot, fa[100010][21], dep[100010], Q, dis[100010];
inline data operator-(data p, data q) {
  return (data){(p.a - q.a + mod) % mod, (p.b - q.b + mod) % mod,
                (p.c - q.c + mod) % mod};
}
inline void add(int from, int to, int w) {
  e[++tot].next = h[from];
  h[from] = tot;
  e[tot].to = to;
  e[tot].w = w;
}
inline data Merge(data p, data q, long long d) {
  data res;
  res.a = (p.a + q.a) % mod;
  res.b = (p.b + q.b + q.a * d) % mod;
  res.c = (p.c + q.c + d * d % mod * q.a % mod + q.b * d % mod * 2 % mod) % mod;
  return res;
}
inline void DFS1(int now, int ffa) {
  Sub[now].a = 1;
  fa[now][0] = ffa;
  dep[now] = dep[ffa] + 1;
  for (register int i = h[now]; i; i = e[i].next) {
    int to = e[i].to;
    if (to == ffa) continue;
    dis[to] = (dis[now] + e[i].w) % mod;
    DFS1(to, now);
    Sub[now] = Merge(Sub[now], Sub[to], e[i].w);
  }
}
inline void DFS2(int now, int ffa) {
  for (register int i = h[now]; i; i = e[i].next) {
    int to = e[i].to;
    if (to == ffa) continue;
    All[to].a = n;
    All[to].b = (Sub[to].b + e[i].w * (n - Sub[to].a) % mod +
                 (All[now].b - Sub[to].b - Sub[to].a * e[i].w % mod)) %
                mod;
    if (All[to].b < 0) All[to].b += mod;
    long long tmp1 = All[now].c - Sub[to].c -
                     1ll * e[i].w * e[i].w % mod * Sub[to].a % mod -
                     2ll * e[i].w * Sub[to].b % mod;
    tmp1 %= mod;
    tmp1 += mod;
    tmp1 %= mod;
    long long tmp2 = (All[now].b - Sub[to].b - Sub[to].a * e[i].w % mod);
    tmp2 %= mod;
    tmp2 += mod;
    tmp2 %= mod;
    All[to].c =
        (Sub[to].c + 1ll * e[i].w * e[i].w % mod * (n - Sub[to].a) % mod +
         tmp1 + 2ll * tmp2 * e[i].w % mod) %
        mod;
    DFS2(to, now);
  }
}
inline void Init() {
  for (register int i = 1; i <= 19; ++i)
    for (register int j = 1; j <= n; ++j) fa[j][i] = fa[fa[j][i - 1]][i - 1];
}
inline int lca(int u, int v) {
  if (dep[u] < dep[v]) swap(u, v);
  for (register int i = 19; i >= 0; --i)
    if (dep[fa[u][i]] >= dep[v]) u = fa[u][i];
  if (u == v) return u;
  for (register int i = 19; i >= 0; --i)
    if (fa[u][i] != fa[v][i]) u = fa[u][i], v = fa[v][i];
  return fa[u][0];
}
inline int getdis(int u, int v) {
  int L = lca(u, v);
  long long tmp = (long long)dis[u] + dis[v] - 2ll * dis[L];
  tmp %= mod;
  tmp += mod;
  tmp %= mod;
  return tmp;
}
inline int Query(int u, int v) {
  int L = lca(u, v);
  if (L != v) {
    long long d = getdis(u, v);
    long long tmp1 =
        (Sub[v].c + d * d % mod * Sub[v].a % mod + 2ll * Sub[v].b * d % mod) %
        mod;
    long long tmp2 = (All[u].c - tmp1 + mod) % mod;
    return (tmp1 - tmp2 + mod) % mod;
  } else {
    long long d = getdis(u, v);
    data t = All[v] - Sub[v];
    long long tmp2 =
        (t.c + d * d % mod * t.a % mod + 2ll * t.b * d % mod) % mod;
    long long tmp1 = (All[u].c - tmp2 + mod) % mod;
    return (tmp1 - tmp2 + mod) % mod;
  }
}
int main() {
  n = read();
  for (register int i = 1; i < n; ++i) {
    int u = read(), v = read(), w = read();
    add(u, v, w);
    add(v, u, w);
  }
  DFS1(1, 0);
  All[1] = Sub[1];
  DFS2(1, 0);
  Init();
  Q = read();
  for (register int i = 1; i <= Q; ++i) {
    int u = read(), v = read();
    cout << Query(u, v) << "\n";
  }
  return 0;
}
