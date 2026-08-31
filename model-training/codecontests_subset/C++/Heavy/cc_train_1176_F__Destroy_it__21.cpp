#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  int n;
  cin >> n;
  vector<long long> carry(10, LONG_LONG_MIN);
  carry[0] = 0;
  for (int r = 0; r < n; r++) {
    int k;
    cin >> k;
    vector<vector<vector<long long>>> dp(
        10,
        vector<vector<long long>>(3 + 1, vector<long long>(3, LONG_LONG_MIN)));
    for (int i = 0; i < 10; i++) {
      dp[i][0][0] = carry[i];
    }
    for (int card = 0; card < k; card++) {
      int cost;
      long long dmg;
      cin >> cost >> dmg;
      for (int j = 3; j >= cost; j--) {
        dp[0][j][0] = max(dp[0][j][0], dp[9][j - cost][0] + 2 * dmg);
        dp[0][j][1] = max(dp[0][j][1], dp[9][j - cost][0] + dmg);
        dp[0][j][0] = max(dp[0][j][0], dp[9][j - cost][2] + dmg);
        for (int i = 1; i < 10; i++) {
          dp[i][j][0] = max(dp[i][j][0], dp[i - 1][j - cost][0] + dmg);
          dp[i][j][1] = max(dp[i][j][1], dp[i - 1][j - cost][1] + dmg);
          dp[i][j][2] = max(dp[i][j][2], dp[i - 1][j - cost][2] + dmg);
          dp[i][j][0] = max(dp[i][j][0], dp[i - 1][j - cost][1] + 2 * dmg);
          dp[i][j][2] = max(dp[i][j][2], dp[i - 1][j - cost][0] + 2 * dmg);
        }
      }
    }
    carry.assign(10, LONG_LONG_MIN);
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 3 + 1; j++) {
        carry[i] = max(carry[i], dp[i][j][0]);
      }
    }
  }
  long long result = 0;
  for (int i = 0; i < 10; i++) {
    result = max(result, carry[i]);
  }
  cout << result << endl;
  return 0;
}
