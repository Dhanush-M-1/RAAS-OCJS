#include <bits/stdc++.h>
int main() {
  char str[105];
  int i, j, k, l, num1[1000];
  gets(str);
  for (i = 0; str[i] != '\0'; i++) {
    if (i % 2 == 0) {
      num1[i] = str[i] - 48;
    }
  }
  for (i = 0; i <= strlen(str); i += 2) {
    for (j = i + 2; j <= strlen(str); j += 2) {
      if (num1[i] > num1[j]) {
        int temp = num1[i];
        num1[i] = num1[j];
        num1[j] = temp;
      }
    }
    printf("%d", num1[i]);
    if (i == strlen(str) - 1) {
      break;
    }
    printf("+");
  }
  printf("\n");
  return 0;
}
