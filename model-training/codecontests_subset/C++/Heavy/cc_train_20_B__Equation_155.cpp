#include <bits/stdc++.h>
using namespace std;
double a, b, c;
int main() {
  cin >> a >> b >> c;
  double k = b * b;
  double l = 4 * a * c;
  if (a == 0) {
    if (b == 0 && c == 0) {
      cout << -1 << endl;
      return 0;
    }
    if (b == 0 && c != 0) {
      cout << 0 << endl;
      return 0;
    }
    if (c == 0) {
      cout << 1 << endl;
      printf("%.9f", 0);
    } else {
      cout << 1 << endl;
      printf("%.9f", -c / b);
    }
  } else {
    if (k - l < 0)
      cout << 0 << endl;
    else if (k - l == 0) {
      cout << 1 << endl;
      printf("%.9f\n", (sqrt(k - l) - b) / 2 / a);
    } else if (k - l > 0) {
      cout << 2 << endl;
      printf("%.9f\n%.9f\n",
             ((sqrt(k - l) - b) / 2 / a - (-sqrt(k - l) - b) / 2 / a) < 0
                 ? (sqrt(k - l) - b) / 2 / a
                 : (-sqrt(k - l) - b) / 2 / a,
             ((sqrt(k - l) - b) / 2 / a - (-sqrt(k - l) - b) / 2 / a) > 0
                 ? (sqrt(k - l) - b) / 2 / a
                 : (-sqrt(k - l) - b) / 2 / a);
    }
  }
  return 0;
}
