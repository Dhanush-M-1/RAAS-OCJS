#include <bits/stdc++.h>
int main() {
  char a[100];
  gets(a);
  int i, x, j = 0, p = 0, d, swap;
  x = strlen(a);
  int b[100];
  for (i = 0; i < x; i++) {
    if (a[i] >= 48 && a[i] <= 57) {
      b[j] = a[i];
      j++;
      p++;
    }
  }
  for (j = 1; j < p; j++) {
    d = j;
    while (d > 0 && b[d] < b[d - 1]) {
      swap = b[d];
      b[d] = b[d - 1];
      b[d - 1] = swap;
      d--;
    }
  }
  for (j = 0; j < p; j++) {
    printf("%c", b[j]);
    if (j < p - 1) printf("+");
  }
  return 0;
}
