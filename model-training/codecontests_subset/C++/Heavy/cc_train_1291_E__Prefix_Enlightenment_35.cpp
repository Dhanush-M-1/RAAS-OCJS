#include <bits/stdc++.h>
using namespace std;
int n, m;
int fa[300005];
int x[300005], y[300005];
int f[300005][2];
int a[300005][3], b[300005];
int p;
char s[300005];
int main() {
  scanf("%d%d%s", &n, &m, s);
  for (int i = 1; i <= m; i++) {
    int ha;
    scanf("%d", &ha);
    while (ha--) {
      int haha;
      scanf("%d", &haha);
      a[haha][++b[haha]] = i;
    }
    fa[i] = i;
    f[i][0] = 1;
    y[i] = -1;
  }
  for (int i = 1; i <= n; i++) {
    if (b[i] == 1) {
      int j = a[i][1];
      int l = j, r = 0;
      for (; fa[l] != l; l = fa[l]) r ^= x[l];
      r ^= (s[i - 1] == '1');
      if (y[l] == -1) {
        y[l] = r;
        p -= min(f[l][0], f[l][1]);
        p += f[l][r];
      }
    } else if (b[i] == 2) {
      int j = a[i][1], k = a[i][2], l = x[j], u = x[k];
      while (j != fa[j]) {
        j = fa[j];
        l ^= x[j];
      }
      while (k != fa[k]) {
        k = fa[k];
        u ^= x[k];
      }
      if (j != k) {
        if (f[j][0] + f[j][1] < f[k][0] + f[k][1]) swap(j, k);
        if (y[j] == -1)
          p -= min(f[j][0], f[j][1]);
        else
          p -= f[j][y[j]];
        if (y[k] == -1)
          p -= min(f[k][0], f[k][1]);
        else
          p -= f[k][y[k]];
        fa[k] = j;
        if (l ^ u ^ (s[i - 1] == '0')) {
          x[k] = 1;
          swap(f[k][0], f[k][1]);
          if (y[k] != -1) y[k] ^= 1;
        }
        f[j][0] += f[k][0];
        f[j][1] += f[k][1];
        if (y[k] != -1) y[j] = y[k];
        if (y[j] == -1)
          p += min(f[j][0], f[j][1]);
        else
          p += f[j][y[j]];
      }
    }
    printf("%d\n", p);
  }
  return 0;
}
