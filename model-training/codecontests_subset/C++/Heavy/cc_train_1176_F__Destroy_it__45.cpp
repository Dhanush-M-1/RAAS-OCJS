#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  long long n, i, j, k, a, b, x, t, c, d, dmax, id, ans;
  cin >> n;
  vector<vector<tuple<long long, long long, long long>>> plist(n + 1);
  for (i = 1; i <= n; i++) {
    cin >> x;
    vector<vector<long long>> clist(4);
    for (j = 0; j < x; j++) {
      cin >> c >> d;
      clist[c].push_back(d);
    }
    for (j = 1; j <= 3; j++) sort(clist[j].rbegin(), clist[j].rend());
    plist[i].push_back({0, 0, 0});
    if (clist[1].size() > 0) plist[i].push_back({1, clist[1][0], clist[1][0]});
    if (clist[2].size() > 0) plist[i].push_back({1, clist[2][0], clist[2][0]});
    if (clist[3].size() > 0) plist[i].push_back({1, clist[3][0], clist[3][0]});
    if ((clist[1].size() > 0) && (clist[2].size() > 0))
      plist[i].push_back(
          {2, clist[1][0] + clist[2][0], max(clist[1][0], clist[2][0])});
    if (clist[1].size() > 1)
      plist[i].push_back(
          {2, clist[1][0] + clist[1][1], max(clist[1][0], clist[1][1])});
    if (clist[1].size() > 2)
      plist[i].push_back({3, clist[1][0] + clist[1][1] + clist[1][2],
                          max(clist[1][0], max(clist[1][1], clist[1][2]))});
  }
  vector<vector<long long>> dp(n + 1, vector<long long>(10, -(1LL << 60)));
  dp[0][0] = 0;
  for (i = 0; i < n; i++) {
    for (j = 0; j < 10; j++) {
      for (auto p : plist[i + 1]) {
        tie(c, d, dmax) = p;
        x = dp[i][j] + d;
        if (j + c >= 10) x += dmax;
        id = (j + c) % 10;
        dp[i + 1][id] = max(dp[i + 1][id], x);
      }
    }
  }
  ans = 0;
  for (i = 0; i < 10; i++) ans = max(ans, dp[n][i]);
  cout << ans << "\n";
  return 0;
}
