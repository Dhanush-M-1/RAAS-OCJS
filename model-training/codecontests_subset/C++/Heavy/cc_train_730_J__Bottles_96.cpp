#include <bits/stdc++.h>
using namespace std;
const int N = 105;
int n, a[N], b[N];
pair<int, int> dp[N][N * N];
void init() {
  for (int i = 0; i < N; i++) {
    for (int j = 0; j < N * N; j++) dp[i][j] = {-1, -1};
  }
}
pair<int, int> sum(pair<int, int> p1, pair<int, int> p2) {
  return make_pair(p1.first + p2.first, p1.second + p2.second);
}
pair<int, int> solve(int idx, int rem) {
  if (rem <= 0) return {0, 0};
  if (idx == n) return {(int)1 << 30, (int)1 << 30};
  if (dp[idx][rem] != make_pair(-1, -1)) return dp[idx][rem];
  int mn = min(b[idx] - a[idx], rem - a[idx]);
  return dp[idx][rem] =
             min(sum(solve(idx + 1, rem - mn - a[idx]), make_pair(1, mn)),
                 solve(idx + 1, rem));
}
int main() {
  scanf("%d", &n);
  int tot = 0;
  for (int i = 0; i < n; i++) scanf("%d", &a[i]), tot += a[i];
  for (int i = 0; i < n; i++) scanf("%d", &b[i]);
  init();
  pair<int, int> ans = solve(0, tot);
  printf("%d %d", ans.first, ans.second);
}
