#include <bits/stdc++.h>
using namespace std;
bool cmp(pair<pair<long long, long long>, long long> a,
         pair<pair<long long, long long>, long long> b) {
  return a.first.second < b.first.second;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long t;
  cin >> t;
  while (t--) {
    long long n, k;
    cin >> n >> k;
    vector<pair<pair<long long, long long>, long long> > a(n);
    for (long long i = 0; i < n; i++) {
      cin >> a[i].first.first >> a[i].first.second;
      a[i].second = i + 1;
    }
    sort(a.begin(), a.end(), cmp);
    vector<vector<long long> > dp(n + 1, vector<long long>(k + 1, -1e18));
    vector<vector<long long> > pred(n + 1, vector<long long>(k + 1, -1));
    dp[0][0] = 0;
    long long ans = 0;
    for (long long i = 1; i <= n; i++) {
      for (long long j = 0; j <= k; j++) {
        if (j + 1 <= k &&
            dp[i - 1][j] + j * a[i - 1].first.second + a[i - 1].first.first >=
                dp[i][j + 1]) {
          pred[i][j + 1] = 1;
          dp[i][j + 1] =
              max(dp[i][j + 1], dp[i - 1][j] + j * a[i - 1].first.second +
                                    a[i - 1].first.first);
        }
        if (dp[i][j] < dp[i - 1][j] + (k - 1) * a[i - 1].first.second) {
          dp[i][j] =
              max(dp[i][j], dp[i - 1][j] + (k - 1) * a[i - 1].first.second);
          pred[i][j] = 0;
        }
      }
    }
    long long st = k;
    long long i = n;
    if (dp[n][k - 1] > dp[n][k]) {
      st = k - 1;
    }
    vector<long long> ans1, ans2;
    while (i > 0) {
      if (pred[i][st] == 1) {
        ans1.push_back(i);
        st--;
      } else {
        ans2.push_back(i);
      }
      i--;
    }
    reverse(ans1.begin(), ans1.end());
    cout << ans1.size() + 2 * ans2.size() << "\n";
    if (ans1.size() == k) {
      for (long long i = 0; i < ans1.size() - 1; i++) {
        cout << a[ans1[i] - 1].second << " ";
      }
    } else {
      for (long long i = 0; i < ans1.size(); i++) {
        cout << a[ans1[i] - 1].second << " ";
      }
    }
    for (long long i = 0; i < ans2.size(); i++) {
      cout << a[ans2[i] - 1].second << " ";
      cout << -a[ans2[i] - 1].second << " ";
    }
    if (ans1.size() == k) {
      cout << a[ans1.back() - 1].second << " ";
    }
    cout << "\n";
  }
  return 0;
}
