#include <bits/stdc++.h>
long i, j, k, q, p;
long A[100];
void tool() {
  p = i * j;
  q = 0;
  while (p != 0) {
    q++;
    A[q] = p % k;
    p = p / k;
  }
  for (q = q; q >= 1; q--) printf("%ld", A[q]);
}
int main() {
  scanf("%ld", &k);
  for (i = 1; i < k; i++) {
    for (j = 1; j < k - 1; j++) {
      tool();
      printf(" ");
    }
    j = k - 1;
    tool();
    printf("\n");
  }
}
