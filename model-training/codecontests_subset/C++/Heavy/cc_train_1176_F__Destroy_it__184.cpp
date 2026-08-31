#include <bits/stdc++.h>
using namespace std;
const int maxn = 200204;
long long dp[maxn][10];
vector<long long> b[maxn][4];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i < n; i++) {
    int k;
    cin >> k;
    vector<pair<long long, long long>> a(k);
    for (int j = 0; j < k; j++) {
      long long c, x;
      cin >> c >> x;
      a[j] = {x, c};
    }
    sort(a.rbegin(), a.rend());
    for (int j = 0; j < k; j++) {
      if (a[j].second == 1 && int(b[i][1].size()) < 3) {
        b[i][1].push_back(a[j].first);
      }
      if (a[j].second == 2 && int(b[i][2].size()) < 1) {
        b[i][2].push_back(a[j].first);
      }
      if (a[j].second == 3 && int(b[i][3].size()) < 1) {
        b[i][3].push_back(a[j].first);
      }
    }
    sort(b[i][1].rbegin(), b[i][1].rend());
  }
  for (int i = 0; i <= n; i++)
    for (int j = 0; j < 10; j++) dp[i][j] = -1;
  dp[0][0] = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < 10; j++) {
      if (dp[i][j] == -1) {
        continue;
      }
      dp[i + 1][j] = max(dp[i + 1][j], dp[i][j]);
      if (int(b[i][1].size()) > 0) {
        dp[i + 1][(j + 1) % 10] =
            max(dp[i + 1][(j + 1) % 10],
                dp[i][j] + (j + 1 == 10 ? 2 * b[i][1][0] : b[i][1][0]));
      }
      if (int(b[i][1].size()) > 1) {
        dp[i + 1][(j + 2) % 10] =
            max(dp[i + 1][(j + 2) % 10],
                dp[i][j] + (j + 2 >= 10 ? 2 * b[i][1][0] + b[i][1][1]
                                        : b[i][1][0] + b[i][1][1]));
      }
      if (int(b[i][1].size()) > 2) {
        dp[i + 1][(j + 3) % 10] = max(
            dp[i + 1][(j + 3) % 10],
            dp[i][j] + (j + 3 >= 10 ? 2 * b[i][1][0] + b[i][1][1] + +b[i][1][2]
                                    : b[i][1][0] + b[i][1][1] + b[i][1][2]));
      }
      if (int(b[i][2].size()) > 0) {
        dp[i + 1][(j + 1) % 10] =
            max(dp[i + 1][(j + 1) % 10],
                dp[i][j] + (j + 1 == 10 ? 2 * b[i][2][0] : b[i][2][0]));
      }
      if (int(b[i][1].size()) > 0 && int(b[i][2].size()) > 0) {
        dp[i + 1][(j + 2) % 10] =
            max(dp[i + 1][(j + 2) % 10],
                dp[i][j] + (j + 2 >= 10 ? 2 * max(b[i][2][0], b[i][1][0]) +
                                              min(b[i][2][0], b[i][1][0])
                                        : b[i][1][0] + b[i][2][0]));
      }
      if (int(b[i][3].size()) > 0) {
        dp[i + 1][(j + 1) % 10] =
            max(dp[i + 1][(j + 1) % 10],
                dp[i][j] + (j + 1 == 10 ? 2 * b[i][3][0] : b[i][3][0]));
      }
    }
  }
  long long mx = 0;
  for (int i = 0; i < 10; i++) mx = max(mx, dp[n][i]);
  cout << mx;
  return 0;
}
