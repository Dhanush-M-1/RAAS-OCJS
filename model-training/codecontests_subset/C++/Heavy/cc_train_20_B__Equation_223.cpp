#include <bits/stdc++.h>
using namespace std;
double min(double a, double b) { return a < b ? a : b; }
double max(double a, double b) { return a > b ? a : b; }
int main() {
  double a, b, c, x1, x2, dlta;
  int num;
  while (cin >> a >> b >> c) {
    if (a == 0 && b == 0 && c == 0) {
      cout << "-1" << endl;
      continue;
    }
    if (a == 0 && b == 0 && c != 0) {
      cout << '0' << endl;
      continue;
    }
    if (a == 0 && b != 0) {
      x1 = (-1 * c) / b;
      num = 1;
      cout << num << endl;
      printf("%.10lf\n", x1);
      continue;
    }
    if (a != 0) {
      dlta = b * b - 4 * a * c;
      if (dlta > 0) {
        x1 = (-b + sqrt(dlta)) / (2 * a);
        x2 = (-b - sqrt(dlta)) / (2 * a);
        num = 2;
        cout << num << endl;
        printf("%.10lf\n%.10lf\n", min(x1, x2), max(x1, x2));
        continue;
      }
      if (dlta == 0) {
        x1 = -b / (2 * a);
        cout << '1' << endl;
        printf("%.10lf\n", x1);
        continue;
      }
      if (dlta < 0) {
        cout << '0' << endl;
        continue;
      }
    }
  }
  return 0;
}
