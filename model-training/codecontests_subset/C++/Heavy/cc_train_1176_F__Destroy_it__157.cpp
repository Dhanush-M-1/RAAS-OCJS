#include <bits/stdc++.h>
using namespace std;
bool isrange(int second, int first, int n, int m) {
  if (0 <= second && second < n && 0 <= first && first < m) return true;
  return false;
}
int dy[4] = {1, 0, -1, 0}, dx[4] = {0, 1, 0, -1},
    ddy[8] = {1, 0, -1, 0, 1, 1, -1, -1}, ddx[8] = {0, 1, 0, -1, 1, -1, 1, -1};
bool tmr(long long int a, long long int b) { return a > b; }
const int MAX = 202020;
long long int dp[MAX][10];
int lim = 0;
int main(void) {
  int n;
  scanf("%d", &n);
  memset(dp, -1, sizeof(dp));
  dp[0][0] = 0;
  for (int e = 1; e <= n; e++) {
    int k;
    scanf("%d", &k);
    vector<long long int> v[4];
    for (int p = 0; p < k; p++) {
      int c, d;
      scanf("%d%d", &c, &d);
      v[c].push_back((long long int)d);
    }
    for (int e = 1; e <= 3; e++) sort(v[e].begin(), v[e].end(), tmr);
    pair<long long int, long long int> vv[4][4];
    for (int e = 0; e < 4; e++) {
      for (int p = 1; p < 4; p++) vv[e][p] = make_pair(-1, -1);
    }
    for (int e = 1; e <= 3; e++) {
      if ((int)v[e].size()) {
        vv[1][e] = make_pair(v[e][0], v[e][0]);
      }
    }
    if ((int)v[1].size() >= 2) {
      vv[2][1] = make_pair(v[1][0] + v[1][1], v[1][0]);
    }
    if ((int)v[1].size() && (int)v[2].size()) {
      vv[2][2] = make_pair(v[1][0] + v[2][0], max(v[1][0], v[2][0]));
    }
    if ((int)v[1].size() >= 3) {
      vv[3][1] = make_pair(v[1][0] + v[1][1] + v[1][2], v[1][0]);
    }
    for (int p = 0; p < 10; p++) dp[e][p] = dp[e - 1][p];
    for (int p = 1; p <= 3; p++) {
      for (int q = 1; q <= 3; q++) {
        if (vv[p][q].first == -1) continue;
        for (int r = 0; r < 10; r++) {
          if (dp[e - 1][r] == -1) continue;
          if (r + p >= 10) {
            dp[e][(r + p) % 10] =
                max(dp[e][(r + p) % 10],
                    dp[e - 1][r] + vv[p][q].first + vv[p][q].second);
          } else {
            dp[e][r + p] = max(dp[e][r + p], dp[e - 1][r] + vv[p][q].first);
          }
        }
      }
    }
  }
  long long int ans = -1;
  for (int e = 0; e < 10; e++) ans = max(ans, dp[n][e]);
  printf("%lld\n", ans);
  return 0;
}
