#include <bits/stdc++.h>
int main() {
  int n, i, j, temp, min;
  char str[105];
  gets(str);
  n = strlen(str);
  for (i = 0; i < n; i += 2) {
    min = i;
    for (j = i + 2; j < n; j += 2) {
      if (str[min] >= str[j]) {
        min = j;
      }
    }
    if (min != i) {
      temp = str[min];
      str[min] = str[i];
      str[i] = temp;
    }
  }
  puts(str);
  return 0;
}
