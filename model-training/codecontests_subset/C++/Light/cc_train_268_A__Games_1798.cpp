#include <bits/stdc++.h>
int main() {
  int p[30][2];
  int n, i, j, t = 0;
  scanf("%d", &n);
  for (i = 0; i < n; i++)
    for (j = 0; j < 2; j++) scanf("%d", &p[i][j]);
  for (i = 0; i < n; i++) {
    for (j = 0; j < n; j++) {
      if (i != j) {
        if (p[i][0] == p[j][1]) t++;
      }
    }
  }
  printf("%d\n", t);
  return 0;
}
