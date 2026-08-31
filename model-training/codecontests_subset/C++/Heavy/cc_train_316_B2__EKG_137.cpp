#include <bits/stdc++.h>
using namespace std;
int fa[100005], vis[100005], valid[100005];
vector<int> v[100005];
int res[100005], dis[100005], nex[1000005];
int dfs(int cur, int d) {
  dis[cur] = d;
  vis[cur] = 1;
  if (v[cur].size()) return dfs(v[cur][0], d + 1);
  return d;
}
int main() {
  int n, x, k;
  scanf("%d%d", &n, &k);
  vector<int> di;
  int i;
  for (i = 1; i <= n; i++) scanf("%d", &fa[i]);
  for (i = 1; i <= n; i++) {
    if (fa[i])
      v[fa[i]].push_back(i);
    else
      valid[i] = 1;
  }
  int pr = 0;
  for (i = 1; i <= n; i++) {
    if (valid[i]) {
      int l = dfs(i, 1);
      if (pr == 0 && vis[k] == 1)
        res[dis[k]] = 1;
      else
        di.push_back(l);
      pr += vis[k];
    }
  }
  int j;
  for (i = 0; i < di.size(); i++) {
    for (j = 1; j <= n; j++)
      if (res[j] == 1) nex[j + di[i]] = 1;
    for (j = 1; j <= n; j++)
      if (nex[j] == 1) res[j] = 1;
  }
  for (i = 1; i <= n; i++)
    if (res[i]) printf("%d\n", i);
}
