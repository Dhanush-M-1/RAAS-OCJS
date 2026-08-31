#include <bits/stdc++.h>
using namespace std;
long long n, ans;
string str;
long long solve() {
  long long c;
  cin >> n >> c;
  long long x[n];
  for (long long i = 0; i <= n - 1; ++i) cin >> x[i];
  for (long long i = 0; i <= n - 2; ++i) {
    ans = max(ans, x[i] - x[i + 1] - c);
  }
  cout << ans;
  return 0;
}
signed main() {
  ios::sync_with_stdio(0);
  long long t = 1;
  while (t--) solve();
  return 0;
}
