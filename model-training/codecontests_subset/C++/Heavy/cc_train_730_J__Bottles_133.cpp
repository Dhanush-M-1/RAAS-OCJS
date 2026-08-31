#include <bits/stdc++.h>
using namespace std;
int a[110];
int s[110];
int b[110];
int dp[110][110 * 110];
int main() {
  int n;
  scanf(" %d", &n);
  int total = 0;
  for (int i = 0; i < n; i++) {
    scanf(" %d", &a[i]);
    total += a[i];
  }
  for (int i = 0; i < n; i++) {
    scanf(" %d", &b[i]);
    s[i] = b[i];
  }
  sort(s, s + n, greater<int>());
  int ng = 0, sm = 0;
  while (sm < total) {
    sm += s[ng];
    ng++;
  }
  for (int i = 0; i < n; i++) {
    for (int j = ng - 1; j > 0; j--) {
      for (int k = 110 * 110 - b[i] - 1; k >= 0; k--) {
        if (dp[j][k] > 0) {
          dp[j + 1][k + b[i]] = max(dp[j + 1][k + b[i]], dp[j][k] + a[i]);
        }
      }
    }
    dp[1][b[i]] = max(dp[1][b[i]], a[i]);
  }
  int res = -1;
  for (int i = total; i < 110 * 110; i++) {
    res = max(res, dp[ng][i]);
  }
  printf("%d %d\n", ng, total - res);
  return 0;
}
