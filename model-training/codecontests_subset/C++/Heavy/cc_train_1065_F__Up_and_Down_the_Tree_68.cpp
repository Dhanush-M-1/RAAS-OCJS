#include <bits/stdc++.h>
using namespace std;
const int maxn = 1002000;
int n, k, fa[maxn];
vector<int> g[maxn];
int dep[maxn], minn[maxn];
int f[maxn], d[maxn];
void read() {
  scanf("%d%d", &n, &k);
  for (int i = 2; i <= n; i++) {
    scanf("%d", &fa[i]);
    g[fa[i]].push_back(i);
  }
}
void dfs(int now, int dp) {
  dep[now] = dp;
  if (g[now].size() == 0) {
    minn[now] = dp;
    return;
  }
  minn[now] = 1e8;
  for (int i = 0; i < g[now].size(); i++) {
    dfs(g[now][i], dp + 1);
    minn[now] = min(minn[now], minn[g[now][i]]);
  }
}
void dfs2(int now) {
  if (g[now].size() == 0) {
    f[now] = d[now] = 1;
    return;
  }
  for (int i = 0; i < g[now].size(); i++) dfs2(g[now][i]);
  for (int i = 0; i < g[now].size(); i++)
    if (minn[g[now][i]] - dep[now] <= k) d[now] += d[g[now][i]];
  for (int i = 0; i < g[now].size(); i++) {
    if (minn[g[now][i]] - dep[now] <= k)
      f[now] = max(f[now], d[now] - d[g[now][i]] + f[g[now][i]]);
    else
      f[now] = max(f[now], d[now] + f[g[now][i]]);
  }
}
void work() {
  dfs(1, 1);
  dfs2(1);
  printf("%d\n", f[1]);
}
int main() {
  read();
  work();
  return 0;
}
