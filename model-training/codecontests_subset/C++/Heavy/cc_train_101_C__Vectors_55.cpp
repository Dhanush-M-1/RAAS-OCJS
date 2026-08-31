#include <bits/stdc++.h>
using namespace std;
long long aax, aay, bbx, bby, ccx, ccy;
long long num[3][5];
bool flag1, flag2, flag3, flag4;
long long gcd(long long x, long long y) { return y ? gcd(y, x % y) : x; }
long long lcm(long long x, long long y) { return (x * y) / gcd(x, y); }
bool check(long long ax, long long ay, long long bx, long long by, long long cx,
           long long cy) {
  if (cx * cx + cy * cy == 0) {
    if (ax == bx && ay == by)
      return 1;
    else
      return 0;
  } else {
    if ((cx * (by - ay) - cy * (bx - ax)) % (cx * cx + cy * cy) == 0 &&
        (cy * (by - ay) + cx * (bx - ax)) % (cx * cx + cy * cy) == 0)
      return 1;
    else
      return 0;
  }
}
int main() {
  scanf("%lld%lld%lld%lld%lld%lld", &aax, &aay, &bbx, &bby, &ccx, &ccy);
  flag1 = check(aax, aay, bbx, bby, ccx, ccy);
  flag2 = check(-aax, -aay, bbx, bby, ccx, ccy);
  flag3 = check(aay, -aax, bbx, bby, ccx, ccy);
  flag4 = check(-aay, aax, bbx, bby, ccx, ccy);
  if (flag1 || flag2 || flag3 || flag4)
    puts("YES");
  else
    puts("NO");
  return 0;
}
