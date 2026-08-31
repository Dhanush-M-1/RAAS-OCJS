#include <bits/stdc++.h>
int main() {
  char str1[100];
  int i, j, n, temp;
  scanf("%s", str1);
  n = strlen(str1);
  for (i = 0; i < n - 2; i = i + 2) {
    for (j = i + 2; j < n; j = j + 2) {
      if (str1[i] > str1[j]) {
        temp = str1[i];
        str1[i] = str1[j];
        str1[j] = temp;
      }
    }
  }
  printf("%s", str1);
  return 0;
}
