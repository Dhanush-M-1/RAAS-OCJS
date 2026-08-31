#include <bits/stdc++.h>
using namespace std;
int n;
int x[100000 + 10], h[100000 + 10];
int dp[100000 + 10][2];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) cin >> x[i] >> h[i];
  dp[0][0] = 1;
  if (x[0] + h[0] < x[1]) dp[0][1] = 1;
  for (int i = 1; i <= n - 1; i++) {
    int x1, x2;
    x1 = dp[i - 1][0];
    x2 = dp[i - 1][1];
    if (x[i] - h[i] > x[i - 1]) x1++;
    if (x[i] - h[i] > x[i - 1] + h[i - 1]) x2++;
    dp[i][0] = max(x1, x2);
    x1 = dp[i - 1][0];
    x2 = dp[i - 1][1];
    int t = max(x1, x2);
    if (i == n - 1 || x[i] + h[i] < x[i + 1]) t++;
    dp[i][1] = t;
  }
  cout << max(dp[n - 1][0], dp[n - 1][1]) << endl;
  return 0;
}
