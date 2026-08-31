#include <bits/stdc++.h>
using namespace std;
const int N = 200, M = 1e4, S = 1010;
int gi() {
  int w = 0;
  bool q = 1;
  char c = getchar();
  while ((c < '0' || c > '9') && c != '-') c = getchar();
  if (c == '-') q = 0, c = getchar();
  while (c >= '0' && c <= '9') w = w * 10 + c - '0', c = getchar();
  return q ? w : -w;
}
int e0[N][N], e1[N][N];
int f[N][N][2], g[2][2][N][N][N], q[M];
int len[M], e[M][S], u[M], v[M];
const int mod = 1e9 + 7;
int main() {
  int n = gi(), m = gi(), i, j, a, b, t, p, ans, l, r, k, o, O;
  for (i = 1; i <= m; i++) {
    a = u[i] = gi(), b = v[i] = gi();
    e0[a][b] = e1[b][a] = i;
    if (len[i] = gi())
      for (j = 1; j <= len[i]; j++) e[i][j] = gi();
    else
      g[0][0][a][b][1] = 1;
  }
  for (t = 1; t <= m; t++)
    for (p = 1; p <= len[t]; p++) {
      if (e[t][p] == u[t]) {
        l = 1, r = 0;
        for (i = p; i; i--) q[++r] = e[t][i];
        for (k = q[1]; l != r;) {
          if (!(j = e1[k][q[++l]])) goto over;
          for (i = len[j]; i; i--) q[++r] = e[j][i];
          k = q[l];
          if (r > (n << 1)) goto over;
        }
        reverse(q + 1, q + 1 + r);
        if (p == len[t])
          g[1][0][q[1]][v[t]][r]++;
        else if (e[t][p + 1] == v[t]) {
          for (i = p + 1; i <= len[t]; i++) q[++r] = e[t][i];
          for (k = v[t], ++l; l != r;) {
            if (!(j = e0[k][q[++l]])) goto over;
            for (i = 1; i <= len[j]; i++) q[++r] = e[j][i];
            k = q[l];
            if (r > (n << 1)) goto over;
          }
          g[1][1][q[1]][q[r]][r - 1]++;
        }
      } else if (p == 1 && e[t][1] == v[t]) {
        l = 1, r = 0;
        for (i = 1; i <= len[t]; i++) q[++r] = e[t][i];
        for (k = q[1]; l != r;) {
          if (!(j = e0[k][q[++l]])) goto over;
          for (i = 1; i <= len[j]; i++) q[++r] = e[j][i];
          k = q[l];
          if (r > (n << 1)) goto over;
        }
        g[0][1][u[t]][q[r]][r]++;
      }
    over:;
    }
  for (i = 1; i <= n; i++) f[0][i][0] = 1;
  for (t = 0; t <= (n << 1); t++) {
    ans = 0;
    for (i = 1; i <= n; i++) {
      (ans += f[t][i][1]) %= mod;
      for (o = 0; o < 2; o++)
        if (f[t][i][o])
          for (j = 1; j + t <= (n << 1); j++)
            for (k = 1; k <= n; k++)
              for (O = 0; O < 2; O++)
                f[j + t][k][O] =
                    (f[j + t][k][O] + 1LL * f[t][i][o] * g[!o][O][i][k][j]) %
                    mod;
    }
    if (t) printf("%d\n", ans);
  }
  return 0;
}
