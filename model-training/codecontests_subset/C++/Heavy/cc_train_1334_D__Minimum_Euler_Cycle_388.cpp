#include <bits/stdc++.h>
using namespace std;
long long power(long long x, long long y, long long md = 1000000007LL) {
  long long res = 1;
  x %= md;
  while (y > 0) {
    if (y & 1) res = (res * x) % md;
    x *= x;
    if (x >= md) x %= md;
    y >>= 1;
  }
  return res;
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  long long t = 1;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    vector<long long> ans;
    long long prev = 1;
    for (long long i = 1; i <= n; i++) {
      long long st = prev;
      long long end = prev + 2 * (n - i) - 1;
      if (l > end) {
        prev = end + 1;
        continue;
      }
      if (r < st) break;
      long long st1 = max(l, st);
      long long en1 = min(r, end);
      for (long long j = st1; j <= en1; j++) {
        if ((j - st) % 2 == 0)
          ans.emplace_back(i);
        else {
          long long ex = (j - st + 1) / 2;
          ans.emplace_back(i + ex);
        }
      }
      prev = end + 1;
    }
    if (r == prev) ans.emplace_back(1);
    for (auto &x : ans) cout << x << " ";
    cout << '\n';
  }
}
