#include <bits/stdc++.h>
using namespace std;
int dp[7][149];
int pre[7][149];
int zc[149][7];
inline void Re(int i, int j, int x, int y) {
  if (dp[i][j]) return;
  dp[i][j] |= dp[x][y];
  if (dp[i][j]) pre[i][j] = y;
}
void init() {
  dp[0][0] = 1;
  for (int i = 1; i <= 6; i++) {
    for (int j = 0; j <= 48; j++)
      if (dp[i - 1][j]) {
        dp[i][j] = dp[i - 1][j];
        pre[i][j] = j;
      }
    for (int j = 48; j >= 4; j--) {
      if (j >= 7) Re(i, j, i - 1, j - 7);
      Re(i, j, i - 1, j - 4);
    }
  }
  for (int i = (1); i <= (6); i++)
    for (int j = (1); j <= (48); j++)
      if (dp[i][j]) {
        for (int k = (1); k <= (i - 1); k++) zc[j][k] = zc[pre[i][j]][k];
        zc[j][i] = j - pre[i][j];
      }
}
bool g[20][6];
int p1[20][6], p2[20][6];
int dig[20];
void PR(int x) {
  long long X[7];
  memset(X, 0, sizeof X);
  for (int j = (1); j <= (6); j++) X[j] = zc[dig[19] + x * 10][j];
  long long base = 10;
  for (int i = 19; i >= 1; i--) {
    for (int j = 1; j <= 6; j++) X[j] += base * 1ll * zc[p1[i][x]][j];
    x = p2[i][x];
    base *= 10ll;
  }
  for (int i = (1); i <= (6); i++) printf("%I64d\n", X[i]);
}
void Work(long long val) {
  memset(dig, 0, sizeof dig);
  memset(g, 0, sizeof g);
  for (int i = (19); i >= (1); i--) {
    dig[i] = val % 10;
    val /= 10ll;
  }
  g[1][0] = 1;
  for (int i = (1); i <= (18); i++)
    for (int jw = (0); jw <= (5); jw++)
      if (g[i][jw]) {
        int al = jw * 10 + dig[i];
        for (int k = (0); k <= (48); k++)
          if (k <= al && dp[6][k] && al - k <= 5)
            if (!g[i + 1][al - k]) {
              g[i + 1][al - k] = 1;
              p1[i + 1][al - k] = k;
              p2[i + 1][al - k] = jw;
            }
      }
  for (int i = (0); i <= (5); i++)
    if (g[19][i] && dp[6][i * 10 + dig[19]]) {
      PR(i);
      return;
    }
  printf("-1\n");
}
int main() {
  int t;
  scanf("%d", &t);
  init();
  while (t--) {
    long long x;
    scanf("%I64d", &x);
    Work(x);
  }
  return 0;
}
