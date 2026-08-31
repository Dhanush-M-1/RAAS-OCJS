#include <bits/stdc++.h>
#pragma comment(linker, "/STACK:167772160000")
using namespace std;
pair<int, int> bottles[110];
int totAmount;
pair<int, int> dp[110][11000];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i < (n); i++) {
    cin >> bottles[i].second;
  }
  for (int i = 0; i < (n); i++) cin >> bottles[i].first;
  for (int i = 0; i < (n + 1); i++)
    for (int j = 0; j < (11000); j++) dp[i][j] = pair<int, int>(1E8, 1E8);
  dp[0][0] = pair<int, int>(0, 0);
  for (int i = 0; i < (n); i++) {
    totAmount += bottles[i].second;
    for (int j = 0; j < (11000); j++) {
      dp[i + 1][j] = min(dp[i][j], dp[i + 1][j]);
      for (int k = 0; k <= bottles[i].first; k++) {
        if (k <= bottles[i].second)
          dp[i + 1][j + k] =
              min(dp[i + 1][j + k],
                  pair<int, int>(dp[i][j].first + 1, dp[i][j].second));
        else
          dp[i + 1][j + k] =
              min(dp[i + 1][j + k],
                  pair<int, int>(dp[i][j].first + 1,
                                 dp[i][j].second + k - bottles[i].second));
      }
    }
  }
  cout << dp[n][totAmount].first << " " << dp[n][totAmount].second << endl;
  return 0;
}
