#include <bits/stdc++.h>
using namespace std;
const int MAX = 1e5 + 5;
long long dp[MAX] = {}, dp_max[MAX] = {};
void initiaize(int n) {
  dp_max[n - 1] = dp[n - 1];
  for (int i = n - 2; i >= 0; i--) dp_max[i] = max(dp_max[i + 1], dp[i]);
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  int n, l;
  cin >> n >> l;
  int a[n];
  for (int i = 0; i < n; i++) {
    cin >> a[i];
    if (i == 0)
      dp[i] = a[i];
    else
      dp[i] = a[i] + dp[i - 1];
  }
  initiaize(n);
  long long add = 0, ans = 0;
  for (int i = 0; i < n; i++) {
    if ((dp[i] + add) > l) {
      cout << -1;
      return 0;
    }
    if (a[i] == 0) {
      if (dp[i] + add < 0) {
        ans++;
        add = l - dp_max[i];
        if ((dp[i] + add) < 0) {
          cout << -1;
          return 0;
        }
      }
    }
  }
  cout << ans;
  return 0;
}
