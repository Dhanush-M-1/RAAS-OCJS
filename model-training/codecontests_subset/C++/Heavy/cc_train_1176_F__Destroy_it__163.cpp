#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
long long dp[N][10];
bool cmp(int a, int b) { return a >= b; }
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  int n;
  cin >> n;
  for (int i = 0; i <= n; ++i) {
    for (int j = 0; j < 10; ++j) {
      dp[i][j] = -1;
    }
  }
  dp[0][0] = 0;
  long long ans = 0;
  for (int i = 1; i <= n; ++i) {
    int k;
    cin >> k;
    vector<int> v[4];
    for (int j = 1; j <= k; ++j) {
      int c, d;
      cin >> c >> d;
      if (c <= 3) v[c].push_back(d);
    }
    for (int i = 1; i <= 3; ++i) sort(v[i].begin(), v[i].end(), cmp);
    vector<pair<int, pair<long long, int> > > lst;
    lst.push_back(make_pair(0, make_pair(0, 0)));
    for (int i = 1; i <= 3; ++i) {
      if (v[i].size() >= 1)
        lst.push_back(make_pair(1, make_pair(v[i][0], v[i][0])));
    }
    if (v[1].size() >= 2)
      lst.push_back(make_pair(2, make_pair(v[1][0] + v[1][1], v[1][0])));
    if (v[1].size() >= 1 && v[2].size() >= 1)
      lst.push_back(
          make_pair(2, make_pair(v[1][0] + v[2][0], max(v[1][0], v[2][0]))));
    if (v[1].size() >= 3)
      lst.push_back(make_pair(
          3, make_pair((long long)v[1][0] + v[1][1] + v[1][2], v[1][0])));
    for (int j = 0; j < lst.size(); ++j) {
      for (int k = 0; k < 10; ++k) {
        if (dp[i - 1][k] == -1) continue;
        int nx = k + lst[j].first;
        long long dmg = lst[j].second.first;
        if (nx >= 10) dmg += lst[j].second.second;
        nx %= 10;
        dp[i][nx] = max(dp[i][nx], dp[i - 1][k] + dmg);
        ans = max(ans, dp[i][nx]);
      }
    }
  }
  cout << ans << endl;
  return 0;
}
