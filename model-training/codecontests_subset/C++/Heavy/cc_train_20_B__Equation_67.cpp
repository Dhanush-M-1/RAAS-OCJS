#include <bits/stdc++.h>
using namespace std;
const int O = 2e9;
const double E = 1e-9;
const double api = 3.1415926536;
int DX[] = {1, -1, -1, 1};
int DY[] = {-1, 1, 1, -1};
int main() {
  long double a, b, c;
  cin >> a >> b >> c;
  if (a == b && b == c && a == 0) {
    cout << -1 << endl;
    return 0;
  }
  if (a == b && b == 0 && c != 0) {
    cout << 0 << endl;
    return 0;
  }
  if (a == 0) {
    cout << 1 << endl
         << fixed << setprecision(10) << ((double)-1 * c / b) << endl;
    return 0;
  }
  long double sq = b * b - 4 * a * c;
  if (sq < 0) {
    cout << 0 << endl;
    return 0;
  }
  sq = sqrt(sq);
  if (sq == 0) {
    cout << 1 << endl << fixed << setprecision(10) << -b / (2 * a) << endl;
    return 0;
  }
  double r1 = (-b + sq) / (2 * a);
  double r2 = (-b - sq) / (2 * a);
  if (r1 == r2)
    cout << 1 << endl << fixed << setprecision(10) << r1 << endl;
  else
    cout << 2 << endl
         << fixed << setprecision(10) << min(r1, r2) << endl
         << max(r1, r2) << endl;
  ;
  return 0;
}
