#include <bits/stdc++.h>
using namespace std;
const int N = 110;
const int INF = 0x3f3f3f3f;
struct node {
  int v, r;
  bool operator<(const node& u) const { return v > u.v; }
} a[N];
int dp[110][10010];
int sum[N];
int main() {
  int n, tot = 0, k = 0;
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) scanf("%d", &a[i].r), tot += a[i].r;
  for (int i = 1; i <= n; i++) scanf("%d", &a[i].v);
  sort(a + 1, a + n + 1);
  for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + a[i].v;
  for (int i = 1; i <= n; i++)
    if (sum[i] >= tot) {
      k = i;
      break;
    }
  memset(dp, INF, sizeof(dp));
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++)
    for (int j = min(i - 1, k); j >= 0; j--)
      for (int x = sum[i - 1]; x >= 0; x--) {
        dp[j + 1][x + a[i].v] = min(dp[j][x], dp[j + 1][x + a[i].v]);
        if (dp[j][x] != INF) dp[j][x] += a[i].r;
      }
  int ans = INF;
  for (int i = tot; i <= sum[k]; i++) ans = min(ans, dp[k][i]);
  printf("%d %d\n", k, ans);
  return 0;
}
