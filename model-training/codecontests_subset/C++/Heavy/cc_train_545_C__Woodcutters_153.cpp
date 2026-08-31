#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long int n, x, h, ans = 0;
  long int dp[3][100005];
  cin >> n;
  if (n <= 2) {
    ans = (n == 2) ? 2 : 1;
  } else {
    ans += 2;
    for (int i = 0; i < n; i++) {
      cin >> x >> h;
      dp[0][i] = x - h;
      dp[1][i] = x;
      dp[2][i] = x + h;
    }
    long int pivot = dp[1][0];
    for (int i = 1; i < n - 1; i++) {
      if (pivot < dp[0][i] && dp[1][i - 1] < dp[0][i]) {
        pivot = dp[1][i];
        ans++;
      } else if (dp[2][i] < dp[1][i + 1]) {
        pivot = dp[2][i];
        ans++;
      }
    }
  }
  cout << ans << '\n';
  return 0;
}
