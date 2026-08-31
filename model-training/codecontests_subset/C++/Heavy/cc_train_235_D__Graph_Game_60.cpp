#include <bits/stdc++.h>
using namespace std;
const int N = 3010;
vector<int> e[N];
double ans = 0;
int n, h, t, rt, tot, d[N], vis[N], q[N];
void dfs(int u, int a, int b) {
  if (d[u] == 2)
    ++b;
  else
    ++a;
  vis[u] = rt;
  if (b == tot)
    ans += 1.0 / (a + 2);
  else if (b <= 2)
    ans += 1.0 / (a + b);
  else
    ans += 1.0 / (a + b) + 1.0 / (a + tot - b + 2) - 1.0 / (a + tot);
  for (auto v : e[u])
    if (vis[v] ^ rt) dfs(v, a, b);
}
int main() {
  scanf("%d", &n), h = 1;
  for (int i = 1, x, y; i <= n; i++)
    scanf("%d%d", &x, &y), ++x, ++y, e[x].push_back(y), e[y].push_back(x),
        ++d[x], ++d[y];
  for (int i = 1; i <= n; i++)
    if (d[i] == 1) q[++t] = i;
  for (int x; h <= t;) {
    x = q[h++];
    for (auto v : e[x]) {
      --d[v];
      if (d[v] == 1) q[++t] = v;
    }
  }
  for (int i = 1; i <= n; i++)
    if (d[i] == 2) ++tot;
  for (int i = 1; i <= n; i++) rt = i, dfs(rt, 0, 0);
  printf("%0.10lf\n", ans);
  return 0;
}
