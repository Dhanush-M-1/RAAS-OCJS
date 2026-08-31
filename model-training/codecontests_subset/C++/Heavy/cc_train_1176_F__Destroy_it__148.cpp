#include <bits/stdc++.h>
using namespace std;
const long long MAX_N = 2 * 1E5 + 1, INF = 1e16;
long long dp[MAX_N][10];
void init_dp() {
  dp[0][9] = 0;
  for (long long i = 0; i < 9; i++) dp[0][i] = -INF;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  init_dp();
  long long n, k, price, damage, ans = 0;
  cin >> n;
  for (long long each = 1; each <= n; each++) {
    cin >> k;
    long long two = -INF, three = -INF;
    vector<long long> one(3, -INF);
    for (long long j = 0; j < k; j++) {
      cin >> price >> damage;
      if (price == 1) {
        if (damage > one[0]) {
          one[2] = one[1];
          one[1] = one[0];
          one[0] = damage;
        } else if (damage > one[1]) {
          one[2] = one[1];
          one[1] = damage;
        } else if (damage > one[2])
          one[2] = damage;
      } else if (price == 2)
        two = max(two, damage);
      else
        three = max(three, damage);
    }
    for (long long r = 0; r < 10; r++) {
      dp[each][r] = dp[each - 1][(r + 3) % 10];
      if (r == 8 || r == 9 || r == 7)
        dp[each][r] += one[0] * 2 + one[1] + one[2];
      else
        dp[each][r] += one[0] + one[1] + one[2];
      long long x = dp[each][r];
      dp[each][r] = dp[each - 1][(r + 2) % 10];
      if (r == 9 || r == 8)
        dp[each][r] +=
            max(one[0], max(two, one[1])) * 2 + min(one[0], max(two, one[1]));
      else
        dp[each][r] += one[0] + max(two, one[1]);
      long long y = dp[each][r];
      dp[each][r] = dp[each - 1][(r + 1) % 10];
      long long f = max(one[0], max(two, three));
      if (r == 9)
        dp[each][r] += f * 2;
      else
        dp[each][r] += f;
      long long z = dp[each][r];
      dp[each][r] = max(x, max(y, max(z, dp[each - 1][r])));
    }
  }
  for (long long j = 0; j < 10; j++) ans = max(ans, dp[n][j]);
  cout << ans << "\n";
  return 0;
}
