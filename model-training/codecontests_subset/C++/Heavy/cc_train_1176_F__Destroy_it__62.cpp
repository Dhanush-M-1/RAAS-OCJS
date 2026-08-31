#include <bits/stdc++.h>
using namespace std;
long long n, k, c, d, ans, dp[1000005][10];
multiset<long long> s[5];
multiset<long long>::iterator it;
int main() {
  scanf("%lld", &n);
  dp[0][0] = 0;
  for (long long i = 1; i < 10; i++) dp[0][i] = -100000000000000007;
  for (long long i = 1; i <= n; i++) {
    scanf("%lld", &k);
    for (long long i = 1; i <= 3; i++) s[i].clear();
    for (long long j = 1; j <= k; j++) {
      scanf("%lld %lld", &c, &d);
      s[c].insert(d);
      if ((int)s[c].size() > 3) s[c].erase(s[c].find(*s[c].begin()));
    }
    for (int j = 0; j < 10; j++) dp[i][j] = dp[i - 1][j];
    long long mx = 0;
    if (!s[3].empty()) mx = max(mx, *s[3].rbegin());
    if (!s[2].empty()) mx = max(mx, *s[2].rbegin());
    if (!s[1].empty()) mx = max(mx, *s[1].rbegin());
    for (long long j = 0; j < 10; j++)
      dp[i][(j + 1) % 10] =
          max(dp[i][(j + 1) % 10], dp[i - 1][j] + mx + mx * (j + 1 >= 10));
    long long cvp = 0, sum = 0;
    if ((int)s[1].size() >= 2) {
      long long top = 0, amk = 0;
      it = s[1].end();
      it--;
      top += *it;
      amk = *it;
      it--;
      top += *it;
      amk += top;
      cvp = max(cvp, amk);
      sum = max(sum, top);
    }
    if (!s[1].empty() and !s[2].empty()) {
      long long top = 0, amk = 0;
      top = *s[1].rbegin() + *s[2].rbegin();
      amk = top + max(*s[1].rbegin(), *s[2].rbegin());
      sum = max(sum, top);
      cvp = max(cvp, amk);
    }
    if (sum)
      for (long long j = 0; j < 10; j++)
        dp[i][(j + 2) % 10] =
            max(dp[i][(j + 2) % 10],
                dp[i - 1][j] + sum + (-sum + cvp) * (j + 2 >= 10));
    if ((int)s[1].size() >= 3) {
      long long amk = 0, sum = 0;
      it = s[1].end();
      it--;
      amk = *it;
      sum = amk;
      it--;
      sum += *it;
      it--;
      sum += *it;
      amk += sum;
      for (long long j = 0; j < 10; j++)
        dp[i][(j + 3) % 10] =
            max(dp[i][(j + 3) % 10],
                dp[i - 1][j] + sum + (-sum + amk) * (j + 3 >= 10));
    }
  }
  for (long long i = 0; i < 10; i++) ans = max(ans, dp[n][i]);
  printf("%lld\n", ans);
  return 0;
}
