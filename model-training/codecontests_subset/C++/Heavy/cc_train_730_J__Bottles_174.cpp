#include <bits/stdc++.h>
using namespace std;
int dp[105][10005];
struct node {
  int le, val;
  friend bool operator<(node a, node b) {
    if (a.val == b.val) return a.le > b.le;
    return a.val > b.val;
  }
} s[105];
int main() {
  int n, i, j, k, ans1, ans2, tmp, sum;
  while (scanf("%d", &n) != EOF) {
    sum = 0;
    for (i = 1; i <= n; i++) {
      scanf("%d", &s[i].le);
      sum += s[i].le;
    }
    for (i = 1; i <= n; i++) scanf("%d", &s[i].val);
    sort(s + 1, s + n + 1);
    tmp = 0;
    for (i = 1; i <= n; i++) {
      tmp += s[i].val;
      if (tmp >= sum) {
        ans1 = i;
        break;
      }
    }
    memset(dp, -1, sizeof(dp));
    dp[0][0] = 0;
    for (i = 1; i <= n; i++) {
      for (j = sum; j >= 0; j--) {
        for (k = 1; k <= i; k++) {
          if (j >= s[i].le && dp[k - 1][j - s[i].le] != -1)
            dp[k][j] = max(dp[k][j], dp[k - 1][j - s[i].le] + s[i].val);
        }
      }
    }
    for (i = sum; i >= 0; i--) {
      if (dp[ans1][i] >= sum) {
        ans2 = sum - i;
        break;
      }
    }
    printf("%d %d\n", ans1, ans2);
  }
  return 0;
}
