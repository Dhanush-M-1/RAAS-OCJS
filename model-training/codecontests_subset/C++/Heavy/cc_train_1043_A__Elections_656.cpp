#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5 + 5;
long long n;
long long a[N];
long long check(long long k) {
  long long votes = 0;
  for (long long i = 1; i <= n; i++) {
    votes -= a[i];
    votes += (k - a[i]);
  }
  return votes > 0;
}
long long binsearch(long long lo, long long hi) {
  while (lo < hi) {
    long long mid = (lo + hi) / 2;
    if (check(mid))
      hi = mid;
    else
      lo = mid + 1;
  }
  return lo;
}
int32_t main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> n;
  for (long long i = 1; i <= n; i++) cin >> a[i];
  sort(a + 1, a + n + 1);
  long long ans = binsearch(a[n], 1e9);
  cout << ans;
  return 0;
}
