#include <bits/stdc++.h>
char s[3], t[110][3];
int n;
int main() {
  scanf("%s%d", s, &n);
  for (int i = 1; i <= n; i++) scanf("%s", t[i]);
  for (int i = 1; i <= n; i++)
    if (t[i][0] == s[0] && t[i][1] == s[1]) {
      printf("YES\n");
      return 0;
    }
  for (int i = 1; i <= n; i++)
    for (int j = 1; j <= n; j++)
      if (t[i][1] == s[0] && t[j][0] == s[1]) {
        printf("YES\n");
        return 0;
      }
  printf("NO\n");
  return 0;
}
