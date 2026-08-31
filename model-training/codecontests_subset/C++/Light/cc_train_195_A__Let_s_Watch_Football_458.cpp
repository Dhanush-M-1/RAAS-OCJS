#include <bits/stdc++.h>
int main() {
  int a, b, c;
  int denom, numer;
  scanf("%d %d %d", &a, &b, &c);
  denom = a * b;
  numer = (a - b) * (c * a);
  if (numer % denom == 0) {
    printf("%d\n", numer / denom);
  } else {
    printf("%d\n", numer / denom + 1);
  }
  return 0;
}
