#include <bits/stdc++.h>
int main() {
  int k, a, b;
  scanf("%d", &k);
  for (int i = 1; i < k; i++) {
    for (int j = 1; j < k; j++) {
      if (j == 1) {
        printf("%d", i);
        continue;
      }
      a = i * j / k;
      b = i * j % k;
      if (a == 0)
        printf("  %d", b);
      else
        printf(" %d%d", a, b);
    }
    puts("");
  }
}
