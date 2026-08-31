#include <bits/stdc++.h>
int main() {
  int i, j, n, sum, one, two, w, flag;
  sum = 0;
  one = 0;
  two = 0;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d", &w);
    w = w / 100;
    if (w == 1)
      one++;
    else
      two++;
    sum = sum + w;
  }
  flag = 0;
  for (i = 0; i <= one; i++) {
    for (j = 0; j <= two; j++) {
      if (i + 2 * j == sum - i - 2 * j) {
        flag = 1;
        break;
      }
    }
  }
  if (flag)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
