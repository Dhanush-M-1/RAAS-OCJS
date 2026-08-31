#include <bits/stdc++.h>
using namespace std;
long long int dp[int(2e5 + 100)][10];
long long int sz[] = {0, 3, 1, 1};
int main() {
  long long int n, k, c, d, sum, m;
  vector<long long int> v[4];
  cin >> n;
  for (long long int j = 1; j < 10; j++) dp[0][j] = INT_MIN;
  for (long long int i = 1; i <= n; i++) {
    cin >> k;
    for (long long int j = 0; j < 10; j++) dp[i][j] = dp[i - 1][j];
    while (k--) {
      cin >> c >> d;
      v[c].push_back(d);
    }
    for (long long int j = 1; j <= 3; j++) {
      sort(v[j].begin(), v[j].end(), greater<long long int>());
      while (v[j].size() > sz[j]) v[j].pop_back();
    }
    if (v[1].size() == 3) {
      sum = v[1][0] + v[1][1] + v[1][2];
      m = v[1][0];
      for (long long int j = 0; j < 10; j++) {
        if (dp[i - 1][j] == INT_MIN) continue;
        if (j + 3 < 10)
          dp[i][j + 3] = max(dp[i][j + 3], sum + dp[i - 1][j]);
        else
          dp[i][(j + 3) % 10] =
              max(dp[i][(j + 3) % 10], sum + dp[i - 1][j] + m);
      }
    }
    if (v[1].size() > 1 || (v[2].size() == 1 && v[1].size())) {
      sum = m = 0;
      if (v[2].size() == 1 && v[1].size()) {
        sum = v[2][0] + v[1][0];
        m = max(v[2][0], v[1][0]);
      }
      if (v[1].size() > 1 && sum < v[1][0] + v[1][1]) {
        sum = v[1][0] + v[1][1];
        m = v[1][0];
      }
      for (long long int j = 0; j < 10; j++) {
        if (dp[i - 1][j] == INT_MIN) continue;
        if (j + 2 < 10)
          dp[i][j + 2] = max(dp[i][j + 2], sum + dp[i - 1][j]);
        else
          dp[i][(j + 2) % 10] =
              max(dp[i][(j + 2) % 10], sum + dp[i - 1][j] + m);
      }
    }
    if (v[3].size() || v[2].size() || v[1].size()) {
      sum = max(((v[1].size() == 0) ? 0 : v[1][0]),
                max(((v[2].size() == 0) ? 0 : v[2][0]),
                    ((v[3].size() == 0) ? 0 : v[3][0])));
      m = sum;
      for (long long int j = 0; j < 10; j++) {
        if (dp[i - 1][j] == INT_MIN) continue;
        if (j + 1 < 10)
          dp[i][j + 1] = max(dp[i][j + 1], sum + dp[i - 1][j]);
        else
          dp[i][(j + 1) % 10] =
              max(dp[i][(j + 1) % 10], sum + dp[i - 1][j] + m);
      }
    }
    for (long long int j = 1; j <= 3; j++) v[j].clear();
  }
  cout << *max_element(dp[n], dp[n] + 10) << endl;
}
