#include <bits/stdc++.h>
const int N = 55, M = N * N, p = 1e9 + 7;
int n, m, x[M], y[M], len[M], f[N << 1][N][2], q[N << 1], mp[N][N], mpr[N][N];
std::vector<int> a[M];
typedef struct {
  int y, l, fx, fy;
} node;
std::vector<node> qs[N];
inline void add(int x, int y, int l, int fx, int fy) {
  qs[x].push_back((node){y, l, fx, fy});
}
int main() {
  int i, j, k, tmp, hd, tl, xx, yy, zz;
  scanf("%d%d", &n, &m);
  for (i = 1; i <= m; i++) {
    scanf("%d%d%d", &x[i], &y[i], &len[i]);
    mp[x[i]][y[i]] = mpr[y[i]][x[i]] = i;
    for (j = 0; j < len[i]; j++) scanf("%d", &tmp), a[i].push_back(tmp);
  }
  for (i = 1; i <= m; i++) {
    for (j = 0; j + 1 < len[i]; j++)
      if (a[i][j] == x[i] && a[i][j + 1] == y[i]) break;
    if (j + 1 < len[i]) {
      tmp = j;
      for (j = tmp - 1, q[tl = 0] = x[i]; j >= 0; j--) q[++tl] = a[i][j];
      for (hd = 1; hd <= tl && mpr[q[hd - 1]][q[hd]] && tl <= n * 2; hd++)
        for (k = len[mpr[q[hd - 1]][q[hd]]] - 1; k >= 0; k--)
          q[++tl] = a[mpr[q[hd - 1]][q[hd]]][k];
      if (hd <= tl) continue;
      xx = q[tl];
      zz = tl;
      for (j = tmp + 2, q[tl = 0] = y[i]; j < len[i]; j++) q[++tl] = a[i][j];
      for (hd = 1; hd <= tl && mp[q[hd - 1]][q[hd]] && tl <= n * 2; hd++)
        for (k = 0; k < len[mp[q[hd - 1]][q[hd]]]; k++)
          q[++tl] = a[mp[q[hd - 1]][q[hd]]][k];
      if (hd <= tl) continue;
      yy = q[tl];
      zz += tl;
      add(xx, yy, zz + 1, 1, 1);
    } else if (len[i] && a[i][len[i] - 1] == x[i]) {
      for (j = len[i] - 2, q[tl = 0] = x[i]; j >= 0; j--) q[++tl] = a[i][j];
      for (hd = 1; hd <= tl && mpr[q[hd - 1]][q[hd]] && tl <= n * 2; hd++)
        for (k = len[mpr[q[hd - 1]][q[hd]]] - 1; k >= 0; k--)
          q[++tl] = a[mpr[q[hd - 1]][q[hd]]][k];
      if (hd <= tl) continue;
      add(q[tl], y[i], tl + 1, 1, 0);
    } else if (len[i] && a[i][0] == y[i]) {
      for (j = 1, q[tl = 0] = y[i]; j < len[i]; j++) q[++tl] = a[i][j];
      for (hd = 1; hd <= tl && mp[q[hd - 1]][q[hd]] && tl <= n * 2; hd++)
        for (k = 0; k < len[mp[q[hd - 1]][q[hd]]]; k++)
          q[++tl] = a[mp[q[hd - 1]][q[hd]]][k];
      if (hd <= tl) continue;
      add(x[i], q[tl], tl + 1, 0, 1);
    } else if (!len[i])
      add(x[i], y[i], 1, 0, 0);
  }
  for (i = 1; i <= n; i++) f[0][i][0] = 1;
  for (i = 0; i <= n * 2; i++)
    for (j = 1; j <= n; j++)
      for (k = 0; k < qs[j].size(); k++)
        f[i + qs[j][k].l][qs[j][k].y][qs[j][k].fy] =
            (f[i + qs[j][k].l][qs[j][k].y][qs[j][k].fy] +
             f[i][j][qs[j][k].fx ^ 1]) %
            p;
  for (i = 1; i <= n * 2; i++) {
    for (tmp = 0, j = 1; j <= n; j++) tmp = (tmp + f[i][j][1]) % p;
    printf("%d\n", tmp);
  }
  return 0;
}
