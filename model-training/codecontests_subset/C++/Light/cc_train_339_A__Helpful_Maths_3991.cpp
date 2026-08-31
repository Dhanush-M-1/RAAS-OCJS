#include <bits/stdc++.h>
int main() {
  char a[100];
  int temp, len, i, j;
  gets(a);
  len = strlen(a);
  for (i = 0; i < len; i += 2) {
    for (j = i + 2; j < len; j += 2) {
      if (a[i] >= a[j]) {
        temp = a[j];
        a[j] = a[i];
        a[i] = temp;
      }
    }
  }
  printf("%s", a);
  printf("\n");
  return 0;
}
