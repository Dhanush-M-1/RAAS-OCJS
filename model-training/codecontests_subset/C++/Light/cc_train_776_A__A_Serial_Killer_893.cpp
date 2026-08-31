#include <bits/stdc++.h>
int main() {
  char n1[20], n2[20];
  char n[20], k[20];
  int i, j;
  scanf("%s %s", n1, n2);
  scanf("%d", &j);
  printf("%s %s\n", n1, n2);
  for (i = 0; i < j; i++) {
    scanf("%s %s", n, k);
    if (strcmp(n, n1) == 0) {
      strcpy(n1, k);
      printf("%s %s\n", n1, n2);
    } else {
      strcpy(n2, k);
      printf("%s %s\n", n1, n2);
    }
  }
  return 0;
}
