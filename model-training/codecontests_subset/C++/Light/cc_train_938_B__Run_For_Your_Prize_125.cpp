#include <bits/stdc++.h>
using namespace std;
const int64_t N = 1e3 + 3;
const int64_t mod = 998244353;
int64_t dx[] = {-1, 1, 0, 0};
int64_t dy[] = {0, 0, 1, -1};
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int64_t n;
  cin >> n;
  int64_t a[n + 1];
  for (int64_t i = 1; i <= n; i++) cin >> a[i];
  sort(a + 1, a + n + 1);
  a[0] = 1;
  a[n + 1] = 1e6;
  int64_t ans = 1e9;
  for (int64_t i = 0; i <= n; i++) {
    ans = min(ans, max(a[i] - a[0], a[n + 1] - a[i + 1]));
  }
  cout << ans;
}
