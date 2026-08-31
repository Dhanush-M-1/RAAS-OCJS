#include <bits/stdc++.h>
long long P, q;
long long a = -1, b = -1, c = -1;
int main() {
  scanf("%I64d", &P);
  q = sqrt(P);
  for (long long i = 2; i <= q; i++) {
    if (P % i == 0) {
      a = i;
      break;
    }
  }
  if (a == -1) {
    printf("1\n0\n");
    return 0;
  }
  P /= a;
  q = sqrt(P);
  for (long long i = 2; i <= q; i++) {
    if (P % i == 0) {
      b = i;
      break;
    }
  }
  if (b == -1) {
    printf("2\n");
    return 0;
  }
  printf("1\n%I64d\n", a * b);
  return 0;
}
