#include <bits/stdc++.h>
char st[200005];
int main() {
  int i = 0, j, n, a = 0, f = 0;
  scanf("%d%s", &n, st);
  for (j = 0; j < n; j++) {
    if (st[j] == 'A')
      a++;
    else if (st[j] == 'I')
      i++;
    else
      f++;
  }
  if (i > 1)
    printf("0\n");
  else if (i == 1)
    printf("1\n");
  else
    printf("%d\n", a);
  return 0;
}
