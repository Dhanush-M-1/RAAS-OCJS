#include <bits/stdc++.h>
const int msc = 90, mod = (int)1e9 + 7;
using namespace std;
typedef int arr32[110][110][110];
typedef int arrct[100010];
int path[5][110][110][110];
arr32 d, t, f;
arrct q;
int n, m;
void inc(int &x, const int &y) {
  x += y;
  if (x >= mod) x -= mod;
}
void work(int x, int y) {
  int *a = d[x][y], *b = t[x][y];
  if (b[0] == 0) return;
  if (a[0] == 0) return;
  if (!b[x] && !b[y]) return;
  if (b[x] && b[x] != a[0] && a[b[x] + 1] != y) return;
  if (b[y] && b[y] != 1 && a[b[y] - 1] != x) return;
  int tA, He, nt, cnt, len = 1, st = 0, et = 0, stat = 0;
  if (b[x]) {
    tA = 0, He = 1, nt = x, cnt = 1;
    for (int i = b[x] - 1; i; --i) q[++tA] = a[i];
    while (He <= tA && cnt < msc) {
      int z = q[He];
      if (t[z][nt][0] == 0)
        cnt = msc;
      else
        for (int i = d[z][nt][0]; i; --i) q[++tA] = d[z][nt][i];
      ++He, nt = z, ++len;
    }
    if (cnt == msc) return;
    st = nt, stat += 1;
  } else
    st = x;
  if (b[y]) {
    tA = 0, He = 1, nt = y, cnt = 1;
    for (int i = b[y] + 1; i <= a[0]; ++i) q[++tA] = a[i];
    while (He <= tA && cnt < msc) {
      int z = q[He];
      if (t[nt][z][0] == 0)
        cnt = msc;
      else
        for (int i = 1; i <= d[nt][z][0]; ++i) q[++tA] = d[nt][z][i];
      ++He, nt = z, ++len;
    }
    if (cnt == msc) return;
    et = nt, stat += 2;
  } else
    et = y;
  path[stat][len][st][et] += 1;
}
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= m; ++i) {
    int x, y, z;
    scanf("%d %d %d", &x, &y, &z);
    for (int j = 1; j <= z; ++j) scanf("%d", q + j);
    if (z <= 2 * n + 1) {
      d[x][y][0] = z, t[x][y][0] = 1;
      for (int j = 1; j <= z; ++j) t[x][y][q[j]] = j;
      for (int j = 1; j <= z; ++j) d[x][y][j] = q[j];
    }
    if (z == 0) path[0][1][x][y] += 1;
  }
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      if (t[i][j][0] == 1) {
        work(i, j);
      }
  int m = 2 * n;
  for (int i = 1; i <= n; ++i) f[0][1][i] = 1;
  for (int i = 0; i < m; ++i)
    for (int stat_j = 0; stat_j < 4; ++stat_j) {
      if (!(stat_j & 1)) continue;
      for (int j = 1; j <= n; ++j) {
        if (!f[i][stat_j][j]) continue;
        for (int stat_k = 0; stat_k < 4; ++stat_k)
          if ((stat_j >> 1) ^ (stat_k & 1))
            for (int k = 1; k <= n; ++k)
              for (int L = 1; L <= m; ++L) {
                if (path[stat_k][L][j][k]) {
                  inc(f[i + L][(stat_j & 1) ^ (stat_k & 2)][k],
                      (long long)f[i][stat_j][j] * path[stat_k][L][j][k] % mod);
                }
              }
      }
    }
  for (int i = 1; i <= m; ++i) {
    int result = 0;
    for (int j = 1; j <= n; ++j) inc(result, f[i][3][j]);
    printf("%d\n", result);
  }
}
