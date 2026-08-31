#include <bits/stdc++.h>
using namespace std;
int n;
int conv(int num, int *str, int base) {
  str[0] = 0;
  while (num > 0) {
    str[++str[0]] = num % base;
    num /= base;
  }
  return 0;
}
int input(void) {
  scanf("%d", &n);
  return 0;
}
int solve(void) {
  int str[10 + 1];
  for (register int i = 1; i <= n - 1; i++) {
    for (register int j = 1; j <= n - 1; j++) {
      conv(i * j, str, n);
      for (register int t = str[0]; t >= 1; t--) {
        printf("%d", str[t]);
      }
      if (j < n - 1) printf(" ");
    }
    printf("\n");
  }
  return 0;
}
int main(void) {
  input();
  solve();
  return 0;
}
