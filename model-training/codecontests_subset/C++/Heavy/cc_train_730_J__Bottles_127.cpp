#include <bits/stdc++.h>
using namespace std;
int n, dp[105][10005] = {0};
struct node {
  int a, b;
} c[105];
bool cmp(const node &x, const node &y) { return x.b < y.b; }
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &c[i].a);
  for (int i = 1; i <= n; i++) scanf("%d", &c[i].b);
  sort(c + 1, c + n + 1, cmp);
  int sum = 0;
  for (int i = n; i; i--) sum += c[i].a;
  int ans1 = 0, cur = sum;
  for (int i = n; i && cur > 0; i--) {
    ans1++;
    cur -= c[i].b;
  }
  int m = 0;
  for (int i = 1; i <= n; i++) m += c[i].b;
  for (int j = 0; j <= ans1; j++)
    for (int i = 0; i <= m; i++) dp[j][i] = -1;
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = m; j >= c[i].b; j--) {
      for (int k = ans1; k; k--)
        if (dp[k - 1][j - c[i].b] >= 0)
          dp[k][j] = max(dp[k][j], dp[k - 1][j - c[i].b] + c[i].a);
    }
  }
  int ans2 = 0;
  for (int i = sum; i <= m; i++) ans2 = max(ans2, dp[ans1][i]);
  printf("%d %d\n", ans1, sum - ans2);
  return 0;
}
