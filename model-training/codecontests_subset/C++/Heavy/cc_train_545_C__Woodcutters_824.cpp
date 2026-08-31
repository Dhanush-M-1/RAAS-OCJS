#include <bits/stdc++.h>
using namespace std;
const int lala = 2e9 + 1;
int max(int a, int b) { return a > b ? a : b; }
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int n;
  pair<int, int> arr[100005];
  int dp[3][100005];
  cin >> n;
  for (int i = 0; i < n; i++) cin >> arr[i].first >> arr[i].second;
  arr[n].first = lala, arr[n].second = 0;
  dp[0][0] = 0;
  dp[1][0] = 1;
  dp[2][0] = arr[0].first + arr[0].second < arr[1].first ? 1 : 0;
  for (int i = 1; i < n; i++) {
    dp[0][i] = max(dp[0][i - 1], max(dp[1][i - 1], dp[2][i - 1]));
    if (arr[i].first - arr[i].second > arr[i - 1].first) {
      if (arr[i].first - arr[i].second > arr[i - 1].first + arr[i - 1].second) {
        dp[1][i] = dp[0][i] + 1;
      } else {
        dp[1][i] = dp[1][i - 1] + 1;
      }
    } else {
      dp[1][i] = dp[0][i];
    }
    if (arr[i].first + arr[i].second < arr[i + 1].first) {
      dp[2][i] = dp[0][i] + 1;
    } else {
      dp[2][i] = dp[0][i];
    }
  }
  cout << max(dp[0][n - 1], max(dp[1][n - 1], dp[2][n - 1])) << endl;
}
