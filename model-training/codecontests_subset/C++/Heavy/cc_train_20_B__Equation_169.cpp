#include <bits/stdc++.h>
using namespace std;
const double eps = 1e-10;
int main() {
  int a, b, c;
  double delta;
  double A, B, C;
  long long aa, bb, cc;
  while (scanf("%d %d %d", &a, &b, &c) != EOF) {
    if (a == 0 && b == 0 && c == 0) {
      printf("-1\n");
      continue;
    }
    if (a == 0 && b == 0) {
      printf("0\n");
      continue;
    }
    B = b;
    C = c;
    if (a == 0) {
      printf("1\n");
      printf("%.10lf\n", -C / B);
      continue;
    }
    A = a;
    aa = a;
    bb = b;
    cc = c;
    if (bb * bb - 4LL * aa * cc < 0) {
      printf("0\n");
      continue;
    }
    if (bb * bb - 4LL * aa * cc == 0) {
      printf("1\n");
      printf("%.10lf\n", -B / A / 2.0);
      continue;
    }
    delta = B * B - 4 * A * C;
    printf("2\n");
    if (a < 0) {
      printf("%.10lf\n", (-B + sqrt(delta)) / A / 2.0);
      printf("%.10lf\n", (-B - sqrt(delta)) / A / 2.0);
    } else {
      printf("%.10lf\n", (-B - sqrt(delta)) / A / 2.0);
      printf("%.10lf\n", (-B + sqrt(delta)) / A / 2.0);
    }
  }
  return 0;
}
