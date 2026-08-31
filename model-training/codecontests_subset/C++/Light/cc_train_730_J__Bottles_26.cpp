#include <bits/stdc++.h>
using namespace std;
const int N = 105;
const int MX = N * N;
const int INF = ~0x3f3f3f3f;
int a[N], b[N];
int dp[N][MX];
int main() {
  int n;
  while (scanf("%d", &n) == 1) {
    int sum = 0;
    for (int i = 0; i < n; i++) {
      scanf("%d", a + i);
      sum += a[i];
    }
    for (int i = 0; i < n; i++) {
      scanf("%d", b + i);
    }
    memset(dp, INF, sizeof dp);
    dp[0][0] = 0;
    for (int i = 0; i < n; i++) {
      int aa = a[i], bb = b[i];
      for (int j = i; j >= 0; j--) {
        for (int k = 0; k < MX; k++) {
          if (dp[j][k] != INF) {
            dp[j + 1][k + bb] = max(dp[j + 1][k + bb], dp[j][k] + aa);
          }
        }
      }
    }
    for (int i = 1; i <= n; i++) {
      int mx = INF;
      for (int j = sum; j < MX; j++) {
        mx = max(mx, dp[i][j]);
      }
      if (mx != INF) {
        printf("%d %d\n", i, sum - mx);
        break;
      }
    }
  }
  return 0;
}
