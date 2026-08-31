#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 2;
vector<int> t[N];
int fa[N], sz[N];
void dfs1(int u) {
  sz[u] = 1;
  for (auto v : t[u]) {
    dfs1(v);
    sz[u] += sz[v];
  }
}
void dfs(int u) {
  for (auto v : t[u])
    if (sz[v] % 2 == 0) dfs(v);
  printf("%d\n", u);
  for (auto v : t[u])
    if (sz[v] & 1) dfs(v);
}
int main() {
  int n, root = -1;
  scanf("%d", &n);
  if (n % 2 == 0) return puts("NO"), 0;
  puts("YES");
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &fa[i]);
    if (fa[i])
      t[fa[i]].push_back(i);
    else
      root = i;
  }
  dfs1(root);
  dfs(root);
  return 0;
}
