#include <bits/stdc++.h>
using namespace std;
vector<int> edge[300005];
int vis[300005];
bool flag = false;
int cnt = 0;
void dfs(int u, int x, int y) {
  if (u == y) flag = true;
  if (u == x || vis[u]) return;
  vis[u] = 1;
  cnt++;
  for (int v : edge[u])
    if (!vis[v] && v != x) dfs(v, x, y);
}
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    int n, m, x, y;
    scanf("%d %d %d %d", &n, &m, &x, &y);
    for (int i = 1; i <= n; i++) edge[i].clear();
    for (int i = 0; i < m; i++) {
      int u, v;
      scanf("%d %d", &u, &v);
      edge[u].push_back(v);
      edge[v].push_back(u);
    }
    int first, second;
    for (int i = 1; i <= n; i++) vis[i] = 0;
    for (int i = 1; i <= n; i++) {
      if (vis[i]) continue;
      cnt = 0;
      flag = false;
      dfs(i, x, y);
      if (flag) {
        first = n - cnt - 1;
        break;
      }
    }
    for (int i = 1; i <= n; i++) vis[i] = 0;
    for (int i = 1; i <= n; i++) {
      if (vis[i]) continue;
      cnt = 0;
      flag = false;
      dfs(i, y, x);
      if (flag) {
        second = n - cnt - 1;
        break;
      }
    }
    printf("%lld\n", 1ll * first * second);
  }
}
