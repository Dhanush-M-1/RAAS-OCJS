#include <bits/stdc++.h>
using namespace std;
int main() {
  int tc;
  double a, b, c;
  cin >> a >> b >> c;
  double D = b * b - 4 * a * c;
  int n;
  if (D < 0) {
    printf("0\n");
  } else if (a == 0 && b == 0 && c == 0)
    cout << "-1" << endl;
  else if (a == 0 && b == 0)
    cout << "0" << endl;
  else if (a == 0 && b != 0) {
    {
      cout << "1\n";
      printf("%lf\n", -c / b);
      n = -1;
    }
  } else {
    if (D == 0) {
      cout << "1\n";
      n = 1;
    } else {
      cout << "2\n";
      n = 2;
    }
    double x1, x2;
    x1 = (-b + sqrt(D)) / (2 * a);
    x2 = (-b - sqrt(D)) / (2 * a);
    if (n == 2) {
      if (x1 < x2)
        printf("%lf\n%lf\n", x1, x2);
      else
        printf("%lf\n%lf\n", x2, x1);
    } else {
      printf("%lf\n", x1);
    }
  }
  return 0;
}
