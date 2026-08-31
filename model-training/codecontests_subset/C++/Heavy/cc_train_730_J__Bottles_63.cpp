#include <bits/stdc++.h>
using namespace std;
int n;
int a[105], b[105];
pair<int, int> dp[105][20006];
bool vis[105][20006];
pair<int, int> solve(int i, int sum) {
  if (i == n + 1)
    return sum >= 0 ? make_pair(0, 0) : make_pair(100000000, 100000000);
  if (vis[i][sum + 10002]) return dp[i][sum + 10002];
  vis[i][sum + 10002] = true;
  pair<int, int> takit = solve(i + 1, sum - a[i]);
  takit.second += a[i];
  pair<int, int> leavit = solve(i + 1, sum + b[i] - a[i]);
  ++leavit.first;
  return dp[i][sum + 10002] = min(takit, leavit);
}
int main(int argc, const char* argv[]) {
  scanf("%d", &n);
  for (int(i) = (1); i <= (int)(n); (i)++) scanf("%d", &a[i]);
  for (int(i) = (1); i <= (int)(n); (i)++) scanf("%d", &b[i]);
  memset(dp, -1, sizeof dp);
  pair<int, int> ans = solve(1, 0);
  printf("%d %d\n", ans.first, ans.second);
  return 0;
}
