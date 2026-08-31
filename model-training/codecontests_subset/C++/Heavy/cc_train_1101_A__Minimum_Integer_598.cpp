#include <bits/stdc++.h>
using namespace std;
int64_t gcd(int64_t a, int64_t b) {
  if (a == 0) {
    return (b);
  } else {
    return (gcd(b % a, a));
  }
}
bool x[10000001] = {false};
int spf[10000001];
map<int64_t, int64_t> mp, mp1;
vector<int64_t> pri, pris;
int64_t fast(int64_t n, int64_t a) {
  if (n == 0)
    return (1);
  else if (n == 1)
    return (a % 1000000007);
  else {
    int64_t r = fast(n / 2, a) % 1000000007;
    if (n % 2 == 0)
      return (((r % 1000000007) * (r % 1000000007)) % 1000000007);
    else
      return (((((r % 1000000007) * a) % 1000000007) * r) % 1000000007);
  }
}
int64_t check(int64_t n) {
  if (n == 1 || n == 0)
    return (0);
  else if (n == 2 || n == 3)
    return (1);
  else if (n % 2 == 0 || n % 3 == 0)
    return (0);
  else {
    for (int64_t i = 5; i * i <= n; i += 6) {
      if (n % i == 0 || n % (i + 2) == 0) return (0);
    }
    return (1);
  }
}
int main() {
  int q;
  cin >> q;
  while (q--) {
    int64_t l, r, x;
    scanf("%lld%lld%lld", &l, &r, &x);
    if (x < l || x > r) {
      printf("%lld\n", x);
    } else if (x >= l && x <= r) {
      int64_t p = r / x;
      printf("%lld\n", (p + 1) * x);
    }
  }
}
