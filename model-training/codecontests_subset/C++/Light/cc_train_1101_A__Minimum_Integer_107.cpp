#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const long long INF = 1e18;
const long long MAXN = 25;
long long l, r, d, n;
long long myceil(long long x, long long y) {
  if ((x % y) == 0) {
    return x / y + 1;
  } else {
    return x / y + 1;
  }
}
int main() {
  {
    scanf("%lld", &n);
    for (long long i = 1; i <= n; i++) {
      scanf("%lld %lld %lld", &l, &r, &d);
      if (l <= d && d <= r) {
        long long be = myceil(r, d);
        printf("%lld\n", (be)*d);
      } else {
        printf("%lld\n", d);
      }
    }
  }
}
