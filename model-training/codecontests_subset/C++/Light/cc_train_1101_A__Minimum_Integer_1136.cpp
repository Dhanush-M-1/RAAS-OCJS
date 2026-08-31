#include <bits/stdc++.h>
using namespace std;
signed main() {
  long long t;
  scanf("%lld", &t);
  while (t--) {
    long long l, r, d;
    scanf("%lld%lld%lld", &l, &r, &d);
    if (d < l)
      printf("%lld\n", d);
    else if (d > r)
      printf("%lld\n", d);
    else
      printf("%lld\n", (r / d + 1) * d);
  }
}
