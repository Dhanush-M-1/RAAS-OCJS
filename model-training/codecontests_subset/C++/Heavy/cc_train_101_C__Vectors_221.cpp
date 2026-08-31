#include <bits/stdc++.h>
using namespace std;
long long x, y, ax[4], ay[4], by, bx, xx, yy;
bool ok() {
  for (int i = 0; i < 4; i++) {
    xx = ax[i] - bx;
    yy = ay[i] - by;
    long long a = abs(x * xx + y * yy);
    long long b = abs(y * xx - x * yy);
    long long len = abs(x * x + y * y);
    if (x == 0 && y == 0) {
      if (xx == 0 && yy == 0) return true;
    } else if (a % len == 0 && b % len == 0) {
      return true;
    }
  }
  return false;
}
int main() {
  cin >> ax[0] >> ay[0] >> bx >> by >> x >> y;
  for (int i = 1; i < 4; i++) {
    ax[i] = ay[i - 1];
    ay[i] = -ax[i - 1];
  }
  if (ok())
    printf("YES");
  else
    printf("NO");
  return 0;
}
