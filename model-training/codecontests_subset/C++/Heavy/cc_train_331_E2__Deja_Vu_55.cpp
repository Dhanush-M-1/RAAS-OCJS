#include <bits/stdc++.h>
using namespace std;
int b[51][51][51], c[51][51], d1[10001], d2[10001], n, m, i, j, k, l, x, h, t1,
    t2;
long long f[2][101][51], g[3][101][51][51], ans[101];
bool a[51][51], Ans1;
void work1() {
  int i, j, k, l, x, len;
  for (i = 1; i <= n; i++) {
    for (j = 1; j <= n; j++)
      if (a[i][j] && c[i][j]) {
        for (k = 1; k <= c[i][j] - 1; k++)
          if (b[i][j][k] == i && b[i][j][k + 1] == j) {
            x = i;
            h = t1 = 1;
            d1[1] = i;
            len = 1;
            for (l = k - 1; l >= 1; l--) d1[++t1] = b[i][j][l], ++len;
            while (h < t1) {
              ++h;
              if (len > n + n || !a[d1[h]][x]) {
                h = -114514;
                break;
              }
              for (l = c[d1[h]][x]; l >= 1; l--)
                d1[++t1] = b[d1[h]][x][l], ++len;
              x = d1[h];
            }
            if (h < t1) break;
            x = j;
            h = t2 = 1;
            d2[1] = j;
            for (l = k + 2; l <= c[i][j]; l++) d2[++t2] = b[i][j][l], ++len;
            while (h < t2) {
              ++h;
              if (len > n + n || !a[x][d2[h]]) {
                h = -114514;
                break;
              }
              for (l = 1; l <= c[x][d2[h]]; l++)
                d2[++t2] = b[x][d2[h]][l], ++len;
              x = d2[h];
            }
            if (h < t2) break;
            if (!Ans1) {
              Ans1 = 1;
            }
            ++g[1][len][d1[t1]][d2[t2]];
            break;
          }
        if (b[i][j][c[i][j]] == i) {
          x = i;
          h = t1 = 1;
          d1[1] = i;
          len = 1;
          for (l = c[i][j] - 1; l >= 1; l--) d1[++t1] = b[i][j][l], ++len;
          while (h < t1) {
            ++h;
            if (len > n + n || !a[d1[h]][x]) {
              h = -114514;
              break;
            }
            for (l = c[d1[h]][x]; l >= 1; l--) d1[++t1] = b[d1[h]][x][l], ++len;
            x = d1[h];
          }
          if (!(len > n + n || h < t1)) ++g[0][len][d1[t1]][j];
        }
        if (b[i][j][1] == j) {
          x = j;
          h = t2 = 1;
          d2[1] = j;
          len = 1;
          for (l = 2; l <= c[i][j]; l++) d2[++t2] = b[i][j][l], ++len;
          while (h < t2) {
            ++h;
            if (len > n + n || !a[x][d2[h]]) {
              h = -114514;
              break;
            }
            for (l = 1; l <= c[x][d2[h]]; l++) d2[++t2] = b[x][d2[h]][l], ++len;
            x = d2[h];
          }
          if (!(len > n + n || h < t2)) ++g[2][len][i][d2[t2]];
        }
      }
  }
}
void work2() {
  int i, s, j, k, l;
  for (i = 1; i <= n; i++) {
    for (j = 1; j <= n; j++) {
      for (k = 1; k <= n + n; k++)
        f[0][k][j] = ((f[0][k][j]) + (g[0][k][i][j])) % 1000000007,
        f[1][k][j] = ((f[1][k][j]) + (g[1][k][i][j])) % 1000000007;
    }
  }
  for (i = 1; i <= n + n - 1; i++) {
    for (s = 0; s <= 1; s++) {
      for (j = 1; j <= n; j++)
        if (f[s][i][j]) {
          if (s == 1) {
            for (l = 1; l <= n; l++)
              if (a[j][l] && !c[j][l])
                f[0][i + 1][l] = ((f[0][i + 1][l]) + (f[s][i][j])) % 1000000007;
          }
          for (k = 1; k <= n + n - i; k++) {
            for (l = 1; l <= n; l++) switch (s) {
                case 0: {
                  f[0][i + k][l] =
                      ((f[0][i + k][l]) + (f[s][i][j] * g[0][k][j][l])) %
                      1000000007;
                  f[1][i + k][l] =
                      ((f[1][i + k][l]) + (f[s][i][j] * g[1][k][j][l])) %
                      1000000007;
                  break;
                }
                case 1: {
                  f[1][i + k][l] =
                      ((f[1][i + k][l]) + (f[s][i][j] * g[2][k][j][l])) %
                      1000000007;
                  break;
                }
              }
          }
        }
    }
  }
}
int main() {
  scanf("%d%d", &n, &m);
  for (i = 1; i <= m; i++) {
    scanf("%d%d", &j, &k);
    a[j][k] = 1;
    scanf("%d", &c[j][k]);
    for (l = 1; l <= c[j][k]; l++) scanf("%d", &b[j][k][l]);
  }
  work1();
  if (!Ans1) {
    for (i = 1; i <= n + n; i++) printf("0\n");
  } else {
    work2();
    for (i = 1; i <= n + n; i++)
      for (j = 1; j <= n; j++) ans[i] = ((ans[i]) + (f[1][i][j])) % 1000000007;
    for (i = 1; i <= n + n; i++) printf("%lld\n", ans[i]);
  }
  fclose(stdin);
  fclose(stdout);
  return 0;
}
