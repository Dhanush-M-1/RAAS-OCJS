#include <bits/stdc++.h>
using namespace std;
double a, b, c, x, x1, x2, d;
int main() {
  cin >> a >> b >> c;
  d = b * b - 4 * a * c;
  if (a == 0 && b == 0 && c != 0) {
    cout << 0 << endl;
    return 0;
  }
  if (a == 0 && b == 0 && c == 0) {
    cout << -1 << endl;
    return 0;
  }
  if (a == 0 && b != 0) {
    cout << 1 << endl;
    printf("%.5f", (-c) / b);
    return 0;
  }
  if (d == 0) {
    cout << 1 << endl;
    x = (-b + sqrt(d)) / (2 * a);
    printf("%.5f", x);
    return 0;
  }
  if (d < 0) {
    cout << 0;
    return 0;
  }
  cout << 2 << endl;
  x2 = (-b + sqrt(d)) / (2 * a);
  x1 = (-b - sqrt(d)) / (2 * a);
  if (x1 > x2) swap(x1, x2);
  printf("%.5f\n", x1);
  printf("%.5f\n", x2);
}
