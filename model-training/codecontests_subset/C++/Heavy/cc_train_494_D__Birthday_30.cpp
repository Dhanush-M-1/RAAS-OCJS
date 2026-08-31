#include <bits/stdc++.h>
using namespace std;
template <class T>
inline void R(T &xx) {
  xx = 0;
  char ch = getchar();
  bool F = 0;
  while ((ch < '0' || ch > '9') && ch != '-') ch = getchar();
  if (ch == '-') F = 1, ch = getchar();
  while (ch >= '0' && ch <= '9')
    xx = xx + xx + (xx << 3) + ch - 48, ch = getchar();
  if (F) xx = -xx;
}
template <class T>
inline void add(int &x, T y) {
  for (x += y; x >= 1000000007; x -= 1000000007)
    ;
}
long long A[200011], B[200011], C[200011], sum[200011], sum2[200011],
    dis[200011];
int f[200011][23], dep[200011], sz[200011], n;
vector<pair<int, int> > g[200011];
void dfs(int u, int fa) {
  f[u][0] = fa;
  sz[u] = 1;
  sum[u] = dis[u];
  sum2[u] = (long long)dis[u] * dis[u] % 1000000007;
  dep[u] = dep[fa] + 1;
  for (int i = 0; i < (int)((int)g[u].size()); i++)
    if (g[u][i].first != fa) {
      int v = g[u][i].first;
      dis[v] = (dis[u] + g[u][i].second) % 1000000007;
      dfs(v, u);
      sz[u] += sz[v];
      (sum[u] += sum[v]) %= 1000000007;
      (sum2[u] += sum2[v]) %= 1000000007;
    }
}
void dfs1(int u, int fa) {
  A[u] = 4ll * dis[fa] % 1000000007 * dis[fa] % 1000000007 * (sz[fa] - sz[u]) %
         1000000007;
  B[u] = 4ll * dis[fa] % 1000000007 * (sz[fa] - sz[u]) % 1000000007;
  C[u] = 4ll * dis[fa] % 1000000007 * (sum[fa] - sum[u]) % 1000000007;
  (A[u] += A[fa]) %= 1000000007;
  (B[u] += B[fa]) %= 1000000007;
  (C[u] += C[fa]) %= 1000000007;
  for (int i = 0; i < (int)((int)g[u].size()); i++)
    if (g[u][i].first != fa) dfs1(g[u][i].first, u);
}
int LCA(int x, int y) {
  if (dep[x] < dep[y]) swap(x, y);
  for (int j = 21 - 1; ~j; j--)
    if (dep[f[x][j]] >= dep[y]) x = f[x][j];
  if (x == y) return x;
  for (int j = 21 - 1; ~j; j--)
    if (f[x][j] != f[y][j]) x = f[x][j], y = f[y][j];
  return f[x][0];
}
long long cal(int x, int y) {
  long long ans =
      ((long long)dis[x] * dis[x] % 1000000007 * sz[y] % 1000000007 + sum2[y] +
       2ll * dis[x] * sum[y] % 1000000007) %
      1000000007;
  int lca = LCA(x, y);
  if (lca != y) {
    ans += 4ll * dis[lca] * dis[lca] % 1000000007 * sz[y] % 1000000007;
    ans -= 4ll * dis[lca] * dis[x] % 1000000007 * sz[y] % 1000000007;
    ans -= 4ll * dis[lca] * sum[y] % 1000000007;
  } else {
    ans += 4ll * dis[x] * dis[x] % 1000000007 * sz[x] % 1000000007;
    ans -= 4ll * dis[x] * dis[x] % 1000000007 * sz[x] % 1000000007;
    ans -= 4ll * dis[x] * sum[x] % 1000000007;
    ans += A[x] - A[y];
    ans -= (B[x] - B[y]) * dis[x] % 1000000007;
    ans -= C[x] - C[y];
  }
  return (ans % 1000000007 + 1000000007) % 1000000007;
}
int main() {
  int Q, x, y, z;
  R(n);
  for (int i = 1; i < n; i++)
    R(x), R(y), R(z), g[x].push_back(make_pair(y, z)),
        g[y].push_back(make_pair(x, z));
  dfs(1, 0);
  dfs1(1, 0);
  for (int j = 1; j < 21; j++)
    for (int i = 1; i <= n; i++) f[i][j] = f[f[i][j - 1]][j - 1];
  for (R(Q); Q--;) {
    R(x), R(y);
    printf("%I64d\n", (2ll * cal(x, y) - cal(x, 1) + 1000000007) % 1000000007);
  }
  return 0;
}
