#include <bits/stdc++.h>
using namespace std;
long long a, b, c, d, e, f;
bool ju2(long long x, long long y) {
  x -= c, y -= d;
  long long div = e * e + f * f;
  if (!div) return x == 0 && y == 0;
  return (e * x + f * y) % div == 0 && (e * y - f * x) % div == 0;
}
bool ju1() {
  if (ju2(a, b)) return 1;
  if (ju2(-a, -b)) return 1;
  if (ju2(-b, a)) return 1;
  if (ju2(b, -a)) return 1;
  return 0;
}
signed main() {
  scanf("%lld%lld%lld%lld%lld%lld", &a, &b, &c, &d, &e, &f);
  if (ju1())
    puts("YES");
  else
    puts("NO");
  return 0;
}
