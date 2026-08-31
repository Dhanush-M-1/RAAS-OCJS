#include <bits/stdc++.h>
using namespace std;
double A, B, C, d;
void Stampa(double x) { cout << fixed << setprecision(7) << x << endl; }
double Delta() { return pow(B, 2) - 4 * A * C; }
int main() {
  ios::sync_with_stdio(false);
  cin >> A >> B >> C;
  if (A == 0) {
    if (B == 0 && C == 0) {
      cout << "-1\n";
      return 0;
    } else if (B == 0 && C != 0) {
      cout << "0\n";
      return 0;
    } else if (B != 0 && C == 0) {
      cout << "1\n";
      Stampa(0);
      return 0;
    } else {
      cout << "1\n";
      Stampa(-C / B);
      return 0;
    }
  } else if (B == 0) {
    if (C == 0) {
      cout << "1\n";
      Stampa(0);
      return 0;
    } else {
      if ((-C / A) < 0) {
        cout << "0\n";
        return 0;
      }
      double x1 = sqrt((-C / A));
      double x2 = -x1;
      cout << "2\n";
      Stampa(x2);
      Stampa(x1);
      return 0;
    }
  } else if (C == 0) {
    double x = (-B / A);
    cout << "2\n";
    if (x > 0) {
      Stampa(0);
      Stampa(x);
    } else {
      Stampa(x);
      Stampa(0);
    }
    return 0;
  } else {
    d = Delta();
    if (d < 0) {
      cout << "0\n";
      return 0;
    } else if (d == 0) {
      cout << "1\n";
      Stampa(-B / (2 * A));
      return 0;
    } else {
      double x1 = ((-B - sqrt(d)) / (2 * A));
      double x2 = ((-B + sqrt(d)) / (2 * A));
      cout << "2\n";
      Stampa(min(x1, x2));
      Stampa(max(x1, x2));
    }
  }
  return 0;
}
