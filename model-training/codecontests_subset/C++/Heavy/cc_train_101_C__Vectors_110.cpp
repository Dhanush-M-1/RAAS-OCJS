#include <bits/stdc++.h>
using namespace std;
int main() {
  long long x1, y1, x2, y2, x3, y3;
  scanf("%I64d%I64d", &x1, &y1);
  scanf("%I64d%I64d", &x2, &y2);
  scanf("%I64d%I64d", &x3, &y3);
  bool flag = false, flag2 = false, flag3 = false, flag4 = false;
  long long m = x2 - x1, n = y2 - y1;
  if (x3 == 0 && y3 == 0) {
    if (m == 0 && n == 0)
      flag = true;
    else
      flag = false;
  } else {
    long long a = x3 * x3, b = y3 * y3;
    if ((y3 * m - x3 * n) % (a + b) == 0 && (x3 * m + y3 * n) % (a + b) == 0)
      flag = true;
    else
      flag = false;
  }
  m = x2 + y1, n = y2 - x1;
  if (x3 == 0 && y3 == 0) {
    if (m == 0 && n == 0)
      flag2 = true;
    else
      flag2 = false;
  } else {
    long long a = x3 * x3, b = y3 * y3;
    if ((y3 * m - x3 * n) % (a + b) == 0 && (x3 * m + y3 * n) % (a + b) == 0)
      flag2 = true;
    else
      flag2 = false;
  }
  m = x2 + x1, n = y2 + y1;
  if (x3 == 0 && y3 == 0) {
    if (m == 0 && n == 0)
      flag3 = true;
    else
      flag3 = false;
  } else {
    long long a = x3 * x3, b = y3 * y3;
    if ((y3 * m - x3 * n) % (a + b) == 0 && (x3 * m + y3 * n) % (a + b) == 0)
      flag3 = true;
    else
      flag3 = false;
  }
  m = x2 - y1, n = y2 + x1;
  if (x3 == 0 && y3 == 0) {
    if (m == 0 && n == 0)
      flag4 = true;
    else
      flag4 = false;
  } else {
    long long a = x3 * x3, b = y3 * y3;
    if ((y3 * m - x3 * n) % (a + b) == 0 && (x3 * m + y3 * n) % (a + b) == 0)
      flag4 = true;
    else
      flag4 = false;
  }
  flag || flag2 || flag3 || flag4 ? printf("YES\n") : printf("NO\n");
  return 0;
}
