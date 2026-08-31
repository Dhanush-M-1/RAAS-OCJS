#include <bits/stdc++.h>
using namespace std;
const int maxn = 2 * (int)(1e5) + 10;
const int inf = 0x3f3f3f3f;
const int mod = (int)1e9 + 9;
const double eps = 1e-6;
vector<int> edge[maxn * 2];
int sz[maxn];
void dfs1(int u) {
  sz[u] = 1;
  for (int i = 0; i < edge[u].size(); i++) {
    int v = edge[u][i];
    dfs1(v);
    sz[u] += sz[v];
  }
}
void dfs2(int u) {
  for (int i = 0; i < edge[u].size(); i++) {
    int v = edge[u][i];
    if (sz[v] % 2 == 0) dfs2(v);
  }
  printf("%d\n", u);
  for (int i = 0; i < edge[u].size(); i++) {
    int v = edge[u][i];
    if (sz[v] % 2) dfs2(v);
  }
}
int main() {
  int n;
  while (~scanf("%d", &n)) {
    for (int i = 1; i <= n; i++) edge[i].clear();
    int root, v;
    for (int u = 1; u <= n; u++) {
      scanf("%d", &v);
      if (!v) root = u;
      edge[v].push_back(u);
    }
    if (n % 2 == 0) {
      printf("NO\n");
      continue;
    } else {
      memset(sz, 0, sizeof(sz));
      printf("YES\n");
      dfs1(root);
      dfs2(root);
    }
  }
  return 0;
}
