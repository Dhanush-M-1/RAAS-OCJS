#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
int dirX[] = {0, -1, 0, 1, -1, 1, -1, 1};
int dirY[] = {-1, 0, 1, 0, 1, -1, -1, 1};
const long long MOD = 998244353;
const long long N = 1e5 + 7;
const long long inf = 1e18 + 5;
long long t, n, m, a, b, k, c = 0, d;
long long x11, x22, y11, y22;
long long dp[N][3];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  ios_base::sync_with_stdio(0);
  cin >> n;
  vector<pair<long long, long long> > v(n);
  for (int i = 0; i < n; i++) cin >> v[i].first >> v[i].second;
  dp[0][0] = 0;
  dp[0][1] = 1;
  dp[0][2] = (v[0].first + v[0].second < v[1].first) ? 1 : 0;
  for (int i = 1; i < n; i++) {
    dp[i][0] = max({dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]});
    dp[i][1] = dp[i][0];
    dp[i][2] = dp[i][0];
    if (v[i].first - v[i].second > v[i - 1].first) {
      dp[i][1] = 1 + max({dp[i - 1][1], dp[i - 1][0]});
    }
    if (v[i].first - v[i].second > v[i - 1].first + v[i - 1].second) {
      dp[i][1] = max({dp[i - 1][2] + 1, dp[i - 1][1], dp[i - 1][0]});
    }
    if (i == n - 1 ||
        (i < n - 1 && v[i + 1].first > v[i].second + v[i].first)) {
      dp[i][2]++;
    }
  }
  cout << max({dp[n - 1][0], dp[n - 1][1], dp[n - 1][2]});
}
