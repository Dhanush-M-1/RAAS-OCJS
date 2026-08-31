#include <iostream>

using namespace std;

double outer_product (double* x, double* y, int i) {
  return (x[i] - x[(i+3)%4]) * (y[i] - y[(i+1)%4]) - (y[(i+3)%4] - y[i]) * (x[(i+1)%4] - x[i]);
}

int main () {
  double x[4], y[4];
  double z0;
  bool success;

  while (cin >> x[0]) {
    cin.ignore();
    cin >> y[0];
    for (int i = 1; i <= 3; i++) {
      cin.ignore();
      cin >> x[i];
      cin.ignore();
      cin >> y[i];
    }
    success = true;

    z0 = outer_product(x, y, 0);
    for (int i = 1; i < 4; i++) {
      if (outer_product(x, y, i) * z0 < 0) {
        success = false;
      }
    }

    if(success)
      cout << "YES" << endl;
    else
      cout << "NO" << endl;
  }
}