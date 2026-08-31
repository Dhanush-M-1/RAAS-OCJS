#include <bits/stdc++.h>
using namespace std;
const int N = 101, INF = 0x3f3f3f3f;
int a[N], b[N], dp[2][N][2 * N * N];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (int i = 1; i <= n; i++) scanf("%d", &b[i]);
  memset(dp, 0x3f, sizeof dp);
  for (int i = N * N; i < 2 * N * N; i++) dp[0][0][i] = 0;
  int q = 1;
  for (int i = 1; i <= n; i++) {
    for (int j = 0; j <= n; j++) {
      for (int k = 0; k < 2 * N * N; k++) {
        dp[q][j][k] = min(
            k >= a[i] ? a[i] + dp[q ^ 1][j][k - a[i]] : INF,
            j && k + b[i] >= a[i] ? dp[q ^ 1][j - 1][k + b[i] - a[i]] : INF);
      }
    }
    q ^= 1;
  }
  for (int i = 1; i <= n; i++) {
    if (dp[q ^ 1][i][N * N] < INF) {
      printf("%d %d\n", i, dp[q ^ 1][i][N * N]);
      return 0;
    }
  }
}
