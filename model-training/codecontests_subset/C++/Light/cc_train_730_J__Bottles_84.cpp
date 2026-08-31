#include <bits/stdc++.h>
using namespace std;
pair<int, int> a[105];
int dp[3][103][10005];
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  int tv = 0;
  for (int i = 1; i <= n; i++) {
    cin >> a[i].second;
    tv += a[i].second;
  }
  for (int i = 1; i <= n; i++) cin >> a[i].first;
  sort(a + 1, a + n + 1);
  int tv1 = 0;
  int k;
  for (int i = n; i >= 1; i--) {
    tv1 += a[i].first;
    if (tv1 >= tv) {
      k = n - i + 1;
      break;
    }
  }
  int ans = 0;
  for (int j = 0; j <= k; j++) {
    for (int u = 0; u <= 10000; u++) {
      dp[2][j][u] = -100000000;
    }
  }
  dp[2][0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= k; j++) {
      for (int u = 0; u <= 10000; u++) {
        if (u >= a[i].first) {
          dp[1][j][u] =
              max(dp[2][j][u], dp[2][j - 1][u - a[i].first] + a[i].second);
        } else
          dp[1][j][u] = dp[2][j][u];
        if (j == k && u >= tv) ans = max(ans, dp[1][j][u]);
      }
    }
    for (int j = 1; j <= k; j++) {
      for (int u = 1; u <= 10000; u++) dp[2][j][u] = dp[1][j][u];
    }
  }
  cout << k << '\n';
  cout << tv - ans << '\n';
}
