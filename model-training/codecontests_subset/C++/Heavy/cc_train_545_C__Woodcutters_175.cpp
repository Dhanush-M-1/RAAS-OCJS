#include <bits/stdc++.h>
using namespace std;
const double pi = 3.14159265358979323846;
const long long int NO = 1000001;
bool compare(pair<long long int, long long int> A,
             pair<long long int, long long int> B) {
  return A.first < B.first;
}
long long int solve() {
  long long int n;
  cin >> n;
  pair<long long int, long long int> arr[n];
  for (long long int i = 0; i < n; i++) {
    long long int x, h;
    cin >> x >> h;
    arr[i].first = x;
    arr[i].second = h;
  }
  if (n < 3) return n;
  sort(arr, arr + n, compare);
  long long int dp[3][n];
  dp[0][0] = 0;
  dp[1][0] = 1;
  dp[2][0] = 0;
  if (arr[1].first >= arr[0].first + arr[0].second) {
    dp[2][0] = 1;
  }
  for (long long int i = 1; i < n - 1; i++) {
    dp[0][i] = max(dp[0][i - 1], max(dp[1][i - 1], dp[2][i - 1]));
    dp[1][i] = dp[0][i];
    dp[2][i] = dp[0][i];
    if (arr[i].first - arr[i].second > arr[i - 1].first) {
      dp[1][i] = max(dp[1][i], dp[1][i - 1] + 1);
      if (arr[i].first - arr[i].second >
          (arr[i - 1].first + arr[i - 1].second)) {
        dp[1][i] = max(dp[1][i], dp[2][i - 1] + 1);
      }
    }
    if (arr[i].first + arr[i].second < arr[i + 1].first) {
      dp[2][i] = max(dp[2][i], max(dp[1][i - 1], dp[2][i - 1]) + 1);
    }
  }
  return max(dp[0][n - 2], max(dp[1][n - 2], dp[2][n - 2])) + 1;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long int t = 1;
  for (long long int w = 1; w <= t; w++) {
    long long int num = solve();
    cout << num << "\n";
  }
  return 0;
}
