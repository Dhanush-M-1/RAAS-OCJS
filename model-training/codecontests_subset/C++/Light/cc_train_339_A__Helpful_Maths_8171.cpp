#include <bits/stdc++.h>
int main() {
  char s[100], temp;
  scanf("%s", s);
  int l = strlen(s);
  for (int i = 0; i < l; i += 2) {
    for (int j = 0; j < l - i - 2; j += 2) {
      if (s[j] > s[j + 2]) {
        temp = s[j];
        s[j] = s[j + 2];
        s[j + 2] = temp;
      }
    }
  }
  printf("%s\n", s);
  return 0;
}
