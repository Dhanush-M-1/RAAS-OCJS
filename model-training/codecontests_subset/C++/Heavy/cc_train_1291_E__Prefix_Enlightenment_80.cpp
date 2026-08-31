#include <bits/stdc++.h>
using namespace std;
int n, m, k, x;
vector<int> vec[300010];
char c[300010];
int fa[300010 << 1], sz[300010 << 1];
int lim[300010 << 1];
int find(int x) {
  if (fa[x] == x) return x;
  return fa[x] = find(fa[x]);
}
int main() {
  scanf("%d%d%s", &n, &k, c + 1);
  for (int i = 1; i <= k; i++) {
    scanf("%d", &m);
    for (int j = 1; j <= m; j++) {
      scanf("%d", &x);
      vec[x].push_back(i);
    }
  }
  for (int i = 1; i <= k; i++) {
    fa[i * 2 - 1] = i * 2 - 1;
    sz[i * 2 - 1] = 1;
    fa[i * 2] = i * 2;
    sz[i * 2] = 0;
    lim[i * 2 - 1] = lim[i * 2] = -1;
  }
  int ans = 0;
  for (int i = 1; i <= n; i++) {
    if (vec[i].size() == 1) {
      int x = vec[i][0];
      int f1 = find(x * 2 - 1), f0 = find(x * 2);
      int s1 = sz[f1], s0 = sz[f0];
      if (lim[f1] == -1)
        ans -= min(s0, s1);
      else
        ans -= lim[f1] ? s1 : s0;
      lim[f1] = (c[i] == '0');
      lim[f0] = lim[f1] ^ 1;
      ans += lim[f1] ? s1 : s0;
    } else if (vec[i].size() == 2) {
      int x = vec[i][0], y = vec[i][1];
      int fx1 = find(x * 2 - 1), fx0 = find(x * 2);
      int sx1 = sz[fx1], sx0 = sz[fx0];
      int fy1 = find(y * 2 - 1), fy0 = find(y * 2);
      int sy1 = sz[fy1], sy0 = sz[fy0];
      if (fx0 != fy0 && fx0 != fy1) {
        if (lim[fx1] == -1)
          ans -= min(sx0, sx1);
        else
          ans -= lim[fx1] ? sx1 : sx0;
        if (lim[fy1] == -1)
          ans -= min(sy0, sy1);
        else
          ans -= lim[fy1] ? sy1 : sy0;
        if (c[i] == '1') {
          fa[fx1] = fy1;
          fa[fx0] = fy0;
          sz[fy1] += sz[fx1];
          sz[fy0] += sz[fx0];
          if (lim[fx1] != -1) {
            lim[fy1] = lim[fx1];
            lim[fy0] = lim[fy1] ^ 1;
          }
        } else {
          fa[fx1] = fy0;
          fa[fx0] = fy1;
          sz[fy0] += sz[fx1];
          sz[fy1] += sz[fx0];
          if (lim[fx1] != -1) {
            lim[fy0] = lim[fx1];
            lim[fy1] = lim[fy0] ^ 1;
          }
        }
        int f1 = find(x * 2 - 1), f0 = find(x * 2);
        int s1 = sz[f1], s0 = sz[f0];
        if (lim[f1] == -1)
          ans += min(s0, s1);
        else
          ans += lim[f1] ? s1 : s0;
      }
    }
    printf("%d\n", ans);
  }
  return 0;
}
