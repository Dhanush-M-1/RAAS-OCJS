#include <bits/stdc++.h>
int main() {
  int a, b;
  scanf("%d %d", &a, &b);
  int fc, uc, df, sum = 0;
  fc = a;
  uc = 0;
  df = b;
  while (1) {
    sum += fc;
    if (fc == 0 && uc < df) break;
    uc += fc;
    fc = uc / df;
    uc = uc % df;
  }
  printf("%d\n", sum);
  return 0;
}
