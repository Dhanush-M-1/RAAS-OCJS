#include <bits/stdc++.h>
int main() {
  int n, x, y;
  int s = 0, m = 0;
  scanf("%i %i %i", &n, &x, &y);
  if ((n * y) % 100 != 0) {
    s = ((n * y) / 100) + 1;
  } else {
    s = ((n * y) / 100);
  }
  if (s - x < 0) {
    printf("0");
    return 0;
  }
  printf("%i", s - x);
  return 0;
}
