#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 1000;
int du[N];
int fa[N];
vector<int> g[N];
queue<int> q;
bool vis[N];
void del(int u) {
  if (vis[u]) return;
  q.push(u);
  vis[u] = 1;
  for (int i = 0; i < g[u].size(); ++i) {
    int v = g[u][i];
    if (vis[v]) continue;
    del(v);
  }
}
void dfs(int u) {
  for (int i = 0; i < g[u].size(); ++i) {
    dfs(g[u][i]);
  }
  if (du[u] % 2 == 0) {
    du[fa[u]]--;
    del(u);
  }
}
int main() {
  int n;
  scanf("%d", &n);
  int root;
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &fa[i]);
    g[fa[i]].push_back(i);
    if (fa[i] == 0) {
      root = i;
      continue;
    }
    du[fa[i]]++;
    du[i]++;
  }
  dfs(root);
  if (q.size() != n) {
    puts("NO");
    return 0;
  }
  puts("YES");
  while (!q.empty()) {
    int v = q.front();
    printf("%d\n", v);
    q.pop();
  }
  return 0;
}
