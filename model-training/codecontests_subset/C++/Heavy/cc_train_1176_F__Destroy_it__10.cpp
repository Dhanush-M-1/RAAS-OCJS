#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  vector<vector<vector<long long>>> p(n, vector<vector<long long>>(4));
  for (int i = 0; i < n; i++) {
    int k;
    cin >> k;
    for (int j = 0; j < k; j++) {
      int c, d;
      cin >> c >> d;
      p[i][c].push_back(d);
    }
    for (int j = 1; j <= 3; j++)
      sort(p[i][j].begin(), p[i][j].end(), greater<long long>());
  }
  vector<vector<long long>> dp(n + 1, vector<long long>(10, -1e18));
  dp[0][0] = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < 10; j++) {
      if (dp[i][j] < 0) continue;
      for (int i1 = 0; i1 <= 3; i1++) {
        for (int i2 = 0; i2 <= 1; i2++) {
          for (int i3 = 0; i3 <= 1; i3++) {
            if (i1 + i2 * 2 + i3 * 3 > 3) break;
            if (p[i][1].size() < i1) break;
            if (p[i][2].size() < i2) break;
            if (p[i][3].size() < i3) break;
            long long d = 0, c = 0;
            for (int k = 0; k < i1; k++) {
              d += p[i][1][k];
              c = max(c, p[i][1][k]);
            }
            for (int k = 0; k < i2; k++) {
              d += p[i][2][k];
              c = max(c, p[i][2][k]);
            }
            for (int k = 0; k < i3; k++) {
              d += p[i][3][k];
              c = max(c, p[i][3][k]);
            }
            if (i1 + i2 + i3 + j >= 10) d += c;
            dp[i + 1][(i1 + i2 + i3 + j) % 10] =
                max(dp[i + 1][(i1 + i2 + i3 + j) % 10], dp[i][j] + d);
          }
        }
      }
    }
  }
  long long res = 0;
  for (int i = 0; i < 10; i++) res = max(res, dp[n][i]);
  cout << res;
  return 0;
}
