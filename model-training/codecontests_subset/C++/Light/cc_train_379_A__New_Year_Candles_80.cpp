#include <bits/stdc++.h>
int a, b;
int old;
int leftold;
int hours;
int main() {
  scanf("%d %d", &a, &b);
  hours = a;
  old = a / b;
  leftold = a;
  while (!(old == 0 && leftold < b)) {
    leftold %= b;
    while (old > 0) {
      hours += old;
      leftold += old % b;
      old /= b;
    }
    old = leftold / b;
  }
  printf("%d\n", hours);
  return 0;
}
