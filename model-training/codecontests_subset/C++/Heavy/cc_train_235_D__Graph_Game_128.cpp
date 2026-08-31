#include <bits/stdc++.h>
using namespace std;
int N, lk[6005], nx[6005], head[3005], s[3005], d[3005], dfn[3005], tot, L,
    p[3005], q[3005], fa[3005], f[3005][3005];
bool b[3005];
void init() {
  scanf("%d", &N);
  auto add = [&](int u, int v, int t) {
    lk[t] = v, nx[t] = head[u], head[u] = t;
  };
  for (int i = 1, u, v; i <= N; i++)
    scanf("%d%d", &u, &v), add(++u, ++v, i), add(v, u, i + N);
}
void loop(int u) {
  dfn[u] = ++tot;
  for (int i = head[u], v; v = lk[i], i; i = nx[i])
    if (fa[u] != v && !dfn[v]) fa[v] = u, loop(v);
  for (int i = head[u], v; v = lk[i], i; i = nx[i])
    if (dfn[v] > dfn[u] && fa[v] != u) {
      for (int x = v; x != u; x = fa[x]) q[++L] = x, b[x] = 1;
      q[++L] = u, b[u] = 1;
    }
}
void dfs(int u) {
  for (int i = head[u], v; v = lk[i], i; i = nx[i])
    if (!b[v] && !d[v]) d[v] = d[u] + 1, p[v] = p[u], dfs(v);
}
void dfs(int u, int s) {
  for (int i = head[u], v; v = lk[i], i; i = nx[i])
    if (!f[s][v]) f[s][v] = f[s][u] + 1, dfs(v, s);
}
void doit() {
  loop(1);
  for (int i = 1; i <= L; i++)
    s[q[i]] = s[q[i - 1]] + 1, p[q[i]] = q[i], d[q[i]] = 1, dfs(q[i]);
  for (int i = 1; i <= N; i++) f[i][i] = 1, dfs(i, i);
  double ans = 0;
  for (int i = 1; i <= N; i++)
    for (int j = i + 1; j <= N; j++)
      if (p[i] == p[j])
        ans += 1.0 / f[i][j];
      else {
        int x = d[i] + d[j], y = s[p[i]] - s[p[j]] - 1, z = L - y - 2;
        if (y < 0) y += L, z -= L;
        ans += 1.0 / (x + y) + 1.0 / (x + z) - 1.0 / (x + y + z);
      }
  printf("%.9lf\n", ans * 2 + N);
}
int main() {
  init();
  doit();
  return 0;
}
