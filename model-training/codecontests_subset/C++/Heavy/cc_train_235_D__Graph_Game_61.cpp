#include <bits/stdc++.h>
using namespace std;
const int N = 3005, mod = 1e9 + 7;
inline int read() {
  int s = 0;
  char ch = getchar();
  while (!isdigit(ch)) ch = getchar();
  while (isdigit(ch)) s = s * 10 + ch - '0', ch = getchar();
  return s;
}
inline long long qpow(long long a, long long b) {
  long long res = 1;
  for (; b; b >>= 1, a = a * a % mod)
    if (b & 1) res = res * a % mod;
  return res;
}
inline void add(int &x, int y) {
  x += y;
  if (x >= mod) x -= mod;
}
inline void dec(int &x, int y) {
  x -= y;
  if (x < 0) x += mod;
}
int n;
vector<int> G[N], cir;
int dep[N];
int inv[N], fa[N], tag[N], col[N];
int vis[N], f[N][12];
bool flag = 0;
void init(int n) {
  for (int i = 1; i <= n; i++) inv[i] = qpow(i, mod - 2);
}
inline void find_cir(int u, int f) {
  if (flag) return;
  fa[u] = f;
  vis[u] = 1;
  for (int v : G[u]) {
    if (v == f) continue;
    if (flag) return;
    if (vis[v]) {
      while (u != v) cir.push_back(u), u = fa[u];
      cir.push_back(v);
      flag = 1;
      return;
    } else
      find_cir(v, u);
  }
}
void dfs(int u, int fa, int c) {
  f[u][0] = fa;
  for (int i = 1; i <= 11; i++) f[u][i] = f[f[u][i - 1]][i - 1];
  col[u] = c;
  dep[u] = dep[fa] + 1;
  for (int v : G[u]) {
    if (v == fa || tag[v]) continue;
    dfs(v, u, c);
  }
}
inline int LCA(int u, int v) {
  if (dep[u] < dep[v]) swap(u, v);
  for (int i = 11; i >= 0; i--)
    if ((dep[u] - dep[v]) >> i & 1) u = f[u][i];
  if (u == v) return u;
  for (int i = 11; i >= 0; i--)
    if (f[u][i] != f[v][i]) u = f[u][i], v = f[v][i];
  return f[u][0];
}
inline int dis(int u, int v) {
  return dep[u] + dep[v] - 2 * dep[LCA(u, v)] + 1;
}
int main() {
  init(3000);
  n = read();
  for (int i = 1; i <= n; i++) {
    int u = read(), v = read();
    u++, v++;
    G[u].push_back(v);
    G[v].push_back(u);
  }
  find_cir(1, 0);
  for (int u : cir) tag[u] = 1;
  for (int i = 0; i < (int)cir.size(); i++) dfs(cir[i], 0, i);
  double ans = 0;
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++) {
      if (col[i] == col[j])
        ans += 1.0 / dis(i, j);
      else {
        int x = dep[i] + dep[j], l = abs(col[i] - col[j]) - 1,
            r = (int)cir.size() - l - 2;
        ans += 1.0 / (x + l) + 1.0 / (x + r) - 1.0 / (x + l + r);
      }
    }
  printf("%.10lf", ans);
  return 0;
}
