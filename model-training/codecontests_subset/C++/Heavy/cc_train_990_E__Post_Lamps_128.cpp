#include <bits/stdc++.h>
using namespace std;
long long pos[1000005] = {0};
long long cost[1000005] = {0};
long long dp[1000005] = {0};
long long foo[1000005] = {0};
int main() {
  ios_base::sync_with_stdio(false);
  long long n, m, k, i, temp;
  cin >> n >> m >> k;
  for (i = 0; i < m; i++) {
    cin >> temp;
    temp++;
    pos[temp] = 1;
  }
  for (i = 1; i <= k; i++) {
    cin >> cost[i];
  }
  if (pos[1] == 1) {
    cout << "-1" << endl;
    return 0;
  }
  dp[1] = 1;
  long long bheem = 1;
  for (i = 2; i <= n; i++) {
    if (pos[i] == 0) {
      dp[i] = i;
    } else {
      dp[i] = dp[i - 1];
    }
    bheem = max(bheem, i - dp[i]);
  }
  long long c = cost[k];
  for (i = k - 1; i >= 1; i--) {
    if (cost[i] < c) {
      c = cost[i];
    } else {
      foo[i] = 1;
    }
  }
  long long ans = 1000000000000000, flag = 0, flag1 = 0;
  for (i = bheem; i <= k; i++) {
    if (foo[i] == 1) continue;
    long long me = 0;
    flag = 0;
    long long t = 1, last = 0;
    while (1) {
      me += cost[i];
      if (t <= last) {
        flag = 0;
        break;
      }
      last = t;
      t += i;
      if (t > n) {
        flag1 = 1;
        flag = 1;
        break;
      }
      t = dp[t];
    }
    if (flag == 1) ans = min(me, ans);
  }
  if (flag1 == 0) {
    cout << "-1" << endl;
  } else {
    cout << ans << endl;
  }
  return 0;
}
