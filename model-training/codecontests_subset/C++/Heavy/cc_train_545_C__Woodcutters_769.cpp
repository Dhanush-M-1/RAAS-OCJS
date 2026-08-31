#include <bits/stdc++.h>
using namespace std;
const int N = 100004;
const int Inf = 1e9 + 7;
int dp[N][4];
pair<int, int> arr[N];
int n;
int h[N], x[N];
int dir[N];
int dfs(int i, int f) {
  if (i == n + 1) return 0;
  if (f == 2)
    if (arr[i].first <= arr[i - 1].first + arr[i - 1].second) return -Inf;
  if (dp[i][f] != -1) return dp[i][f];
  int res = 0;
  if (f == 0 || f == 1) {
    res = max(res, dfs(i + 1, 0));
    if (arr[i].first - arr[i].second > arr[i - 1].first)
      res = max(res, 1 + dfs(i + 1, 1));
    res = max(res, 1 + dfs(i + 1, 2));
  } else {
    res = max(res, dfs(i + 1, 0));
    if (arr[i].first - arr[i].second > arr[i - 1].first + arr[i - 1].second)
      res = max(res, 1 + dfs(i + 1, 1));
    res = max(res, 1 + dfs(i + 1, 2));
  }
  dp[i][f] = res;
  return res;
}
int main() {
  scanf("%d", &n);
  int i;
  for (i = 1; i <= n; i++) {
    scanf("%d %d", &x[i], &h[i]);
    arr[i] = (make_pair(x[i], h[i]));
  }
  memset(dp, -1, sizeof(dp));
  int ans = 1 + dfs(2, 1);
  printf("%d\n", ans);
  return 0;
}
