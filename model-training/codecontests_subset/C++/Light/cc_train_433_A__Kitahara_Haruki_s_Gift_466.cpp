#include <bits/stdc++.h>
int n, num1, num2;
int i, j, k, w;
int flag;
int main() {
  scanf("%d", &n);
  num1 = num2 = 0;
  for (i = 1; i <= n; i++) {
    scanf("%d", &j);
    if (j == 100)
      num1++;
    else
      num2++;
  }
  flag = 0;
  for (i = 0; i <= num1; i++)
    for (j = 0; j <= num2; j++) {
      k = i * 100 + j * 200;
      w = (num1 - i) * 100 + (num2 - j) * 200;
      if (k == w) flag = 1;
    }
  if (flag)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
