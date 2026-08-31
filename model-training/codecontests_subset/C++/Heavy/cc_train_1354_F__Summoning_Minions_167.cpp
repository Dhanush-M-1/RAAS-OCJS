#include <bits/stdc++.h>
using namespace std;
const int mod = 998244353;
const int inf = 1e9;
const int N = 5005;
const int mf[] = {0, 0, 1, -1}, mc[] = {1, -1, 0, 0};
const double eps = 1e-9;
const double pi = acos(-1);
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int n, k;
    cin >> n >> k;
    vector<pair<pair<int, int>, int>> v(n);
    for (int i = 0; i < n; i++) {
      cin >> v[i].first.first >> v[i].first.second;
      v[i].second = i + 1;
    }
    sort((v).begin(), (v).end(),
         [&](pair<pair<int, int>, int> i, pair<pair<int, int>, int> j) {
           return i.first.second < j.first.second;
         });
    vector<vector<int>> dp(n + 1, vector<int>(k + 1, -inf));
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      int a = v[i - 1].first.first;
      int b = v[i - 1].first.second;
      dp[i][0] = dp[i - 1][0] + (k - 1) * b;
      for (int j = 1; j <= k; j++)
        dp[i][j] =
            max(dp[i - 1][j] + (k - 1) * b, dp[i - 1][j - 1] + a + (j - 1) * b);
    }
    vector<bool> mark(n + 1);
    vector<int> stay;
    int j = k;
    for (int i = n; i >= 1; i--) {
      int a = v[i - 1].first.first;
      int b = v[i - 1].first.second;
      int id = v[i - 1].second;
      if (dp[i][j] == dp[i - 1][j - 1] + a + (j - 1) * b) {
        mark[id] = true;
        stay.push_back(id);
        j--;
      }
    }
    vector<int> ans;
    for (int i = k - 1; i > 0; i--) ans.push_back(stay[i]);
    for (int i = 1; i <= n; i++)
      if (!mark[i]) {
        ans.push_back(i);
        ans.push_back(-i);
      }
    ans.push_back(stay[0]);
    cout << k + 2 * (n - k) << '\n';
    for (int &i : ans) cout << i << " \n"[&i == &ans.back()];
  }
  return 0;
}
