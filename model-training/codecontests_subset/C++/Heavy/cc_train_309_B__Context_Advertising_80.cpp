#include <bits/stdc++.h>
using namespace std;
int i, j, k, n, m, r, c, x, ma, an1, an2, len;
int l[1000010], f[1000010][21], s[1000010], L[1000010], R[1000010];
char p[1000010 * 6];
int main() {
  scanf("%d%d%d", &n, &r, &c);
  for (i = 1; i <= n; i++) {
    scanf("%s", p + len + 1);
    l[i] = strlen(p + len + 1);
    s[i] = s[i - 1] + l[i];
    L[i] = len + 1;
    len += l[i] + 1;
    R[i] = len - 1;
  }
  j = n;
  for (i = n; i; i--) {
    for (; j >= i && s[j] - s[i - 1] + j - i > c; j--)
      ;
    if (j >= i) f[i][0] = j;
  }
  for (i = 1; i <= 20; i++)
    for (j = 1; j <= n; j++)
      if (f[j][i - 1]) f[j][i] = max(f[f[j][i - 1] + 1][i - 1], f[j][i - 1]);
  for (i = 1; i <= n; i++)
    if (f[i][0]) {
      for (k = r, x = i, j = 20; j >= 0; j--)
        if (k >= (1 << j) && f[x][0]) x = f[x][j] + 1, k -= 1 << j;
      if (x - i > ma) {
        ma = x - i;
        an1 = i, an2 = x - 1;
      }
    }
  if (ma) {
    k = -1;
    for (i = an1; i <= an2; i++) {
      if (k + l[i] + 1 > c) printf("\n"), k = -1;
      if (k >= 0) printf(" ");
      k += l[i] + 1;
      for (j = L[i]; j <= R[i]; j++) printf("%c", p[j]);
    }
    printf("\n");
  }
  return 0;
}
