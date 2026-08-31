#include <bits/stdc++.h>
using namespace std;
long long a, b, c, d, x, y;
long long pd(long long a, long long b) {
  long long sum = c * c + d * d;
  if (sum == 0)
    return a == 0 && b == 0;
  else
    return (a * c + b * d) % sum == 0 && (b * c - a * d) % sum == 0;
}
int main() {
  scanf("%lld%lld%lld%lld%lld%lld", &a, &b, &x, &y, &c, &d);
  if (pd(a - x, b - y) || pd(a + x, b + y) || pd(a - y, b + x) ||
      pd(a + y, b - x))
    return printf("YES\n"), 0;
  else
    return printf("NO\n"), 0;
}
