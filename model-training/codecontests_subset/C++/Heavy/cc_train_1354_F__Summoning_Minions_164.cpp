#include <bits/stdc++.h>
using namespace std;
using ull = unsigned long long;
using ll = long long;
using ld = long double;
const int mod = 1e9 + 7;
const double pi = acos(-1.0);
const int inf = INT_MAX;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int t;
  cin >> t;
  while (t--) {
    int n, k;
    cin >> n >> k;
    vector<int> a(n), b(n);
    for (int i = 0; i < n; i++) cin >> a[i] >> b[i];
    vector<int> ind(n);
    iota(ind.begin(), ind.end(), 0);
    sort(ind.begin(), ind.end(), [&](int i, int j) { return b[i] < b[j]; });
    vector<vector<int>> dp(n, vector<int>(n + 1));
    dp[0][0] = (k - 1) * b[ind[0]];
    dp[0][1] = a[ind[0]];
    for (int i = 1; i < n; i++) {
      dp[i][0] = (k - 1) * b[ind[i]] + dp[i - 1][0];
      for (int j = 1; j <= i + 1; j++) {
        if (j < i + 1) {
          dp[i][j] = (k - 1) * b[ind[i]] + dp[i - 1][j];
          dp[i][j] =
              max(dp[i][j], (j - 1) * b[ind[i]] + a[ind[i]] + dp[i - 1][j - 1]);
        } else {
          dp[i][j] = (j - 1) * b[ind[i]] + a[ind[i]] + dp[i - 1][j - 1];
        }
      }
    }
    vector<int> final;
    for (int i = n - 1, j = k; j > 0;) {
      if (j < i + 1 && dp[i][j] == (k - 1) * b[ind[i]] + dp[i - 1][j]) {
        i--;
      } else {
        final.push_back(ind[i]);
        i--, j--;
      }
    }
    reverse(final.begin(), final.end());
    cout << k + 2 * (n - k) << '\n';
    for (int i = 0; i < k - 1; i++) {
      cout << final[i] + 1 << ' ';
    }
    for (int i = 0; i < n; i++) {
      if (count(final.begin(), final.end(), i) == 0) {
        cout << i + 1 << ' ' << -i - 1 << ' ';
      }
    }
    cout << final[k - 1] + 1 << '\n';
  }
  return 0;
}
