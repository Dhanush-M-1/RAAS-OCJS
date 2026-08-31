#include <bits/stdc++.h>
using namespace std;
const unsigned long long INF = 2e18;
const int INFi = 2e9;
const int maxN = 2e5 + 5;
const int P = 998244353;
const int md = 1e9 + 7;
double getTime() { return clock() / (double)CLOCKS_PER_SEC; };
void solve() {
  unsigned long long n;
  cin >> n;
  unsigned long long n1 = n;
  vector<vector<int>> dp(21, vector<int>(10));
  vector<vector<array<int, 3>>> pref(21, vector<array<int, 3>>(10));
  dp[0][0] = 1;
  vector<int> to(21);
  for (int i = 1; i < 21; ++i) {
    to[i] = n % 10;
    n /= 10;
  }
  for (int i = 1; i < 21; ++i) {
    for (int j = 0; (j) < 10; ++(j)) {
      if (dp[i - 1][j]) {
        for (int cnt4 = 0; cnt4 < 7; ++cnt4) {
          for (int cnt7 = 0; cnt4 + cnt7 < 7; ++cnt7) {
            int s = j + cnt4 * 4 + cnt7 * 7;
            if (s % 10 == to[i]) {
              dp[i][s / 10] = 1;
              pref[i][s / 10] = {j, cnt4, cnt7};
            }
          }
        }
      }
    }
  }
  if (!dp[20][0]) {
    cout << "-1\n";
    return;
  }
  vector<pair<int, int>> path;
  for (int i = 20, j = 0; i >= 1; --i) {
    path.emplace_back(pref[i][j][1], pref[i][j][2]);
    j = pref[i][j][0];
  }
  vector<unsigned long long> ans(6, 0);
  unsigned long long cur = 1;
  reverse((path).begin(), (path).end());
  for (auto x : path) {
    for (int i = 0; (i) < x.first; ++(i)) {
      ans[i] += cur * 4;
    }
    for (int i = x.first; i < x.first + x.second; ++i) {
      ans[i] += cur * 7;
    }
    cur *= 10;
  }
  unsigned long long s = 0;
  for (int i = 0; (i) < 6; ++(i)) s += ans[i];
  if (s != n1) {
    cout << "-1\n";
    return;
  }
  for (int i = 0; (i) < 6; ++(i)) {
    cout << ans[i] << " ";
  }
  cout << "\n";
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  int tests;
  cin >> tests;
  for (int _ = 0; (_) < tests; ++(_)) {
    solve();
  }
  return 0;
}
