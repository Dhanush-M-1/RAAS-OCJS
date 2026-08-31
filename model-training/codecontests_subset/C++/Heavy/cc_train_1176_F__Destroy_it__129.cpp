#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ld = long double;
const int N = 2e5 + 10;
vector<int> data[N][3];
ll dp[N][10];
int n;
ll solve(int i, int k) {
  if (i == n) return 0;
  ll &dp = ::dp[i][k];
  if (dp != -1) return dp;
  dp = 0;
  if (data[i][0].size() >= 3) {
    dp = max(dp, solve(i + 1, (k + 3) % 10) + data[i][0].end()[-3] +
                     data[i][0].end()[-2] +
                     data[i][0].end()[-1] * (k >= 7 ? 2 : 1));
    dp = max(dp, solve(i + 1, (k + 2) % 10) + data[i][0].end()[-2] +
                     data[i][0].end()[-1] * (k >= 8 ? 2 : 1));
    dp = max(dp, solve(i + 1, (k + 1) % 10) +
                     data[i][0].end()[-1] * (k == 9 ? 2 : 1));
  } else if (data[i][0].size() >= 2) {
    dp = max(dp, solve(i + 1, (k + 2) % 10) + data[i][0].end()[-2] +
                     data[i][0].end()[-1] * (k >= 8 ? 2 : 1));
    dp = max(dp, solve(i + 1, (k + 1) % 10) +
                     data[i][0].end()[-1] * (k == 9 ? 2 : 1));
  } else if (data[i][0].size() == 1) {
    dp = max(dp, solve(i + 1, (k + 1) % 10) +
                     data[i][0].end()[-1] * (k == 9 ? 2 : 1));
  }
  if (data[i][1].size() >= 1) {
    if (!data[i][0].empty()) {
      int mx = max(data[i][0].back(), data[i][1].back());
      dp = max(dp, solve(i + 1, (k + 2) % 10) + data[i][0].back() +
                       data[i][1].back() - mx + mx * (k >= 8 ? 2 : 1));
    }
    dp = max(dp,
             solve(i + 1, (k + 1) % 10) + data[i][1].back() * (k == 9 ? 2 : 1));
  }
  if (data[i][2].size() >= 1)
    dp = max(dp,
             solve(i + 1, (k + 1) % 10) + data[i][2].back() * (k == 9 ? 2 : 1));
  dp = max(dp, solve(i + 1, k));
  return dp;
}
int main(int argc, char const *argv[]) {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.precision(10);
  cout << fixed;
  cin >> n;
  for (int i = 0; i < n; ++i) {
    int k;
    cin >> k;
    while (k--) {
      int c, d;
      cin >> c >> d;
      data[i][c - 1].push_back(d);
    }
    for (int j = 0; j < 3; ++j) sort(data[i][j].begin(), data[i][j].end());
  }
  memset(dp, -1, sizeof(dp));
  cout << solve(0, 0) << '\n';
  return 0;
}
