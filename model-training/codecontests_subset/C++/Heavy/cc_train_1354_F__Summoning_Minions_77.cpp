#include <bits/stdc++.h>
using namespace std;
long long n, k, dp[100][100], tak[100][100];
pair<long long, pair<long long, long long> > a[100];
void solve() {
  cin >> n >> k;
  for (int i = 1; i <= n; i++) {
    cin >> a[i].second.first >> a[i].first;
    a[i].second.second = i;
  }
  for (int i = 1; i <= 75; i++)
    for (int j = 0; j <= 75; j++) tak[i][j] = 0;
  sort(a + 1, a + n + 1);
  for (int i = 1; i <= n; i++) dp[0][i] = -9999999999999999;
  for (int i = 1; i <= n; i++) {
    for (int j = 0; j <= min(k, (long long)i); j++) {
      long long ra1 = dp[i - 1][j] + a[i].first * (k - 1);
      long long ra2 = -9999999999999999;
      if (j) ra2 = dp[i - 1][j - 1] + a[i].second.first + a[i].first * (j - 1);
      if (ra1 <= ra2) {
        tak[i][j] = 1;
      }
      dp[i][j] = max(ra1, ra2);
    }
    for (int j = min(k, (long long)i) + 1; j <= n; j++)
      dp[i][j] = -9999999999999999;
  }
  vector<long long> ans, las;
  long long p = k;
  for (int i = n; i >= 1; i--) {
    if (tak[i][p]) {
      p--;
      ans.push_back(a[i].second.second);
    } else {
      las.push_back(a[i].second.second);
    }
  }
  reverse(ans.begin(), ans.end());
  cout << n + (int)las.size() << '\n';
  for (int i = 0; i < (int)ans.size() - 1; i++) cout << ans[i] << " ";
  for (int i = 0; i < las.size(); i++) {
    cout << las[i] << " -" << las[i] << " ";
  }
  cout << ans[(int)ans.size() - 1] << '\n';
}
int main() {
  ios::sync_with_stdio(false);
  long long q;
  cin >> q;
  while (q--) solve();
  return 0;
}
