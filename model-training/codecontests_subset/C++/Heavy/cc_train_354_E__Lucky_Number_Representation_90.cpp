#include <bits/stdc++.h>
using namespace std;
mt19937 mrand(43);
const double PI = acos((double)-1);
const double eps = 1e-5;
const long long inf0 = 1023 * 1024 * 1024;
const long long inf = inf0 * inf0;
const long long mod = 998244353;
void solve();
void scan();
signed main() {
  cin.tie(0);
  cout.tie(0);
  ios_base::sync_with_stdio(false);
  cout << fixed;
  cout.precision(15);
  solve();
  return 0;
}
int dp[21][5];
void solve() {
  int t;
  cin >> t;
  while (t--) {
    long long n;
    cin >> n;
    for (int i = 0; i < 21; i++)
      for (int j = 0; j < 5; j++) dp[i][j] = -1;
    dp[0][0] = 2e9;
    vector<vector<int>> ans(6, vector<int>(19));
    for (int i = 1; i <= 19; i++) {
      for (int j = 0; j < 5; j++) {
        if (dp[i - 1][j] == -1) continue;
        for (int k = 0; k <= 6; k++) {
          for (int h = 0; h <= 6 - k; h++) {
            int t = 6 - k - h;
            int x = 7 * k + 4 * h + j;
            long long c = (n / (long long)pow(10ll, i - 1)) % 10ll;
            if (x % 10 == c) dp[i][x / 10] = j;
          }
        }
      }
    }
    if (dp[19][0] == -1)
      cout << -1 << '\n';
    else {
      int x = 0;
      for (int i = 19; i > 0; i--) {
        ;
        int y = dp[i][x];
        bool fl = false;
        for (int k = 0; k <= 6; k++) {
          for (int h = 0; h <= 6 - k; h++) {
            int t = 6 - k - h;
            int mem = 7 * k + 4 * h + y;
            long long c = (n / (long long)pow(10ll, i - 1)) % 10ll;
            if (mem % 10 == c && mem / 10 == x) {
              for (int m = 0; m < k; m++) ans[m][i - 1] = 7;
              for (int m = 5; m >= 6 - h; m--) ans[m][i - 1] = 4;
              fl = true;
              break;
            }
          }
          if (fl) break;
        }
        x = y;
      }
      for (int i = 0; i < 6; i++) {
        while (!ans[i].empty() && ans[i].back() == 0) ans[i].pop_back();
        if (ans[i].empty()) ans[i].push_back(0);
        reverse((ans[i]).begin(), (ans[i]).end());
        for (int j : ans[i]) cout << j;
        cout << " ";
      }
      cout << '\n';
    }
  }
  return;
}
