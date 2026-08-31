#include <bits/stdc++.h>
using namespace std;
const int maxn = 101;
int n, a[maxn], b[maxn], f[maxn][10000], water = 0, ans = 0, m, q, w = 0,
                                         g[maxn][10000];
priority_queue<int> que;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    water += a[i];
  }
  for (int i = 1; i <= n; i++) {
    scanf("%d", &b[i]);
    que.push(b[i]);
    w += b[i];
  }
  int tot = 0;
  while (tot < water) {
    ans++;
    int x = que.top();
    que.pop();
    tot += x;
  }
  printf("%d ", ans);
  m = n - ans;
  q = w - water;
  memset(g, 63, sizeof(g));
  for (int i = 0; i <= q; i++) g[0][i] = 0;
  for (int i = b[1]; i <= q; i++) g[1][i] = a[1];
  for (int i = 2; i <= n; i++) {
    memset(f, 63, sizeof(f));
    for (int j = 0; j <= q; j++) {
      f[0][j] = 0;
    }
    for (int j = 1; j <= m; j++) {
      if (j > i) continue;
      for (int k = 0; k <= q; k++) {
        f[j][k] = g[j][k];
        if (k >= b[i]) f[j][k] = min(f[j][k], g[j - 1][k - b[i]] + a[i]);
      }
    }
    for (int j = 0; j <= m; j++)
      for (int k = 0; k <= q; k++) g[j][k] = f[j][k];
  }
  printf("%d\n", g[m][q]);
  return 0;
}
