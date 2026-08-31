#include <bits/stdc++.h>
using namespace std;
const int N = 200005;
int n, root, deg[N], fa[N], del[N];
vector<int> g[N], ans;
void dfs2(int x) {
  ans.push_back(x);
  del[x] = 1;
  for (int i = 0; i < g[x].size(); ++i) {
    int v = g[x][i];
    if (!del[v]) dfs2(v);
  }
}
void dfs(int x) {
  for (int i = 0; i < g[x].size(); ++i) {
    int v = g[x][i];
    dfs(v);
    if (!del[v]) deg[x] ^= 1;
  }
  if (fa[x]) deg[x] ^= 1;
  if (!deg[x]) dfs2(x);
}
int main() {
  int i, j;
  scanf("%d", &n);
  for (i = 1; i <= n; ++i) {
    scanf("%d", &fa[i]);
    if (!fa[i])
      root = i;
    else
      g[fa[i]].push_back(i);
    ;
  }
  dfs(root);
  if (ans.size() < n) {
    puts("NO");
  } else {
    puts("YES");
    for (i = 0; i < n; ++i) printf("%d\n", ans[i]);
  }
  return 0;
}
