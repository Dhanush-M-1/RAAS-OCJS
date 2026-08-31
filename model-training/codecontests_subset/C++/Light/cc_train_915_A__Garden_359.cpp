#include <bits/stdc++.h>
int a[100], i, j, maxim, h, l, n, b;
int main() {
  scanf("%d", &n);
  scanf("%d", &l);
  for (i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  i = 0;
  j = 0;
  b = 0;
  h = l;
  maxim = l;
  while (i < n) {
    if (l % a[i] == 0) {
      h = l / a[i];
    }
    if (h < maxim) maxim = h;
    i++;
  }
  printf("%d", maxim);
}
