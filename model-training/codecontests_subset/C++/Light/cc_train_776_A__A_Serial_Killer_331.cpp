#include <bits/stdc++.h>
char str_1[15];
char str_2[15];
char str_3[15];
char str_4[15];
int main() {
  int n;
  scanf("%s%s", str_1, str_2);
  scanf("%d", &n);
  printf("%s %s\n", str_1, str_2);
  for (int i = 0; i < n; i++) {
    getchar();
    scanf("%s%s", str_3, str_4);
    if (strcmp(str_1, str_3) == 0) {
      strcpy(str_1, str_4);
    } else {
      for (int i = 0; i < strlen(str_4); i++) {
        strcpy(str_2, str_4);
      }
    }
    printf("%s %s\n", str_1, str_2);
    memset(str_3, 0, sizeof(str_3));
    memset(str_4, 0, sizeof(str_4));
    memset(str_3, 0, sizeof(str_1));
    memset(str_4, 0, sizeof(str_2));
  }
  return 0;
}
