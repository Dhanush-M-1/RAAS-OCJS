#include <bits/stdc++.h>
using namespace std;
const long long MAXN = 2e5 + 5;
long long dp[MAXN][11];
long long dp2[5][2];
vector<long long> cards[MAXN][5];
int main() {
  long long n;
  cin >> n;
  for (long long i = 0; i <= n; i++) {
    for (long long j = 0; j < 10; j++) {
      dp[i][j] = -1e18;
    }
  }
  dp[0][0] = 0;
  for (long long i = 0; i < n; i++) {
    long long k;
    cin >> k;
    for (long long j = 0; j < k; j++) {
      long long x, y;
      cin >> x >> y;
      cards[i][x].push_back(y);
    }
  }
  for (long long i = 0; i < n; i++) {
    for (long long j = 1; j <= 3; j++) {
      long long s;
      if (j == 1) {
        s = 3;
      } else {
        s = 1;
      }
      sort(cards[i][j].begin(), cards[i][j].end());
      reverse(cards[i][j].begin(), cards[i][j].end());
      while (cards[i][j].size() > s) {
        cards[i][j].pop_back();
      }
    }
  }
  for (long long i = 0; i < n; i++) {
    for (long long j = 0; j < 4; j++) {
      for (long long k = 0; k < 2; k++) {
        dp2[j][k] = -1e18;
      }
    }
    dp2[0][0] = 0;
    vector<pair<long long, long long>> curr;
    for (long long j = 1; j <= 3; j++) {
      for (auto x : cards[i][j]) {
        curr.push_back(make_pair(j, x));
      }
    }
    sort(curr.begin(), curr.end());
    do {
      long long lim = 3;
      long long score = 0;
      long long mx = 0;
      long long cnt = 0;
      for (auto x : curr) {
        cnt++;
        if (lim < x.first) {
          break;
        }
        lim -= x.first;
        mx = max(mx, x.second);
        score += x.second;
        dp2[cnt][0] = max(dp2[cnt][0], score);
        dp2[cnt][1] = max(dp2[cnt][1], score + mx);
      }
    } while (next_permutation(curr.begin(), curr.end()));
    for (long long j = 0; j < 10; j++) {
      for (long long k = 0; k <= 3; k++) {
        long long nxt = (j + k) % 10;
        long long f = 0;
        if (j + k >= 10) {
          f = 1;
        }
        dp[i + 1][nxt] = max(dp[i + 1][nxt], dp[i][j] + dp2[k][f]);
      }
    }
  }
  long long ans = 0;
  for (long long i = 0; i < 10; i++) {
    ans = max(ans, dp[n][i]);
  }
  cout << ans << endl;
}
