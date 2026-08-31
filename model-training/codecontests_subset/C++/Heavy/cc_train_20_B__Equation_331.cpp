#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c, d, e, f, g;
  cin >> a >> b >> c;
  if (a == 0 && b == 0 && c == 0) {
    cout << "-1";
    return 0;
  }
  if (a == 0 && b == 0) {
    cout << "0" << endl;
    return 0;
  }
  if (a == 0) {
    cout << "1" << endl;
    cout << std ::fixed;
    cout << setprecision(7) << (-c) / b << endl;
    return 0;
  }
  d = (b * b) - (4 * a * c);
  e = (-b + sqrt(d)) / (2 * a);
  f = (-b - sqrt(d)) / (2 * a);
  g = (-b) / (2 * a);
  if (d == 0) {
    cout << "1" << endl;
    cout << std ::fixed;
    cout << setprecision(7) << g << endl;
  }
  if (d < 0) {
    cout << 0 << endl;
  }
  if (d > 0) {
    cout << "2" << endl;
    if (e > f) {
      cout << std ::fixed;
      cout << setprecision(7) << f << endl;
      cout << std ::fixed;
      cout << setprecision(7) << e << endl;
    } else if (e < f) {
      cout << std ::fixed;
      cout << setprecision(7) << e << endl;
      cout << std ::fixed;
      cout << setprecision(7) << f << endl;
    }
  }
}
