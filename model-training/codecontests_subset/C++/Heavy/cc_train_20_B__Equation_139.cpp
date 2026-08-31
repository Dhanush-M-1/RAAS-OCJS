#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c;
  cin >> a >> b >> c;
  long long d = b * b - 4 * a * c;
  if (a != 0) {
    double x = a, y = b;
    if (d < 0) cout << 0;
    if (d == 0) {
      cout << 1 << endl;
      printf("%lf", -y / (2 * x));
    }
    if (d > 0) {
      cout << 2 << endl;
      if (x > 0)
        printf("%lf\n%lf", (-y - sqrt(d)) / (2 * x), (-y + sqrt(d)) / (2 * x));
      else
        printf("%lf\n%lf", (-y + sqrt(d)) / (2 * x), (-y - sqrt(d)) / (2 * x));
    }
  } else {
    if (b == 0) {
      if (c == 0)
        cout << -1;
      else
        cout << 0;
    } else {
      double s = c, t = b;
      cout << 1 << endl;
      printf("%lf", -s / t);
    }
  }
}
