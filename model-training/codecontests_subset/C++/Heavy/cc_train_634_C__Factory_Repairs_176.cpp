#include <bits/stdc++.h>
#pragma GCC optimize("O3")
using namespace std;
const long long maxN = 2 * (long long)1e5 + 100;
long long fenw[2][maxN];
long long n;
void upd(long long ind, long long where, long long val) {
  while (where <= n) {
    fenw[ind][where] += val;
    where = (where | (where - 1)) + 1;
  }
}
long long get(long long ind, long long r) {
  long long ans = 0;
  while (r > 0) {
    ans += fenw[ind][r];
    r = r & (r - 1);
  }
  return ans;
}
long long get(long long ind, long long l, long long r) {
  if (l > r) return 0;
  if (r == 0) return 0;
  return get(ind, r) - get(ind, l - 1);
}
long long k, a[2], q;
long long val[maxN];
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cin >> n >> k >> a[1] >> a[0] >> q;
  for (long long i = 1; i <= q; i++) {
    long long tp;
    cin >> tp;
    if (tp == 1) {
      long long day, by;
      cin >> day >> by;
      for (long long j = 0; j < 2; j++) {
        upd(j, day, -min(val[day], a[j]));
      }
      val[day] += by;
      for (long long j = 0; j < 2; j++) {
        upd(j, day, min(val[day], a[j]));
      }
    } else {
      long long p;
      cin >> p;
      cout << get(1, p + k, n) + get(0, 1, p - 1) << '\n';
    }
  }
  return 0;
}
