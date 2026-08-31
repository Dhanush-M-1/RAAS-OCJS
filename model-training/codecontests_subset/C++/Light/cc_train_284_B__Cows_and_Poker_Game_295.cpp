#include <bits/stdc++.h>
char str[210000];
int a, f, i;
int main() {
  int len;
  scanf("%d", &len);
  scanf("%s", str);
  int cnt;
  for (cnt = 0; cnt < len; cnt++) {
    if (str[cnt] == 'A')
      a++;
    else if (str[cnt] == 'F')
      f++;
    else
      i++;
  }
  if (0 == i)
    printf("%d\n", a);
  else if (1 == i)
    printf("1\n");
  else
    printf("0\n");
  return 0;
}
