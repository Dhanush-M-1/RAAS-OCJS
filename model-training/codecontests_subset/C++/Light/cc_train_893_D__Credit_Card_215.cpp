#include <bits/stdc++.h>
using namespace std;
constexpr long long maxN = 1e5 + 43;
long long n, d;
vector<long long> a;
long long suff[maxN];
long long had_max[maxN];
signed main() {
  ios_base::sync_with_stdio(false);
  cin >> n >> d;
  a.resize(n + 1);
  for (long long i = 1; i <= n; ++i) cin >> a[i];
  long long ans = 0;
  long long maxx = 0, minn = 0;
  for (long long i = 1; i <= n; ++i) {
    if (a[i] != 0) {
      maxx += a[i];
      minn += a[i];
      maxx = min(maxx, d);
      if (minn > d) {
        cout << -1;
        return 0;
      }
    } else {
      if (maxx < 0) {
        maxx = d;
        minn = 0;
        ++ans;
      } else {
        minn = max((long long)0, minn);
      }
    }
  }
  cout << ans;
  return 0;
}
