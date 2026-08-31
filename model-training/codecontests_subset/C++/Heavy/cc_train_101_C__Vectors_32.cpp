#include <bits/stdc++.h>
using namespace std;
bool check(int xa, int ya, int xb, int yb, long long xc, long long yc) {
  long long k1 = xb - xa;
  long long k2 = yb - ya;
  if (xc != 0) {
    long long wNum = k1 * yc - k2 * xc;
    long long wDen = xc * xc + yc * yc;
    if (wNum % wDen) return false;
    long long w = wNum / wDen;
    long long qNum = k1 - w * yc;
    if (qNum % xc) return false;
    return true;
  } else {
    return (k1 % yc == 0) && (k2 % yc == 0);
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  int xa, xb, xc, ya, yb, yc;
  cin >> xa >> ya >> xb >> yb >> xc >> yc;
  if (xc == 0 && yc == 0) {
    if ((xa == xb && ya == yb) || (xa == -yb && ya == xb) ||
        (xa == -xb && ya == -yb) || (xa == yb && ya == -xb))
      cout << "YES";
    else
      cout << "NO";
    return 0;
  }
  if (check(xa, ya, xb, yb, xc, yc) || check(ya, -xa, xb, yb, xc, yc) ||
      check(-xa, -ya, xb, yb, xc, yc) || check(-ya, xa, xb, yb, xc, yc))
    cout << "YES";
  else
    cout << "NO";
}
