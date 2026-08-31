#include <bits/stdc++.h>
int main() {
  int n, a, b, c;
  int i, j, sum;
  while (scanf("%d%d%d%d", &n, &a, &b, &c) != EOF) {
    sum = 0;
    for (i = 0; i <= b; i++) {
      for (j = 0; j <= n - i && j <= c; j++) {
        if ((a / 2) >= (n - i - j * 2) && (n - i - j * 2) >= 0) {
          sum++;
        }
      }
    }
    printf("%d\n", sum);
  }
  return 0;
}
