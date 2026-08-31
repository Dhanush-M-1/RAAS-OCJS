#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c, det, x1, x2;
  cout.precision(15);
  cin >> a >> b >> c;
  det = b * b - 4 * a * c;
  if (a == 0 && b == 0 && c == 0)
    cout << -1;
  else if (a == 0 && b == 0 || det < 0)
    cout << 0;
  else if (a == 0)
    cout << 1 << endl << -c / b;
  else {
    if (det == 0)
      cout << 1 << endl << fixed << -1 * b / (2 * a);
    else {
      x1 = (-b - sqrt(det)) / (2 * a);
      x2 = (-b + sqrt(det)) / (2 * a);
      if (x1 > x2) swap(x1, x2);
      cout << 2 << endl << fixed << x1 << endl << fixed << x2;
    }
  }
}
