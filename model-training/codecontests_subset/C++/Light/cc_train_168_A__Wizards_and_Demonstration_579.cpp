#include <bits/stdc++.h>
int main() {
  int n, x, y, clo;
  double cit;
  scanf("%d %d %d", &n, &x, &y);
  cit = clo = 0;
  cit = (((double)n * (double)y)) / (double)100;
  while (x + clo < cit) {
    clo++;
  }
  printf("%d\n", clo);
  getchar();
  getchar();
  return 0;
}
