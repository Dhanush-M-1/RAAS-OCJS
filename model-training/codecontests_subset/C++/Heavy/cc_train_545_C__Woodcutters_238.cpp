#include <bits/stdc++.h>
using namespace std;
int Set(int mask, int pos) { return mask = mask | (1 << pos); }
bool check(int mask, int pos) { return (bool)(mask & (1 << pos)); }
int dp[200005][2];
int h[200005], x[200005];
int main() {
  ios::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  dp[0][0] = 1, dp[0][1] = 0;
  for (int i = 1; i < n; i++) {
    dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]);
    if (x[i] - h[i] > x[i - 1]) dp[i][0] = dp[i - 1][0] + 1;
    if (x[i] - h[i] > x[i - 1] + h[i - 1])
      dp[i][0] = max(dp[i][0], dp[i - 1][1] + 1);
    if (i == n - 1 || x[i] + h[i] < x[i + 1]) {
      dp[i][1] = max(dp[i - 1][0] + 1, dp[i - 1][1] + 1);
    }
  }
  cout << max(dp[n - 1][0], dp[n - 1][1]) << endl;
  return 0;
}
