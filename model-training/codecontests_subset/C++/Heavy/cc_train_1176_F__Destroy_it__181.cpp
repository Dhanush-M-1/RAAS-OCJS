#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  vector<vector<vector<long long>>> a(n);
  for (int i = 0; i < n; i++) {
    int k;
    cin >> k;
    vector<vector<long long>> ta(3);
    for (int j = 0; j < k; j++) {
      int c, d;
      cin >> c >> d;
      c--;
      ta[c].push_back(d);
    }
    for (int j = 0; j < 3; j++) {
      sort(ta[j].begin(), ta[j].end());
      reverse(ta[j].begin(), ta[j].end());
    }
    a[i] = ta;
  }
  vector<long long> dp(10, -(1LL << 60));
  dp[0] = 0;
  for (int i = 0; i < n; i++) {
    vector<long long> ndp = dp;
    for (int j = 0; j < 3; j++) {
      if (a[i][j].size() == 0) continue;
      long long car = a[i][j][0];
      for (int h = 0; h < 9; h++) {
        ndp[h + 1] = max(ndp[h + 1], dp[h] + car);
      }
      ndp[0] = max(ndp[0], dp[9] + car * 2);
    }
    if (a[i][0].size() >= 2) {
      long long car0 = a[i][0][0], car1 = a[i][0][1];
      for (int h = 0; h < 8; h++) {
        ndp[h + 2] = max(ndp[h + 2], dp[h] + car0 + car1);
      }
      ndp[0] = max(ndp[0], dp[8] + car0 * 2 + car1);
      ndp[1] = max(ndp[1], dp[9] + car0 * 2 + car1);
    }
    if (a[i][0].size() > 0 && a[i][1].size() > 0) {
      long long car0 = max(a[i][0][0], a[i][1][0]),
                car1 = min(a[i][0][0], a[i][1][0]);
      for (int h = 0; h < 8; h++) {
        ndp[h + 2] = max(ndp[h + 2], dp[h] + car0 + car1);
      }
      ndp[0] = max(ndp[0], dp[8] + car0 * 2 + car1);
      ndp[1] = max(ndp[1], dp[9] + car0 * 2 + car1);
    }
    if (a[i][0].size() >= 3) {
      long long car0 = a[i][0][0], car1 = a[i][0][1], car2 = a[i][0][2];
      for (int h = 0; h < 7; h++) {
        ndp[h + 3] = max(ndp[h + 3], dp[h] + car0 + car1 + car2);
      }
      ndp[0] = max(ndp[0], dp[7] + car0 * 2 + car1 + car2);
      ndp[1] = max(ndp[1], dp[8] + car0 * 2 + car1 + car2);
      ndp[2] = max(ndp[2], dp[9] + car0 * 2 + car1 + car2);
    }
    dp = ndp;
  }
  long long res = 0;
  for (int i = 0; i < 10; i++) res = max(res, dp[i]);
  cout << res << "\n";
  return 0;
}
