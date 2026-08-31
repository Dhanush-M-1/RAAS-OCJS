#include <bits/stdc++.h>
int main() {
  int i, j = 1, x, k = 0;
  int c, y;
  int ar[1000];
  char str[500];
  scanf("%s", str);
  for (i = 0; str[i] != '\0'; i++) {
    x = isdigit(str[i]);
    if (x != 0) {
      ar[j] = str[i];
      j++;
      k++;
    }
  }
  int pass;
  for (pass = 1; pass <= k; pass++) {
    for (j = 1; j <= k - 1; j++) {
      if (ar[j] > ar[j + 1]) {
        c = ar[j];
        ar[j] = ar[j + 1];
        ar[j + 1] = c;
      }
    }
  }
  j = 1;
  for (i = 0; str[i] != '\0'; i++) {
    y = isdigit(str[i]);
    {
      if (y != 0) {
        str[i] = ar[j];
        j++;
      }
    }
  }
  printf("%s", str);
}
