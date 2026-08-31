#include <bits/stdc++.h>
inline int Get() {
  char ch;
  while ((ch = getchar()) < '0' || ch > '9')
    ;
  int Num = ch - '0';
  while ((ch = getchar()) >= '0' && ch <= '9')
    Num = (Num << 3) + (Num << 1) + ch - '0';
  return Num;
}
const int N = 105;
const int M = 2505;
const int mod = 1e9 + 7;
int n, m, w[N][N], que[N];
int tx[M], ty[M], seq[M][N], g[2][2][N][N][N], dp[N][N][2];
int main() {
  n = Get(), m = Get();
  for (int i = 1; i <= m; ++i) {
    tx[i] = Get(), ty[i] = Get(), w[tx[i]][ty[i]] = i;
    seq[i][0] = Get();
    for (int k = 1; k <= seq[i][0]; ++k) seq[i][k] = Get();
    if (!seq[i][0]) g[0][0][tx[i]][ty[i]][1] = 1;
  }
  for (int id = 1, nxt; id <= m; ++id)
    for (int j = 1; j <= seq[id][0]; ++j) {
      if (seq[id][j] == tx[id]) {
        int ql = 1, qr = 0;
        for (int i = j; i; --i) que[++qr] = seq[id][i];
        for (int i = que[ql]; ql != qr; i = que[++ql]) {
          if (!(nxt = w[que[ql + 1]][i])) goto GG;
          for (int k = seq[nxt][0]; k; --k) que[++qr] = seq[nxt][k];
          if (qr > (n << 1)) goto GG;
        }
        std ::reverse(que + 1, que + qr + 1);
        if (j == seq[id][0])
          ++g[1][0][que[1]][ty[id]][qr];
        else {
          if (seq[id][j + 1] != ty[id]) goto GG;
          for (int i = j + 1; i <= seq[id][0]; ++i) que[++qr] = seq[id][i];
          for (int i = que[++ql]; ql != qr; i = que[++ql]) {
            if (!(nxt = w[i][que[ql + 1]])) goto GG;
            for (int k = 1; k <= seq[nxt][0]; ++k) que[++qr] = seq[nxt][k];
            if (qr - 1 > (n << 1)) goto GG;
          }
          ++g[1][1][que[1]][que[qr]][qr - 1];
        }
      } else if (j == 1 && seq[id][1] == ty[id]) {
        int ql = 1, qr = 0;
        for (int i = j; i <= seq[id][0]; ++i) que[++qr] = seq[id][i];
        for (int i = que[ql]; ql != qr; i = que[++ql]) {
          if (!(nxt = w[i][que[ql + 1]])) goto GG;
          for (int k = 1; k <= seq[nxt][0]; ++k) que[++qr] = seq[nxt][k];
          if (qr > (n << 1)) goto GG;
        }
        ++g[0][1][tx[id]][que[qr]][qr];
      }
    GG:;
    }
  for (int i = 1; i <= n; ++i) dp[0][i][0] = 1;
  for (int i = 0; i < n * 2; ++i)
    for (int u = 1; u <= n; ++u)
      for (int a = 0; a < 2; ++a)
        if (dp[i][u][a])
          for (int j = 1; i + j <= n * 2; ++j)
            for (int v = 1; v <= n; ++v)
              for (int b = 0; b < 2; ++b)
                if (g[!a][b][u][v][j])
                  dp[i + j][v][b] =
                      ((long long)dp[i][u][a] * g[!a][b][u][v][j] +
                       dp[i + j][v][b]) %
                      mod;
  for (int i = 1; i <= n * 2; ++i) {
    int ans = 0;
    for (int u = 1; u <= n; ++u) ans = (ans + dp[i][u][1]) % mod;
    printf("%d\n", ans);
  }
}
