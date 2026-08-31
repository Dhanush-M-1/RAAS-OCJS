#include <bits/stdc++.h>
using namespace std;
int main() {
  double i, k, l, j, x1, y1, x2, y2, x3, y3, a, b, c, d;
  cin >> x1 >> y1 >> x2 >> y2 >> x3 >> y3;
  if (x3 == 0 && y3 == 0) {
    if ((x1 + x2) == 0 && (y2 + y1) == 0) {
      cout << "YES" << endl;
      return 0;
    } else if ((x1 - x2) == 0 && (y2 - y1) == 0) {
      cout << "YES" << endl;
      return 0;
    } else if ((x1 + y2) == 0 && (x2 - y1) == 0) {
      cout << "YES" << endl;
      return 0;
    } else if ((x1 - y2) == 0 && (x2 + y1) == 0) {
      cout << "YES" << endl;
      return 0;
    }
  } else {
    a = x1 + x2;
    b = y1 + y2;
    c = abs((a * x3 + b * y3) / (x3 * x3 + y3 * y3));
    d = abs((b * x3 - a * y3) / (x3 * x3 + y3 * y3));
    if (floor(c) == c && floor(d) == d) {
      cout << "YES" << endl;
      return 0;
    }
    a = -x1 + x2;
    b = -y1 + y2;
    c = abs((a * x3 + b * y3) / (x3 * x3 + y3 * y3));
    d = abs((b * x3 - a * y3) / (x3 * x3 + y3 * y3));
    if (floor(c) == c && floor(d) == d) {
      cout << "YES" << endl;
      return 0;
    }
    a = -y1 + x2;
    b = x1 + y2;
    c = abs((a * x3 + b * y3) / (x3 * x3 + y3 * y3));
    d = abs((b * x3 - a * y3) / (x3 * x3 + y3 * y3));
    if (floor(c) == c && floor(d) == d) {
      cout << "YES" << endl;
      return 0;
    }
    a = y1 + x2;
    b = -x1 + y2;
    c = abs((a * x3 + b * y3) / (x3 * x3 + y3 * y3));
    d = abs((b * x3 - a * y3) / (x3 * x3 + y3 * y3));
    if (floor(c) == c && floor(d) == d) {
      cout << "YES" << endl;
      return 0;
    }
  }
  cout << "NO" << endl;
  return 0;
}
