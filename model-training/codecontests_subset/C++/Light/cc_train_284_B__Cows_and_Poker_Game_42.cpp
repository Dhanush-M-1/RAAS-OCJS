#include <bits/stdc++.h>
int main() {
  long j, n, I, A, F;
  char aux;
  scanf("%li", &n);
  scanf("%c", &aux);
  A = I = F = 0;
  for (j = 1; j <= n; j++) {
    scanf("%c", &aux);
    if (aux == 'A') {
      A++;
    }
    if (aux == 'F') {
      F++;
    }
    if (aux == 'I') {
      I++;
    }
  }
  if (I == 1) {
    printf("1\n");
  } else {
    if (I > 1) {
      printf("0\n");
    } else {
      printf("%ld\n", A);
    }
  }
  return 0;
}
