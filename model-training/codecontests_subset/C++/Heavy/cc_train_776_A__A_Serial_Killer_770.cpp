#include <bits/stdc++.h>
#pragma warning(disable : 4996)
int main() {
  char a[2][15];
  char temp[15];
  for (int i = 0; i < 2; i++) {
    scanf("%s", a[i]);
  }
  int b;
  scanf("%d", &b);
  char c[1010][2][15];
  int i;
  for (int j = 0; j < b; j++) {
    for (i = 0; i < 2; i++) {
      scanf("%s", c[j][i]);
    }
  }
  if (strcmp(c[0][0], a[0]) == 0) {
    strcpy(c[0][0], c[0][1]);
    strcpy(c[0][1], a[1]);
    goto L1;
  }
  if (strcmp(c[0][1], a[0]) == 0) {
    strcpy(c[0][1], a[1]);
    goto L1;
  }
  if (strcmp(c[0][0], a[1]) == 0) {
    strcpy(c[0][0], a[0]);
    strcpy(c[0][1], c[0][1]);
    goto L1;
  }
  if (strcmp(c[0][1], a[1]) == 0) {
    strcpy(c[0][1], a[0]);
    goto L1;
  }
L1:
  for (int j = 0; j < b; j++) {
    for (i = 0; i < 2; i++) {
      if (strcmp(c[j][i], c[j + 1][i]) == 0) {
        if (i % 2 == 0) {
          strcpy(c[j + 1][i], c[j + 1][i + 1]);
          strcpy(c[j + 1][i + 1], c[j][i + 1]);
        }
        if (i % 2 != 0) {
          strcpy(c[j + 1][j + 1], c[j][i]);
        }
        break;
      }
      if (strcmp(c[j][i], c[j + 1][i + 1]) == 0) {
        strcpy(c[j + 1][i + 1], c[j][i + 1]);
        ;
        break;
      }
      if (strcmp(c[j][i + 1], c[j + 1][i]) == 0) {
        strcpy(c[j + 1][i], c[j][i]);
        break;
      }
    }
  }
L4:
  printf("%s %s", a[0], a[1]);
  printf("\n");
  for (int j = 0; j < b; j++) {
    for (int i = 0; i < 2; i++) {
      printf("%s ", c[j][i]);
    }
    printf("\n");
  }
  return (0);
}
