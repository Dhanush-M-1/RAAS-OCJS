#include <bits/stdc++.h>
int main() {
  char a[101];
  scanf("%s", a);
  int i;
  int n = 101;
  while (n > 0) {
    for (i = 0; a[i + 2] != '\0'; i++) {
      if (i % 2 == 0) {
        char temp;
        if (a[i] > a[i + 2]) {
          temp = a[i];
          a[i] = a[i + 2];
          a[i + 2] = temp;
        }
      }
    }
    n--;
  }
  for (i = 0; a[i] != '\0'; i++) {
    printf("%c", a[i]);
  }
  return 0;
}
