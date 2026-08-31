#include <bits/stdc++.h>
using namespace std;
long long xa, ya, xb, yb, xc, yc;
long long o;
bool check(long long xa, long long ya) {
  if (!o) return xa == xb && ya == yb;
  return ((xb - xa) * xc + (yb - ya) * yc) % o == 0 &&
         ((xb - xa) * yc - (yb - ya) * xc) % o == 0;
}
int main() {
  scanf("%I64d %I64d %I64d %I64d %I64d %I64d", &xa, &ya, &xb, &yb, &xc, &yc);
  o = xc * xc + yc * yc;
  bool flag =
      check(xa, ya) || check(ya, -xa) || check(-ya, xa) || check(-xa, -ya);
  if (flag)
    printf("YES\n");
  else
    printf("NO\n");
}
