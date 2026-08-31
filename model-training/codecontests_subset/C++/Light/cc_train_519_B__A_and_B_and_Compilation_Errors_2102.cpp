#include <bits/stdc++.h>
int main() {
  long long n;
  long long f1 = 0, f2 = 0, f3 = 0;
  long long err = 0, err2 = 0;
  scanf("%lld", &n);
  for (int i = 0; i < n; i++) {
    scanf("%lld", &err);
    f1 += err;
  }
  for (int i = 0; i < n - 1; i++) {
    scanf("%lld", &err);
    f2 += err;
  }
  printf("%lld\n", f1 - f2);
  for (int i = 0; i < n - 2; i++) {
    scanf("%lld", &err);
    f3 += err;
  }
  printf("%lld", f2 - f3);
  return 0;
}
