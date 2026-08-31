#include <bits/stdc++.h>
using namespace std;
int main() {
  long long xa, ya, xb, yb, xc, yc, a, A;
  cin >> xa >> ya >> xb >> yb >> xc >> yc;
  if ((xa == xb) && (ya == yb))
    cout << "YES";
  else if ((xb == ya) && (yb == -xa))
    cout << "YES";
  else if ((xb == -xa) && (yb == -ya))
    cout << "YES";
  else if ((xb == -ya) && (yb == xa))
    cout << "YES";
  else if (((xc * xc) + (yc * yc)) == 0)
    cout << "NO";
  else {
    A = (xc * xc) + (yc * yc);
    a = (((xb - xa) * xc) + ((yb - ya) * yc));
    if (a % A == 0) {
      a = a / A;
      if ((yc != 0) && ((xb - xa - (xc * a)) % yc == 0)) {
        cout << "YES";
        return 0;
      } else if ((xc != 0) && ((yb - ya - (yc * a)) % xc == 0)) {
        cout << "YES";
        return 0;
      }
    }
    a = (((xb + ya) * xc) + ((yb - xa) * yc));
    if (a % A == 0) {
      a = a / A;
      if ((yc != 0) && ((xb + ya - (xc * a)) % yc == 0)) {
        cout << "YES";
        return 0;
      } else if ((xc != 0) && ((yb - xa - (yc * a)) % xc == 0)) {
        cout << "YES";
        return 0;
      }
    }
    a = (((xb + xa) * xc) + ((yb + ya) * yc));
    if (a % A == 0) {
      a = a / A;
      if ((yc != 0) && ((xb + xa - (xc * a)) % yc == 0)) {
        cout << "YES";
        return 0;
      } else if ((xc != 0) && ((yb + ya - (yc * a)) % xc == 0)) {
        cout << "YES";
        return 0;
      }
    }
    a = (((xb - ya) * xc) + ((yb + xa) * yc));
    if (a % A == 0) {
      a = a / A;
      if ((yc != 0) && ((xb - ya - (xc * a)) % yc == 0)) {
        cout << "YES";
        return 0;
      } else if ((xc != 0) && ((yb + xa - (yc * a)) % xc == 0)) {
        cout << "YES";
        return 0;
      }
    }
    cout << "NO";
  }
  return 0;
}
