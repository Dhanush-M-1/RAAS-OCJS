#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 7;
const int inf = INT_MAX;
const long long inff = 1e18;
const long long mod = 1e9 + 7;
long long n;
long long dp[maxn][12], k, x, y;
vector<long long> _1, _2, _3;
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  cin >> n;
  for (long long i = 0; i <= n; i++) {
    for (long long j = 0; j <= 9; j++) dp[i][j] = -inff;
  }
  dp[0][0] = 0;
  for (long long i = 1; i <= n; i++) {
    cin >> k;
    _1.clear();
    _2.clear();
    _3.clear();
    for (long long j = 1; j <= k; j++) {
      cin >> x >> y;
      if (x == 1)
        _1.push_back(y);
      else if (x == 2)
        _2.push_back(y);
      else
        _3.push_back(y);
    }
    sort((_1).begin(), (_1).end());
    sort((_2).begin(), (_2).end());
    sort((_3).begin(), (_3).end());
    reverse((_1).begin(), (_1).end());
    reverse((_2).begin(), (_2).end());
    reverse((_3).begin(), (_3).end());
    for (long long j = 0; j <= 9; j++) {
      dp[i][j] = dp[i - 1][j];
      if (((long long)(_1).size()) > 0) {
        if (j == 0)
          dp[i][j] = max(dp[i][j], dp[i - 1][(j + 10 - 1) % 10] + _1[0] * 2);
        else
          dp[i][j] = max(dp[i][j], dp[i - 1][(j + 10 - 1) % 10] + _1[0]);
      }
      if (((long long)(_2).size()) > 0) {
        if (j <= 0)
          dp[i][j] = max(dp[i][j], dp[i - 1][(j + 10 - 1) % 10] + _2[0] * 2);
        else
          dp[i][j] = max(dp[i][j], dp[i - 1][(j + 10 - 1) % 10] + _2[0]);
      }
      if (((long long)(_1).size()) >= 2) {
        if (j <= 1)
          dp[i][j] =
              max(dp[i][j], dp[i - 1][(j + 10 - 2) % 10] + _1[0] * 2 + _1[1]);
        else
          dp[i][j] =
              max(dp[i][j], dp[i - 1][(j + 10 - 2) % 10] + _1[0] + _1[1]);
      }
      if (((long long)(_3).size()) >= 1) {
        if (j <= 0)
          dp[i][j] = max(dp[i][j], dp[i - 1][(j + 10 - 1) % 10] + _3[0] * 2);
        else
          dp[i][j] = max(dp[i][j], dp[i - 1][(j + 10 - 1) % 10] + _3[0]);
      }
      if (((long long)(_1).size()) >= 1 && ((long long)(_2).size()) >= 1) {
        if (j <= 1)
          dp[i][j] = max(dp[i][j], dp[i - 1][(j + 10 - 2) % 10] + _1[0] +
                                       _2[0] + max(_1[0], _2[0]));
        else
          dp[i][j] =
              max(dp[i][j], dp[i - 1][(j + 10 - 2) % 10] + _1[0] + _2[0]);
      }
      if (((long long)(_1).size()) >= 3) {
        if (j <= 2)
          dp[i][j] = max(dp[i][j], dp[i - 1][(j + 10 - 3) % 10] + _1[0] * 2 +
                                       _1[1] + _1[2]);
        else
          dp[i][j] = max(dp[i][j],
                         dp[i - 1][(j + 10 - 3) % 10] + _1[0] + _1[1] + _1[2]);
      }
    }
  }
  long long maxx = -1;
  for (long long i = 0; i <= 9; i++) maxx = max(maxx, dp[n][i]);
  cout << maxx << endl;
}
