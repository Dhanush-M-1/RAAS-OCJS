#include <bits/stdc++.h>
int main() {
  int i, j, n, first = 0, second = 0;
  char flag = 1, Pass[10];
  gets(Pass);
  scanf("%d", &n);
  char S[n][10];
  for (i = 0; i < n; i++) {
    scanf("%s", S[i]);
  }
  for (i = 0; (flag) && (i < n); i++) {
    if (strstr(Pass, S[i])) {
      printf("YES\n");
      flag = 0;
    }
  }
  for (i = 0; (flag) && (i < n); i++) {
    if (S[i][1] == Pass[0]) {
      first = 1;
      for (j = 0; (j < n); j++) {
        if (S[j][0] == Pass[1]) {
          second = 1;
        }
      }
    }
  }
  if (flag) {
    if ((first) && (second))
      printf("YES\n");
    else
      printf("NO\n");
  }
  return 0;
}
