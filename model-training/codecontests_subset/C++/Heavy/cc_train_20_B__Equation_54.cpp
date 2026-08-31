#include <bits/stdc++.h>
using namespace std;
int main() {
  cout << setprecision(6) << fixed;
  double a, b, c;
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0) {
      if (c == 0) {
        cout << -1;
      } else {
        cout << 0;
      }
    } else {
      cout << 1 << endl;
      cout << -c / b;
    }
  } else if (pow(b, 2) == 4 * a * c) {
    cout << 1 << endl;
    cout << -b / (2 * a);
  } else if (4 * a * c > pow(b, 2)) {
    cout << 0;
  } else if (pow(b, 2) > 4 * a * c) {
    cout << 2 << endl;
    double g = (-b - sqrt(pow(b, 2) - 4 * a * c)) / (2 * a);
    double h = (-b + sqrt(pow(b, 2) - 4 * a * c)) / (2 * a);
    cout << min(g, h) << endl;
    cout << max(g, h);
  }
}
