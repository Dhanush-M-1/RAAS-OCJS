#include <bits/stdc++.h>
using namespace std;
int n, a[105], b[105], dp[105][10005], suma, sumb, ans;
int main() {
  scanf("%d", &n);
  for (int i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    suma += a[i];
  }
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &b[i]);
    sumb += b[i];
  }
  for (int i = 1; i <= n; i++) {
    for (int j = sumb; j >= b[i]; j--) {
      for (int k = i; k > 0; k--) {
        if (j == b[i] || dp[k - 1][j - b[i]]) {
          dp[k][j] = max(dp[k][j], dp[k - 1][j - b[i]] + a[i]);
        }
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    ans = 100005;
    for (int j = suma; j <= sumb; j++) {
      if (dp[i][j]) {
        ans = min(ans, suma - dp[i][j]);
      }
    }
    if (ans < 100005) {
      printf("%d %d", i, ans);
      return 0;
    }
  }
}
