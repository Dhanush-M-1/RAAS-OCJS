#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  double p, q;
  while (cin >> a >> b >> c) {
    if (a == 0 && b == 0 && c == 0)
      cout << -1 << endl;
    else if (a == 0 && b == 0 && c != 0)
      cout << 0 << endl;
    else if (a == 0) {
      if (b != 0 && c == 0) {
        cout << 1 << endl;
        p = 0 * 1.0;
        printf("%lf\n", p);
      } else {
        cout << 1 << endl;
        p = 1.0 * (-c / b);
        printf("%lf", p);
      }
    } else {
      if (b * b - 4 * a * c == 0) {
        cout << 1 << endl;
        p = -b / (2 * a) * 1.0;
        if (!p) p = 0;
        printf("%lf\n", p);
      } else if (b * b - 4 * a * c > 0) {
        cout << 2 << endl;
        p = (-b - sqrt(b * b - 4 * a * c)) / (2 * a) * 1.0;
        q = (-b + sqrt(b * b - 4 * a * c)) / (2 * a) * 1.0;
        if (p > q) swap(p, q);
        printf("%lf\n%lf\n", p, q);
      } else
        cout << 0;
    }
  }
  return 0;
}
