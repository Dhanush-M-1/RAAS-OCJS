#include <bits/stdc++.h>
using namespace std;
int n, k, dep[2000010], mn[2000010], f[2000010][2];
vector<int> v[2000010];
void dfs(int p, int fa) {
  dep[p] = dep[fa] + 1;
  if (v[p].size() == 1 && p != 1)
    mn[p] = dep[p], f[p][0] = f[p][1] = 1;
  else
    mn[p] = 1e9;
  int t = 0;
  for (int i : v[p])
    if (i != fa)
      dfs(i, p), mn[p] = min(mn[p], mn[i]), f[p][1] += f[i][1], t += f[i][1];
  for (int i : v[p])
    if (i != fa) f[p][0] = max(f[p][0], t - f[i][1] + f[i][0]);
  if (mn[p] >= dep[p] + k) f[p][1] = 0;
}
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 2; i <= n; i++) {
    int x;
    scanf("%d", &x);
    v[x].push_back(i), v[i].push_back(x);
  }
  dfs(1, 0);
  printf("%d\n", f[1][0]);
  return 0;
}
