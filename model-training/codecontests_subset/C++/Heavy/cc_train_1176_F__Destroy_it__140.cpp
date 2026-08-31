#include <bits/stdc++.h>
using namespace std;
const int maxn = 2e5 + 70;
const int INF = 2.1e9;
const long long inf = 9e18;
const int MOD = 1e9 + 7;
const double eps = 1e-7;
const double PI = acos(-1.0);
int n, m, k;
long long dp[2][10];
int main() {
  while (cin >> n) {
    bool t = 0;
    dp[t][0] = 0;
    for (int i = 1; i < 10; i++) dp[t][i] = -inf;
    for (int i = 0; i < n; i++) {
      scanf("%d", &k);
      vector<int> V[4];
      while (k--) {
        int c, d;
        scanf("%d %d", &c, &d);
        V[c].push_back(d);
      }
      for (int j = 1; j <= 3; j++) {
        sort((V[j]).begin(), (V[j]).end());
        reverse((V[j]).begin(), (V[j]).end());
      }
      memcpy(dp[t ^ 1], dp[t], sizeof(dp[t]));
      int d = 0;
      for (int j = 1; j <= 3; j++)
        if (V[j].size()) d = max(d, V[j][0]);
      for (int j = 0; j < 10; j++) {
        dp[t ^ 1][(j + 1) % 10] =
            max(dp[t ^ 1][(j + 1) % 10], dp[t][j] + d * (j == 9 ? 2 : 1));
      }
      if (V[1].size() >= 2) {
        int d1 = V[1][0], d2 = V[1][1];
        for (int j = 0; j < 10; j++) {
          dp[t ^ 1][(j + 2) % 10] =
              max(dp[t ^ 1][(j + 2) % 10],
                  dp[t][j] + d1 * ((j == 9 || j == 8) ? 2 : 1) + d2);
        }
      }
      if (V[1].size() && V[2].size()) {
        int d1 = V[1][0], d2 = V[2][0];
        if (d1 < d2) swap(d1, d2);
        for (int j = 0; j < 10; j++) {
          dp[t ^ 1][(j + 2) % 10] =
              max(dp[t ^ 1][(j + 2) % 10],
                  dp[t][j] + d1 * ((j == 9 || j == 8) ? 2 : 1) + d2);
        }
      }
      if (V[1].size() >= 3) {
        int d1 = V[1][0], d2 = V[1][1], d3 = V[1][2];
        for (int j = 0; j < 10; j++) {
          dp[t ^ 1][(j + 3) % 10] = max(
              dp[t ^ 1][(j + 3) % 10],
              dp[t][j] + d1 * ((j == 9 || j == 8 || j == 7) ? 2 : 1) + d2 + d3);
        }
      }
      t ^= 1;
    }
    long long ans = 0;
    for (int i = 0; i < 10; i++) {
      ans = max(ans, dp[t][i]);
    }
    printf("%lld\n", ans);
  }
  return 0;
}
