#include <bits/stdc++.h>
int k;
int main() {
  scanf("%d", &k);
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++)
      if (j != 1)
        printf("%2d ", (i * j / k) * 10 + (i * j) % k);
      else
        printf("%d ", i * j);
    printf("\n");
  }
}
