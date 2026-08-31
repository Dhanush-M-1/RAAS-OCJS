#include <bits/stdc++.h>
using namespace std;
int readint() {
  int x;
  scanf("%d", &x);
  return x;
}
int dp[10005][105];
int main() {
  int n = readint();
  vector<int> a(n + 1), b(n + 1);
  vector<int> c(n + 1);
  int sum = 0;
  for (int i = 1; i <= n; i++) a[i] = readint(), sum += a[i];
  for (int i = 1; i <= n; i++) b[i] = readint(), c[i] = b[i];
  sort(c.begin(), c.end());
  reverse(c.begin() + 1, c.end());
  for (int i = 1; i <= n; i++) c[i] = c[i - 1] + c[i];
  int k = lower_bound(c.begin(), c.end(), sum) - c.begin();
  cout << k << ' ';
  memset(dp, 128, sizeof dp);
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++)
    for (int j = c[k]; j >= b[i]; j--)
      for (int kk = 1; kk <= k; kk++)
        dp[j][kk] = max(dp[j][kk], dp[j - b[i]][kk - 1] + a[i]);
  int ans = -1;
  for (int i = sum; i <= c[k]; i++) ans = max(ans, dp[i][k]);
  cout << sum - ans;
}
