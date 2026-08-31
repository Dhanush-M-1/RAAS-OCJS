#include <bits/stdc++.h>
using namespace std;
const long long N = 500005;
const long long mod = 1e9 + 7;
void solve() {
  long long x = 0, y = 0, c = 0, ans = 0;
  long long n, m, k;
  cin >> n >> k;
  long long a[n];
  for (long long i = 0; i < n; ++i) {
    cin >> a[i];
  }
  for (long long i = 0; i < n; ++i) {
    c += a[i];
    if (c > k) {
      cout << -1 << "\n";
      return;
      ;
    }
    if (a[i] == 0 and c < 0) c = 0;
  }
  c = 0;
  for (long long i = 0; i < n; ++i) {
    c += a[i];
    if (a[i] == 0 and c < 0) {
      c = k;
      ans++;
    }
    if (c > k) c = k;
  }
  cout << ans << "\n";
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  solve();
  return 0;
}
