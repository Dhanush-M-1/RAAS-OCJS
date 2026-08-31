#include <bits/stdc++.h>
int main() {
  int a, b, c, i = 0, j = 0, k = 0, n, l;
  char s[100];
  scanf("%s", &s);
  l = strlen(s);
  for (n = 0; n < l; n++) {
    if (s[n] == '1')
      i++;
    else if (s[n] == '2')
      j++;
    else if (s[n] == '3')
      k++;
  }
  l = l / 2 + 1;
  n = 0;
  for (a = 0; a < i; a++) {
    n++;
    if (n != l)
      printf("1+");
    else
      printf("1");
  }
  for (b = 0; b < j; b++) {
    n++;
    if (n != l)
      printf("2+");
    else
      printf("2");
  }
  for (c = 0; c < k; c++) {
    n++;
    if (n != l)
      printf("3+");
    else
      printf("3");
  }
  return 0;
}
