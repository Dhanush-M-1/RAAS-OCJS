#include <bits/stdc++.h>
int main() {
  double a, b, c, s;
  scanf("%lf %lf %lf", &a, &b, &c);
  if (a == 0 && b == 0 && c == 0) {
    printf("-1");
  } else if (a == 0 && b != 0) {
    printf("1\n%lf", (-c) / b);
  } else if (a == 0 && b == 0 && c != 0) {
    printf("%lf", b);
  } else {
    s = (b * b) - 4 * a * c;
    if (s > 0) {
      double w, e;
      w = (((-b) - sqrt(s)) / (2 * a));
      e = (((-b) + sqrt(s)) / (2 * a));
      if (w > e)
        printf("2\n%lf \n%lf", e, w);
      else
        printf("2\n%lf \n%lf", w, e);
    }
    if (s == 0) {
      printf("1\n%lf", ((-b) / (2 * a)));
    }
    if (s < 0) {
      printf("0");
    }
  }
  return 0;
}
