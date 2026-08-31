#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n;
  cin >> n;
  long long dp[10];
  dp[0] = 0;
  for (int i = 1; i < 10; ++i) {
    dp[i] = -1e18;
  }
  while (n-- > 0) {
    int k;
    cin >> k;
    multiset<long long> us[3];
    for (int i = 0; i < k; ++i) {
      long long a, b;
      cin >> a >> b;
      --a;
      b = -b;
      us[a].insert(b);
    }
    long long temp[10];
    for (int i = 0; i < 10; ++i) {
      temp[i] = dp[i];
    }
    if (us[2].size()) {
      for (int i = 0; i < 10; ++i) {
        if (dp[i] == -1e18) continue;
        int to = (i + 1) % 10;
        if (to) {
          temp[to] = max(temp[to], dp[i] - *us[2].begin());
        } else {
          temp[to] = max(temp[to], dp[i] - (*us[2].begin()) * (long long)2);
        }
      }
    }
    if (us[1].size()) {
      for (int i = 0; i < 10; ++i) {
        if (dp[i] == -1e18) continue;
        int to = (i + 1) % 10;
        if (to) {
          temp[to] = max(temp[to], dp[i] - *us[1].begin());
        } else {
          temp[to] = max(temp[to], dp[i] - (*us[1].begin()) * (long long)2);
        }
      }
    }
    if (us[1].size() && us[0].size()) {
      long long kek = 0;
      kek -= *us[1].begin();
      kek -= *us[0].begin();
      long long mx = max(-*us[1].begin(), -*us[0].begin());
      for (int i = 0; i < 10; ++i) {
        if (dp[i] == -1e18) continue;
        int to = (i + 2) % 10;
        if (to > i) {
          temp[to] = max(temp[to], dp[i] + kek);
        } else {
          temp[to] = max(temp[to], dp[i] + kek + mx);
        }
      }
    }
    if (us[0].size()) {
      if (us[0].size() >= 1) {
        long long kek = -*us[0].begin();
        long long mx = kek;
        for (int i = 0; i < 10; ++i) {
          if (dp[i] == -1e18) continue;
          int to = (i + 1) % 10;
          if (to) {
            temp[to] = max(temp[to], dp[i] + kek);
          } else {
            temp[to] = max(temp[to], dp[i] + kek + mx);
          }
        }
      }
      if (us[0].size() >= 2) {
        long long kek = -*us[0].begin();
        long long mx = kek;
        long long last = *us[0].begin();
        us[0].erase(us[0].begin());
        kek -= *us[0].begin();
        mx = max(mx, -*us[0].begin());
        for (int i = 0; i < 10; ++i) {
          if (dp[i] == -1e18) continue;
          int to = (i + 2) % 10;
          if (to > i) {
            temp[to] = max(temp[to], dp[i] + kek);
          } else {
            temp[to] = max(temp[to], dp[i] + kek + mx);
          }
        }
        us[0].insert(last);
      }
      if (us[0].size() >= 3) {
        long long kek = -*us[0].begin();
        long long mx = kek;
        us[0].erase(us[0].begin());
        kek -= *us[0].begin();
        mx = max(mx, -*us[0].begin());
        us[0].erase(us[0].begin());
        kek -= *us[0].begin();
        mx = max(mx, -*us[0].begin());
        for (int i = 0; i < 10; ++i) {
          if (dp[i] == -1e18) continue;
          int to = (i + 3) % 10;
          if (to > i) {
            temp[to] = max(temp[to], dp[i] + kek);
          } else {
            temp[to] = max(temp[to], dp[i] + kek + mx);
          }
        }
      }
    }
    for (int i = 0; i < 10; ++i) {
      dp[i] = temp[i];
    }
  }
  long long ans = -1e18;
  for (int i = 0; i < 10; ++i) {
    ans = max(ans, dp[i]);
  }
  cout << ans << endl;
}
