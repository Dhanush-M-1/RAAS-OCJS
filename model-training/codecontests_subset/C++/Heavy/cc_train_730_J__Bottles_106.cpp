#include <bits/stdc++.h>
using namespace std;
int dp[2][110][110 * 110];
int a[110], b[110], c[110];
template <typename T>
void smax(T& x, T y) {
  if (x < y) x = y;
}
int main() {
  int N, S, K, SS, tp, ans;
  scanf("%d", &N);
  for (int i = 0; i < N; i++) scanf("%d", a + i);
  for (int i = 0; i < N; i++) scanf("%d", b + i);
  for (int i = 0; i < N; i++) c[i] = b[i];
  sort(c, c + N);
  reverse(c, c + N);
  S = 0;
  for (int i = 0; i < N; i++) S += a[i];
  for (int i = 0; i < N; i++) {
    S -= c[i];
    if (S <= 0) {
      K = i + 1;
      break;
    }
  }
  S = 0;
  for (int i = 0; i < N; i++) S += a[i];
  SS = 0;
  for (int i = 0; i < N; i++) SS += b[i];
  tp = 0;
  memset(dp[tp], 0xff, sizeof(dp[tp]));
  dp[tp][0][0] = 0;
  dp[tp][1][b[0]] = a[0];
  for (int i = 1; i < N; i++) {
    for (int k = 0; k <= K; k++)
      for (int j = 0; j <= SS; j++) {
        dp[tp ^ 1][k][j] = -1;
        if (k == 0 && j == 0) {
          dp[tp ^ 1][k][j] = 0;
          continue;
        }
        dp[tp ^ 1][k][j] = dp[tp][k][j];
        if (k && j >= b[i] && dp[tp][k - 1][j - b[i]] != -1) {
          smax(dp[tp ^ 1][k][j], dp[tp][k - 1][j - b[i]] + a[i]);
        }
      }
    tp = tp ^ 1;
  }
  ans = 0;
  for (int i = S; i <= SS; i++) smax(ans, dp[tp][K][i]);
  printf("%d %d\n", K, S - ans);
  return 0;
}
