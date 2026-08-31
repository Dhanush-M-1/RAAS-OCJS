#include <bits/stdc++.h>
int main() {
  char a[101];
  int len, i, temp, j;
  scanf("%s", &a);
  len = strlen(a);
  for (i = 0; i < len; i = i + 2) {
    for (j = 0; j < len - i - 2; j = j + 2) {
      if (a[j] > a[j + 2]) {
        temp = a[j];
        a[j] = a[j + 2];
        a[j + 2] = temp;
      }
    }
  }
  printf("%s", a);
  return 0;
}
