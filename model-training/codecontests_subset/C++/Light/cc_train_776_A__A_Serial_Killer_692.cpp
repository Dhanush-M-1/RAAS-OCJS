#include <bits/stdc++.h>
using namespace std;
const long long N = 500005;
const long long mod = 1e9 + 7;
void solve() {
  long long c = 0, ans = 0;
  long long n, m, k;
  string s, t, x, y;
  cin >> s >> t >> n;
  cout << s << " " << t << "\n";
  for (long long i = 0; i < n; ++i) {
    cin >> x >> y;
    if (x == s) {
      cout << t << " " << y << "\n";
      s = y;
    } else if (x == t) {
      cout << s << " " << y << "\n";
      t = y;
    }
  }
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  solve();
  return 0;
}
