#include <bits/stdc++.h>
using namespace std;
long long get_pow(long long base, long long exp);
int main(int argc, char *argv[]) {
  long long q, l, r, d, i;
  scanf("%lld", &q);
  while (q--) {
    scanf("%lld %lld %lld", &l, &r, &d);
    if (d < l) {
      printf("%lld\n", d);
    } else {
      printf("%lld\n", (r + d) - (r + d) % d);
    }
  }
  return 0;
}
long long get_pow(long long base, long long exp) {
  long long ret = 1LL;
  while (exp) {
    if (exp % 2) {
      ret *= base;
      ret %= 1000000007LL;
    }
    base *= base;
    base %= 1000000007LL;
    exp /= 2LL;
  }
  return ret;
}
