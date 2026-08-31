#include <bits/stdc++.h>
using namespace std;
const long long oo = 1e18 + 7, mod = 1e9 + 7;
const long long N = 2e5 + 5;
long long n, dp[N][10];
vector<long long> vc[N][4];
signed main() {
  ios_base::sync_with_stdio(0);
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    long long cards;
    cin >> cards;
    for (long long j = 1; j <= cards; j++) {
      long long cost, val;
      cin >> cost >> val;
      vc[i][cost].push_back(val);
    }
  }
  for (long long i = 1; i <= n; i++) {
    for (long long j = 1; j <= 3; j++) {
      while (vc[i][j].size() < (3 / j)) vc[i][j].push_back(-oo);
      sort(vc[i][j].begin(), vc[i][j].end(), greater<long long>());
    }
  }
  for (long long i = 0; i <= n; i++) {
    for (long long j = 0; j < 10; j++) dp[i][j] = -oo;
  }
  dp[0][0] = 0;
  for (long long i = 1; i <= n; i++) {
    for (long long j = 0; j < 10; j++) {
      dp[i][j] = max(dp[i][j], dp[i - 1][j]);
      if (j)
        dp[i][j] =
            max(dp[i][j], dp[i - 1][(j + 9) % 10] +
                              max(max(vc[i][1][0], vc[i][2][0]), vc[i][3][0]));
      if (j >= 2)
        dp[i][j] = max(
            dp[i][j], dp[i - 1][(j + 8) % 10] + max(vc[i][1][0] + vc[i][2][0],
                                                    vc[i][1][0] + vc[i][1][1]));
      if (j >= 3)
        dp[i][j] = max(dp[i][j], dp[i - 1][(j + 7) % 10] + vc[i][1][0] +
                                     vc[i][1][1] + vc[i][1][2]);
    }
    dp[i][0] =
        max(dp[i][0],
            dp[i - 1][9] + max(max(vc[i][1][0], vc[i][2][0]), vc[i][3][0]) * 2);
    dp[i][0] =
        max(dp[i][0], dp[i - 1][8] + max(vc[i][1][0] + vc[i][2][0] +
                                             max(vc[i][1][0], vc[i][2][0]),
                                         vc[i][1][0] * 2 + vc[i][1][1]));
    dp[i][1] =
        max(dp[i][1], dp[i - 1][9] + max(vc[i][1][0] + vc[i][2][0] +
                                             max(vc[i][1][0], vc[i][2][0]),
                                         vc[i][1][0] * 2 + vc[i][1][1]));
    dp[i][0] = max(dp[i][0],
                   dp[i - 1][7] + vc[i][1][0] * 2 + vc[i][1][1] + vc[i][1][2]);
    dp[i][1] = max(dp[i][1],
                   dp[i - 1][8] + vc[i][1][0] * 2 + vc[i][1][1] + vc[i][1][2]);
    dp[i][2] = max(dp[i][2],
                   dp[i - 1][9] + vc[i][1][0] * 2 + vc[i][1][1] + vc[i][1][2]);
    for (long long j = 0; j < 10; j++) dp[i][j] = max(dp[i][j], -oo);
  }
  long long answ = -1;
  for (long long i = 0; i < 10; i++) answ = max(answ, dp[n][i]);
  cout << answ;
}
