#include <bits/stdc++.h>
int main() {
  int i, j, k, l, x, y, flag = 1, a[101] = {0};
  scanf("%d%d", &i, &j);
  for (k = 1; k <= i; k++) {
    scanf("%d", &x);
    for (l = 0; l < x; l++) {
      scanf("%d", &y);
      a[y - 1] = 1;
    }
  }
  for (k = 0; k < j; k++) {
    if (a[k] == 0) flag = 0;
  }
  if (flag == 1)
    printf("YES");
  else
    printf("NO");
  return 0;
}
