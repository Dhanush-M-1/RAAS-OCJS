#include <bits/stdc++.h>
using namespace std;
int dp[106][10006];
struct bottle {
  int remain, volume;
} f[105];
bool cmp(bottle a, bottle b) {
  if (a.volume != b.volume)
    return a.volume > b.volume;
  else
    return a.remain > b.remain;
}
int main() {
  int n;
  cin >> n;
  int sum1, sum2;
  sum1 = sum2 = 0;
  for (int i = 1; i <= n; i++) {
    cin >> f[i].remain;
    sum1 += f[i].remain;
  }
  for (int i = 1; i <= n; i++) {
    cin >> f[i].volume;
    sum2 += f[i].volume;
  }
  int x = sum1;
  int num = 0;
  sort(f + 1, f + 1 + n, cmp);
  while (1) {
    x -= f[++num].volume;
    if (x <= 0) break;
  }
  for (int i = 0; i <= 105; i++)
    for (int j = 0; j <= 10005; j++) dp[i][j] = -999999;
  dp[0][0] = 0;
  for (int i = 1; i <= n; i++) {
    for (int j = sum2; j >= f[i].volume; j--)
      for (int k = 1; k <= num; k++)
        dp[k][j] = max(dp[k][j], dp[k - 1][j - f[i].volume] + f[i].remain);
  }
  int ans = 0;
  for (int i = sum1; i <= sum2; i++) {
    ans = max(ans, dp[num][i]);
  }
  printf("%d %d\n", num, sum1 - ans);
}
