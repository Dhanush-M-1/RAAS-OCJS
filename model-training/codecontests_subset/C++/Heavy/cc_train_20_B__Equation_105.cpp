#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c, dt;
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0 && c == 0)
      cout << -1;
    else if (b == 0 && c != 0)
      cout << 0;
    else if (b != 0 && c != 0) {
      cout << 1 << "\n";
      printf("%.8lf", -c / b);
    } else {
      cout << 1 << "\n" << 0.00000000;
    }
  } else {
    dt = b * b - 4 * a * c;
    if (dt < 0) {
      cout << 0;
    } else if (dt == 0) {
      cout << 1 << "\n";
      printf("%.8lf", -b / (2 * a));
    } else {
      cout << 2 << "\n";
      double x = (-b - sqrt(dt)) / (2 * a);
      double y = (-b + sqrt(dt)) / (2 * a);
      if (x < y)
        printf("%.8lf\n%.8lf", x, y);
      else
        printf("%.8lf\n%.8lf", y, x);
    }
  }
}
