#include <bits/stdc++.h>
using namespace std;
const int N = 110000;
const int oo = 0x3f3f3f3f;
struct node {
  int x, h;
} a[N];
int dp[N][3];
int main() {
  int n;
  while (scanf("%d", &n) != EOF) {
    int i;
    for (i = 1; i <= n; i++) scanf("%d%d", &a[i].x, &a[i].h);
    memset(dp, 0, sizeof(dp));
    dp[1][0] = dp[1][1] = 1;
    if (a[2].x - a[1].x > a[1].h) dp[1][2] = 1;
    for (i = 2; i <= n; i++) {
      int t = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2]));
      dp[i][1] = t;
      if (a[i].x - a[i - 1].x > a[i].h)
        dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]) + 1;
      if (a[i].x - a[i - 1].x > a[i].h + a[i - 1].h)
        dp[i][0] = max(dp[i][0], dp[i - 1][2] + 1);
      if (i < n && a[i + 1].x - a[i].x > a[i].h) dp[i][2] = t + 1;
      if (i == n) dp[i][2] = t + 1;
    }
    printf("%d\n", max(dp[n][0], max(dp[n][1], dp[n][2])));
  }
  return 0;
}
