#include <bits/stdc++.h>
using namespace std;
int a[75];
int b[75];
int order[75];
int main() {
  cin.tie(0);
  ios_base::sync_with_stdio(0);
  int t;
  cin >> t;
  while (t--) {
    int n, k;
    cin >> n >> k;
    for (int i = 0; i < n; ++i) cin >> a[i] >> b[i], order[i] = i;
    sort(order, order + n, [&](int x, int y) {
      if (b[x] == b[y])
        return a[x] > a[y];
      else
        return b[x] < b[y];
    });
    vector<vector<int>> dp(n + 1, vector<int>(n + 1, -1e9));
    dp[0][0] = 0;
    for (int ii = 1; ii <= n; ++ii) {
      int i = order[ii - 1];
      for (int j = max(0, k - (n - ii)); j <= min(ii, k); ++j) {
        dp[ii][j] = dp[ii - 1][j] + b[i] * (k - 1);
        if (j)
          dp[ii][j] = max(dp[ii][j], dp[ii - 1][j - 1] + a[i] + b[i] * (j - 1));
      }
    }
    vector<int> ans;
    int cur = k;
    int last = -1;
    for (int i = n; i >= 1; i--) {
      if (cur &&
          (dp[i - 1][cur - 1] + a[order[i - 1]] + b[order[i - 1]] * (cur - 1) >=
               dp[i - 1][cur] + b[order[i - 1]] * (k - 1) ||
           cur + (n - i) < k)) {
        if (last == -1)
          last = order[i - 1] + 1;
        else
          ans.push_back(order[i - 1] + 1);
        cur--;
      } else {
        ans.push_back(-order[i - 1] - 1);
      }
    }
    reverse(ans.begin(), ans.end());
    vector<int> ans2;
    for (auto q : ans)
      if (q > 0) ans2.push_back(q);
    for (auto q : ans)
      if (q < 0) ans2.push_back(-q), ans2.push_back(q);
    ans2.push_back(last);
    cout << ans2.size() << endl;
    for (auto q : ans2) cout << q << " ";
    cout << endl;
  }
  return 0;
}
