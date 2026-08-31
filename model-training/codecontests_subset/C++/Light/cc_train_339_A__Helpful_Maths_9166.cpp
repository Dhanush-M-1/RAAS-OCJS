#include <bits/stdc++.h>
int main() {
  char s[101];
  int i, j, a, b, count, temp;
  gets(s);
  int n = strlen(s);
  for (i = 0; i < n - 1; i = i + 2) {
    for (j = i + 2; j < n; j = j + 2) {
      if (s[i] > s[j]) {
        temp = s[i];
        s[i] = s[j];
        s[j] = temp;
      }
    }
  }
  printf("%s\n", s);
  return 0;
}
