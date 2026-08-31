#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c, d, x1, x2;
  cin >> a >> b >> c;
  d = (b * b) - 4 * a * c;
  if (a == 0 && b == 0 && c == 0)
    cout << "-1\n";
  else if (a == 0 && b == 0)
    cout << "0\n";
  else if (d < 0)
    cout << "0\n";
  else if (a == 0) {
    cout << "1\n";
    printf("%0.7lf\n", -c / b);
  } else if (d == 0) {
    cout << "1\n";
    printf("%0.7lf\n", -b / (2 * a));
  } else {
    d = sqrt(d);
    x1 = (-b - d) / (2 * a);
    x2 = (-b + d) / (2 * a);
    cout << "2\n";
    printf("%0.7lf\n%0.7lf\n", min(x1, x2), max(x1, x2));
  }
  return 0;
}
