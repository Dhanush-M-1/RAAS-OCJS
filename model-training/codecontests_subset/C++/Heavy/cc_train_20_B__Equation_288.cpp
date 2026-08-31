#include <bits/stdc++.h>
using namespace std;
int main() {
  double a;
  double b;
  double c;
  cin >> a;
  cin >> b;
  cin >> c;
  double D = (b * b) - (4 * a * c);
  double x = (sqrt(D) - b) / (2 * a);
  double y = (-(sqrt(D)) - b) / (2 * a);
  double z = ((-1) * c) / b;
  if (a == 0 && b == 0 && c == 0) {
    cout << "-1" << endl;
  } else if (a == 0 && b != 0) {
    cout << "1" << endl;
    printf("%.10f\n", z);
  } else if (D < 0 || (a == 0 && b == 0)) {
    cout << "0" << endl;
  } else if (D == 0) {
    cout << "1" << endl;
    printf("%.10f\n", x);
  } else {
    cout << "2" << endl;
    if (x > y) {
      printf("%.10f\n", y);
      printf("%.10f\n", x);
    } else {
      printf("%.10f\n", x);
      printf("%.10f\n", y);
    }
  }
  return 0;
}
