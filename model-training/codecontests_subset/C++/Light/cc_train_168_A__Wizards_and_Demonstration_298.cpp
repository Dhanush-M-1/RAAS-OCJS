#include <bits/stdc++.h>
int main() {
  int n, a, b, t;
  scanf("%d", &(n)), scanf("%d", &(a)), scanf("%d", &(b));
  t = n * b;
  t = ceil((double)t / 100);
  printf("%d", (0 > (t - a) ? 0 : (t - a)));
  printf("\n");
  return 0;
}
