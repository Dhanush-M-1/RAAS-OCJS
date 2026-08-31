#include <bits/stdc++.h>
using namespace std;
long long xa, ya, xb, yb, xc, yc, xd, yd;
bool getAC() {
  if (xc == 0 && yc == 0) {
    if (xd == 0 && yd == 0) {
      return true;
    } else
      return false;
  } else {
    long long tmp = xc * xc + yc * yc;
    long long t1 = yd * xc - xd * yc;
    long long t2 = yd * yc + xd * xc;
    if (t1 % tmp == 0 && t2 % tmp == 0) {
      return true;
    } else
      return false;
  }
}
int main() {
  cin >> xa >> ya >> xb >> yb >> xc >> yc;
  for (int i = 0; i < 4; i++) {
    if (i == 0) {
      xd = xb - xa;
      yd = yb - ya;
    } else if (i == 1) {
      xd = xb - ya;
      yd = yb + xa;
    } else if (i == 2) {
      xd = xb + xa;
      yd = yb + ya;
    } else if (i == 3) {
      xd = xb + ya;
      yd = yb - xa;
    }
    if (getAC()) {
      cout << "YES" << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
  return 0;
}
