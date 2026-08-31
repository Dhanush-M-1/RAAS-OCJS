#include <bits/stdc++.h>
using namespace std;
const int N = 2 * 100 * 1000 + 10;
long long dp[12][N];
int main() {
  int n;
  cin >> n;
  for (int i = 1; i < 10; i++) dp[i][0] = -1LL * 1e18;
  long long ans = 0;
  for (int i = 1; i < n + 1; i++) {
    int t;
    cin >> t;
    vector<long long> vec[3];
    for (int j = 0; j < t; j++) {
      int a, b;
      cin >> a >> b;
      vec[a - 1].push_back(b);
    }
    for (int j = 0; j < 3; j++)
      sort(vec[j].begin(), vec[j].end(), greater<long long>());
    for (int j = 0; j < 10; j++) {
      dp[j][i] = dp[j][i - 1];
      for (int k = 0; k < 3; k++)
        if ((int)vec[k].size()) {
          if (j != 0)
            dp[j][i] =
                max(dp[j][i], (i ? dp[(j + 9) % 10][i - 1] : 0) + vec[k][0]);
          else
            dp[j][i] = max(dp[j][i],
                           (i ? dp[(j + 9) % 10][i - 1] : 0) + 2 * vec[k][0]);
        }
      if ((int)vec[0].size() >= 3) {
        if (j > 2)
          dp[j][i] = max(dp[j][i], (i ? dp[(j + 7) % 10][i - 1] : 0) +
                                       vec[0][0] + vec[0][1] + vec[0][2]);
        else
          dp[j][i] = max(dp[j][i], (i ? dp[(j + 7) % 10][i - 1] : 0) +
                                       2 * vec[0][0] + vec[0][1] + vec[0][2]);
      }
      if ((int)vec[0].size() >= 2) {
        if (j > 1)
          dp[j][i] = max(dp[j][i], (i ? dp[(j + 8) % 10][i - 1] : 0) +
                                       vec[0][0] + vec[0][1]);
        else
          dp[j][i] = max(dp[j][i], (i ? dp[(j + 8) % 10][i - 1] : 0) +
                                       2 * vec[0][0] + vec[0][1]);
      }
      if ((int)vec[0].size() && (int)vec[1].size()) {
        if (j > 1)
          dp[j][i] = max(dp[j][i], (i ? dp[(j + 8) % 10][i - 1] : 0) +
                                       vec[0][0] + vec[1][0]);
        else
          dp[j][i] =
              max(dp[j][i], (i ? dp[(j + 8) % 10][i - 1] : 0) + vec[0][0] +
                                vec[1][0] + max(vec[0][0], vec[1][0]));
      }
      ans = max(ans, dp[j][i]);
    }
  }
  cout << ans << endl;
  return 0;
}
