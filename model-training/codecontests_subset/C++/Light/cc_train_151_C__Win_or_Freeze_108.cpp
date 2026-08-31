#include <bits/stdc++.h>
using namespace std;
const double PI = 2.0 * acos(0.0);
const int MOD = 1e9 + 9;
const int oo = 2e9 + 1e8;
long long gcd(long long x, long long y) { return !y ? x : gcd(y, x % y); }
int main() {
  long long n, cnt, ret;
  scanf("%I64d", &n);
  ret = 1, cnt = 0;
  for (long long i = 2; i * i <= n; i++) {
    while (n % i == 0) {
      n /= i, cnt++;
      if (cnt <= 2) ret *= i;
    }
    if (cnt > 1) break;
  }
  if (n != 1) {
    cnt++;
    if (cnt <= 2) ret *= n;
  }
  if (cnt < 2)
    puts("1\n0");
  else if (cnt == 2)
    puts("2");
  else
    printf("1\n%I64d\n", ret);
  return 0;
}
