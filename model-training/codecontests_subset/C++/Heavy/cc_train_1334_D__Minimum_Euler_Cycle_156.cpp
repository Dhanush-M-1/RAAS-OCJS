#include <bits/stdc++.h>
using namespace ::std;
const long double PI = acos(-1);
const long long MOD = 1000000000 + 7;
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
long long add(long long a, long long b, long long m = MOD) {
  if (a >= m) a %= m;
  if (b >= m) b %= m;
  if (a < 0) a += m;
  if (b < 0) b += m;
  long long res = a + b;
  if (res >= m or res <= -m) res %= m;
  if (res < 0) res += m;
  return res;
}
long long mul(long long a, long long b, long long m = MOD) {
  if (a >= m) a %= m;
  if (b >= m) b %= m;
  if (a < 0) a += m;
  if (b < 0) b += m;
  long long res = a * b;
  if (res >= m or res <= -m) res %= m;
  if (res < 0) res += m;
  return res;
}
long long pow_mod(long long a, long long b, long long m = MOD) {
  long long res = 1LL;
  a = a % m;
  while (b) {
    if (b & 1) res = mul(res, a, m);
    b >>= 1;
    a = mul(a, a, m);
  }
  return res;
}
long long fastexp(long long a, long long b) {
  long long res = 1LL;
  while (b) {
    if (b & 1) res = res * a;
    b >>= 1;
    a *= a;
  }
  return res;
}
int gcdExtendido(int a, int b, int *x, int *y) {
  if (a == 0) {
    *x = 0;
    *y = 1;
    return b;
  }
  int x1, y1;
  int gcd = gcdExtendido(b % a, a, &x1, &y1);
  *x = y1 - (b / a) * x1;
  *y = x1;
  return gcd;
}
int modInverso(int a, int m) {
  int x, y;
  int g = gcdExtendido(a, m, &x, &y);
  if (g != 1)
    return -1;
  else
    return (x % m + m) % m;
}
const int N = 100000 + 5;
int n;
long long l, r;
int ans[N];
long long f(int x) { return 2LL * n * x - 1LL * x * (x + 1); }
int main() {
  int t;
  scanf("%d", &(t));
  while (t--) {
    scanf("%d", &(n));
    scanf("%lld %lld", &(l), &(r));
    int len = r - l + 1;
    if (r == 1LL * n * (n - 1) + 1) {
      ans[r - l] = 1;
      r -= 1;
    }
    int lo = 1, hi = n;
    while (lo < hi) {
      int mi = lo + (hi - lo) / 2;
      if (f(mi) < l)
        lo = mi + 1;
      else
        hi = mi;
    }
    l -= f(lo - 1);
    r -= f(lo - 1);
    int pos = 0;
    int x = lo;
    int y = lo + (l + 1) / 2;
    bool goX = l & 1;
    for (int i = l; i <= r; i++) {
      if (goX) {
        ans[pos++] = x;
      } else {
        ans[pos++] = y;
        y += 1;
      }
      if (y == n + 1) {
        x += 1;
        y = x + 1;
      }
      goX = !goX;
    }
    for (int i = 0; i < len; i++) {
      printf("%d%c", ans[i], " \n"[i + 1 == len]);
    }
  }
  return 0;
}
