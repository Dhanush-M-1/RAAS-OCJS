#include <bits/stdc++.h>
int main() {
  int r1, r2, c1, c2, d1, d2;
  int i, j, k, l;
  bool b[10];
  for (i = 0; i < 10; i++) b[i] = false;
  scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2);
  for (i = 1; i < 10; i++) {
    b[i] = true;
    for (j = 1; j < 10; j++) {
      if (b[j]) continue;
      b[j] = true;
      for (k = 1; k < 10; k++) {
        if (b[k]) continue;
        b[k] = true;
        for (l = 1; l < 10; l++) {
          if (b[l]) continue;
          if (i + j == r1 && k + l == r2 && i + k == c1 && j + l == c2 &&
              i + l == d1 && j + k == d2) {
            printf("%d %d\n", i, j);
            printf("%d %d\n", k, l);
            return 0;
          }
        }
        b[k] = false;
      }
      b[j] = false;
    }
    b[i] = false;
  }
  printf("-1\n");
  return 0;
}
