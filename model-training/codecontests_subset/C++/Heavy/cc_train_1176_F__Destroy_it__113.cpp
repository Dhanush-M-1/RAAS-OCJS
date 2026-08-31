#include <bits/stdc++.h>
using namespace std;
int main() {
  long long n;
  cin >> n;
  vector<vector<long long> > foo(n);
  for (long long i = 0; i < n; i++) {
    long long k;
    cin >> k;
    vector<long long> bar[3];
    for (long long j = 0; j < k; j++) {
      long long c, d;
      cin >> c;
      cin >> d;
      bar[c - 1].push_back(d);
    }
    if (!bar[0].empty()) sort(bar[0].rbegin(), bar[0].rend());
    if (!bar[1].empty()) bar[1][0] = *max_element(bar[1].begin(), bar[1].end());
    if (!bar[2].empty()) bar[2][0] = *max_element(bar[2].begin(), bar[2].end());
    bar[0].resize(min((long long)bar[0].size(), 3ll));
    bar[1].resize(min((long long)bar[1].size(), 1ll));
    bar[2].resize(min((long long)bar[2].size(), 1ll));
    bar[0].push_back(0);
    bar[1].push_back(0);
    bar[2].push_back(0);
    foo[i].push_back(0);
    foo[i].push_back(max(bar[0][0], max(bar[1][0], bar[2][0])));
    if (bar[0][0]) {
      long long temp = 0;
      if (bar[0][1]) temp = bar[0][0] + bar[0][1];
      if (bar[1][0] != 0) temp = max(temp, bar[0][0] + bar[1][0]);
      if (temp) foo[i].push_back(temp);
    }
    if (bar[0].size() == 4) foo[i].push_back(bar[0][0] + bar[0][1] + bar[0][2]);
    foo[i].push_back(0);
    foo[i].push_back(foo[i][1]);
    foo[i].push_back(max(bar[0][0], bar[1][0]));
    foo[i].push_back(bar[0][0]);
  }
  long long dp[n + 5][11];
  memset(dp, -1, sizeof dp);
  for (long long i = 0; i < foo[0].size() - 4; i++) dp[0][i] = foo[0][i];
  for (long long i = 1; i < n; i++) {
    for (long long j = 0; j < 10; j++) {
      if (dp[i - 1][j] != -1) {
        for (long long k = 0; k < foo[i].size() - 4; k++) {
          if ((j + k) < 10)
            dp[i][(j + k) % 10] =
                max(dp[i][(j + k) % 10], dp[i - 1][j] + foo[i][k]);
          else
            dp[i][(j + k) % 10] =
                max(dp[i][(j + k) % 10],
                    dp[i - 1][j] + foo[i][k] + foo[i][k + foo[i].size() - 4]);
        }
      }
    }
  }
  long long ans = 0;
  for (long long i = 0; i < 10; i++) {
    ans = max(ans, dp[n - 1][i]);
  }
  cout << ans << endl;
}
