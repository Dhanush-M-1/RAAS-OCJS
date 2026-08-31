#include <bits/stdc++.h>
using namespace std;
double a, b, c;
int main() {
  cin >> a >> b >> c;
  if (a == 0) {
    if (b == 0) {
      if (c == 0)
        cout << -1;
      else
        cout << 0;
    } else {
      cout << 1 << endl;
      double x = -c / b;
      printf("%.8f", x);
    }
  } else {
    double D = b * b - 4 * a * c;
    if (D < 0) {
      cout << 0 << endl;
    } else if (D == 0) {
      cout << 1 << endl;
      printf("%.8f", -b / (2 * a));
    } else {
      cout << 2 << endl;
      printf("%.8f", min((-b - sqrt(D)) / (2 * a), (-b + sqrt(D)) / (2 * a)));
      cout << endl;
      printf("%.8f", max((-b - sqrt(D)) / (2 * a), (-b + sqrt(D)) / (2 * a)));
    }
  }
}
