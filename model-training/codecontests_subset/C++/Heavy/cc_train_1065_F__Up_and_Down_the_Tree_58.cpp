#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 10;
int n;
int k;
int v[2 * N];
int x[2 * N];
int ct;
int al[N];
int dp[N][2];
int rk[N];
inline void add(int u, int V) {
  v[++ct] = V;
  x[ct] = al[u];
  al[u] = ct;
}
inline void dfs1(int u) {
  rk[u] = 0x3f3f3f3f;
  for (int i = al[u]; i; i = x[i]) dfs1(v[i]), rk[u] = min(rk[u], rk[v[i]]);
  rk[u] = (rk[u] == 0x3f3f3f3f) ? 0 : rk[u] + 1;
}
inline void dfs(int u) {
  int son = 0;
  int del = 0;
  for (int i = al[u]; i; i = x[i]) {
    son++;
    dfs(v[i]);
    if (rk[v[i]] >= k) {
      del = max(del, dp[v[i]][1]);
    } else
      del = max(del, dp[v[i]][1] - dp[v[i]][0]), dp[u][0] += dp[v[i]][0];
  }
  if (son == 0)
    dp[u][0] = dp[u][1] = 1;
  else
    dp[u][1] = dp[u][0] + del;
}
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 2, f; i <= n; i++) scanf("%d", &f), add(f, i);
  dfs1(1);
  dfs(1);
  printf("%d", dp[1][1]);
  return 0;
}
