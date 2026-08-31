#include <bits/stdc++.h>
using namespace std;
int dp[76][76];
bool taken[76][76];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int t, n, m;
  cin >> t;
  while (t--) {
    cin >> n >> m;
    vector<pair<pair<int, int>, int>> data(n);
    for (int i = 0; i < n; ++i) {
      cin >> data[i].first.second >> data[i].first.first;
      data[i].second = i + 1;
    }
    sort(data.begin(), data.end());
    for (int i = 1; i <= n; ++i) {
      int s = data[i - 1].first.first * (m - 1);
      int f = data[i - 1].first.second;
      f -= data[i - 1].first.first;
      dp[i][min(i, m)] = 0;
      taken[i][min(i, m)] = false;
      for (int p = 0; p <= m && p < i; ++p) {
        dp[i][p] = dp[i - 1][p] + s;
        taken[i][p] = false;
      }
      for (int p = 0; p < m && p < i; ++p) {
        f += data[i - 1].first.first;
        if (dp[i - 1][p] + f > dp[i][p + 1]) {
          dp[i][p + 1] = dp[i - 1][p] + f;
          taken[i][p + 1] = true;
        }
      }
    }
    int r = m;
    int pos = n;
    vector<int> order, others;
    while (pos > 0) {
      if (taken[pos][r]) {
        order.push_back(data[pos - 1].second);
        r--;
      } else
        others.push_back(data[pos - 1].second);
      pos--;
    }
    reverse(order.begin(), order.end());
    int last = order.back();
    order.pop_back();
    cout << m + (n - m) * 2 << "\n";
    for (auto &x : order) cout << x << " ";
    for (auto &x : others) cout << x << " " << -x << " ";
    cout << last << "\n";
  }
  return 0;
}
