#include <bits/stdc++.h>
using namespace std;
const int inf = 1e9;
const long long Inf = 1e10;
const int N = 100005;
const int P = 1000000007;
int IN() {
  int x = 0;
  int f = 0, ch = 0;
  for ((ch = getchar()); ch < 48 || ch > 57; (ch = getchar())) f = (ch == '-');
  for (; ch >= 48 && ch <= 57; (ch = getchar()))
    x = (x << 1) + (x << 3) + ch - 48;
  return f ? (-x) : x;
}
int Pow(int x, int y, int p) {
  int A = 1;
  for (; y; y >>= 1, x = (long long)x * x % p)
    if (y & 1) A = (long long)A * x % p;
  return A;
}
int n, F[N], eu, ev, dep[N], B[N];
struct edge {
  int v, pre;
} e[N];
int dex, adj[N];
int sz;
int get(int x) {
  if (F[x] == x) return x;
  return F[x] = get(F[x]);
}
int fa[20][3005];
void DFS2(int x, int f) {
  for (int i = adj[x]; i; i = e[i].pre) {
    int v = e[i].v;
    if (B[v] == v) continue;
    if (v == f) continue;
    B[v] = B[x];
    dep[v] = dep[x] + 1;
    fa[0][v] = x;
    for (int i = (int)1; i <= (int)16; i++) fa[i][v] = fa[i - 1][fa[i - 1][v]];
    DFS2(v, x);
  }
}
int lab[N], Q[N], r, vis[N], Pre[N], tot;
void BFS(int x) {
  memset(vis, 0, sizeof vis);
  vis[Q[r = 1] = x] = 1;
  for (int i = (int)1; i <= (int)r; i++) {
    int u = Q[i];
    for (int i = adj[u]; i; i = e[i].pre) {
      int v = e[i].v;
      if (vis[v]) continue;
      Pre[v] = u;
      if (!vis[v]) vis[Q[++r] = v] = 1;
    }
  }
  for (int i = ev; i; i = Pre[i]) {
    B[i] = i;
    lab[i] = ++tot;
  }
}
int lca(int x, int y) {
  if (dep[x] < dep[y]) swap(x, y);
  for (int i = 11; i >= 0; i--)
    if (dep[fa[i][x]] >= dep[y]) x = fa[i][x];
  for (int i = 11; i >= 0; i--)
    if (fa[i][x] ^ fa[i][y]) x = fa[i][x], y = fa[i][y];
  return (x == y) ? (x) : (fa[0][x]);
}
int main() {
  scanf("%d", &n);
  for (int i = (int)1; i <= (int)n; i++) F[i] = i;
  for (int i = (int)1; i <= (int)n; i++) {
    int u = IN() + 1, v = IN() + 1;
    int ux = get(u), vx = get(v);
    if (ux == vx) {
      eu = u, ev = v;
      continue;
    }
    e[++dex] = (edge){v, adj[u]};
    adj[u] = dex;
    e[++dex] = (edge){u, adj[v]};
    adj[v] = dex;
    F[ux] = vx;
  }
  BFS(eu);
  memset(dep, 0, sizeof dep);
  for (int i = (int)1; i <= (int)n; i++)
    if (B[i] == i) {
      dep[i] = 1;
      DFS2(i, 0);
    }
  double ans = 0;
  for (int i = (int)1; i <= (int)n; i++)
    for (int j = (int)1; j <= (int)n; j++) {
      if (B[i] == B[j]) {
        ans += 1. / (dep[i] + dep[j] - 2 * dep[lca(i, j)] + 1);
      } else {
        int X = lab[B[i]], Y = lab[B[j]];
        int u = dep[i] - 1, v = dep[j] - 1;
        if (X < Y) swap(X, Y);
        ans += 1. / (u + v + X - Y + 1);
        ans += 1. / (u + v + Y + tot - X + 1);
        ans -= 1. / (u + v + tot);
      }
    }
  printf("%.10f\n", ans);
  return 0;
}
