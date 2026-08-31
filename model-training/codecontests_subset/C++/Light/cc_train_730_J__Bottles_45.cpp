#include <bits/stdc++.h>
using namespace std;
int n;
int a[105], b[105];
pair<int, int> memo[105][20005];
pair<int, int> dp(int i, int x) {
  if (i == n)
    return (x < 0 ? pair<int, int>(105, 10002) : pair<int, int>(0, 0));
  if (memo[i][x + 10002] != pair<int, int>(-1, -1)) return memo[i][x + 10002];
  memo[i][x + 10002] = dp(i + 1, x + b[i] - a[i]);
  memo[i][x + 10002].first += 1;
  pair<int, int> tmp = dp(i + 1, x - a[i]);
  tmp.second += a[i];
  if (tmp.first < memo[i][x + 10002].first)
    memo[i][x + 10002] = tmp;
  else if (tmp.first == memo[i][x + 10002].first)
    memo[i][x + 10002].second = min(memo[i][x + 10002].second, tmp.second);
  return memo[i][x + 10002];
}
int main() {
  scanf("%d", &n);
  for (int i = 0; i < n; ++i) scanf("%d", &a[i]);
  for (int i = 0; i < n; ++i) scanf("%d", &b[i]);
  memset(memo, -1, sizeof memo);
  pair<int, int> ans = dp(0, 0);
  printf("%d %d\n", ans.first, ans.second);
}
