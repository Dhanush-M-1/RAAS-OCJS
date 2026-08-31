#include <bits/stdc++.h>
using namespace std;
long long int convertstringtoint(string a) {
  long long int ans = 0;
  for (long long int i = 0; i < a.size(); i++) {
    ans = (ans * 10) + a[i] - '0';
    ans = ans;
  }
  return ans;
}
void solve() {
  long long int n, k;
  cin >> n >> k;
  vector<long long int> v(n);
  for (long long int i = 0; i < n; ++i) cin >> v[i];
  long long int ans = INT_MAX;
  for (auto x : v) {
    if (k % x == 0) {
      ans = min(ans, k / x);
    }
  }
  cout << ans;
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long int t;
  t = 1;
  while (t--) solve();
}
