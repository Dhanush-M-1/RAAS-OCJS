#include <bits/stdc++.h>
int main(void) {
  int r1, r2;
  int c1, c2;
  int d1, d2;
  int countr1 = 0;
  int countr2 = 0;
  int a[100];
  int b[100];
  int i, j, k;
  scanf("%d%d", &r1, &r2);
  getchar();
  scanf("%d%d", &c1, &c2);
  getchar();
  scanf("%d%d", &d1, &d2);
  for (i = 1, j = 0; i <= 9; i++) {
    if (r1 - i > 9)
      continue;
    else {
      if (r1 - i <= 0) break;
      a[j] = i;
      a[j + 1] = r1 - i;
      j += 2;
      countr1++;
    }
  }
  for (i = 1, j = 0; i <= 9; i++) {
    if (r2 - i > 9)
      continue;
    else {
      if (r2 - i <= 0) break;
      b[j] = i;
      b[j + 1] = r2 - i;
      j += 2;
      countr2++;
    }
  }
  for (i = 0; i < countr1 * 2; i += 2) {
    for (j = 0; j < countr2 * 2; j += 2) {
      if (a[i] != b[j] && a[i] != b[j + 1] && a[i + 1] != b[j] &&
          a[i + 1] != b[j + 1] && a[i] != a[i + 1] && b[j] != b[j + 1]) {
        if (a[i] + b[j] == c1 && a[i + 1] + b[j + 1] == c2 &&
            a[i] + b[j + 1] == d1 && a[i + 1] + b[j] == d2) {
          printf("%d %d\n", a[i], a[i + 1]);
          printf("%d %d\n", b[j], b[j + 1]);
          return 0;
        } else
          continue;
      } else
        continue;
    }
  }
  printf("%d", -1);
  return 0;
}
