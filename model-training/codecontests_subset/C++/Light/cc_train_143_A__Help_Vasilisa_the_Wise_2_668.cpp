#include <bits/stdc++.h>
int main() {
  int r1, r2, c1, c2, d1, d2;
  scanf("%d%d%d%d%d%d", &r1, &r2, &c1, &c2, &d1, &d2);
  for (int i = 1; i < 10; i++)
    for (int j = 1; j < 10; j++)
      if (i != j)
        for (int k = 1; k < 10; k++)
          if (k != i && k != j)
            for (int l = 1; l < 10; l++)
              if (l != i && l != j && l != k)
                if (i + j == r1 && k + l == r2 && i + k == c1 && j + l == c2 &&
                    i + l == d1 && j + k == d2) {
                  printf("%d %d\n%d %d\n", i, j, k, l);
                  return 0;
                }
  printf("-1\n");
  return 0;
}
