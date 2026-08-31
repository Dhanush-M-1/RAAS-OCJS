#include <bits/stdc++.h>
using namespace std;
long long x, n, a, b, i;
int main() {
  scanf("%lld", &n);
  x = n;
  a = 0;
  b = 0;
  for (i = 2; i <= sqrt(n) && x > 1; ++i) {
    while (x % i == 0) {
      if (a == 0)
        a = i;
      else if (b == 0)
        b = i;
      else {
        printf("1\n");
        printf("%lld\n", a * b);
        return 0;
      }
      x /= i;
    }
  }
  if (x > 1) {
    if (a == 0)
      a = x;
    else if (b == 0)
      b = x;
    else {
      printf("1\n");
      printf("%lld\n", a * b);
      return 0;
    }
  }
  if (a * b == 0)
    printf("1\n0\n");
  else
    printf("2\n");
  return 0;
}
