#include <bits/stdc++.h>
int a, b, c;
void solver() {
  if (a == 0 && b != 0) {
    printf("1\n%.5f\n", (-c / (float)b));
    return;
  }
  if (a == 0 && b == 0 && c == 0) {
    printf("-1\n");
    return;
  }
  if ((a == 0 && b == 0 && c != 0) || (a == b && b == c) ||
      (b == 0 && a * c > 0)) {
    printf("0\n");
    return;
  }
  if (a * b * 4 == b * b && c != 0) {
    printf("1\n%.5f\n", (-b / (float)(2 * a)));
    return;
  }
  double discriminante = sqrt((double)b * b - (double)4 * a * c);
  double v1 = (-b - discriminante) / (double)(2 * a);
  double v2 = (-b + discriminante) / (double)(2 * a);
  if (v1 < v2)
    printf("2\n%.5lf\n%.5lf\n", v1, v2);
  else {
    if (v1 != v2)
      printf("2\n%.5lf\n%.5lf\n", v2, v1);
    else
      printf("1\n%.5lf\n", v1);
  }
}
int main() {
  while (scanf("%d %d %d", &a, &b, &c) != EOF) solver();
  return 0;
}
