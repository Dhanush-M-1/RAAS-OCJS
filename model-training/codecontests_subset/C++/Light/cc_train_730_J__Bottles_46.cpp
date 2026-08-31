#include <bits/stdc++.h>
using namespace std;
struct node {
  int a, b;
} p[105];
int dp[105][105 * 105];
bool cmp(const node &a, const node &b) { return a.b > b.b; }
int main() {
  int n, sum = 0, tmp, cnt = 0, tol = 0, ans = 0;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &p[i].a), sum += p[i].a;
  for (int i = 1; i <= n; i++) scanf("%d", &p[i].b), tol += p[i].b;
  tmp = sum;
  sort(p + 1, p + 1 + n, cmp);
  for (int i = 1; i <= n; i++) {
    tmp -= p[i].b;
    if (tmp <= 0) {
      cnt = i;
      break;
    }
  }
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = tol; j >= p[i].b; j--) {
      for (int k = i; k > 0; k--) {
        if (dp[k - 1][j - p[i].b] != -1) {
          dp[k][j] = max(dp[k][j], dp[k - 1][j - p[i].b] + p[i].a);
        }
      }
    }
  }
  for (int i = sum; i <= tol; i++) ans = max(ans, dp[cnt][i]);
  printf("%d %d\n", cnt, sum - ans);
  return 0;
}
