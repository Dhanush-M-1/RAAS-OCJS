#include <bits/stdc++.h>
using namespace std;
int main() {
  float a, b, c;
  cin >> a >> b >> c;
  float d = (b * b - 4 * a * c);
  if (a == 0) {
    if (b == 0) {
      if (c == 0)
        cout << -1 << endl;
      else
        cout << 0 << endl;
    } else
      cout << 1 << endl << fixed << setprecision(6) << -c / b << endl;
  } else {
    if (d == 0) {
      cout << 1 << endl;
      cout << fixed << setprecision(6) << -b / (2 * a) << endl;
    } else {
      if (d < 0)
        cout << 0 << endl;
      else {
        d = sqrt(b * b - 4 * a * c);
        cout << 2 << endl;
        float x = (-b - d) / (2 * a);
        float y = (-b + d) / (2 * a);
        cout << fixed << setprecision(6) << min(x, y) << endl;
        cout << fixed << setprecision(6) << max(x, y) << endl;
      }
    }
  }
}
