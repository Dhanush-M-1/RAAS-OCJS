#include <bits/stdc++.h>
using namespace std;
const long long maxv = 1e5 + 5;
const long long mod = 998244353;
long long n, a[maxv], ans, digit[33], len[maxv];
bool cmp(long long x, long long y) { return x > y; }
long long quick_pow(long long a, long long b, long long m) {
  long long ans = 1;
  while (b > 0) {
    if (b & 1) {
      ans = ans * a % m;
    }
    a = a * a % m;
    b >>= 1;
  }
  return ans;
}
int main() {
  ios::sync_with_stdio(false);
  cin >> n;
  for (long long i = 1; i <= n; i++) {
    cin >> a[i];
    long long now = a[i], co = 0;
    while (now) {
      co++;
      now /= 10;
    }
    len[i] = co;
    digit[co]++;
  }
  sort(a + 1, a + n + 1, cmp);
  for (long long i = 1; i <= n; i++) {
    long long now = a[i], pos = 1, co = 0;
    long long tmp = now;
    for (; tmp; tmp /= 10, co++)
      ;
    while (now) {
      for (long long j = co - 1; j >= 1; j--) {
        if (j >= pos) {
          ans = (ans + (now % 10) * quick_pow(10, 2 * pos - 2, mod) % mod *
                           digit[j] % mod) %
                mod;
          ans = (ans + (now % 10) * quick_pow(10, 2 * pos - 1, mod) % mod *
                           digit[j] % mod) %
                mod;
        } else
          ans = (ans + (now % 10) * quick_pow(10, pos + j - 1, mod) % mod *
                           digit[j] * 2 % mod) %
                mod;
      }
      for (long long j = co + 1; j <= 20; j++) {
        ans = (ans + (now % 10) * quick_pow(10, 2 * pos - 1, mod) % mod *
                         digit[j] % mod) %
              mod;
        ans = (ans + (now % 10) * quick_pow(10, 2 * pos - 2, mod) % mod *
                         digit[j] % mod) %
              mod;
      }
      ans = (ans +
             (now % 10) * quick_pow(10, 2 * pos - 2, mod) % mod * digit[co]) %
            mod;
      ans = (ans +
             (now % 10) * quick_pow(10, 2 * pos - 1, mod) % mod * digit[co]) %
            mod;
      now /= 10;
      pos++;
    }
  }
  cout << ans << endl;
  return 0;
}
