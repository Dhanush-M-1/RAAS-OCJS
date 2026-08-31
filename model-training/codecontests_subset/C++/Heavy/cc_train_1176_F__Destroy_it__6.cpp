#include <bits/stdc++.h>
using namespace std;
const int oo = 1e9 + 5;
const int MOD = 1e9;
const long long ooll = 1e18 + 5;
const int N = 2e5 + 5;
const int M = 401;
const int lgN = 18;
vector<long long> play(vector<long long> dp, int x) {
  vector<long long> res(10);
  for (int i = 0; i < 10; ++i) {
    int j = (i < 9) ? (i + 1) : 0;
    res[j] = dp[i] + x + (j == 0 ? x : 0);
  }
  return res;
}
void solve() {
  int n, m, i, j;
  cin >> n;
  vector<long long> dp(10, -ooll);
  dp[0] = 0;
  for (i = 0; i < n; ++i) {
    int k;
    cin >> k;
    vector<vector<int>> v(3);
    for (j = 0; j < k; ++j) {
      int x, y;
      cin >> x >> y;
      v[x - 1].push_back(y);
    }
    for (j = 0; j < 3; ++j)
      if (!v[j].empty()) {
        sort(v[j].begin(), v[j].end(), [](int a, int b) { return a > b; });
      }
    vector<long long> dq(dp.begin(), dp.end());
    if ((int)v[0].size() >= 3) {
      auto now = play(play(play(dp, v[0][0]), v[0][1]), v[0][2]);
      for (int i = 0; i < 10; ++i) dq[i] = max(dq[i], now[i]);
      now = play(play(play(dp, v[0][0]), v[0][2]), v[0][1]);
      for (int i = 0; i < 10; ++i) dq[i] = max(dq[i], now[i]);
      now = play(play(play(dp, v[0][1]), v[0][0]), v[0][2]);
      for (int i = 0; i < 10; ++i) dq[i] = max(dq[i], now[i]);
      now = play(play(play(dp, v[0][1]), v[0][2]), v[0][0]);
      for (int i = 0; i < 10; ++i) dq[i] = max(dq[i], now[i]);
      now = play(play(play(dp, v[0][2]), v[0][0]), v[0][1]);
      for (int i = 0; i < 10; ++i) dq[i] = max(dq[i], now[i]);
      now = play(play(play(dp, v[0][2]), v[0][1]), v[0][0]);
      for (int i = 0; i < 10; ++i) dq[i] = max(dq[i], now[i]);
    }
    if ((int)v[0].size() >= 2) {
      auto now = play(play(dp, v[0][0]), v[0][1]);
      for (int i = 0; i < 10; ++i) dq[i] = max(dq[i], now[i]);
      now = play(play(dp, v[0][1]), v[0][0]);
      for (int i = 0; i < 10; ++i) dq[i] = max(dq[i], now[i]);
    }
    if ((int)v[0].size() >= 1) {
      auto now = play(dp, v[0][0]);
      for (int i = 0; i < 10; ++i) dq[i] = max(dq[i], now[i]);
    }
    if ((int)v[0].size() >= 1 && (int)v[1].size() >= 1) {
      auto now = play(play(dp, v[0][0]), v[1][0]);
      for (int i = 0; i < 10; ++i) dq[i] = max(dq[i], now[i]);
      now = play(play(dp, v[1][0]), v[0][0]);
      for (int i = 0; i < 10; ++i) dq[i] = max(dq[i], now[i]);
    }
    if ((int)v[1].size() >= 1) {
      auto now = play(dp, v[1][0]);
      for (int i = 0; i < 10; ++i) dq[i] = max(dq[i], now[i]);
    }
    if ((int)v[2].size() >= 1) {
      auto now = play(dp, v[2][0]);
      for (int i = 0; i < 10; ++i) dq[i] = max(dq[i], now[i]);
    }
    dp = dq;
  }
  long long ans = -ooll;
  for (auto it : dp) ans = max(ans, it);
  cout << ans << '\n';
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int t = 1;
  for (int tc = 1; tc <= t; ++tc) {
    solve();
  }
  return 0;
}
