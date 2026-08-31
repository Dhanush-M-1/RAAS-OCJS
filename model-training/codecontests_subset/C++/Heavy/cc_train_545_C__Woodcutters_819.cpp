#include <bits/stdc++.h>
using namespace std;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
int dx[8] = {1, -1, 0, 0, -1, -1, 1, 1};
int dy[8] = {0, 0, -1, 1, -1, 1, -1, 1};
vector<int> adj[200010], dis1(300010, -1), vis(300010, 0), dis(300010, -1);
int myrandom(int i) { return std::rand() % i; }
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  vector<pair<int, int>> v;
  for (int i = 0; i < n; i++) {
    int a, b;
    cin >> a >> b;
    v.push_back({a, b});
  }
  if (n == 1) {
    cout << 1 << '\n';
    return 0;
  }
  long long dp[n + 1][2];
  memset(dp, 0, sizeof(dp));
  dp[0][0] = 0;
  dp[0][1] = 1;
  for (int i = 1; i < n; i++) {
    dp[i][0] = max(dp[i - 1][0], dp[i - 1][1]);
    if (v[i].first - v[i - 1].first > v[i - 1].second) {
      dp[i][0] = max(dp[i][0], dp[i - 1][0] + 1);
    }
    if (v[i].first - v[i - 1].first > v[i].second) {
      dp[i][1] = max(dp[i - 1][1], dp[i - 1][0]) + 1;
    }
    if (v[i].first - v[i - 1].first > v[i].second + v[i - 1].second) {
      dp[i][1] = max(dp[i][1], dp[i - 1][0] + 2);
    }
  }
  cout << max(dp[n - 1][0] + 1, dp[n - 1][1]) << '\n';
}
