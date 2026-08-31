#include <bits/stdc++.h>
int main() {
  int i, j, k, m;
  char str[100];
  char str2[100];
  char str3[100];
  char str4[100];
  scanf("%s %s", str, str2);
  scanf("%d", &m);
  for (i = 0; i <= m; i++) {
    printf("%s %s\n", str, str2);
    scanf("%s %s", str3, str4);
    if (strcmp(str3, str) != 0 && strcmp(str3, str2) != 0) {
      if (strcmp(str4, str) == 0) strcpy(str, str3);
      if (strcmp(str4, str2) == 0) strcpy(str2, str3);
    }
    if (strcmp(str4, str) != 0 && strcmp(str4, str2) != 0) {
      if (strcmp(str3, str) == 0) strcpy(str, str4);
      if (strcmp(str3, str2) == 0) strcpy(str2, str4);
    }
  }
  return 0;
}
