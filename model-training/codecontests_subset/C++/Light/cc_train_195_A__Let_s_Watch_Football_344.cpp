#include <bits/stdc++.h>
using namespace std;
signed main() {
  cin.tie(0)->sync_with_stdio(0);
  long long a, b, c;
  cin >> a >> b >> c;
  long long lo = 0, hi = 1e9;
  auto check = [&](long long x) {
    long long recv = x * b;
    for (long long i = x; i <= x + c; i++) {
      long long need = (i - x) * a;
      if (need > recv) {
        return 0;
      }
      recv += b;
    }
    return 1;
  };
  while (lo < hi) {
    long long mid = (lo + hi) / 2;
    if (check(mid))
      hi = mid;
    else
      lo = mid + 1;
  }
  cout << lo << "\n";
}
