#include <bits/stdc++.h>
using namespace std;
typedef struct node {
  int left, volume;
} node;
node a[105];
bool cmp(node a, node b) {
  if (a.volume != b.volume)
    return a.volume > b.volume;
  else
    return a.left > b.left;
}
int main() {
  int n;
  while (~scanf("%d", &n)) {
    int dp[105][10005];
    int sum = 0;
    memset(dp, -1, sizeof(dp));
    for (int i = 1; i <= n; i++) {
      scanf("%d", &a[i].left);
      sum += a[i].left;
    }
    for (int i = 1; i <= n; i++) scanf("%d", &a[i].volume);
    int cnt = 0;
    int total = 0;
    sort(a + 1, a + 1 + n, cmp);
    for (int i = 1; i <= n; i++) {
      total += a[i].volume;
      if (total >= sum) {
        cnt = i;
        break;
      }
    }
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = sum; (j - a[i].left) >= 0; j--) {
        for (int k = i; k >= 1; k--) {
          if (dp[k - 1][j - a[i].left] != -1)
            dp[k][j] = max(dp[k][j], dp[k - 1][j - a[i].left] + a[i].volume);
        }
      }
    }
    int ans = 0;
    for (int i = sum; i >= 1; i--) {
      if (dp[cnt][i] >= sum) {
        ans = sum - i;
        break;
      }
    }
    printf("%d %d\n", cnt, ans);
  }
}
