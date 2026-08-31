#include <bits/stdc++.h>
using namespace std;
const int N = 1e2 + 10, M = 2e4 + 10;
int dp[M][N], a[N], b[N];
int main() {
  int n, sum = 0, mx = 0;
  cin >> n;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    sum += a[i];
  }
  for (int i = 0; i < n; i++) {
    cin >> b[i];
    mx += b[i];
  }
  mx += sum;
  for (int i = 0; i <= n; i++)
    for (int j = 0; j <= mx + 2; j++) dp[j][i] = -1e9;
  for (int i = 0; i <= n; i++) dp[0][i] = 0;
  for (int i = 0; i < n; i++) {
    for (int j = mx; j >= 0; j--) {
      if (j - b[i] < 0) break;
      for (int k = 1; k <= n; k++) {
        if (dp[j - b[i]][k - 1] >= 0)
          dp[j][k] = max(dp[j][k], dp[j - b[i]][k - 1] + a[i]);
      }
    }
  }
  for (int i = mx; i >= 0; i--)
    for (int j = 0; j <= n; j++) dp[i][j] = max(dp[i][j], dp[i + 1][j]);
  for (int i = 0; i <= n; i++)
    if (dp[sum][i] >= 0) {
      cout << i << " " << sum - dp[sum][i] << "\n";
      return 0;
    }
}
