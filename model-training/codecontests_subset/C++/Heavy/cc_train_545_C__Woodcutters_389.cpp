#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1e5 + 5;
pair<int, int> arr[MAXN];
int dp[MAXN][2];
int dpL(int i) {
  int x1 = arr[i - 1].first, x = arr[i].first, h1 = arr[i - 1].second,
      h = arr[i].second;
  if (x - x1 <= h) {
    return max(dp[i - 1][0], dp[i - 1][1]);
  }
  if (x - x1 > h + h1) {
    return max(dp[i - 1][0] + 1, dp[i - 1][1] + 1);
  } else {
    return max(dp[i - 1][0] + 1, dp[i - 1][1]);
  }
}
int dpR(int i) {
  if (arr[i + 1].first - arr[i].first > arr[i].second)
    return max(dp[i - 1][0], dp[i - 1][1]) + 1;
  return dp[i][0];
}
int main() {
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> arr[i].first >> arr[i].second;
  }
  if (n == 1) {
    cout << 1 << endl;
    return 0;
  }
  sort(arr, arr + n);
  dp[0][0] = 1;
  dp[0][1] = (arr[1].first - arr[0].first > arr[0].second);
  for (int i = 1; i < n - 1; i++) {
    dp[i][0] = dpL(i);
    dp[i][1] = dpR(i);
  }
  cout << max(dp[n - 2][0], dp[n - 2][1]) + 1 << endl;
}
