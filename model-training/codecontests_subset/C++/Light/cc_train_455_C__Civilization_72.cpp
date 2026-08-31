#include <bits/stdc++.h>
int p[300005], far, dist, d[300005];
std::vector<int> G[300005];
void dfs(int v, int fat, int c, int d = 0) {
  p[v] = c;
  if (d > dist) dist = d, far = v;
  for (int x : G[v])
    if (x != fat) dfs(x, v, c, d + 1);
}
int f(int a) { return p[a] == a ? a : p[a] = f(p[a]); }
void me(int a, int b) {
  int x = f(a), y = f(b);
  p[x] = y;
  d[y] = std::max({d[y], d[x], (d[y] + 1) / 2 + (d[x] + 1) / 2 + 1});
}
int main() {
  int n, m, q, a, b;
  scanf("%d%d%d", &n, &m, &q);
  while (m--) {
    scanf("%d%d", &a, &b);
    G[a].push_back(b);
    G[b].push_back(a);
  }
  for (int i = 1; i <= n; i++)
    if (!p[i]) {
      dist = -1;
      dfs(i, i, i);
      dist = -1;
      dfs(far, far, i);
      d[i] = dist;
    }
  while (q--) {
    scanf("%d%d", &m, &a);
    if (m == 1)
      printf("%d\n", d[f(a)]);
    else {
      scanf("%d", &b);
      if (f(a) != f(b)) me(a, b);
    }
  }
  return 0;
}
