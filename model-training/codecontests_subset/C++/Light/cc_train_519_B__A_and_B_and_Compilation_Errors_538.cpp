#include <bits/stdc++.h>
int main() {
  int n, tmp, a, b, i;
  long long int sm = 0, tmp1;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d", &tmp);
    sm += tmp;
  }
  tmp1 = sm;
  sm = 0;
  for (i = 1; i <= n - 1; i++) {
    scanf("%d", &tmp);
    sm += tmp;
  }
  a = tmp1 - sm;
  tmp1 = sm;
  sm = 0;
  for (i = 1; i <= n - 2; i++) {
    scanf("%d", &tmp);
    sm += tmp;
  }
  b = tmp1 - sm;
  printf("%d\n%d", a, b);
  return 0;
}
