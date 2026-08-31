#include <bits/stdc++.h>
int main() {
  int n, count = 0, i, len;
  char num[105];
  scanf("%d ", &n);
  gets(num);
  len = strlen(num);
  if (n >= 11) {
    for (i = 0; i < len; i++) {
      if (num[i] == '8') {
        n -= 11;
        if (n >= 0) {
          count++;
          continue;
        } else
          break;
      }
    }
    printf("%d\n", count);
  } else
    printf("%d\n", 0);
  return 0;
}
