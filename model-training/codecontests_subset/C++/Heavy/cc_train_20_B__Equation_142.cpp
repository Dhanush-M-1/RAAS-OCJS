#include <bits/stdc++.h>
using namespace std;
double a, b, c, d;
int main() {
  cin >> a >> b >> c;
  if (a == b && a == c && a == 0) {
    cout << -1;
    return 0;
  }
  if (a == 0 && b == 0) {
    cout << 0;
    return 0;
  }
  if (a == 0) {
    cout << 1 << endl;
    cout << fixed;
    cout << setprecision(9) << -c / b;
    return 0;
  }
  d = b * b - 4 * a * c;
  if (d < 0) {
    cout << 0;
    return 0;
  }
  if (d == 0) {
    cout << 1 << endl;
    cout << fixed;
    cout << setprecision(6) << (-b - sqrt(d)) / ((double)2 * a);
    return 0;
  }
  cout << 2 << endl;
  cout << fixed;
  if ((-b - sqrt(d)) / ((double)2 * a) < (-b + sqrt(d)) / ((double)2 * a)) {
    cout << setprecision(9) << (-b - sqrt(d)) / ((double)2 * a) << endl;
    cout << setprecision(9) << (-b + sqrt(d)) / ((double)2 * a) << endl;
  } else {
    cout << setprecision(9) << (-b + sqrt(d)) / ((double)2 * a) << endl;
    cout << setprecision(9) << (-b - sqrt(d)) / ((double)2 * a) << endl;
  }
}
