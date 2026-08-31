#include <bits/stdc++.h>
int main(void) {
  int n, c;
  scanf("%d %d", &n, &c);
  int a[n], i, max = 0;
  for (i = 0; i < n; ++i) scanf("%d", &a[i]);
  for (i = 0; i < n - 1; ++i) {
    if ((a[i] - a[i + 1]) > max) max = a[i] - a[i + 1];
  }
  if ((max - c) > 0)
    printf("%d", max - c);
  else
    printf("0");
  return 0;
}
