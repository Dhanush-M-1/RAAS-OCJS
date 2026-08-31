#include <bits/stdc++.h>
double n, x, y, i;
int main() {
  scanf("%lf%lf%lf", &n, &x, &y);
  for (;; i += 1.0) {
    if ((x + i) * 100 / n >= y) {
      printf("%.0lf", i);
      break;
    }
  }
  scanf(" ");
}
