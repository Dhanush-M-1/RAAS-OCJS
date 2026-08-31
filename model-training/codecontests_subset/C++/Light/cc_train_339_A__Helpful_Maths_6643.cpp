#include <bits/stdc++.h>
int main() {
  char str[100];
  scanf("%s", str);
  int len = strlen(str);
  int i, j, count;
  int ara[len / 2 + 1];
  for (i = 0, count = 0, j = 0; i < len; i += 2, j++, count++) {
    ara[j] = str[i] - 48;
  }
  for (i = 0; i < count; i++) {
    for (int j = i + 1; j < count; j++) {
      if (ara[i] > ara[j]) {
        int t = ara[i];
        ara[i] = ara[j];
        ara[j] = t;
      }
    }
  }
  for (i = 0; i < count; i++) {
    if (i == 0) {
      printf("%d", ara[i]);
    } else {
      printf("+%d", ara[i]);
    }
  }
  printf("\n");
  return 0;
}
