#include <bits/stdc++.h>
using namespace std;
double delta(long long a, long long b, long long c) {
  long long res = 0;
  res = b * b - 4 * a * c;
  return res;
}
int main() {
  int n;
  double a, b, c;
  double r1, r2;
  cin >> a >> b >> c;
  if (a == 0) {
    n = (b == 0) ? 0 : 1;
    r1 = (b == 0) ? 0 : -c / b;
    if (b == 0 and c == 0) n = -1;
  } else {
    double d = delta(a, b, c);
    if (d > 0) {
      n = 2;
      r1 = (-b + sqrt(d)) / (2 * a);
      r2 = (-b - sqrt(d)) / (2 * a);
    } else if (d == 0) {
      n = 1;
      r1 = -b / (2 * a);
    } else {
      n = 0;
    }
  }
  cout << n << endl;
  if (n == 1) {
    printf("%.6f\n", r1);
  }
  if (n == 2) {
    if (r1 > r2) {
      printf("%.6f\n", r2);
      printf("%.6f\n", r1);
    } else {
      printf("%.6f\n", r1);
      printf("%.6f\n", r2);
    }
  }
}
