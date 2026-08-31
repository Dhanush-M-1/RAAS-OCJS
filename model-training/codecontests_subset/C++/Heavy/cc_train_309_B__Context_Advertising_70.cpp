#include <bits/stdc++.h>
const int N = 1e6 + 6;
const int LEN = 5e6 + 6;
char s[LEN];
int n, nr, nc, a[N], to[N][20], mx, str;
int main() {
  scanf("%d%d%d", &n, &nr, &nc);
  for (int i = 1; i <= n; ++i)
    scanf("%s", s + a[i - 1]), a[i] = strlen(s + a[i - 1]) + a[i - 1];
  for (int i = 1, j = 1; i <= n; ++i) {
    if (j < i) j = i;
    while (j <= n && a[j] - a[i - 1] + j - i <= nc) ++j;
    to[i][0] = j;
  }
  to[n + 1][0] = n + 1;
  for (int k = 1; k < 20; ++k) {
    for (int i = 1; i <= n; ++i) to[i][k] = to[to[i][k - 1]][k - 1];
    to[n + 1][k] = n + 1;
  }
  mx = 0, str = 0;
  for (int l = 1; l <= n; ++l) {
    int r = l;
    for (int k = 19; ~k; --k)
      if ((nr >> k) & 1) r = to[r][k];
    if (r - l > mx) mx = r - l, str = l;
  }
  if (str) {
    for (int i = 1; i <= nr; ++i) {
      if (str == to[str][0]) break;
      for (int j = str; j < to[str][0]; ++j) {
        if (j ^ str) putchar(' ');
        for (int k = a[j - 1]; k < a[j]; ++k) putchar(s[k]);
      }
      printf("\n");
      str = to[str][0];
    }
  }
}
