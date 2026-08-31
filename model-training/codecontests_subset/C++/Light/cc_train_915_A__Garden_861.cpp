#include <bits/stdc++.h>
long long cmpfunc(const void* a, const void* b) {
  return (*(long long*)a - *(long long*)b);
}
int main(void) {
  long long int test, i, j, n, count,
      flag = 0, o1 = 0, o2 = 0, b1, x, m, l, max, sum2, min, f, k, r, o, sum1,
      sum = 0, y, count1 = 0, a[3000] = {0}, b[3000] = {0}, c[26] = {0};
  scanf("%lld%lld", &n, &k);
  for (i = 1; i <= n; i++) {
    scanf("%lld", &x);
    a[x]++;
  }
  for (i = k; i >= 1; i--) {
    if (a[i] != 0 && k % i == 0) {
      printf("%lld", k / i);
      break;
    }
  }
  return 0;
}
