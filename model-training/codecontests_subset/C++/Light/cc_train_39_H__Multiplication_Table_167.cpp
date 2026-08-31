#include <bits/stdc++.h>
int conv(int num, int base);
int main() {
  int k, i, j, num;
  while (scanf("%d", &k) != EOF) {
    for (i = 1; i < k; i++) {
      for (j = 1; j < k; j++) {
        num = conv(i * j, k);
        if (j == 1)
          printf("%d", num);
        else
          printf(" %d", num);
      }
      printf("\n");
    }
  }
  return 0;
}
int conv(int num, int base) {
  int temp = 0, ans = 0, i;
  for (i = 0;; i++) {
    temp = num % base;
    num = num / base;
    ans = (temp * pow(10, i)) + ans;
    if (num == 0) break;
  }
  return ans;
}
