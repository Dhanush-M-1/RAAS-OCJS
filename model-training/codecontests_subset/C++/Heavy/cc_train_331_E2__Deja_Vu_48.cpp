#include <bits/stdc++.h>
long long n, m, p = (long long)(1e9 + 7);
long long a[105][105], seq[105][105][105];
long long pl[1300], pr[1300], rd[1300];
long long flag[105][105];
long long f[105][105][105][4], dp[105][105][2];
long long ans[105];
void inc(long long i, long long j, long long k, long long o) {
  f[i][j][k][o]++;
  if (o == 0) dp[j][k][1]++;
  if (o == 2) dp[j][k][0]++;
}
void pt_pt() {
  for (long long i = 1; i <= n; i++)
    for (long long j = 1; j <= n; j++)
      if (flag[i][j]) {
        long long pos, x, y, rf = 0;
        for (long long k = 1; k <= seq[i][j][0] - 1; k++)
          if (seq[i][j][k] == i && seq[i][j][k + 1] == j) {
            pos = k;
            break;
          }
        pl[pl[0] = 1] = i, pr[pr[0] = 1] = j;
        rd[0] = 0;
        for (long long k = pos + 1; k <= seq[i][j][0]; k++)
          rd[++rd[0]] = seq[i][j][k];
        while (pl[0] + pr[0] <= 2 * n + 1 && rd[0] > pr[0] &&
               a[rd[pr[0]]][rd[pr[0] + 1]]) {
          rf |= flag[x = rd[pr[0]]][y = rd[pr[0] + 1]];
          pr[++pr[0]] = y;
          for (long long k = 1; k <= seq[x][y][0]; k++)
            rd[++rd[0]] = seq[x][y][k];
        }
        if (rd[0] > pr[0]) continue;
        rd[0] = 0;
        for (long long k = pos; k >= 1; k--) rd[++rd[0]] = seq[i][j][k];
        while (pl[0] + pr[0] <= 2 * n + 1 && rd[0] > pl[0] &&
               a[rd[pl[0] + 1]][rd[pl[0]]]) {
          x = rd[pl[0] + 1], y = rd[pl[0]];
          pl[++pl[0]] = x;
          for (long long k = seq[x][y][0]; k >= 1; k--)
            rd[++rd[0]] = seq[x][y][k];
        }
        if (rd[0] > pl[0]) continue;
        if (!rf) inc(pl[pl[0]], pr[pr[0]], pl[0] + pr[0] - 1, 0);
      }
}
void _pt() {
  for (long long i = 1; i <= n; i++)
    for (long long j = 1; j <= n; j++)
      if (a[i][j] && seq[i][j][1] == j) {
        long long x, y;
        rd[0] = 0;
        for (long long k = 1; k <= seq[i][j][0]; k++)
          rd[++rd[0]] = seq[i][j][k];
        pr[pr[0] = 1] = j;
        while (pr[0] <= 2 * n && rd[0] > pr[0] && a[rd[pr[0]]][rd[pr[0] + 1]]) {
          x = rd[pr[0]], y = rd[pr[0] + 1];
          pr[++pr[0]] = y;
          for (long long k = 1; k <= seq[x][y][0]; k++)
            rd[++rd[0]] = seq[x][y][k];
        }
        if (rd[0] > pr[0]) continue;
        inc(i, pr[pr[0]], pr[0], 1);
      }
}
void pt_() {
  for (long long i = 1; i <= n; i++)
    for (long long j = 1; j <= n; j++)
      if (a[i][j] && seq[i][j][seq[i][j][0]] == i) {
        long long x, y;
        rd[0] = 0;
        for (long long k = seq[i][j][0]; k >= 1; k--)
          rd[++rd[0]] = seq[i][j][k];
        pl[pl[0] = 1] = i;
        while (pl[0] <= 2 * n && rd[0] > pl[0] && a[rd[pl[0] + 1]][rd[pl[0]]]) {
          x = rd[pl[0] + 1], y = rd[pl[0]];
          pl[++pl[0]] = x;
          for (long long k = seq[x][y][0]; k >= 1; k--)
            rd[++rd[0]] = seq[x][y][k];
        }
        if (rd[0] > pl[0]) continue;
        inc(pl[pl[0]], j, pl[0], 2);
      }
}
long long add(long long& x, long long y) { (x += y) %= p; }
void calc() {
  for (long long j = 1; j <= 2 * n; j++)
    for (long long i = 1; i <= n; i++)
      if (dp[i][j][0] || dp[i][j][1]) {
        for (long long k = 1; k <= n; k++)
          for (long long o = 1; o <= 2 * n - j; o++) {
            if (dp[i][j][0] && f[i][k][o][2])
              add(dp[k][j + o][0], dp[i][j][0] * f[i][k][o][2]);
            if (dp[i][j][0] && f[i][k][o][0])
              add(dp[k][j + o][1], dp[i][j][0] * f[i][k][o][0]);
            if (dp[i][j][1] && f[i][k][o][1])
              add(dp[k][j + o][1], dp[i][j][1] * f[i][k][o][1]);
            if (dp[i][j][1] && f[i][k][o][3])
              add(dp[k][j + o][0], dp[i][j][1] * f[i][k][o][3]);
          }
        add(ans[j], dp[i][j][1]);
      }
}
int main() {
  scanf("%lld", &n), scanf("%lld", &m);
  for (long long i = 1; i <= m; i++) {
    long long x, y;
    scanf("%lld", &x), scanf("%lld", &y);
    a[x][y] = i;
    scanf("%lld", &seq[x][y][0]);
    if (!seq[x][y][0]) inc(x, y, 1, 3);
    for (long long j = 1; j <= seq[x][y][0]; j++)
      scanf("%lld", &seq[x][y][j]),
          flag[x][y] |= j > 1 && seq[x][y][j - 1] == x && seq[x][y][j] == y;
  }
  pt_pt(), _pt(), pt_();
  calc();
  for (long long i = 1; i <= 2 * n; i++) printf("%lld\n", ans[i]);
}
