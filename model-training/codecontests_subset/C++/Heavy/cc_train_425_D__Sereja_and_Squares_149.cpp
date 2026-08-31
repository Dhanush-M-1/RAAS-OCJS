#include <bits/stdc++.h>
using namespace std;
long long n;
set<long long> xs[1000005], ys[1000005];
long long x[1000005], y[1000005];
signed main() {
  cin >> n;
  for (long long i = 1; i <= n; i++) cin >> x[i] >> y[i];
  for (long long i = 1; i <= n; i++) {
    xs[x[i]].insert(y[i]);
    ys[y[i]].insert(x[i]);
  }
  long long ans = 0;
  for (long long i = 1; i <= n; i++) {
    set<long long>::iterator a = xs[x[i]].upper_bound(y[i]);
    set<long long>::iterator b = ys[y[i]].upper_bound(x[i]);
    while (a != xs[x[i]].end() && b != ys[y[i]].end()) {
      if (*a - y[i] > *b - x[i])
        b = ys[y[i]].lower_bound(x[i] + *a - y[i]);
      else if (*a - y[i] < *b - x[i])
        a = xs[x[i]].lower_bound(y[i] + *b - x[i]);
      else {
        if (xs[*b].count(*a)) ans++;
        a++, b++;
      }
    }
  }
  cout << ans;
  return 0;
}
