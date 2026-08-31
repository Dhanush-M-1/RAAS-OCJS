#include <bits/stdc++.h>
using namespace std;
int n, sum;
int dp[105][10005];
struct node {
  int a, b;
} m[105];
bool cmp(node a, node b) {
  if (a.b == b.b) return a.a < b.a;
  return a.b < b.b;
}
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &m[i].a);
    sum += m[i].a;
  }
  for (int i = 1; i <= n; i++) scanf("%d", &m[i].b);
  sort(m + 1, m + n + 1, cmp);
  int ans = 0;
  int ii;
  for (int i = n; i >= 1; i--) {
    ans += m[i].b;
    if (ans >= sum) {
      ii = i;
      printf("%d ", n - i + 1);
      break;
    }
  }
  int nn = n - ii + 1;
  for (int k = 1; k <= n; k++)
    for (int i = min(k, nn); i >= 1; i--) {
      if (i == 1)
        dp[1][m[k].b] = max(dp[1][m[k].b], m[k].a);
      else
        for (int j = 10000; j >= 0; j--) {
          if (dp[i - 1][j] == 0) continue;
          dp[i][j + m[k].b] = max(dp[i - 1][j] + m[k].a, dp[i][j + m[k].b]);
        }
    }
  int anss = 0;
  for (int i = sum; i <= 10000; i++) {
    if (dp[nn][i] > anss) anss = dp[nn][i];
  }
  printf("%d\n", sum - anss);
  return 0;
}
