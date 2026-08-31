#include <bits/stdc++.h>
using namespace std;
long long a1, b1, a2, b2, a3, b3;
bool is(long long x, long long y) {
  x = a2 - x;
  y = b2 - y;
  if (a3 == 0 && b3 == 0) {
    if (x == 0 && y == 0) return true;
    return false;
  } else if (a3 == 0) {
    if (x / b3 == (float)x / b3 && y / b3 == (float)y / b3) return true;
    return false;
  } else if (b3 == 0) {
    if (x / a3 == (float)x / a3 && y / a3 == (float)y / a3) return true;
    return false;
  } else {
    long long b = (x * b3 - y * a3) / (a3 * a3 + b3 * b3);
    if ((a3 * a3 + b3 * b3) * b != x * b3 - y * a3)
      return false;
    else {
      long long a = (x - b * b3) / a3;
      if (a * a3 + b * b3 == x) return true;
      return false;
    }
  }
}
int main() {
  scanf("%lld%lld", &a1, &b1);
  scanf("%lld%lld", &a2, &b2);
  scanf("%lld%lld", &a3, &b3);
  if (is(a1, b1) || is(b1, -a1) || is(-a1, -b1) || is(-b1, a1)) {
    printf("YES\n");
    return 0;
  }
  printf("NO\n");
  return 0;
}
