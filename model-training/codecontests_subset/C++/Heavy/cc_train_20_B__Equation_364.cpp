#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  double a, b, c;
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0 && c == 0) {
      cout << "-1" << endl;
      return 0;
    }
    if (b == 0 && c != 0) {
      cout << "0" << endl;
      return 0;
    }
    cout << "1" << endl;
    cout << fixed << setprecision(10) << -c / b << endl;
  } else {
    if (b * b - 4 * a * c < 0) {
      cout << "0" << endl;
      return 0;
    }
    if (b * b - 4 * a * c == 0) {
      cout << "1" << endl;
      cout << fixed << setprecision(10) << -b / 2 / a << endl;
    }
    if (b * b - 4 * a * c > 0) {
      cout << "2" << endl;
      cout << fixed << setprecision(10);
      cout << min((-b - sqrt(b * b - 4 * a * c)) / 2 / a,
                  (-b + sqrt(b * b - 4 * a * c)) / 2 / a)
           << endl;
      cout << max((-b - sqrt(b * b - 4 * a * c)) / 2 / a,
                  (-b + sqrt(b * b - 4 * a * c)) / 2 / a)
           << endl;
    }
  }
  return 0;
}
