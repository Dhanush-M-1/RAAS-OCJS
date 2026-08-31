#include <bits/stdc++.h>
using namespace std;
struct node {
  long long t, d, g, h, s, ds, dq, dis, sum;
} A[100100];
int p[100100], nxt[2 * 100100], C[2 * 100100], V[2 * 100100], f[100100],
    g[100100][19], n, q, i, ed;
int gi() {
  int s = 0;
  char c = getchar();
  while (c < '0' || c > '9') c = getchar();
  while (c >= '0' && c <= '9') s = s * 10 + c - '0', c = getchar();
  return s;
}
void Add(int u, int v, int c) {
  V[++ed] = v, C[ed] = c, nxt[ed] = p[u], p[u] = ed;
}
long long sqr(long long x) { return (x * x) % 1000000007; };
long long Mul(long long x, long long y) {
  return ((x % 1000000007) * y) % 1000000007;
}
void Dfs(int x, int fa) {
  f[x] = fa, A[x].s = 1, A[x].t = A[f[x]].t + 1;
  for (int i = p[x]; i != -1; i = nxt[i]) {
    int v = V[i];
    if (v == fa) continue;
    A[v].d = (A[x].d + C[i]) % 1000000007;
    A[v].g = (A[x].g + A[v].d) % 1000000007;
    A[v].h = (A[x].h + sqr(A[v].d)) % 1000000007;
    Dfs(v, x);
    A[x].s = (A[x].s + A[v].s) % 1000000007;
    A[x].ds = (A[x].ds + A[v].ds + A[v].s * C[i]) % 1000000007;
    A[x].dq = (A[x].dq + A[v].dq + Mul(A[v].s, sqr(C[i])) +
               2LL * Mul(A[v].ds, C[i])) %
              1000000007;
  }
}
void Calc(int x, long long c) {
  A[x].dis = (A[f[x]].dis - Mul(A[x].s, c) + Mul((n - A[x].s), c)) % 1000000007;
  A[x].sum = (A[f[x]].sum + Mul(n, sqr(c))) % 1000000007;
  A[x].sum = (A[x].sum - 2LL * Mul(A[x].ds + Mul(A[x].s, c), c)) % 1000000007;
  A[x].sum =
      (A[x].sum + 2LL * Mul(A[x].dis - A[x].ds - Mul(n - A[x].s, c), c)) %
      1000000007;
  for (int i = p[x]; i != -1; i = nxt[i])
    if (V[i] != f[x]) Calc(V[i], C[i]);
}
int Lca(int u, int v) {
  if (A[u].t < A[v].t) swap(u, v);
  for (int i = 18; i >= 0; i--)
    if (A[g[u][i]].t >= A[v].t) u = g[u][i];
  if (u == v) return u;
  for (int i = 18; i >= 0; i--)
    if (g[u][i] != g[v][i]) u = g[u][i], v = g[v][i];
  return f[u];
}
int find(int u) {
  for (int i = 18; i >= 0; i--)
    if (A[g[u][i]].t >= 2) u = g[u][i];
  return u;
}
int main() {
  memset(p, -1, sizeof(p));
  scanf("%d", &n);
  for (i = 1; i < n; i++) {
    int u = gi(), v = gi(), c = gi();
    Add(u, v, c), Add(v, u, c);
  }
  Dfs(1, 0);
  for (i = 1; i <= n; i++) g[i][0] = f[i];
  for (i = 1; i <= 17; i++)
    for (int j = 1; j <= n; j++) g[j][i] = g[g[j][i - 1]][i - 1];
  for (i = 1; i <= n; i++) A[1].sum += sqr(A[i].d), A[1].dis += A[i].d;
  A[1].sum %= 1000000007, A[1].dis %= 1000000007;
  for (i = p[1]; i != -1; i = nxt[i]) Calc(V[i], C[i]);
  scanf("%d", &q);
  for (i = 1; i <= q; i++) {
    int u = gi(), v = gi();
    int z = Lca(u, v);
    long long ans, o, h, b;
    if (z == v && u != v) {
      o = (A[v].d - A[f[v]].d) % 1000000007;
      b = (A[u].d - A[f[v]].d) % 1000000007;
      h = (A[f[v]].dis - A[v].ds - Mul(o, A[v].s)) % 1000000007;
      ans = (A[f[v]].sum - A[v].dq - Mul(A[v].s, sqr(o)) -
             2LL * Mul(A[v].ds, o)) %
            1000000007;
      ans = (ans + Mul(n - A[v].s, sqr(b)) + 2LL * Mul(h, b)) % 1000000007;
      ans = (A[u].sum - 2 * ans) % 1000000007;
      if (v == 1) ans = A[u].sum;
    } else {
      long long det = (A[u].d + A[v].d - 2LL * A[z].d) % 1000000007;
      ans = (A[v].dq + Mul(A[v].s, sqr(det))) % 1000000007;
      o = (2LL * Mul(A[v].ds, det)) % 1000000007;
      ans = (2LL * (ans + o) - A[u].sum) % 1000000007;
    }
    printf("%I64d\n", (1000000007 + ans) % 1000000007);
  }
}
