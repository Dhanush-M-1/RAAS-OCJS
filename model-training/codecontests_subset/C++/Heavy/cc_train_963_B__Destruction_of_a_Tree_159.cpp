#include <bits/stdc++.h>
using namespace std;
const int N = 200001;
const long long MOD = 1e9 + 7;
int n, root, sz[N];
vector<vector<int> > g;
vector<int> ans;
void dfs1(int u, int p) {
  sz[u] = 1;
  for (int i = 0; i < g[u].size(); i++)
    if (g[u][i] != p) {
      dfs1(g[u][i], u);
      sz[u] += sz[g[u][i]];
    }
}
void dfs2(int u, int p) {
  for (int i = 0; i < g[u].size(); i++)
    if (g[u][i] != p && !(sz[g[u][i]] & 1)) dfs2(g[u][i], u);
  ans.push_back(u);
  for (int i = 0; i < g[u].size(); i++)
    if (g[u][i] != p && (sz[g[u][i]] & 1)) dfs2(g[u][i], u);
}
int main() {
  scanf("%d", &n);
  g.resize(n);
  for (int a = 0, b; a < n; a++) {
    scanf("%d", &b);
    b--;
    if (b != -1) {
      g[a].push_back(b);
      g[b].push_back(a);
    } else
      root = a;
  }
  if (n % 2 == 0) {
    puts("NO");
    return 0;
  }
  dfs1(root, -1);
  dfs2(root, -1);
  puts("YES");
  for (int i = 0; i < ans.size(); i++) printf("%d\n", ans[i] + 1);
  return 0;
}
