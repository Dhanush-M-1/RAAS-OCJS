#include <bits/stdc++.h>
#pragma GCC optimize("Ofast")
using namespace std;
void P(int x) { cout << x << '\n'; }
void PP(int a, int b) { cout << a << " " << b << '\n'; }
void PV(vector<int> v) {
  int n = (v).size();
  for (auto& i : (v)) cout << i << " ";
  cout << '\n';
}
void PPV(vector<pair<int, int> > v) {
  int n = (v).size();
  for (auto& i : (v)) cout << i.first << " " << i.second << '\n';
}
const long long INF = (1LL << 60);
const int MOD = 1e9 + 7;
const int nax = 2e5 + 5;
const double p = 3.14159265359;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  int n;
  cin >> n;
  vector<pair<int, int> > t(n);
  for (int i = 0; i < n; ++i) {
    cin >> t[i].first >> t[i].second;
  }
  vector<vector<int> > dp(2, vector<int>(n, 0));
  dp[0][0] = 1;
  dp[1][0] = 0;
  for (int i = 1; i < n; ++i) {
    dp[0][i] = max({dp[0][i - 1], dp[1][i - 1], dp[0][i]});
    if (t[i].first - t[i].second > t[i - 1].first) {
      dp[0][i] = max(dp[0][i], dp[0][i - 1] + 1);
    }
    if (t[i].first - t[i].second > t[i - 1].first + t[i - 1].second) {
      dp[0][i] = max(dp[0][i], dp[1][i - 1] + 1);
    }
    if (i == n - 1 || t[i].first + t[i].second < t[i + 1].first) {
      dp[1][i] = max(dp[1][i], max(dp[0][i - 1], dp[1][i - 1]) + 1);
    }
  }
  P(max(dp[0][n - 1], dp[1][n - 1]));
  return 0;
}
