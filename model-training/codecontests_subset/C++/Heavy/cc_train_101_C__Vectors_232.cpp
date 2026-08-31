#include <bits/stdc++.h>
using namespace std;
bool can(long long x1, long long y1, long long x2, long long y2, long long x3,
         long long y3) {
  x2 -= x1;
  y2 -= y1;
  long long a = x2 * x3 + y2 * y3;
  long long b = x3 * x3 + y3 * y3;
  if (b == 0) {
    if (x2 == 0 && y2 == 0) return true;
    return false;
  }
  if (a % b) return false;
  a = a / b;
  if (y3) {
    long long x22 = x2 - a * x3;
    if (x22 % y3) return false;
    b = x22 / y3;
  } else {
    if (y2 % x3) return false;
    b = -y2 / x3;
  }
  if (x2 != a * x3 + b * y3) return false;
  if (y2 != -b * x3 + a * y3) return false;
  return true;
}
int main() {
  long long x1, y1, x2, y2, x3, y3;
  cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3;
  int t = 0;
  if (can(x1, y1, x2, y2, x3, y3)) t++;
  if (can(y1, -x1, x2, y2, x3, y3)) t++;
  if (can(-x1, -y1, x2, y2, x3, y3)) t++;
  if (can(-y1, x1, x2, y2, x3, y3)) t++;
  if (t)
    cout << "YES" << endl;
  else
    cout << "NO" << endl;
  return 0;
}
