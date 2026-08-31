#include <bits/stdc++.h>
int main() {
  int n, a, b, c, i, j, ss;
  long long sum;
  while (~scanf("%d%d%d%d", &n, &a, &b, &c)) {
    sum = 0;
    a = a / 2;
    for (i = 0; i <= a; i++) {
      for (j = 0; j <= c; j++) {
        ss = n - i - j * 2;
        if (ss <= b && ss >= 0) {
          sum++;
        }
      }
    }
    printf("%lld\n", sum);
  }
}
