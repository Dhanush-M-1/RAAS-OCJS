#include <bits/stdc++.h>
using namespace std;
struct node {
  int a, b;
  bool operator<(const node& r) const { return r.b < b; }
} e[105];
int dp[10005][105];
int main() {
  int n, sum = 0, num = 0, sum2 = 0;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d", &e[i].a);
    sum += e[i].a;
  }
  for (int i = 0; i < n; i++) {
    scanf("%d", &e[i].b);
    sum2 += e[i].b;
  }
  sort(e, e + n);
  for (int i = 0; i < n; i++) {
    num += e[i].b;
    if (num >= sum) {
      num = i + 1;
      break;
    }
  }
  for (int i = sum2; i >= 0; i--) {
    for (int k = num; k >= 0; k--) {
      dp[i][k] = -234723846;
    }
  }
  dp[0][0] = 0;
  for (int i = 0; i < n; i++) {
    for (int k = sum2; k >= e[i].b; k--) {
      for (int j = num; j >= 1; j--) {
        dp[k][j] = max(dp[k][j], dp[k - e[i].b][j - 1] + e[i].a);
      }
    }
  }
  int ans = 0;
  for (int i = sum; i <= sum2; i++) {
    ans = max(ans, dp[i][num]);
  }
  printf("%d %d\n", num, sum - ans);
}
