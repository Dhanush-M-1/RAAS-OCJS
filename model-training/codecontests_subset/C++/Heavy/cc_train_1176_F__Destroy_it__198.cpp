#include <bits/stdc++.h>
using namespace std;
int n;
int n1, n2, n3;
long long int dp[200010][15];
vector<long long int> damage[200010][5];
long long int DP(int i, int k) {
  if (dp[i][k] != -1) return dp[i][k];
  if (i == 0 && k == 0) return dp[i][k] = 0;
  if (i == 0 && k != 0) return dp[i][k] = -1000000000000000000LL;
  long long int ans = DP(i - 1, k);
  if (damage[i][1].size() > 2) {
    long long int sum = damage[i][1][0] + damage[i][1][1] + damage[i][1][2];
    if (k > 2)
      ans = max(ans, DP(i - 1, k - 3) - sum);
    else {
      long long int doubleDamage =
          min(min(damage[i][1][0], damage[i][1][1]), damage[i][1][2]);
      ans = max(ans, DP(i - 1, 7 + k) - sum - doubleDamage);
    }
  }
  if (damage[i][2].size() > 0 && damage[i][1].size() > 0) {
    long long int sum = damage[i][2][0] + damage[i][1][0];
    if (k > 1)
      ans = max(ans, DP(i - 1, k - 2) - sum);
    else {
      long long int doubleDamage = min(damage[i][2][0], damage[i][1][0]);
      ans = max(ans, DP(i - 1, 8 + k) - sum - doubleDamage);
    }
  }
  if (damage[i][1].size() > 1) {
    long long int sum = damage[i][1][0] + damage[i][1][1];
    if (k > 1)
      ans = max(ans, DP(i - 1, k - 2) - sum);
    else {
      long long int doubleDamage = min(damage[i][1][0], damage[i][1][1]);
      ans = max(ans, DP(i - 1, 8 + k) - sum - doubleDamage);
    }
  }
  for (int g = 1; g <= 3; g++) {
    if (damage[i][g].size() > 0) {
      if (k > 0)
        ans = max(ans, DP(i - 1, k - 1) - damage[i][g][0]);
      else
        ans = max(ans, DP(i - 1, 9) - 2 * damage[i][g][0]);
    }
  }
  return dp[i][k] = ans;
}
int main() {
  scanf("%d", &n);
  memset(dp, -1, sizeof(dp));
  for (int g = 1; g <= n; g++) {
    scanf("%d", &n1);
    for (int h = 0; h < n1; h++) {
      scanf("%d %d", &n2, &n3);
      damage[g][n2].push_back(-n3);
    }
    for (int h = 1; h <= 3; h++) {
      sort(damage[g][h].begin(), damage[g][h].end());
      if (damage[g][h].size() > 3) damage[g][h].resize(3);
    }
  }
  long long int ans = 0;
  for (int g = 0; g < 10; g++) ans = max(ans, DP(n, g));
  printf("%lld\n", ans);
}
