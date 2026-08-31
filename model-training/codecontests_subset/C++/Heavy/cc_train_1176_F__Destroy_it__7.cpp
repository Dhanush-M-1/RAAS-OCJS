#include <bits/stdc++.h>
using namespace std;
long long int dp[200005][10];
long long int dp1[10];
long long int arr[200005][4];
vector<long long int> vec[200005][4];
bool check(long long int a, long long int b) { return a > b; }
int main() {
  int n;
  cin >> n;
  for (long long int i = 1; i <= n; i++) {
    int k;
    cin >> k;
    for (long long int j = 1; j <= k; j++) {
      long long int a, b;
      cin >> a >> b;
      vec[i][a].push_back(b);
    }
    for (long long int j = 1; j <= 3; j++) {
      sort(vec[i][j].begin(), vec[i][j].end(), check);
    }
  }
  for (long long int i = 0; i <= n; i++) {
    for (long long int j = 0; j <= 9; j++) {
      dp[i][j] = -1e18;
    }
  }
  dp[0][0] = 0;
  for (long long int i = 1; i <= n; i++) {
    for (int j = 0; j <= 9; j++) {
      dp1[j] = -1e18;
      dp1[j] = max(dp1[j], dp[i - 1][j]);
    }
    if (vec[i][3].size() != 0) {
      for (int j = 0; j <= 8; j++) {
        dp1[j + 1] = max(dp1[j + 1], dp[i - 1][j] + vec[i][3][0]);
      }
      dp1[0] = max(dp1[0], dp[i - 1][9] + vec[i][3][0] * 2);
    }
    if (vec[i][2].size() != 0) {
      if (vec[i][1].size() != 0) {
        long long int maxi = max(vec[i][1][0], vec[i][2][0]);
        for (int j = 0; j <= 7; j++) {
          dp1[j + 2] =
              max(dp1[j + 2], dp[i - 1][j] + vec[i][2][0] + vec[i][1][0]);
        }
        dp1[0] = max(dp1[0], dp[i - 1][8] + vec[i][2][0] + vec[i][1][0] + maxi);
        dp1[1] = max(dp1[1], dp[i - 1][9] + vec[i][2][0] + vec[i][1][0] + maxi);
      }
      for (int j = 0; j <= 8; j++) {
        dp1[j + 1] = max(dp1[j + 1], dp[i - 1][j] + vec[i][2][0]);
      }
      dp1[0] = max(dp1[0], dp[i - 1][9] + vec[i][2][0] * 2);
    }
    if (vec[i][1].size() != 0) {
      for (int k = 1;
           k <= min((long long int)3, (long long int)vec[i][1].size()); k++) {
        long long int sum = 0;
        long long int maxi = 0;
        for (long long int j = 0; j < k; j++) {
          sum += vec[i][1][j];
          maxi = max(maxi, vec[i][1][j]);
        }
        for (long long int j = 0; j <= 9; j++) {
          if (j + k >= 10) {
            long long int a = (j + k) % 10;
            dp1[a] = max(dp1[a], dp[i - 1][j] + sum + maxi);
          } else {
            long long int a = (j + k);
            dp1[a] = max(dp1[a], dp[i - 1][j] + sum);
          }
        }
      }
    }
    for (long long int j = 0; j <= 9; j++) {
      if (dp1[j] >= 0) {
        dp[i][j] = dp1[j];
      }
    }
  }
  long long int ans = 0;
  for (long long int i = 0; i <= 9; i++) {
    ans = max(ans, dp[n][i]);
  }
  cout << ans << "\n";
}
