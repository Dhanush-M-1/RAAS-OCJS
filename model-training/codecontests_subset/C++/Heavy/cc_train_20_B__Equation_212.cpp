#include <bits/stdc++.h>
using namespace std;
int main() {
  double a, b, c;
  scanf("%lf %lf %lf", &a, &b, &c);
  if (a != 0 && b != 0 && c != 0) {
    if (((b * b) - (4 * a * c)) == 0) {
      printf("1\n");
      printf("%lf", -b / (2 * a));
    } else if (((b * b) - (4 * a * c)) > 0) {
      printf("2\n");
      if ((-b - sqrt(((b * b) - (4 * a * c)))) / (2 * a) <
          (-b + sqrt(((b * b) - (4 * a * c)))) / (2 * a)) {
        printf("%lf\n%lf", (-b - sqrt(((b * b) - (4 * a * c)))) / (2 * a),
               (-b + sqrt(((b * b) - (4 * a * c)))) / (2 * a));
      } else {
        printf("%lf\n%lf", (-b + sqrt(((b * b) - (4 * a * c)))) / (2 * a),
               (-b - sqrt(((b * b) - (4 * a * c)))) / (2 * a));
      }
    }
    if (((b * b) - (4 * a * c)) < 0) {
      printf("0\n");
    }
  }
  if (a == 0 && b != 0 && c != 0) {
    printf("1\n");
    printf("%lf", -c / b);
  }
  if (a != 0 && b == 0 && c > 0) {
    printf("0\n");
  }
  if (a != 0 && b != 0 && c == 0) {
    printf("2\n");
    if (0 < (-b / a)) {
      printf("0.000000\n%lf", -b / a);
    } else {
      printf("%lf\n0.000000", -b / a);
    }
  }
  if (a == 0 && b == 0 && c == 0) {
    printf("-1\n");
  }
  if (a == 0 && b == 0 && c != 0) {
    printf("0\n");
  }
  if (a == 0 && b != 0 && c == 0) {
    printf("1\n");
    printf("0\n");
  }
  if ((a > 0 || a < 0) && b == 0 && c == 0) {
    printf("1\n");
    printf("0.000000");
  }
  if (a != 0 && b == 0 && c < 0) {
    printf("2\n");
    if (sqrt(-c / a) < -sqrt(-c / a)) {
      printf("%lf\n%lf", sqrt(-c / a), -sqrt(-c / a));
    } else {
      printf("%lf\n%lf", -sqrt(-c / a), sqrt(-c / a));
    }
  }
}
