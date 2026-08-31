#include <iostream>

using namespace std;

int p(double x1, double x2, double x3, double x4) {
  return x1 * x4 - x2 * x3;
}

int main() {
  double x[4], y[4];
  while (scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf\n", &x[0], &y[0], &x[1], &y[1], &x[2], &y[2], &x[3], &y[3]) != EOF) {
    double dt[4];
    for (int i = 0; i < 4; i++) {
      dt[i] = p(x[(i+1)%4]-x[i], y[(i+1)%4]-y[i], x[(i+2)%4]-x[i], y[(i+2)%4]-y[i]);
    }
    if ((dt[0] > 0 && dt[1] > 0 && dt[2] > 0 && dt[3] > 0) ||
        (dt[0] < 0 && dt[1] < 0 && dt[2] < 0 && dt[3] < 0)) {
      cout << "YES" << endl;
    } else {
      cout << "NO" << endl;
    }
  }

  return 0;
}