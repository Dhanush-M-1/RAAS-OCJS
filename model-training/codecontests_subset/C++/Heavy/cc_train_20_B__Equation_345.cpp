#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  while (cin >> a >> b >> c) {
    if (a != 0) {
      if (b * b - 4 * a * c < 0)
        cout << 0 << endl;
      else if (b * b - 4 * a * c == 0) {
        printf("%d\n", 1);
        printf("%.10lf\n", -b / (2 * a));
      } else if (b * b - 4 * a * c > 0) {
        cout << 2 << endl;
        if ((-b + sqrt(b * b - 4 * a * c)) / 2 * a <
            (-b - sqrt(b * b - 4 * a * c)) / (2 * a)) {
          printf("%.10lf\n", (-b + sqrt(b * b - 4 * a * c)) / (2 * a));
          printf("%.10lf\n", (-b - sqrt(b * b - 4 * a * c)) / (2 * a));
        } else {
          printf("%.10lf\n", (-b - sqrt(b * b - 4 * a * c)) / (2 * a));
          printf("%.10lf\n", (-b + sqrt(b * b - 4 * a * c)) / (2 * a));
        }
      }
    } else if (b != 0) {
      cout << 1 << endl;
      printf("%.10lf\n", -c / b);
    } else if (c != 0) {
      cout << 0 << endl;
    } else
      cout << -1 << endl;
  }
  return 0;
}
