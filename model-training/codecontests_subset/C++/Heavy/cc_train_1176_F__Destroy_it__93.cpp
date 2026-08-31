#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 5;
inline int read() {
  char c = getchar();
  int t = 0, f = 1;
  while (!isdigit(c)) {
    if (c == '-') f = -1;
    c = getchar();
  }
  while (isdigit(c)) {
    t = (t << 3) + (t << 1) + (c ^ 48);
    c = getchar();
  }
  return t * f;
}
int n;
struct node {
  int c, d;
} a[maxn];
bool cmp(node a, node b) { return a.c == b.c ? a.d > b.d : a.c < b.c; }
long long g[maxn][7], a1[maxn][4], a2[maxn][3], a3[maxn][2];
long long f[maxn][10];
int main() {
  n = read();
  memset(g, ~0x3f, sizeof(g));
  for (int i = 1; i <= n; i++) {
    int k = read();
    for (int j = 1; j <= k; j++) {
      a[j].c = read(), a[j].d = read();
    }
    int tmp1 = 0, tmp2 = 0, tmp3 = 0;
    sort(a + 1, a + 1 + k, cmp);
    for (int j = 1; j <= k; j++) {
      if (tmp1 < 3 && a[j].c == 1) {
        a1[i][++tmp1] = a[j].d;
      }
      if (tmp2 < 1 && a[j].c == 2) {
        a2[i][++tmp2] = a[j].d;
      }
      if (tmp3 < 1 && a[j].c == 3) {
        a3[i][++tmp3] = a[j].d;
      }
    }
    if (tmp1 > 0) g[i][1] = a1[i][1];
    if (tmp1 > 1) g[i][2] = a1[i][1] + a1[i][2];
    if (tmp1 > 2) g[i][3] = g[i][2] + a1[i][3];
    if (tmp2 > 0) g[i][4] = a2[i][1];
    if (tmp2 > 0 && tmp1 > 0) g[i][5] = a2[i][1] + a1[i][1];
    if (tmp3 > 0) g[i][6] = a3[i][1];
  }
  memset(f, ~0x3f, sizeof(f));
  f[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = 0; j <= 9; j++) f[i][j] = f[i - 1][j];
    for (int j = 0; j <= 9; j++) {
      f[i][(j + 1) % 10] =
          max(f[i][(j + 1) % 10],
              f[i - 1][j] + g[i][1] + ((j + 1) >= 10 ? a1[i][1] : 0));
      f[i][(j + 2) % 10] =
          max(f[i][(j + 2) % 10],
              f[i - 1][j] + g[i][2] + ((j + 2) >= 10 ? a1[i][1] : 0));
      f[i][(j + 3) % 10] =
          max(f[i][(j + 3) % 10],
              f[i - 1][j] + g[i][3] + ((j + 3) >= 10 ? a1[i][1] : 0));
      f[i][(j + 1) % 10] =
          max(f[i][(j + 1) % 10],
              f[i - 1][j] + g[i][4] + ((j + 1) >= 10 ? a2[i][1] : 0));
      f[i][(j + 2) % 10] =
          max(f[i][(j + 2) % 10],
              f[i - 1][j] + g[i][5] +
                  ((j + 2) >= 10 ? max(a1[i][1], a2[i][1]) : 0));
      f[i][(j + 1) % 10] =
          max(f[i][(j + 1) % 10],
              f[i - 1][j] + g[i][6] + ((j + 1) >= 10 ? a3[i][1] : 0));
    }
  }
  long long ans = 0;
  for (int i = 0; i <= 9; i++) {
    ans = max(ans, f[n][i]);
  }
  printf("%lld\n", ans);
  return 0;
}
