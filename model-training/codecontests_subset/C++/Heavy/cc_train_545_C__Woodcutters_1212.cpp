#include <bits/stdc++.h>
using namespace std;
long long int dp[100100][2], x[100100], h[100100], n;
long long int solve(long long int i, long long int st) {
  if (i == n - 1) return 1;
  if (dp[i][st] != -1) return dp[i][st];
  long long int temp = LLONG_MIN;
  if (st == 0) {
    if (i == 0) {
      temp = max(temp, 1 + solve(i + 1, 0));
    } else {
      if (h[i] < x[i] - x[i - 1]) {
        temp = max(temp, 1 + solve(i + 1, 0));
      } else {
        temp = max(temp, solve(i + 1, 0));
      }
    }
    if (h[i] < x[i + 1] - x[i])
      temp = max(temp, 1 + solve(i + 1, 1));
    else
      temp = max(temp, solve(i + 1, 0));
  } else {
    if (h[i] < x[i] - x[i - 1] - h[i - 1])
      temp = max(temp, 1 + solve(i + 1, 0));
    else
      temp = max(temp, solve(i + 1, 0));
    if (h[i] < x[i + 1] - x[i])
      temp = max(temp, 1 + solve(i + 1, 1));
    else
      temp = max(temp, solve(i + 1, 0));
  }
  return dp[i][st] = temp;
}
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long int i;
  memset(dp, -1, sizeof dp);
  cin >> n;
  for (i = 0; i < n; i++) {
    cin >> x[i] >> h[i];
  }
  cout << solve(0, 0) << "\n";
  return 0;
}
