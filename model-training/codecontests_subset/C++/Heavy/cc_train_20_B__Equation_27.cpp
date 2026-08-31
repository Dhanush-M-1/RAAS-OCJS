#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c, d;
  cin >> a >> b >> c;
  if (!a && b) {
    cout << "1\n";
    cout << fixed << setprecision(7) << (-c / b);
    return 0;
  }
  if (!a && !b && !c) {
    cout << "-1";
    return 0;
  }
  d = b * b - 4 * a * c;
  if (d < 0 || (!a && !b && c)) {
    cout << "0";
    return 0;
  }
  d = sqrt(d);
  if (a < 0) d = d * -1;
  if (!d) {
    cout << "1\n";
    cout << fixed << setprecision(7) << ((-b - d) / (2 * a));
    return 0;
  } else {
    cout << "2\n";
    cout << fixed << setprecision(7) << ((-b - d) / (2 * a)) << "\n";
    cout << fixed << setprecision(7) << ((-b + d) / (2 * a)) << "\n";
    return 0;
  }
}
