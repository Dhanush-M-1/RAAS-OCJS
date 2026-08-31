#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c, d;
  double x1, x2;
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0) {
      if (c == 0)
        cout << -1 << endl;
      else
        cout << 0 << endl;
    } else
      printf("1\n%f\n", -1 * c / b);
  } else {
    d = b * b - 4 * a * c;
    if (d < 0)
      cout << 0 << endl;
    else {
      x1 = (-1 * b - sqrt(d)) / (2.0 * a);
      x2 = (-1 * b + sqrt(d)) / (2.0 * a);
      if (x1 > x2) {
        double temp = x1;
        x1 = x2;
        x2 = temp;
      }
      if (x1 != x2)
        printf("2\n%f\n%f\n", x1, x2);
      else
        printf("1\n%f\n", x1);
    }
  }
  return 0;
}
