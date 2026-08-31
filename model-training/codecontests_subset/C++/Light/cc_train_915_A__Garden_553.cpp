#include <bits/stdc++.h>
using namespace std;
int a[103];
int dp[103];
int main() {
  int n, k;
  cin >> n >> k;
  for (int i = 0; i < n; ++i) {
    cin >> a[i];
  }
  int ans = 1e9;
  for (int i = 0; i < n; ++i) {
    int sum = 0, cnt = 0;
    while (sum < k) {
      sum += a[i];
      ++cnt;
    }
    if (sum == k) ans = min(ans, cnt);
  }
  cout << ans << endl;
  return 0;
}
