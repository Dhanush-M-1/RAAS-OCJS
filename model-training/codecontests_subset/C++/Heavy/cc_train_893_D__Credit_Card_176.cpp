#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n, d;
  cin >> n >> d;
  vector<long long> a(n);
  for (long long i = 0; i < n; i++) cin >> a[i];
  long long sum = 0, mx = INT_MIN, ans = 0;
  bool flag = true, aagaya = false;
  for (long long i = 0; i < n; i++) {
    if (a[i] == 0) {
      if (sum < 0) {
        if (aagaya && (d - mx) >= 0 && (d - mx) + sum >= 0) {
          mx += abs(sum);
          sum = 0;
        } else {
          ans++;
          mx = 0;
          sum = 0;
        }
        aagaya = true;
      }
    } else {
      sum += a[i];
      mx = max(mx, sum);
    }
    if (mx > d) flag = false;
  }
  if (flag)
    cout << ans << endl;
  else
    cout << -1 << endl;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long t = 1;
  while (t--) solve();
  return 0;
}
