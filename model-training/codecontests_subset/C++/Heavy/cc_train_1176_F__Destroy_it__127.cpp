#include <bits/stdc++.h>
using namespace std;
long long dp[12];
signed main() {
  long long n;
  cin >> n;
  for (long long i = 1; i <= 9; i++) {
    dp[i] = -100000000000000000;
  }
  for (long long ii = 1; ii <= n; ii++) {
    long long cnt;
    cin >> cnt;
    vector<long long> a[4];
    for (long long i = 1; i <= cnt; i++) {
      long long u, v;
      cin >> u >> v;
      a[u].push_back(v);
    }
    for (long long i = 1; i <= 3; i++) {
      sort(a[i].begin(), a[i].end());
    }
    long long dp1[12];
    for (long long i = 0; i <= 9; i++) dp1[i] = -1000000000000000;
    long long sm1 = 0, mx1 = 0;
    for (long long t1 = 0; t1 <= a[1].size(); t1++) {
      if (t1 > 3) break;
      if (t1 > 0) {
        sm1 += a[1][a[1].size() - t1];
        mx1 = max(mx1, a[1][a[1].size() - t1]);
      }
      long long sm2 = 0, mx2 = 0;
      for (long long t2 = 0; t2 <= a[2].size(); t2++) {
        if (t1 + 2 * t2 > 3) break;
        if (t2 > 0) {
          sm2 += a[2][a[2].size() - t2];
          mx2 = max(mx2, a[2][a[2].size() - t2]);
        }
        long long sm3 = 0, mx3 = 0;
        for (long long t3 = 0; t3 <= a[3].size(); t3++) {
          if (t1 + 2 * t2 + 3 * t3 > 3) break;
          if (t3 > 0) {
            sm3 += a[3][a[3].size() - t3];
            mx3 = max(mx3, a[3][a[3].size() - t3]);
          }
          for (long long j = 0; j <= 9; j++) {
            long long nxt = (j + t1 + t2 + t3) % 10;
            if (nxt < j)
              dp1[nxt] = max(dp1[nxt],
                             dp[j] + sm1 + sm2 + sm3 + max(mx1, max(mx2, mx3)));
            else
              dp1[nxt] = max(dp1[nxt], dp[j] + sm1 + sm2 + sm3);
          }
        }
      }
    }
    for (long long i = 0; i <= 9; i++) {
      dp[i] = dp1[i];
    }
  }
  long long ans = 0;
  for (long long i = 0; i <= 9; i++) {
    ans = max(ans, dp[i]);
  }
  cout << ans;
}
