#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c, d;
  while (cin >> a >> b >> c) {
    d = b * b - 4 * a * c;
    if (!a && !b && !c) {
      cout << -1 << endl;
      continue;
    }
    if ((!a && !b && c) || d < 0) {
      cout << 0 << endl;
      continue;
    }
    if (!a && b) {
      printf("1\n%.9lf\n", (-c) / b);
      continue;
    }
    if (a > 0) {
      if (d > 0) {
        printf("2\n%.9lf\n%.9lf\n", ((-b - sqrt(d)) / (2 * a)),
               ((-b + sqrt(d)) / (2 * a)));
        continue;
      }
    } else {
      if (d > 0)
        printf("2\n%.9lf\n%.9lf\n", ((b - sqrt(d)) / (-2 * a)),
               ((b + sqrt(d)) / (-2 * a)));
    }
    if (d == 0) {
      printf("1\n%.9lf\n", (-b) / (2 * a));
      continue;
    }
  }
}
