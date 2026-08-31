#include <bits/stdc++.h>
using namespace std;
int level[200005];
int h[200005];
int val[200005];
bool vis[200005];
bool num[200005];
vector<int> E[200005];
void dfs(int x) {
  if (vis[x]) return;
  vis[x] = true;
  if (E[x].size() == 0) level[x] = 0;
  int sz = E[x].size();
  for (int v : E[x]) {
    if (!vis[v]) {
      dfs(v);
    }
  }
  for (int i = 0; i <= sz + 1; i++) num[i] = true;
  for (int v : E[x]) num[level[v]] = false;
  for (int i = 0; i <= sz + 1; i++) {
    if (num[i]) {
      level[x] = i;
      return;
    }
  }
}
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", &h[i]);
  for (int i = 1; i <= m; i++) {
    int u, v;
    scanf("%d%d", &u, &v);
    E[u].push_back(v);
  }
  for (int i = 1; i <= n; i++) level[i] = -1;
  for (int i = 1; i <= n; i++) vis[i] = false;
  for (int i = 1; i <= n; i++) {
    if (!vis[i]) dfs(i);
  }
  int mx = 0;
  for (int i = 0; i <= mx; i++) val[i] = 0;
  int choose = 0;
  for (int i = 1; i <= n; i++) {
    val[level[i]] ^= h[i];
  }
  for (int i = 1; i <= n; i++) {
    if (val[level[i]] != 0) mx = max(mx, level[i]);
  }
  bool flag = true;
  for (int i = 0; i <= mx; i++)
    if (val[i] != 0) flag = false;
  if (flag) {
    puts("LOSE");
    return 0;
  }
  for (int i = 1; i <= n; i++) {
    if (level[i] == mx) {
      if ((val[mx] ^ h[i]) < h[i]) {
        choose = i;
        break;
      }
    }
  }
  h[choose] = val[mx] ^ h[choose];
  for (int v : E[choose]) {
    int x = level[v];
    if (val[x] != 0) {
      h[v] = val[x] ^ h[v];
      val[x] = 0;
    }
  }
  puts("WIN");
  for (int i = 1; i <= n; i++) {
    printf("%d ", h[i]);
  }
  return 0;
}
