#include <bits/stdc++.h>
long long cmpfunc(const void* a, const void* b) {
  return (*(long long*)a - *(long long*)b);
}
int main(void) {
  long long int test, i, j, n, count, flag = 0, o1 = 0, o2 = 0, b1, x, m, l,
                                      max, sum2, min, f, c, r, o, sum1, sum = 0,
                                      y;
  char a[100000] = {0};
  scanf("%lld%s", &n, a);
  count = 0;
  for (i = 0; i < n; i++) {
    if (a[i] == '8') {
      count++;
    }
  }
  count = (count >= (n / 11)) ? n / 11 : count;
  printf("%lld", count);
  return 0;
}
