#include <bits/stdc++.h>
using namespace std;
double A, B, C;
void Output(int n, double x = 0, double y = 0) {
  printf("%d\n", n);
  if (n >= 2 && x > y) swap(x, y);
  if (n >= 1) printf("%.6f\n", x);
  if (n >= 2) printf("%.6f\n", y);
}
int main(void) {
  scanf("%lf%lf%lf", &A, &B, &C);
  if (fabs(A) == 0) {
    if (fabs(B) == 0) {
      if (fabs(C) == 0)
        Output(-1);
      else
        Output(0);
    } else
      Output(1, -C / B);
  } else {
    double D = B * B - 4 * A * C;
    if (D < -1e-6)
      Output(0);
    else if (D < 1e-6)
      Output(1, -B / 2 / A);
    else
      Output(2, (-B - sqrt(D)) / 2 / A, (-B + sqrt(D)) / 2 / A);
  }
  return 0;
}
