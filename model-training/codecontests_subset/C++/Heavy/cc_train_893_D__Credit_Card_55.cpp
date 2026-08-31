#include <bits/stdc++.h>
#pragma GCC optimize("Ofast", "unroll-loops")
using namespace std;
const long long inf = numeric_limits<long long>::max() / 2;
const long double eps = 1e-9;
const long double pi = acos(-1);
inline void solve(), read();
int main() {
  ios_base::sync_with_stdio(0), cin.tie(0), cout.tie(0);
  read();
  solve();
  return 0;
}
long long n, d;
vector<long long> a, suff, pref;
inline void solve() {
  pref.resize(n);
  pref[0] = a[0];
  for (long long i = 1; i < n; i++) {
    pref[i] = a[i] + pref[i - 1];
  }
  suff.resize(n + 1, -inf);
  for (long long i = n - 1; i >= 0; i--) {
    suff[i] = max(suff[i + 1], pref[i]);
  }
  long long s = 0, ds = 0;
  long long ans = 0;
  for (long long i = 0; i < n; i++) {
    if (a[i] == 0) {
      if (s < 0) {
        long long r = d - (suff[i] + ds);
        ds += r;
        s += r;
        if (s < 0) {
          cout << -1 << "\n";
          return;
        }
        ++ans;
      }
    }
    s += a[i];
    if (s > d) {
      cout << -1 << "\n";
      return;
    }
  }
  cout << ans << "\n";
}
inline void read() {
  cin >> n >> d;
  a.resize(n);
  for (long long i = 0; i < n; i++) {
    cin >> a[i];
  }
}
