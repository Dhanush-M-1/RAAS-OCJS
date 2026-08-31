#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c, e, f, g, h;
  double x1, x2, x3, z, m, d;
  cin >> a >> b >> c;
  m = ((b * b) - (4 * a * c));
  if (m < 0) {
    cout << 0 << endl;
  } else if (a == 0) {
    if (b == 0 && c != 0) {
      cout << 0 << endl;
    } else if (b == 0 && c == 0) {
      cout << -1 << endl;
    } else {
      cout << 1 << endl;
      d = (-c) / b;
      printf("%5lf", d);
      cout << endl;
    }
  } else {
    x1 = ((-b) + sqrt(m)) / (2 * a);
    x2 = ((-b) - sqrt(m)) / (2 * a);
    if (x1 == x2) {
      cout << "1" << endl;
      printf("%5lf", x1);
      cout << endl;
    } else if (x1 > x2) {
      cout << "2" << endl;
      printf("%5lf", x2);
      cout << endl;
      printf("%5lf", x1);
      cout << endl;
    } else {
      cout << "2" << endl;
      printf("%5lf", x1);
      cout << endl;
      printf("%5lf", x2);
      cout << endl;
    }
  }
}
