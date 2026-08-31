#include <bits/stdc++.h>

using namespace std;

int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);

  int tt;
  cin >> tt;
  while (tt--) {
    int n;
    cin >> n;
    vector<int> tag(n);
    for (int i = 0; i < n; ++i) {
      cin >> tag[i];
    }
    vector<int> score(n);
    for (int i = 0; i < n; ++i) {
      cin >> score[i];
    }

    vector<long long> dp(n, 0);
    for (int j = 1; j < n; ++j) {
      for (int i = j - 1; i >= 0; --i) {
        if (tag[i] != tag[j]) {
          long long d = abs(score[i] - score[j]);
          long long ci = dp[j] + d;
          long long cj = dp[i] + d;
          dp[i] = max(dp[i], ci);
          dp[j] = max(dp[j], cj);
        }
      }
    }

    long long ans = *max_element(dp.begin(), dp.end());
    cout << ans << '\n';
  }

  return 0;
}
