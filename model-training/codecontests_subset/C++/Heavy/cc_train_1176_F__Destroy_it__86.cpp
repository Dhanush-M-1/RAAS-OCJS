#include <bits/stdc++.h>
using namespace std;
vector<long long int> c[3];
long long int f(long long int x, long long int y) {
  if (c[x].size() < y) return -1e18;
  long long int ans = 0;
  for (long long int i = 0; i < y; i++) ans += c[x][i];
  return ans;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long int n;
  cin >> n;
  long long int ct = 1;
  long long int dp[10];
  long long int ans = 0;
  long long int dpp[10];
  for (long long int i = 0; i < 10; i++) dpp[i] = dp[i] = -1e18;
  dp[0] = 0;
  dpp[0] = 0;
  while (n--) {
    long long int k;
    cin >> k;
    c[0].clear();
    c[1].clear();
    c[2].clear();
    for (long long int i = 0; i < k; i++) {
      long long int co;
      cin >> co;
      long long int d;
      cin >> d;
      co--;
      c[co].push_back(d);
    }
    long long int ma1, ma2, ma3;
    sort(c[0].begin(), c[0].end(), greater<long long int>());
    sort(c[1].begin(), c[1].end(), greater<long long int>());
    sort(c[2].begin(), c[2].end(), greater<long long int>());
    long long int one = max({f(0, 1), f(1, 1), f(2, 1)});
    long long int two = max({f(0, 2), f(0, 1) + f(1, 1)});
    long long int three = f(0, 3);
    ma1 = one;
    if (f(0, 2) > f(0, 1) + f(1, 1) && f(0, 2) > 0)
      ma2 = c[0][0];
    else if (f(0, 1) + f(1, 1) > 0)
      ma2 = max(c[0][0], c[1][0]);
    else
      ma2 = -1e18;
    if (three > 0)
      ma3 = f(0, 1);
    else
      ma3 = -1e18;
    dpp[2] = max(dpp[2], dp[9] + three + ma3);
    dpp[1] = max(dpp[1], dp[9] + two + ma2);
    dpp[0] = max(dpp[0], dp[9] + one + ma1);
    dpp[1] = max(dpp[1], dp[8] + three + ma3);
    dpp[0] = max(dpp[0], dp[8] + two + ma2);
    dpp[0] = max(dpp[0], dp[7] + three + ma3);
    for (long long int i = 0; i < 10; i++) {
      if (i + 1 < 10) dpp[i + 1] = max(dpp[i + 1], dp[i] + one);
      if (i + 2 < 10) dpp[i + 2] = max(dpp[i + 2], dp[i] + two);
      if (i + 3 < 10) dpp[i + 3] = max(dpp[i + 3], dp[i] + three);
    }
    for (long long int i = 0; i < 10; i++) {
      if (dpp[i] < 0) dpp[i] = -1e18;
      dp[i] = dpp[i];
    }
  }
  for (long long int i = 0; i < 10; i++) ans = max(ans, dp[i]);
  cout << ans << '\n';
  cerr << "Time : " << 1000 * (long double)clock() / (long double)CLOCKS_PER_SEC
       << "ms\n";
  ;
}
