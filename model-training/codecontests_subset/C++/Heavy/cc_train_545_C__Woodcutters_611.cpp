#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
struct Tree {
  int pos, height;
};
Tree a[N];
int dp[N][3];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i].pos >> a[i].height;
  }
  dp[1][0] = 0;
  dp[1][1] = 1;
  if (a[1].pos + a[1].height < a[2].pos)
    dp[1][2] = 1;
  else
    dp[1][2] = 0;
  for (int i = 2; i <= n; i++) {
    dp[i][0] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2]));
    dp[i][1] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2]));
    dp[i][2] = max(dp[i - 1][0], max(dp[i - 1][1], dp[i - 1][2]));
    if (a[i].pos - a[i].height > a[i - 1].pos)
      dp[i][1] = 1 + max(dp[i - 1][0], dp[i - 1][1]);
    if (a[i].pos - a[i].height > a[i - 1].pos + a[i - 1].height)
      dp[i][1] = max(dp[i][1], 1 + dp[i - 1][2]);
    if (i < n) {
      if (a[i].pos + a[i].height < a[i + 1].pos)
        dp[i][2] = 1 + max(dp[i - 1][2], max(dp[i - 1][0], dp[i - 1][1]));
    } else {
      dp[i][2]++;
    }
  }
  cout << max(dp[n][2], max(dp[n][0], dp[n][1]));
  return 0;
}
