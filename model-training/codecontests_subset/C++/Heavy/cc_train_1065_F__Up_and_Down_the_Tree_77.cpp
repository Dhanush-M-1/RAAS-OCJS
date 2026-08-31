#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 100;
vector<int> E[N];
int cnt[2 * N] = {0}, c[N];
int k;
int ans[N], dis[N], dcnt[N];
int uu[N];
int dfs(int u, int dep) {
  int cc = cnt[dep + k + 1], sum = (u != 1 && c[u] == 1), mx = 0, mm = 0,
      sm = 0;
  if (u != 1 && c[u] == 1) cnt[dep]++;
  for (int v : E[u]) {
    sum += dfs(v, dep + 1);
    if (dis[v] > 0) {
      sm += dcnt[v] - uu[v];
      mx = max(mx, ans[v] - dcnt[v]);
    } else
      mx = max(mx, ans[v] - uu[v]);
    mm = max(mm, dis[v] - 1);
  }
  int cur = sum - (cnt[dep + k + 1] - cc);
  dis[u] = mm;
  dcnt[u] = sm + cur;
  ans[u] = mx + cur + sm;
  if (u != 1 && c[u] == 1) dis[u] = k;
  return cur;
}
int dfs2(int u, int dep) {
  int cc = cnt[dep + k], sum = (u != 1 && c[u] == 1);
  if (u != 1 && c[u] == 1) cnt[dep]++;
  for (int v : E[u]) {
    sum += dfs2(v, dep + 1);
  }
  int cur = sum - (cnt[dep + k] - cc);
  uu[u] = cur;
  return cur;
}
int main() {
  int n;
  scanf("%d%d", &n, &k);
  if (n == 1) {
    puts("1");
    return 0;
  }
  for (int i = 2; i <= n; i++) {
    int pa;
    scanf("%d", &pa);
    E[pa].push_back(i);
    c[pa]++;
    c[i]++;
  }
  dfs2(1, 0);
  memset(cnt, 0, sizeof cnt);
  dfs(1, 0);
  printf("%d\n", ans[1]);
  return 0;
}
