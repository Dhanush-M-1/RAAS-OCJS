#include <bits/stdc++.h>
int main() {
  int r1, r2, c1, c2, d1, d2;
  scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2);
  for (int i = 1; i < 10; i++)
    for (int j = 1; j < 10; j++)
      if (i + j == r1)
        for (int k = 1; k < 10; k++)
          if (j + k == d2 && i + k == c1)
            for (int l = 1; l < 10; l++)
              if (k + l == r2 && j + l == c2 && i + l == d1 && i != l &&
                  j != l && k != l && i != k && j != k && i != j) {
                printf("%d %d\n%d %d", i, j, k, l);
                return 0;
              }
  puts("-1");
  return 0;
}
