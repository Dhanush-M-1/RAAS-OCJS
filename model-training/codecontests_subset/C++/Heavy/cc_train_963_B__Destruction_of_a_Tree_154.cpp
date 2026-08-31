#include <bits/stdc++.h>
using namespace std;
vector<int> adj[1000000], ans;
int n, u, v;
int vis[1000000], par[1000000];
void take(int cur) {
  ans.push_back(cur);
  vis[cur] = 1;
  for (int i = 0; i < adj[cur].size(); ++i)
    if (!vis[adj[cur][i]]) take(adj[cur][i]);
}
void dfs(int cur) {
  int deg = 0;
  for (int i = 0; i < adj[cur].size(); ++i) {
    dfs(adj[cur][i]);
    if (!vis[adj[cur][i]]) deg++;
  }
  if (par[cur]) deg++;
  if (!(deg & 1) && cur) take(cur);
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &par[i]);
    adj[par[i]].push_back(i);
  }
  dfs(0);
  if (ans.size() < n)
    printf("NO\n");
  else {
    printf("YES\n");
    for (int i = 0; i < ans.size(); ++i) printf("%d\n", ans[i]);
  }
  return 0;
}
