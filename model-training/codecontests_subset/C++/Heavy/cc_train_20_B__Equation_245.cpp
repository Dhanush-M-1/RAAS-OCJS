#include <bits/stdc++.h>
using namespace std;
long long int r, j, l, x, y, m, c, n, s, f, q, i, z, p, k, d, t, u, e, g, w;
string s1, s2, s3, s4;
int main() {
  cin >> x >> y >> z;
  if (x == 0) {
    if (y == 0) {
      if (z == 0)
        cout << -1;
      else
        cout << 0;
    } else {
      printf("1\n");
      double d = -(z * 1.0) / (y * 1.0);
      printf("%.9f", d);
    }
  } else if (y == 0) {
    p = x * z;
    if (p > 0)
      cout << 0;
    else if (p == 0) {
      cout << "1\n0.00000000";
    } else {
      printf("2\n");
      double d = abs(z * 1.0 / (x * 1.00));
      d = sqrt(d);
      printf("%.9f\n%.9f", -d, d);
    }
  } else {
    p = y * y - (4 * x * z);
    if (p < 0)
      cout << 0;
    else if (p == 0) {
      cout << "1\n";
      double d = -(y * 1.00) / (2 * x * 1.000);
      printf("%.9f", d);
    } else {
      double d = sqrt((double)(p * 1.0000));
      double d1 = (-y + d) / (2 * x * 1.00);
      double d2 = (-y - d) / (2 * x * 1.00);
      cout << "2\n";
      if (d1 < d2)
        printf("%.9f\n%.9f", d1, d2);
      else
        printf("%.9f\n%.9f", d2, d1);
    }
  }
}
