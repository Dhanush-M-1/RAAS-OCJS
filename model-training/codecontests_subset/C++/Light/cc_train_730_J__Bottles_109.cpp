#include <bits/stdc++.h>
using namespace std;
struct node {
  int x, y;
} s[105];
int cmp(node a, node b) { return a.y > b.y; }
int i, n, k, t, j, m, sum = 0, ans = 0;
int dp[105][100005];
int main() {
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", &s[i].x);
    sum += s[i].x;
  }
  for (i = 1; i <= n; i++) scanf("%d", &s[i].y);
  sort(s + 1, s + n + 1, cmp);
  for (i = 1; i <= n; i++) {
    ans += s[i].y;
    if (ans >= sum) {
      k = i;
      break;
    }
  }
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  for (i = 1; i <= n; i++) {
    for (j = sum - s[i].x; j >= 0; j--) {
      for (m = i - 1; m >= 0; m--) {
        if (dp[m][j] != -1)
          dp[m + 1][j + s[i].x] = max(dp[m + 1][j + s[i].x], dp[m][j] + s[i].y);
      }
    }
  }
  for (i = sum; i >= 0; i--) {
    if (dp[k][i] >= sum) {
      t = i;
      break;
    }
  }
  printf("%d %d\n", k, sum - t);
}
