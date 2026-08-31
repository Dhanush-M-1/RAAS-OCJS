#include <bits/stdc++.h>
using namespace std;
long long n, tot;
long long a[109];
inline bool check(long long mid) {
  long long cnt = mid * n;
  if (cnt > 2 * tot)
    return true;
  else
    return false;
}
signed main() {
  cin >> n;
  for (long long i = 1; i < n + 1; ++i) cin >> a[i], tot += a[i];
  long long l = *min_element(a + 1, a + n + 1), r = 100000;
  while (r != l) {
    long long mid = (l + r) >> 1;
    if (check(mid))
      r = mid;
    else
      l = mid + 1;
  }
  l = max(l, *max_element(a + 1, a + n + 1));
  cout << l;
}
