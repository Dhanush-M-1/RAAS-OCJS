#include <bits/stdc++.h>
using namespace std;
struct node {
  int a, b;
} bo[111];
bool cmp(node& x, node& y) {
  if (x.b == y.b) return x.a < y.a;
  return x.b > y.b;
}
int n, sum, num, s, dp[111][11111];
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &bo[i].a);
    sum += bo[i].a;
  }
  for (int i = 1; i <= n; i++) {
    scanf("%d", &bo[i].b);
  }
  sort(bo + 1, bo + n + 1, cmp);
  for (int i = 1; i <= n; i++) {
    s += bo[i].b;
    if (s >= sum) {
      num = i;
      break;
    }
  }
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = sum; j >= bo[i].a; j--) {
      for (int k = i - 1; k >= 0; k--) {
        if (dp[k][j - bo[i].a] != -1)
          dp[k + 1][j] = max(dp[k + 1][j], dp[k][j - bo[i].a] + bo[i].b);
      }
    }
  }
  int ans = sum;
  for (int i = sum; i >= 0; i--) {
    if (dp[num][i] >= sum) {
      ans -= i;
      break;
    }
  }
  printf("%d %d\n", num, ans);
  return 0;
}
