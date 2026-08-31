#include <bits/stdc++.h>
using namespace std;
int used[15];
int main() {
  int i, j, k, l, r1, r2, c1, c2, d1, d2;
  scanf(" %d %d %d %d %d %d", &r1, &r2, &c1, &c2, &d1, &d2);
  for (i = 1; i <= 9; i++) {
    used[i] = 1;
    for (j = 1; j <= 9; j++)
      if (!used[j]) {
        used[j] = 1;
        for (k = 1; k <= 9; k++)
          if (!used[k]) {
            used[k] = 1;
            for (l = 1; l <= 9; l++)
              if (!used[l]) {
                if (i + j == r1 && k + l == r2 && i + k == c1 && j + l == c2 &&
                    i + l == d1 && j + k == d2) {
                  printf("%d %d\n%d %d\n", i, j, k, l);
                  return 0;
                }
              }
            used[k] = 0;
          }
        used[j] = 0;
      }
    used[i] = 0;
  }
  printf("-1\n");
  return 0;
}
