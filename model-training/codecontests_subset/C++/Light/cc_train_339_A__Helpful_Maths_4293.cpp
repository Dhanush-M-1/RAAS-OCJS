#include <bits/stdc++.h>
int main() {
  char a, s[100];
  int i, j;
  gets(s);
  for (i = 0; (s[i] != '\0') && (s[i + 1] != '\0'); i += 2) {
    for (j = 0; (s[j] != '\0') && (s[j + 1] != '\0'); j += 2) {
      if (s[j] > s[j + 2]) {
        a = s[j];
        s[j] = s[j + 2];
        s[j + 2] = a;
      }
    }
  }
  puts(s);
  return 0;
}
