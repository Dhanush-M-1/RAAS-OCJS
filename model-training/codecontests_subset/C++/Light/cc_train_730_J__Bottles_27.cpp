#include <bits/stdc++.h>
using namespace std;
bool cmp(pair<int, int> a, pair<int, int> b) { return a.second > b.second; }
pair<int, int> a[105];
int dp2[105][10005];
int dp[105][10005], tot, n;
int solve(int i, int j) {
  if (j < 0) return 100000000;
  if (i == 0) {
    if (j > a[i].second) return dp[i][j] = 100000000;
    dp2[i][j] = (j && 1);
    return dp[i][j] = abs(j - a[i].first);
  }
  if (dp[i][j] != -1) return dp[i][j];
  dp[i][j] = 100000000;
  dp2[i][j] = 100000000;
  for (int x = 0; x <= a[i].second && x <= j; ++x) {
    int tmp = abs(x - a[i].first) + solve(i - 1, j - x);
    if (dp2[i - 1][j - x] == -1) continue;
    if (dp2[i - 1][j - x] + (x && 1) < dp2[i][j]) {
      dp[i][j] = tmp;
      dp2[i][j] = dp2[i - 1][j - x] + (x && 1);
      continue;
    }
    if (dp2[i - 1][j - x] + (x && 1) == dp2[i][j]) {
      dp[i][j] = min(dp[i][j], tmp);
      continue;
    }
  }
  return dp[i][j];
}
int main() {
  for (int i = 0; i < 105; ++i) {
    for (int j = 0; j < 10005; ++j) {
      dp[i][j] = -1;
      dp2[i][j] = -1;
    }
  }
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) {
    scanf("%d", &a[i].first);
    tot += a[i].first;
  }
  for (int i = 0; i < n; ++i) scanf("%d", &a[i].second);
  sort(a, a + n, cmp);
  solve(n - 1, tot);
  printf("%d %d\n", dp2[n - 1][tot], dp[n - 1][tot] / 2);
  return 0;
}
