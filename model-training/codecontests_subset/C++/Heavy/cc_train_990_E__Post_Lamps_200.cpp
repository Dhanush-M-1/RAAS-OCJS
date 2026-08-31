#include <bits/stdc++.h>
using namespace std;
long long pos[1000005], dp[1000005], a[1000005], ans;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  long long n, m, k, i, j;
  cin >> n >> m >> k;
  for (i = 0; i < m; i++) {
    long long x;
    cin >> x;
    pos[x] = 1;
  }
  for (i = 1; i <= k; i++) cin >> a[i];
  if (pos[0] == 1) {
    cout << -1;
    return 0;
  }
  for (i = 0; i < n; i++) {
    if (pos[i] == 0)
      dp[i] = i;
    else
      dp[i] = dp[i - 1];
  }
  ans = 1e18;
  for (i = 1; i <= k; i++) {
    long long curr = 0, temp = 0, c = 0;
    while (curr < n) {
      if (pos[curr] == 0) {
        curr += i;
        temp++;
      } else {
        if (dp[curr] == curr - i) {
          c = 1;
          break;
        } else
          curr = dp[curr];
      }
    }
    if (c == 0) ans = min(ans, temp * a[i]);
  }
  if (ans == 1e18)
    cout << -1;
  else
    cout << ans;
  return 0;
}
