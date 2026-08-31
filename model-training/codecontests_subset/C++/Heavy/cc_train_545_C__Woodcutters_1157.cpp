#include <bits/stdc++.h>
using namespace std;
int knock(vector<long long int> &positions, vector<long long int> &heights,
          int n) {
  vector<vector<int>> dp(3, vector<int>(n, 0));
  dp[0][0] = 1;
  dp[1][0] = 0;
  dp[2][0] = positions[0] + heights[0] < positions[1] ? 1 : 0;
  for (int i = 1; i < n; i++) {
    if (positions[i] - heights[i] > positions[i - 1]) {
      dp[0][i] = max(dp[0][i - 1], dp[1][i - 1]) + 1;
    }
    if (positions[i] - heights[i] > positions[i - 1] + heights[i - 1]) {
      dp[0][i] = max(dp[0][i], dp[2][i - 1] + 1);
    }
    dp[1][i] = max(dp[0][i - 1], max(dp[1][i - 1], dp[2][i - 1]));
    if (i == n - 1 || (positions[i] + heights[i] < positions[i + 1])) {
      dp[2][i] = max(dp[0][i - 1], max(dp[1][i - 1], dp[2][i - 1])) + 1;
    }
  }
  return max(dp[0][n - 1], max(dp[1][n - 1], dp[2][n - 1]));
}
int main() {
  int n;
  cin >> n;
  vector<long long int> positions, heights;
  for (int i = 0; i < n; i++) {
    long long int x, h;
    cin >> x >> h;
    positions.push_back(x);
    heights.push_back(h);
  }
  cout << knock(positions, heights, n);
  return 0;
}
