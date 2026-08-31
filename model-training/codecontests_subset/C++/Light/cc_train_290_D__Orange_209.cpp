#include <bits/stdc++.h>
int main() {
  char str[100];
  int n, i, j, len;
  while (scanf("%s", str) != EOF) {
    scanf("%d", &n);
    len = strlen(str);
    for (i = 0; i < len; i++) {
      if (str[i] < 'a') str[i] += 'a' - 'A';
      if (str[i] < n + 97) str[i] += 'A' - 'a';
    }
    printf("%s\n", str);
  }
  return 0;
}
