#include <bits/stdc++.h>
int main() {
  int a[5];
  scanf("%d%d%d%d%d", &a[0], &a[1], &a[2], &a[3], &a[4]);
  if ((a[0] + a[1] + a[2] + a[3] + a[4]) % 5 == 0 &&
      (a[0] + a[1] + a[2] + a[3] + a[4]) / 5 != 0)
    printf("%d\n", (a[0] + a[1] + a[2] + a[3] + a[4]) / 5);
  else
    printf("-1\n");
  return 0;
}
