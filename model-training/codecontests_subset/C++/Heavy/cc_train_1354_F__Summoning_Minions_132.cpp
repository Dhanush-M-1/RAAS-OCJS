#include <bits/stdc++.h>
using namespace std;
void solve() {
  int n, k;
  cin >> n >> k;
  long long a1[n], b1[n];
  for (int i = 0; i < n; i++) cin >> a1[i] >> b1[i];
  long long dp[n][k];
  vector<long long> a, b;
  vector<pair<pair<long long, long long>, long long> > e;
  vector<long long> ans;
  long long mx = 0;
  for (int p = 0; p < n; p++) {
    a.clear();
    b.clear();
    e.clear();
    for (int i = 0; i < n; i++)
      if (i == p)
        continue;
      else
        e.push_back(make_pair(make_pair(b1[i], a1[i]), i));
    sort(e.begin(), e.end());
    a.push_back(0);
    b.push_back(0);
    for (int i = 0; i < e.size(); i++) {
      a.push_back(e[i].first.second);
      b.push_back(e[i].first.first);
    }
    for (int i = 0; i < n; i++)
      for (int j = 0; j < k; j++) dp[i][j] = -1e9;
    dp[0][0] = 0;
    for (int i = 1; i < n; i++)
      for (int j = 0; j < k; j++) {
        dp[i][j] = max(dp[i][j], dp[i - 1][j] + b[i] * (k - 1));
        if (j > 0)
          dp[i][j] = max(dp[i][j], dp[i - 1][j - 1] + b[i] * (j - 1) + a[i]);
      }
    if (mx < a1[p] + b1[p] * (k - 1) + dp[n - 1][k - 1]) {
      mx = a1[p] + b1[p] * (k - 1) + dp[n - 1][k - 1];
      vector<long long> x, bad;
      int i = n - 1, j = k - 1;
      while (dp[i][j] > 0) {
        if (j > 0) {
          if (dp[i - 1][j - 1] + b[i] * (j - 1) + a[i] == dp[i][j]) {
            x.push_back(e[i - 1].second + 1);
            i--;
            j--;
          } else {
            bad.push_back(-e[i - 1].second - 1);
            bad.push_back(e[i - 1].second + 1);
            i--;
          }
        } else {
          bad.push_back(-e[i - 1].second - 1);
          bad.push_back(e[i - 1].second + 1);
          i--;
        }
      }
      reverse(x.begin(), x.end());
      reverse(bad.begin(), bad.end());
      for (int i = 0; i < bad.size(); i++) x.push_back(bad[i]);
      x.push_back(p + 1);
      ans = x;
    }
  }
  cout << ans.size() << "\n";
  for (int i = 0; i < ans.size(); i++) cout << ans[i] << ' ';
  cout << "\n";
}
int main() {
  ios::sync_with_stdio(0);
  int q;
  cin >> q;
  while (q--) solve();
}
