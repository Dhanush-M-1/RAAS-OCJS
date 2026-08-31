#include <bits/stdc++.h>
using namespace std;
int r1, r2, c1, c2, d1, d2;
int main() {
  scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2);
  int tag = 0;
  for (int i = 1; i <= 9; ++i) {
    for (int j = 1; j <= 9; ++j) {
      for (int k = 1; k <= 9; ++k) {
        for (int l = 1; l <= 9; ++l) {
          if (i == j || i == k) continue;
          if (i == l || j == k) continue;
          if (j == l || k == l) continue;
          if (i + j == r1 && i + k == c1 && k + l == r2 && j + l == c2 &&
              i + l == d1 && j + k == d2) {
            printf("%d %d\n", i, j);
            printf("%d %d\n", k, l);
            tag = 1;
            break;
          }
        }
        if (tag) break;
      }
      if (tag) break;
    }
    if (tag) break;
  }
  if (!tag) printf("-1\n");
  return 0;
}
