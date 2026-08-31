#include <bits/stdc++.h>
using namespace std;
vector<int> son[200050];
bool deleted[200500];
int seq[200050];
int dcnt, root;
void dfs2(int u) {
  if (deleted[u]) return;
  deleted[u] = 1;
  seq[++dcnt] = u;
  for (int i = 0; i < son[u].size(); ++i) dfs2(son[u][i]);
}
void dfs(int u) {
  int d = 0;
  if (u != root) d++;
  for (int i = 0; i < son[u].size(); ++i) {
    dfs(son[u][i]);
    if (!deleted[son[u][i]]) d++;
  }
  if (d % 2 == 0) dfs2(u);
  return;
}
int main() {
  int n, fa;
  scanf("%d", &n);
  for (int j = 1; j <= n; ++j) {
    scanf("%d", &fa);
    if (!fa)
      root = j;
    else
      son[fa].push_back(j);
  }
  dfs(root);
  if (dcnt != n)
    printf("NO\n");
  else {
    printf("YES\n");
    for (int i = 1; i <= dcnt; ++i) printf("%d\n", seq[i]);
  }
}
