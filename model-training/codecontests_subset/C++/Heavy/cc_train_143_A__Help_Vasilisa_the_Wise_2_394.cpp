#include <bits/stdc++.h>
int check(int i, int j, int k, int l, int r1, int r2, int c1, int c2, int d1,
          int d2) {
  if (i + j != r1) return 0;
  if (k + l != r2) return 0;
  if (i + k != c1) return 0;
  if (j + l != c2) return 0;
  if (i + l != d1) return 0;
  if (j + k != d2)
    return 0;
  else
    return 1;
}
int main() {
  int i, j, k, l, r1, r2, d1, d2, c1, c2;
  scanf("%d %d %d %d %d %d", &r1, &r2, &c1, &c2, &d1, &d2);
  int flag = 0;
  for (i = 1; i < 10; i++) {
    for (j = 1; j < 10; j++) {
      if (i == j) continue;
      for (k = 1; k < 10; k++) {
        if (i == j || j == k || i == k) continue;
        for (l = 1; l < 10; l++) {
          if (i == j || j == k || k == l || i == k || i == l || j == l)
            continue;
          if (check(i, j, k, l, r1, r2, c1, c2, d1, d2)) {
            flag = 1;
            printf("%d %d\n", i, j);
            printf("%d %d", k, l);
            break;
          }
        }
        if (flag == 1) break;
      }
      if (flag == 1) break;
    }
    if (flag == 1) break;
  }
  if (flag != 1) printf("-1");
  return 0;
}
