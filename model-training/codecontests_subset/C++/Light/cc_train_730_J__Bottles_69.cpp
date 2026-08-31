#include <bits/stdc++.h>
using namespace std;
int n, a[102], b[102];
pair<int, int> dp[102][2 * 10002];
bool vis[102][2 * 10002];
pair<int, int> solve(int i, int diff) {
  if (i == n + 1)
    return diff >= 10000 ? pair<int, int>(0, 0) : pair<int, int>(1e9, 1e9);
  if (vis[i][diff]) return dp[i][diff];
  vis[i][diff] = true;
  pair<int, int> take = solve(i + 1, diff - a[i]);
  take.second += a[i];
  pair<int, int> leave = solve(i + 1, diff + b[i] - a[i]);
  ++leave.first;
  return dp[i][diff] = min(take, leave);
}
int main() {
  cin >> n;
  for (int i = (1); i <= (int)(n); ++i) scanf("%d", &a[i]);
  for (int i = (1); i <= (int)(n); ++i) scanf("%d", &b[i]);
  pair<int, int> ans = solve(1, 10000);
  cout << ans.first << " " << ans.second;
}
