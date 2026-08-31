#include <bits/stdc++.h>
using namespace std;
int dp[105][10010];
int a[105], b[105];
int main() {
  ios_base::sync_with_stdio(false);
  int i, j, k, n;
  cin >> n;
  for (i = 0; i < n; i++) cin >> a[i];
  for (i = 0; i < n; i++) cin >> b[i];
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  int s, t;
  s = t = 0;
  for (i = 0; i < n; i++) {
    for (j = i; j >= 0; j--) {
      for (k = 0; k <= t; k++) {
        if (dp[j][k] != -1) {
          dp[j + 1][k + b[i]] = max(dp[j + 1][k + b[i]], dp[j][k] + a[i]);
        }
      }
    }
    s += a[i];
    t += b[i];
  }
  sort(b, b + n);
  reverse(b, b + n);
  int ans1, ans2;
  ans1 = k = 0;
  ans2 = 1099999;
  while (k < s) {
    k += b[ans1];
    ans1++;
  }
  for (i = s; i <= t; ++i) ans2 = min(ans2, s - dp[ans1][i]);
  cout << ans1 << " " << ans2 << endl;
  return 0;
}
