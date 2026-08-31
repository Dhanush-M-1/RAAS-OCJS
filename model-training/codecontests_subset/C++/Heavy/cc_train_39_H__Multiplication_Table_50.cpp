#include <bits/stdc++.h>
void conv(char *str, int k, int n) {
  int n2, num = 0;
  n2 = n;
  while (n2 != 0) {
    num++;
    n2 = n2 / k;
  }
  while (n != 0) {
  }
}
int main() {
  int a[10][10] = {0};
  int d1, d2, c;
  int k, i, j;
  scanf("%d", &k);
  for (j = 0; j < k - 1; j++) a[0][j] = j + 1;
  for (i = 1; i < k - 1; i++) a[i][0] = i + 1;
  for (i = 1; i < k; i++)
    for (j = 1; j < k; j++) {
      c = (i + 1) * (j + 1);
      if (c >= k) {
        d1 = c % k;
        c /= k;
        d2 = c % k;
        a[i][j] = d1 + d2 * 10;
      } else
        a[i][j] = c;
    }
  for (i = 0; i < k - 1; i++) {
    for (j = 0; j < k - 1; j++) {
      printf("%d\t", a[i][j]);
      if (j != k - 1) printf(" ");
    }
    printf("\n");
  }
}
