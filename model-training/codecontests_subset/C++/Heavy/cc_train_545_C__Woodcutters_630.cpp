#include <bits/stdc++.h>
using namespace std;
const int maxn = 100000 + 10;
const int inf = 0x3f3f3f3f;
const double eps = 1e-8;
const double pi = acos(-1.0);
const double ee = exp(1.0);
struct Tree {
  int x, h;
} tree[maxn];
int dp[maxn][5];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    scanf("%d%d", &tree[i].x, &tree[i].h);
  }
  tree[n].x = 2000000010, tree[n].h = 2000000010;
  dp[0][0] = 1;
  dp[0][2] = 0;
  if (tree[0].x + tree[0].h < tree[1].x)
    dp[0][1] = 1;
  else
    dp[0][1] = 0;
  for (int i = 1; i < n; i++) {
    dp[i][2] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2]));
    if (tree[i].x + tree[i].h < tree[i + 1].x) {
      dp[i][1] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2])) + 1;
    }
    if (tree[i].x - tree[i].h <= tree[i - 1].x) {
      dp[i][0] = dp[i][2];
    } else if (tree[i].x - tree[i].h <= tree[i - 1].x + tree[i - 1].h) {
      dp[i][0] = max(dp[i - 1][1], max(dp[i - 1][0] + 1, dp[i - 1][2] + 1));
    } else {
      dp[i][0] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2])) + 1;
    }
  }
  int ans = max(dp[n - 1][0], max(dp[n - 1][1], dp[n - 1][2]));
  printf("%d\n", ans);
  return 0;
}
