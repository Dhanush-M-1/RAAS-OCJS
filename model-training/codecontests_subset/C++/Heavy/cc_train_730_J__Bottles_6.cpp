#include <bits/stdc++.h>
using namespace std;
bool cmp(int x, int y) { return x > y; }
int n, lft, num, tot, ans;
int a[101], b[101], d[101], dp[101][10001];
int main() {
  cin >> n;
  for (int i = 1; i <= n; i++) cin >> a[i], lft += a[i];
  for (int i = 1; i <= n; i++) cin >> b[i], d[i] = b[i];
  sort(d + 1, d + 1 + n, cmp);
  memset(dp, 128, sizeof(dp));
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    tot += d[i];
    if (tot >= lft) {
      num = i;
      break;
    }
  }
  for (int i = 1; i <= n; i++)
    for (int j = tot; j >= b[i]; j--)
      for (int k = 1; k <= num; k++)
        dp[k][j] = max(dp[k][j], dp[k - 1][j - b[i]] + a[i]);
  for (int i = lft; i <= tot; i++) ans = max(ans, dp[num][i]);
  cout << num << " " << lft - ans << endl;
  return 0;
}
