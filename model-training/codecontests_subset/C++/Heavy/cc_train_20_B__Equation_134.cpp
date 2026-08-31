#include <bits/stdc++.h>
using namespace std;
int main() {
  long long a, b, c;
  cin >> a >> b >> c;
  long long det = b * b - 4 * a * c;
  if (a == 0 && b == 0 && c == 0) {
    cout << -1;
    return 0;
  }
  if (a == 0 && b == 0 && c != 0) {
    cout << 0;
    return 0;
  }
  if (a == 0 && b != 0) {
    cout << 1 << '\n';
    double r = -(c / double(b));
    cout << fixed << setprecision(15) << r;
    return 0;
  }
  if (det < 0) {
    cout << 0;
    return 0;
  } else if (det == 0) {
    cout << fixed;
    double x = (-b) / double(2 * a);
    cout << 1 << '\n';
    cout << setprecision(15) << x;
    return 0;
  } else {
    double root1 = (-b + sqrt(det)) / double(2 * a);
    double root2 = (-b - sqrt(det)) / double(2 * a);
    cout << 2 << '\n';
    cout << fixed;
    if (root1 > root2) {
      cout << setprecision(15) << root2 << '\n' << root1;
      return 0;
    } else {
      cout << setprecision(15) << root1 << '\n' << root2;
      return 0;
    }
    return 0;
  }
}
