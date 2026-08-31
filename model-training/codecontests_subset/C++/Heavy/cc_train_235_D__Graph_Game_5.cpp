#include <bits/stdc++.h>
using namespace std;
const int N = 3005;
vector<int> to[N];
int f[N][15], st[N], top, cir[N], dep[N], col[N], n, cnt, siz, vis[N], oncir[N];
void add(int a, int b) {
  to[a].push_back(b);
  to[b].push_back(a);
}
int find(int now, int fa) {
  if (vis[now]) {
    int v;
    do {
      v = st[top--];
      cir[++siz] = v;
      oncir[v] = 1;
    } while (v != now);
    return 1;
  }
  vis[st[++top] = now] = 1;
  for (auto v : to[now])
    if (v != fa && find(v, now)) return 1;
  vis[st[top--]] = 0;
  return 0;
}
void dfs(int now, int fa, int se) {
  col[now] = se;
  f[now][0] = fa;
  dep[now] = dep[fa] + 1;
  for (auto v : to[now])
    if (v != fa && !oncir[v]) dfs(v, now, se);
}
int lca(int x, int y) {
  if (dep[x] < dep[y]) swap(x, y);
  for (int i = 14; i >= 0; i--)
    if (dep[f[x][i]] >= dep[y]) x = f[x][i];
  if (x == y) return x;
  for (int i = 14; i >= 0; i--)
    if (f[x][i] != f[y][i]) x = f[x][i], y = f[y][i];
  return f[x][0];
}
int dis(int x, int y) { return dep[x] + dep[y] - 2 * dep[lca(x, y)] + 1; }
int main() {
  scanf("%d", &n);
  for (int i = 1, x, y; i <= n; i++) {
    scanf("%d%d", &x, &y);
    add(x + 1, y + 1);
  }
  find(1, 0);
  for (int i = 1; i <= siz; i++) dfs(cir[i], 0, i);
  for (int i = 1; (1 << i) <= n; i++)
    for (int j = 1; j <= n; j++) f[j][i] = f[f[j][i - 1]][i - 1];
  double ans = 0;
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++) {
      if (col[i] == col[j])
        ans += 1.0 / dis(i, j);
      else {
        int x = dep[i] + dep[j];
        int y = abs(col[i] - col[j]) - 1;
        int z = siz - 2 - y;
        ans += 1.0 / (x + y) + 1.0 / (x + z) - 1.0 / (x + y + z);
      }
    }
  printf("%.10lf\n", ans);
  return 0;
}
