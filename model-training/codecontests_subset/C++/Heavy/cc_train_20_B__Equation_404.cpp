#include <bits/stdc++.h>
int main() {
  long long a, b, c, d;
  scanf("%lld %lld %lld", &a, &b, &c);
  if (a == 0 && b == 0 && c == 0) {
    printf("-1");
    return 0;
  }
  if (a == 0 && b == 0) {
    printf("0");
    return 0;
  }
  d = b * b - 4 * a * c;
  if (d < 0) {
    printf("0");
    return 0;
  }
  if (a == 0) {
    printf("1\n%.7f", -1.0 * c / b);
    return 0;
  }
  float a1 = (-1 * b + sqrt(d)) / (2.0 * a);
  float a2 = (-1 * b - sqrt(d)) / (2.0 * a);
  if (a1 == a2) {
    printf("1\n%.7f", a1);
    return 0;
  }
  if (a1 > a2) {
    float temp = a2;
    a2 = a1;
    a1 = temp;
  }
  printf("2\n%.7f\n%.7f", a1, a2);
  return 0;
}
