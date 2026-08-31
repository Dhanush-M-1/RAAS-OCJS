#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cout.tie(NULL);
  cin.tie(NULL);
  long long n;
  cin >> n;
  vector<vector<long long>> dp(n + 1, vector<long long>(10, -1));
  dp[0][0] = 0;
  for (int i = 1; i <= n; i += 1) {
    for (int j = 0; j < 10; j += 1) {
      dp[i][j] = dp[i - 1][j];
    }
    long long k;
    cin >> k;
    vector<pair<long long, long long>> v1[3];
    for (int j = 0; j < k; j += 1) {
      int a, b;
      cin >> a >> b;
      v1[a - 1].push_back({a, b});
    }
    for (int j = 0; j < 3; j += 1) {
      sort(v1[j].rbegin(), v1[j].rend());
    }
    vector<pair<long long, long long>> p;
    for (int j = 0; j < min((int)v1[0].size(), 3); j += 1) {
      p.push_back(v1[0][j]);
    }
    if (v1[1].size()) {
      p.push_back(v1[1][0]);
    }
    if (v1[2].size()) {
      p.push_back(v1[2][0]);
    }
    for (int j = 0; j < 10; j += 1) {
      if (dp[i - 1][j] == -1) {
        continue;
      }
      long long val = dp[i - 1][j], cnt = 0;
      for (int ii = 0; ii < p.size(); ii += 1) {
        long long maxi = p[ii].second;
        val += p[ii].second;
        cnt += p[ii].first;
        if (j == 9) {
          dp[i][0] = max(dp[i][0], val + maxi);
        } else {
          dp[i][j + 1] = max(dp[i][j + 1], val);
        }
        for (int jj = ii + 1; jj < p.size(); jj += 1) {
          long long pre = maxi;
          maxi = max(maxi, p[jj].second);
          val += p[jj].second;
          cnt += p[jj].first;
          if (cnt <= 3) {
            if (j == 8) {
              dp[i][0] = max(dp[i][0], val + maxi);
            } else if (j == 9) {
              dp[i][1] = max(dp[i][1], val + maxi);
            } else {
              dp[i][j + 2] = max(dp[i][j + 2], val);
            }
          }
          for (int kk = jj + 1; kk < p.size(); kk += 1) {
            long long pree = maxi;
            maxi = max(maxi, p[kk].second);
            val += p[kk].second;
            cnt += p[kk].first;
            if (cnt <= 3) {
              if (j == 7) {
                dp[i][0] = max(dp[i][0], val + maxi);
              } else if (j == 8) {
                dp[i][1] = max(dp[i][1], val + maxi);
              } else if (j == 9) {
                dp[i][2] = max(dp[i][2], val + maxi);
              } else {
                dp[i][j + 3] = max(dp[i][j + 3], val);
              }
            }
            val -= p[kk].second;
            cnt -= p[kk].first;
            maxi = pree;
          }
          val -= p[jj].second;
          cnt -= p[jj].first;
          maxi = pre;
        }
        val -= p[ii].second;
        cnt -= p[ii].first;
      }
    }
  }
  long long ans = 0;
  for (int i = 0; i < 10; i += 1) {
    ans = max(ans, dp[n][i]);
  }
  cout << ans;
}
