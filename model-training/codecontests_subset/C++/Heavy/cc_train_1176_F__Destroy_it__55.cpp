#include <bits/stdc++.h>
using namespace std;
const long long inf = 4e18;
int n;
long long dp[2][10];
vector<long long> a[3];
int main() {
  ios_base::sync_with_stdio(false);
  cout.tie(0);
  cin.tie(0);
  cin >> n;
  for (int i = 1; i < 10; ++i) dp[0][i] = -inf;
  for (int i = 0; i < n; ++i) {
    int k;
    cin >> k;
    for (int i = 0; i < 3; ++i) a[i].clear();
    for (int i = 0; i < k; ++i) {
      int c;
      long long d;
      cin >> c >> d;
      --c;
      a[c].push_back(d);
    }
    a[0].push_back(0);
    a[0].push_back(0);
    a[1].push_back(0);
    a[2].push_back(0);
    for (int i = 0; i < 3; ++i)
      sort(a[i].begin(), a[i].end(), greater<long long>());
    for (int j = 0; j < 10; ++j) dp[i & 1 ^ 1][j] = dp[i & 1][j];
    long long dmg1, dmg2, dmg3;
    dmg1 = max({a[0][0], a[1][0], a[2][0]});
    for (int j = 0; j < 9; ++j)
      dp[i & 1 ^ 1][j + 1] = max(dp[i & 1 ^ 1][j + 1], dp[i & 1][j] + dmg1);
    dp[i & 1 ^ 1][0] = max(dp[i & 1 ^ 1][0], dp[i & 1][9] + 2 * dmg1);
    if (a[0].size() - 2 + a[1].size() - 1 >= 2 && a[0].size() - 2 >= 1) {
      dmg1 = max(a[0][0], a[1][0]);
      dmg2 = max(min(a[0][0], a[1][0]), a[0][1]);
      for (int j = 0; j < 8; ++j)
        dp[i & 1 ^ 1][j + 2] =
            max(dp[i & 1 ^ 1][j + 2], dp[i & 1][j] + dmg1 + dmg2);
      dp[i & 1 ^ 1][0] = max(dp[i & 1 ^ 1][0], dp[i & 1][8] + 2 * dmg1 + dmg2);
      dp[i & 1 ^ 1][1] = max(dp[i & 1 ^ 1][1], dp[i & 1][9] + 2 * dmg1 + dmg2);
    }
    if (a[0].size() - 2 >= 3) {
      dmg1 = a[0][0];
      dmg2 = a[0][1];
      dmg3 = a[0][2];
      for (int j = 0; j < 7; ++j)
        dp[i & 1 ^ 1][j + 3] =
            max(dp[i & 1 ^ 1][j + 3], dp[i & 1][j] + dmg1 + dmg2 + dmg3);
      dp[i & 1 ^ 1][0] =
          max(dp[i & 1 ^ 1][0], dp[i & 1][7] + 2 * dmg1 + dmg2 + dmg3);
      dp[i & 1 ^ 1][1] =
          max(dp[i & 1 ^ 1][1], dp[i & 1][8] + 2 * dmg1 + dmg2 + dmg3);
      dp[i & 1 ^ 1][2] =
          max(dp[i & 1 ^ 1][2], dp[i & 1][9] + 2 * dmg1 + dmg2 + dmg3);
    }
  }
  long long ans = dp[n & 1][0];
  for (int i = 1; i < 10; ++i) ans = max(ans, dp[n & 1][i]);
  cout << ans << '\n';
}
