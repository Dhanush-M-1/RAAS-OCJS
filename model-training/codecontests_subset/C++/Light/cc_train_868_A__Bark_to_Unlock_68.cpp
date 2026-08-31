#include <bits/stdc++.h>
int main() {
  char s1[3] = {'\0'}, s2[101][3] = {'\0'};
  int i = 0, k = 0, j = 0, x;
  scanf("%s", s1);
  scanf("%d", &x);
  for (i = 0; i < x; i++) {
    scanf("%s", s2[i]);
    if ((s2[i][0] == s1[0] && s2[i][1] == s1[1]) ||
        (s2[i][0] == s1[1]) && (s2[i][1] == s1[0])) {
      k = 1;
      break;
    }
  }
  for (i = 0; i < x; i++) {
    if (s2[i][1] == s1[0]) {
      for (j = 0; j < x; j++)
        if (s2[j][0] == s1[1]) k = 1;
    }
  }
  if (k == 0)
    printf("NO\n");
  else
    printf("YES\n");
  return 0;
}
