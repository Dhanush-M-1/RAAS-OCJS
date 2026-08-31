#include <bits/stdc++.h>
using namespace std;
vector<int> node[200005], ans;
int cnt;
int n, p, rt;
bool vis[200005];
void dfshelper(int x) {
  if (vis[x]) return;
  vis[x] = true;
  ans.push_back(x);
  for (int i = 0; i < node[x].size(); i++) dfshelper(node[x][i]);
}
void dfs(int x) {
  int deg = 0;
  if (x != rt) deg++;
  for (int i = 0; i < node[x].size(); i++) {
    dfs(node[x][i]);
    if (!vis[node[x][i]]) deg++;
  }
  if (deg % 2 == 0) dfshelper(x);
}
int main() {
  scanf("%d", &n);
  memset(vis, 0, sizeof(vis));
  cnt = 0;
  for (int i = 1; i <= n; i++) {
    scanf("%d", &p);
    if (p != 0) cnt++;
    node[p].push_back(i);
    if (p == 0) rt = i;
  }
  if (cnt % 2) {
    printf("NO\n");
    return 0;
  }
  dfs(rt);
  puts("YES");
  for (int i = 0; i < ans.size(); i++) printf("%d\n", ans[i]);
  return 0;
}
