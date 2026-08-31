#include <bits/stdc++.h>
using namespace std;
int n, m, k;
int prv[2 * 1000005];
int main() {
  ios::sync_with_stdio(0);
  cin >> n >> m >> k;
  for (int i = 0; i <= 2 * n; i++) prv[i] = i;
  int x;
  for (int i = 1; i <= m; i++) {
    cin >> x;
    prv[x] = prv[x - 1];
    if (x - prv[x] >= k || x == 0) {
      cout << -1;
      return 0;
    }
  }
  long long ans = (1 << 25);
  ans *= ans;
  for (int i = 1; i <= k; i++) {
    cin >> x;
    long long ans1 = 0;
    int p = 0;
    for (; p < n && prv[p + i] != p; p = prv[p + i]) ans1 += x;
    if (p >= n) ans = min(ans, ans1);
  }
  cout << ans;
  return 0;
}
