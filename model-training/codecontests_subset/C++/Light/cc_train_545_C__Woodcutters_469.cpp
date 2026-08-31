#include <bits/stdc++.h>
int main() {
  long int i, n, j, c = 1;
  scanf("%ld", &n);
  long long int a[n][2];
  for (i = 0; i < n; i++)
    for (j = 0; j < 2; j++) scanf("%lld", &a[i][j]);
  if (n == 1)
    printf("%ld", c);
  else {
    for (i = 1; i < n - 1; i++) {
      if (a[i][0] - a[i][1] > a[i - 1][0])
        c++;
      else if (a[i][0] + a[i][1] < a[i + 1][0]) {
        a[i][0] = a[i][0] + a[i][1];
        c++;
      }
    }
    printf("%ld", c + 1);
  }
  return 0;
}
