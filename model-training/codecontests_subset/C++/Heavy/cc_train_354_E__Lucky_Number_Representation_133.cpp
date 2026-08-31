#include <bits/stdc++.h>
using namespace std;
struct ww {
  int a, b, i, j;
} f[20][5];
int i, j, n, m;
long long k, an[7];
void dfs(int x, int y, long long z) {
  if (x == 1) return;
  int i;
  for (i = 1; i <= f[x][y].i; i++) an[i] += z * 7;
  for (i = 1; i <= f[x][y].j; i++) an[7 - i] += z * 4;
  dfs(x - 1, f[x][y].b, z / 10);
}
inline void work(long long x) {
  int i, j, g[20], n, u, r;
  for (n = 0; x; x /= 10) g[++n] = x % 10;
  long long k = 1;
  for (i = 1; i <= n - 1; i++) k *= 10;
  memset(f, 0, sizeof(f));
  f[1][0].a = 1;
  for (i = 1; i <= n; i++)
    for (j = 0; j <= 4; j++)
      if (f[i][j].a) {
        int A = 0, B = g[i];
        B -= j;
        if (B < 0) A++, B += 10;
        for (u = 0; u <= 6; u++)
          for (r = 0; r <= 6 - u; r++)
            if ((u * 7 + 4 * r) % 10 == B) {
              int C = A + (u * 7 + 4 * r) / 10;
              f[i + 1][C].a = 1;
              f[i + 1][C].b = j;
              f[i + 1][C].i = u;
              f[i + 1][C].j = r;
            }
      }
  if (!f[n + 1][0].a) {
    printf("-1\n");
    return;
  }
  memset(an, 0, sizeof(an));
  dfs(n + 1, 0, k);
  for (i = 1; i <= 6; i++) printf("%I64d ", an[i]);
  printf("\n");
}
int main() {
  scanf("%d", &n);
  for (i = 1; i <= n; i++) scanf("%I64d", &k), work(k);
  return 0;
}
