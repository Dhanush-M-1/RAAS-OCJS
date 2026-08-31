#include <bits/stdc++.h>
int main() {
  double a, b, c;
  scanf("%lf%lf%lf", &a, &b, &c);
  if (a == 0 && b == 0 && c == 0) {
    printf("-1");
    return 0;
  } else if (a == 0 && b == 0) {
    printf("0");
    return 0;
  } else if (b == 0 && c == 0) {
    printf("1\n%lf", 0);
    return 0;
  } else if (a == 0 && c == 0) {
    printf("1\n%lf", 0);
    return 0;
  } else if (a == 0) {
    printf("1\n%lf", (-c / b));
    return 0;
  } else if (b == 0) {
    if ((-c / a) < 0) {
      printf("0");
      return 0;
    }
    printf("2\n%lf %lf", (-sqrt(-c / a)), (sqrt(-c / a)));
    return 0;
  } else if (c == 0) {
    if ((b / a) < 0) {
      printf("2\n0.000000 %lf", (-b / a));
      return 0;
    } else {
      printf("2\n%lf 0.000000", (-b / a));
      return 0;
    }
  } else {
    if (b * b - 4 * a * c < 0) {
      printf("0");
      return 0;
    }
    double p, q;
    p = (-b - sqrt(b * b - 4 * a * c)) / (2 * a);
    q = (-b + sqrt(b * b - 4 * a * c)) / (2 * a);
    if (p == q) {
      printf("1\n%lf", q);
      return 0;
    }
    if (p > q) {
      double temp;
      temp = q;
      q = p;
      p = temp;
    }
    printf("2\n%lf %lf", p, q);
  }
}
