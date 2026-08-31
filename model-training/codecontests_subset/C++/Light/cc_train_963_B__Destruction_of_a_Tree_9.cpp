#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 10;
vector<int> g[N];
int du[N], fa[N];
bool vis[N];
queue<int> q;
void dfs(int r, int f) {
  fa[r] = f;
  for (int i = 0; i < g[r].size(); i++) {
    int v = g[r][i];
    if (v != f) dfs(v, r);
  }
  q.push(r);
}
vector<int> ans;
void del(int x) {
  vis[x] = true;
  ans.push_back(x);
  for (int i = 0; i < g[x].size(); i++) {
    int v = g[x][i];
    if (!vis[v] && fa[x] != v) del(v);
  }
}
int main() {
  int n;
  scanf("%d", &n);
  int x;
  memset(du, 0, sizeof(du));
  memset(vis, false, sizeof(vis));
  for (int i = 1; i <= n; i++) {
    scanf("%d", &x);
    if (x == 0) continue;
    du[x] += 1;
    du[i] += 1;
    g[i].push_back(x);
    g[x].push_back(i);
  }
  dfs(1, -1);
  while (!q.empty()) {
    int x = q.front();
    q.pop();
    if (du[x] % 2 == 0) {
      del(x);
      du[fa[x]] -= 1;
    }
  }
  if (ans.size() != n)
    printf("NO\n");
  else {
    printf("YES\n");
    for (int i = 0; i < n; i++) printf("%d\n", ans[i]);
  }
  return 0;
}
