#include <bits/stdc++.h>
using namespace std;
long long n, dive, multi = 1, times;
int main() {
  scanf("%I64d", &n);
  for (long long i = 2; i * 1ll * i <= n; i++) {
    while (n % i == 0) {
      dive++;
      n /= i;
      if (times < 2) {
        multi *= i;
        times++;
      }
    }
  }
  if (n > 1)
    if (dive > 0) dive++;
  if (dive < 2) {
    printf("1\n0\n");
  } else if (dive == 2) {
    printf("2\n");
  } else {
    printf("1\n%I64d", multi);
  }
  return 0;
}
