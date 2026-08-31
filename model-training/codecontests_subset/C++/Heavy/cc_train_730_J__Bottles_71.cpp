#include <bits/stdc++.h>
using namespace std;
const int N = 100 + 10;
const int M = 100 * 100 + 10;
int n, a[N], b[N];
int dp[M], maxw[M];
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  int sum = 0, total = 0;
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
    sum += a[i];
  }
  for (int i = 0; i < n; ++i) {
    cin >> b[i];
    total += b[i];
  }
  memset(dp, -1, sizeof dp);
  memset(maxw, 0, sizeof maxw);
  dp[0] = maxw[0] = 0;
  for (int i = 0; i < n; ++i) {
    for (int k = total; k >= b[i]; --k) {
      if (dp[k - b[i]] != -1) {
        if (dp[k] == -1) {
          dp[k] = dp[k - b[i]] + 1;
          maxw[k] = maxw[k - b[i]] + a[i];
        } else {
          if (dp[k] > dp[k - b[i]] + 1) {
            dp[k] = dp[k - b[i]] + 1;
            maxw[k] = maxw[k - b[i]] + a[i];
          } else if (dp[k] == dp[k - b[i]] + 1) {
            maxw[k] = max(maxw[k], maxw[k - b[i]] + a[i]);
          }
        }
      }
    }
  }
  int num = 101, maxW = 0;
  for (int k = sum; k <= total; ++k) {
    if (dp[k] != -1) num = min(num, dp[k]);
  }
  for (int k = sum; k <= total; ++k) {
    if (dp[k] == num) maxW = max(maxW, maxw[k]);
  }
  cout << num << " " << sum - maxW << endl;
  return 0;
}
