#include <bits/stdc++.h>
using namespace std;
int main() {
  double A, B, C;
  const double EPSILON = 1e-6;
  cin >> A >> B >> C;
  if (fabs(A) < EPSILON) {
    if (fabs(B) < EPSILON) {
      if (fabs(C) < EPSILON)
        cout << -1 << endl;
      else
        cout << 0 << endl;
    } else {
      cout << 1 << endl;
      double x1 = -C / B;
      if (fabs(x1) < EPSILON) x1 = 0;
      printf("%.10lf\n", x1);
    }
  } else {
    double det = B * B - 4 * A * C;
    if (det < -EPSILON)
      cout << 0 << endl;
    else {
      double x1 = (-B + sqrt(det)) / A / 2;
      double x2 = (-B - sqrt(det)) / A / 2;
      if (fabs(x1) < EPSILON) x1 = 0;
      if (fabs(x2) < EPSILON) x2 = 0;
      if (fabs(x1 - x2) < EPSILON) {
        cout << 1 << endl;
        printf("%.10lf\n", x1);
      } else {
        cout << 2 << endl;
        if (x1 > x2) swap(x1, x2);
        printf("%.10lf\n%.10lf\n", x1, x2);
      }
    }
  }
}
