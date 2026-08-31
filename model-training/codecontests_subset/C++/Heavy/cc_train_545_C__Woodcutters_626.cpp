#include <bits/stdc++.h>
using namespace std;
const int maxn = 1e5 + 7;
pair<int, int> p[maxn];
int dp[maxn][3];
int n;
void start() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
}
void init() { memset(dp, 0, sizeof(dp)); }
void read() {
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> p[i].first >> p[i].second;
  }
}
void solve() {
  sort(p, p + n);
  for (int i = 1; i <= n; i++) {
    dp[i][1] = max(dp[i - 1][1], max(dp[i - 1][0], dp[i - 1][2]));
    if (i == 1 || p[i].first - p[i - 1].first > p[i].second)
      dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]) + 1;
    if (p[i].first - p[i - 1].first > p[i].second + p[i - 1].second)
      dp[i][0] = max(dp[i - 1][2] + 1, dp[i][0]);
    if (i == n || p[i].first + p[i].second < p[i + 1].first)
      dp[i][2] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2])) + 1;
  }
  cout << max(dp[n][0], max(dp[n][1], dp[n][2])) << endl;
}
void AC() {
  start();
  init();
  read();
  solve();
}
int main() {
  AC();
  return 0;
}
