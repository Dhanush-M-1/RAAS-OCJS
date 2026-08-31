#include <bits/stdc++.h>
int n, nr, nc, a[1 << 20];
int d[20][1 << 20];
char *s[1 << 20], buf[6 << 20];
int main() {
  scanf("%d%d%d", &n, &nr, &nc);
  {
    int i, j, sum;
    int best = -1, bi;
    nc += 2;
    for (i = j = 0; i < n; ++i) {
      scanf(" %s", s[i] = buf + j);
      j += a[i] = strlen(buf + j) + 1;
    }
    for (sum = i = j = 0; i < n; sum -= a[i++]) {
      while (j < n && sum + a[j] < nc) sum += a[j++];
      d[0][i] = j;
    }
    d[0][n] = n;
    for (i = 0; ++i < 20;)
      for (j = 0; j <= n; ++j) d[i][j] = d[i - 1][d[i - 1][j]];
    for (i = 0; i < n; ++i) {
      int t = nr, next = i;
      for (j = 0; t; ++j, t >>= 1)
        if (t & 1) next = d[j][next];
      if (best < 0 || best < next - i) {
        best = next - i;
        bi = i;
      }
    }
    best += bi;
    for (sum = 0, i = bi, j = 0; i < best; ++i) {
      if (sum + a[i] >= nc) {
        puts("");
        ++j;
        sum = 0;
      }
      printf(" %s" + !sum, s[i]);
      sum += a[i];
    }
    puts("");
  }
  return 0;
}
