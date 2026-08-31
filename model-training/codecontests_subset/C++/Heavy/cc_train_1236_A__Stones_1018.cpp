#include <bits/stdc++.h>
using namespace std;
const int mod = 1e9 + 7;
const int N = 1e6 + 5;
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long lcm(long long a, long long b) { return a * b / gcd(a, b); }
inline long long qsm(long long x, long long y) {
  long long res = 1;
  while (y) {
    if (y & 1) res = res * x % mod;
    x = x * x % mod;
    y >>= 1;
  }
  return res;
}
int n, m, k, rt;
int main() {
  int T;
  scanf("%d", &T);
  while (T--) {
    int ans = 0, a, b, c;
    scanf("%d%d%d", &a, &b, &c);
    ans += min(c / 2, b);
    b -= min(c / 2, b);
    ans += min(b / 2, a);
    printf("%d\n", ans * 3);
  }
  return 0;
}
