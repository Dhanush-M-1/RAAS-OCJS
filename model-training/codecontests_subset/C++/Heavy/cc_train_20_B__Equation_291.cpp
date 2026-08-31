#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c, d, r1, r2;
  cin >> a >> b >> c;
  if (a == 0 && b == 0 && c == 0)
    cout << "-1";
  else if (a == 0 && b == 0)
    cout << "0";
  else if (a == 0) {
    cout << "1" << endl;
    r1 = -c / b;
    printf("%5f", r1);
  } else {
    d = b * b - 4 * a * c;
    if (d < 0)
      cout << "0";
    else if (d == 0) {
      cout << "1" << endl;
      r1 = -b / (2 * a);
      printf("%5f", r1);
    } else {
      r1 = (-b + sqrt(d)) / (2 * a);
      r2 = (-b - sqrt(d)) / (2 * a);
      cout << "2" << endl;
      if (r1 < r2)
        printf("%5f %5f", r1, r2);
      else
        printf("%5f %5f", r2, r1);
    }
  }
  return 0;
}
