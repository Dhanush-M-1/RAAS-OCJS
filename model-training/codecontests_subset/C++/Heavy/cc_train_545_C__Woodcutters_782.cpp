#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e5 + 4;
int x[MAX], h[MAX], n, dp[MAX][3];
int rec(int i, int d) {
  if (dp[i][d] != 0) return dp[i][d];
  if (i == n + 1)
    dp[i][d] = 0;
  else if (d == 1 || d == 0) {
    if (x[i] - h[i] > x[i - 1])
      dp[i][d] = 1 + rec(i + 1, 0);
    else
      dp[i][d] = max(1 + rec(i + 1, 2), rec(i + 1, 1));
  } else {
    if (x[i - 1] + h[i - 1] >= x[i])
      dp[i][d] = INT_MIN;
    else if (x[i] - h[i] > x[i - 1] + h[i - 1])
      dp[i][d] = 1 + rec(i + 1, 0);
    else
      dp[i][d] = max(1 + rec(i + 1, 2), rec(i + 1, 1));
  }
  return dp[i][d];
}
int main() {
  cin >> n;
  x[0] = INT_MIN, h[0] = 0;
  for (int i = 1; i <= n; ++i) {
    cin >> x[i] >> h[i];
  }
  cout << rec(1, 0) << endl;
  return 0;
}
