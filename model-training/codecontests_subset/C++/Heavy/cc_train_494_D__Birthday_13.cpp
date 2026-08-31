#include <bits/stdc++.h>
using namespace std;
const int N = 200100;
const int P = 1000000007;
int H[N], to[N], len[N], nxt[N], e = 1;
void addedge(int t, int v, int s) {
  e++, to[e] = v, len[e] = s, nxt[e] = H[t], H[t] = e;
  e++, to[e] = t, len[e] = s, nxt[e] = H[v], H[v] = e;
}
struct A {
  long long size, val, ans;
};
A operator+(A x, A y) {
  return {x.size + y.size, (x.val + y.val) % P, (x.ans + y.ans) % P};
}
A operator-(A x, A y) {
  return {x.size - y.size, (x.val - y.val) % P, (x.ans - y.ans) % P};
}
A operator*(A x, long long mul) {
  return {x.size, (x.val + mul * x.size) % P,
          (x.ans + 2 * mul * x.val % P + mul * mul % P * x.size) % P};
}
A dp[N], up[N], down[N];
void Build(int u, int f) {
  for (int i = H[u], v = to[i]; i; i = nxt[i], v = to[i])
    if (v != f) {
      down[v] = (down[u] + dp[u] - up[v]) * len[i];
      Build(v, u);
    }
}
void init_(int u, int f) {
  dp[u] = {1, 0, 0};
  for (int i = H[u], v = to[i]; i; i = nxt[i], v = to[i])
    if (v != f) {
      init_(v, u);
      up[v] = dp[v] * len[i];
      dp[u] = dp[u] + up[v];
    }
}
long long dis[N];
int dep[N], fa[N][21];
void dfs(int u, int f) {
  fa[u][0] = f;
  dep[u] = dep[f] + 1;
  for (int i = 1; i <= 20; i++) fa[u][i] = fa[fa[u][i - 1]][i - 1];
  for (int i = H[u], v = to[i]; i; i = nxt[i], v = to[i])
    if (v != f) {
      dis[v] = dis[u] + len[i];
      dfs(v, u);
    }
}
int calc(int u, int v) {
  if (dep[u] < dep[v]) swap(u, v);
  for (int i = 20; i >= 0; i--)
    if (dep[fa[u][i]] >= dep[v]) u = fa[u][i];
  if (u == v) return u;
  for (int i = 20; i >= 0; i--)
    if (fa[u][i] != fa[v][i]) u = fa[u][i], v = fa[v][i];
  return fa[u][0];
}
int main() {
  int n;
  cin >> n;
  for (int i = 2; i <= n; i++) {
    int t, v, s;
    scanf("%d%d%d", &t, &v, &s);
    addedge(t, v, s);
  }
  dfs(1, 0);
  init_(1, 0);
  Build(1, 0);
  int m;
  cin >> m;
  while (m--) {
    int u, v;
    scanf("%d%d", &u, &v);
    int s = calc(u, v);
    long long dist = (dis[u] + dis[v] - dis[s] * 2) % P;
    if (s == v) {
      A add = dp[u] + down[u];
      A Dec = down[v] * dist;
      printf("%d\n", (int)((add.ans - 2 * Dec.ans) % P + P) % P);
    } else {
      A add = dp[v] * dist;
      A Dec = dp[u] + down[u];
      printf("%d\n", (int)((2 * add.ans - Dec.ans) % P + P) % P);
    }
  }
  return 0;
}
