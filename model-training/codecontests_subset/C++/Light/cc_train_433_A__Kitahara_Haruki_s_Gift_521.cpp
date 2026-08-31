#include <bits/stdc++.h>
int main() {
  int n, a[101] = {0}, b[2] = {0}, i, j, k, c = 0, s = 0;
  scanf("%d", &n);
  for (i = 0; i < n; i++) {
    scanf("%d", &a[i]);
    if (a[i] == 100) {
      b[0]++;
    } else if (a[i] == 200) {
      b[1]++;
    }
  }
  s = b[0] * 100 + b[1] * 200;
  if ((s / 100) % 2 == 1) {
    printf("NO\n");
  } else {
    if (b[0] % 2 == 1) {
      printf("NO\n");
    } else if (b[0] == 0) {
      if (b[1] % 2 == 0) {
        printf("YES\n");
      } else {
        printf("NO\n");
      }
    } else {
      printf("YES\n");
    }
  }
  return 0;
}
