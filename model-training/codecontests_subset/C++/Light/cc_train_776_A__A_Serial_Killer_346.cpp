#include <bits/stdc++.h>
int main() {
  int n, i, j;
  char s[1000][20], s11[1000][20], s1[100], s2[100];
  while (~scanf("%s%s", s1, s2)) {
    scanf("%d", &n);
    getchar();
    for (i = 0; i <= n; i++) {
      if (i == 0) {
        strcpy(s[i], s1);
        strcpy(s11[i], s2);
        printf("%s %s\n", s1, s2);
      } else
        scanf("%s%s", s[i], s11[i]);
      if (strcmp(s[i], s[i - 1]) == 0) {
        printf("%s %s\n", s11[i], s11[i - 1]);
        strcpy(s[i], s11[i]);
        strcpy(s11[i], s11[i - 1]);
      }
      if (strcmp(s[i], s11[i - 1]) == 0) {
        printf("%s %s\n", s[i - 1], s11[i]);
        strcpy(s[i], s[i - 1]);
        strcpy(s11[i], s11[i]);
      }
    }
  }
  return 0;
}
