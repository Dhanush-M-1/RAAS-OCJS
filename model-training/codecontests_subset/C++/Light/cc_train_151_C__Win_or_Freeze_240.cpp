#include <bits/stdc++.h>
using namespace std;
long long n, p, a[111], k;
int main() {
  scanf("%I64d", &n);
  p = 2;
  while (p * p <= n) {
    while (n % p == 0) {
      k++;
      a[k] = p;
      n /= p;
    }
    p++;
  }
  if (k > 0 && n != 1) {
    k++;
    a[k] = n;
  }
  if (k == 2 || k == 1)
    printf("2");
  else {
    if (k == 0)
      printf("1\n0");
    else
      printf("1\n%I64d", a[1] * a[2]);
  }
  return 0;
}
