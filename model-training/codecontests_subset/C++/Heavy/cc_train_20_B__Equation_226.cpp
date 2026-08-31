#include <bits/stdc++.h>
int main() {
  double a, b, c, p, root1, root2;
  scanf(" %lf%lf%lf", &a, &b, &c);
  if (a != 0) {
    p = b * b - 4 * a * c;
    if (p < 0)
      printf("0\n");
    else {
      if (p == 0) {
        printf("1\n");
        root1 = -b / (2 * a);
        printf("%.6lf", root1);
      } else {
        printf("2\n");
        p = sqrt(p);
        root1 = (-b - p) / (2 * a);
        root2 = (-b + p) / (2 * a);
        if (root1 < root2) {
          printf("%.6lf\n", root1);
          printf("%.6lf\n", root2);
        } else {
          printf("%.6lf\n", root2);
          printf("%.6lf\n", root1);
        }
      }
    }
  } else {
    if (b != 0) {
      root1 = -c / b;
      printf("1\n");
      printf("%.6lf", root1);
    } else {
      if (c == 0)
        printf("-1\n");
      else
        printf("0\n");
    }
  }
  return 0;
}
