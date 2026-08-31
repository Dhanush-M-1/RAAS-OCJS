#include <bits/stdc++.h>
using namespace std;
int n, x, y, mx, idx;
int deg[100010];
vector<int> edge[100010];
bool vis[100010];
bool can = true;
void dfs(int u) {
  vis[u] = true;
  int sz_u = (int)edge[u].size();
  if (u != idx && sz_u == 2) {
    can = false;
    return;
  }
  for (int i = 0; i < sz_u && can; ++i) {
    if (!vis[edge[u][i]]) dfs(edge[u][i]);
  }
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i < n; ++i) {
    scanf("%d%d", &x, &y);
    edge[x].push_back(y);
    edge[y].push_back(x);
    deg[x]++;
    deg[y]++;
    if (deg[x] > deg[idx]) {
      idx = x;
    }
    if (deg[y] > deg[idx]) {
      idx = y;
    }
  }
  if (n == 2) {
    puts("YES");
  } else if (n == 3) {
    puts("NO");
  } else {
    dfs(idx);
    can ? puts("YES") : puts("NO");
  }
  return 0;
}
