#include <bits/stdc++.h>
using namespace std;
int main() {
  double i, a, b, c;
  double ans, d, r1, r2;
  cin >> a >> b >> c;
  d = (b * b - 4 * a * c);
  if (a == 0 && (b == 0 && c == 0)) {
    cout << "-1";
  } else if (a == 0 && b != 0) {
    r1 = -c / b;
    printf("1\n%.6f", r1);
  } else if (a == 0 && b == 0) {
    cout << "0";
  } else {
    if (d == 0) {
      ans = 1;
      r1 = -b / (2 * a);
      printf("1\n%.6f", r1);
    } else if (d < 0) {
      ans = 0;
      cout << ans;
    } else {
      ans = 2;
      r1 = (-b + sqrt(d)) / (2 * a);
      r2 = (-b - sqrt(d)) / (2 * a);
      if (r2 >= r1)
        printf("2\n%6f\n%6f", r1, r2);
      else
        printf("2\n%6f\n%6f", r2, r1);
    }
  }
}
