#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  double f = 0, g = 0, i = 0;
  cin >> a >> b >> c;
  f = ((-1 * b + sqrt((b * b) - (4 * a * c))) / (2 * a));
  g = ((-1 * b - sqrt((b * b) - (4 * a * c))) / (2 * a));
  i = ((-1 * c) / b);
  if (a == 0 && b != 0) {
    cout << 1 << endl << fixed << setprecision(10) << i;
  } else if (a == 0 && b == 0 && c == 0) {
    cout << -1;
  } else if ((b * b) < (4 * a * c) || (a == 0 && b == 0)) {
    cout << 0;
  } else if (g == f) {
    cout << 1 << endl << fixed << setprecision(10) << g;
  } else {
    if (g < f) {
      cout << 2 << endl << fixed << setprecision(10) << g << endl << f;
    } else if (g > f) {
      cout << 2 << endl << fixed << setprecision(10) << f << endl << g;
    }
  }
  return 0;
}
