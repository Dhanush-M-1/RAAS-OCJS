#include <bits/stdc++.h>
using namespace std;
void PTBac1(long long a, long long b) {
  if (a == 0) {
    if (b == 0) {
      cout << "-1";
    } else {
      cout << "0";
    }
  } else {
    cout << "1\n";
    cout << fixed << setprecision(5) << 1.0 * -b / a;
  }
}
void PTBac2(long long a, long long b, long long c) {
  long long delta = b * b - 4 * a * c;
  if (delta < 0) {
    cout << "0";
  } else if (delta == 0) {
    cout << "1\n";
    cout << fixed << setprecision(5) << -1.0 * b / 2 / a;
  } else {
    cout << "2\n";
    double x1 = (-b + sqrt(delta)) / 2 / a;
    double x2 = (-b - sqrt(delta)) / 2 / a;
    if (x1 < x2) {
      cout << fixed << setprecision(5) << x1 << endl;
      cout << fixed << setprecision(5) << x2;
    } else {
      cout << fixed << setprecision(5) << x2 << endl;
      cout << fixed << setprecision(5) << x1;
    }
  }
}
int main() {
  long long a, b, c;
  cin >> a >> b >> c;
  if (a == 0) {
    PTBac1(b, c);
  } else {
    PTBac2(a, b, c);
  }
  return 0;
}
