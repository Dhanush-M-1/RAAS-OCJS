#include <bits/stdc++.h>
using namespace std;
long long N, dp[2][10], K[200005], X, Y;
vector<long long> card[200005][4];
vector<pair<long long, long long> > opt[200005];
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cin >> N;
  for (int i = 1; i <= N; ++i) {
    cin >> K[i];
    for (int j = 1; j <= K[i]; ++j) {
      cin >> X >> Y;
      card[i][X].push_back(Y);
    }
    for (int j = 1; j < 4; ++j) {
      sort(card[i][j].begin(), card[i][j].end());
      reverse(card[i][j].begin(), card[i][j].end());
      while (card[i][j].size() > (3 / j)) {
        card[i][j].pop_back();
      }
      for (auto it : card[i][j]) {
        opt[i].push_back(pair<long long, long long>(j, it));
      }
    }
  }
  for (int i = 0; i < 2; ++i) {
    for (int k = 0; k < 10; ++k) {
      dp[i][k] = -1e18;
    }
  }
  dp[0][0] = 0;
  for (int i = 1; i <= N; ++i) {
    for (int j = 0; j < 10; ++j) dp[i & 1][j] = -1e18;
    for (int mask = 0; mask < (1 << (int)opt[i].size()); ++mask) {
      long long totc = 0;
      vector<long long> dmg;
      for (int j = 0; j < opt[i].size(); ++j) {
        if (mask & (1 << j)) {
          totc += opt[i][j].first;
          dmg.push_back(opt[i][j].second);
        }
      }
      if (totc > 3) continue;
      sort(dmg.begin(), dmg.end());
      do {
        for (int m = 0; m < 10; ++m) {
          long long totd = 0;
          for (int j = 0; j < dmg.size(); ++j) {
            int c_count = (m + j + 1) % 10;
            totd += (c_count == 0 ? 2 * dmg[j] : dmg[j]);
          }
          dp[i & 1][(m + dmg.size()) % 10] =
              max(dp[i & 1][(m + dmg.size()) % 10], dp[(i - 1) & 1][m] + totd);
        }
      } while (next_permutation(dmg.begin(), dmg.end()));
    }
  }
  long long ans = 0;
  for (int m = 0; m < 10; ++m) {
    ans = max(ans, dp[N & 1][m]);
  }
  cout << ans << '\n';
}
