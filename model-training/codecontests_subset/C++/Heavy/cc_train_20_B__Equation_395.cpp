#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0) {
      if (c == 0) {
        printf("-1");
      } else {
        printf("0");
      }
    } else {
      printf("1\n%f", -c / b);
    }
  } else {
    if (b * b - 4 * a * c < -1E-6) {
      printf("0");
    } else {
      if (fabs(b * b - 4 * a * c) < 1E-6) {
        printf("1\n%f", -b / (2 * a));
      } else {
        if (a > 0) {
          printf("2\n%f\n%f", (-b - sqrt(b * b - 4 * a * c)) / (2 * a),
                 (-b + sqrt(b * b - 4 * a * c)) / (2 * a));
        } else {
          printf("2\n%f\n%f", (-b + sqrt(b * b - 4 * a * c)) / (2 * a),
                 (-b - sqrt(b * b - 4 * a * c)) / (2 * a));
        }
      }
    }
  }
}
