#include <bits/stdc++.h>
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i < n; i++, printf("\n"))
    for (int j = 1; j < n; j++)
      if (j != 1)
        printf("%4d ", (i * j / n) * 10 + (i * j) % n);
      else
        printf("%d", i * j);
  return 0;
}
