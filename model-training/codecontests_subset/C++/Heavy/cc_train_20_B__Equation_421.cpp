#include <bits/stdc++.h>
using namespace std;
using namespace std;
int main() {
  double A, B, C;
  double eps = 1e-9;
  cin >> A >> B >> C;
  double D = B * B - 4.0 * A * C;
  if (fabs(A) < eps) {
    if (fabs(B) < eps) {
      if (fabs(C) < eps)
        cout << "-1";
      else
        cout << "0";
    } else {
      cout << "1\n";
      double x = -C / B;
      printf("%.9f", x);
    }
  } else if (D < -eps) {
    cout << "0";
  } else {
    double x1 = (-B + sqrt(D)) / (2.0 * A);
    double x2 = (-B - sqrt(D)) / (2.0 * A);
    if (fabs(D) < eps) {
      cout << "1\n";
      printf("%.9f", x1);
    } else {
      cout << "2\n";
      if (x1 > x2) swap(x1, x2);
      printf("%.9f\n", x1);
      printf("%.9f", x2);
    }
  }
  return 0;
}
