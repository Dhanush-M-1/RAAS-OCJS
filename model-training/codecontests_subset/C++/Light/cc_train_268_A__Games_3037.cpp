#include <bits/stdc++.h>
int main() {
  int a, b1[40][2], i, j, t;
  while (scanf("%d", &a) != EOF) {
    t = 0;
    for (i = 0; i < a; i++)
      for (j = 0; j < 2; j++) {
        scanf("%d", &b1[i][j]);
      }
    for (i = 0; i < a; i++) {
      for (j = 0; j < a; j++) {
        if (i == j) continue;
        if (b1[i][0] == b1[j][1]) t++;
      }
    }
    printf("%d\n", t);
  }
}
