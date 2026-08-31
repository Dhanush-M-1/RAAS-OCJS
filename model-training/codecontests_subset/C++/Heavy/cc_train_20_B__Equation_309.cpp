#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, n, line;
  double A, B, C, x1, x2, mid;
  cin >> A >> B >> C;
  mid = (B * B) - (4 * A * C);
  if (A == 0 && B == 0 && C == 0) {
    printf("-1\n");
  } else if (A == 0 && B == 0)
    printf("0\n");
  else if (mid < 0.0)
    printf("0\n");
  else if (A == 0) {
    x1 = -C / B;
    printf("1\n%lf\n", x1);
  } else {
    mid = sqrt(mid);
    x1 = -B + mid;
    x1 = (x1 / (2.0 * A));
    x2 = -B - mid;
    x2 = (x2 / (2.0 * A));
    if (x1 == x2)
      printf("1\n%lf\n", x1);
    else if (x1 < x2)
      printf("2\n%lf\n%lf\n", x1, x2);
    else
      printf("2\n%lf\n%lf\n", x2, x1);
  }
  return 0;
}
