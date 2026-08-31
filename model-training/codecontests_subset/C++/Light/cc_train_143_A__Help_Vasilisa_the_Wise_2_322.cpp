#include <bits/stdc++.h>
using namespace std;
int r1, r2, c1, c2, d1, d2;
int main() {
  scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2);
  for (int i = 1; i <= 9; ++i)
    for (int j = 1; j <= 9; ++j)
      for (int ii = 1; ii <= 9; ++ii)
        for (int jj = 1; jj <= 9; ++jj) {
          if (i != j && i != ii && i != jj && j != ii && j != jj && ii != jj)
            if (i + j == r1 && jj + ii == r2 && i + ii == c1 && j + jj == c2 &&
                i + jj == d1 && j + ii == d2) {
              printf("%d %d\n%d %d", i, j, ii, jj);
              return 0;
            }
        }
  printf("-1");
  return 0;
}
