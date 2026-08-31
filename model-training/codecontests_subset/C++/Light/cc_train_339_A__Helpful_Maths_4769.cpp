#include <bits/stdc++.h>
int main() {
  char temp;
  char a[100];
  gets(a);
  int i, j;
  if (a[1] == '\0')
    printf(a);
  else {
    for (i = 0; i < strlen(a) / 2 + 1; i++) {
      for (j = 0; j < strlen(a) - 2; j = j + 2) {
        if (a[j + 2] < a[j]) {
          temp = a[j];
          a[j] = a[j + 2];
          a[j + 2] = temp;
        }
      }
    }
    printf(a);
  }
}
