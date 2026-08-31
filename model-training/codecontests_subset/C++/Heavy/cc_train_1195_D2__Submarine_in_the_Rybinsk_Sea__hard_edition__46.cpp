#include <bits/stdc++.h>
using namespace std;
const long long mod = 998244353;
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long qpow(long long a, long long b, long long c) {
  long long t = 1;
  while (b) {
    if (b & 1) t = t * a % c;
    a = a * a % c;
    b >>= 1;
  }
  return t;
}
int test = 1;
const int maxn = 5 + 1e5;
const int maxm = 5 + 1e5;
long long n;
long long ar[maxn];
int len[maxn];
long long cnt[20];
long long f[22];
int main() {
  f[0] = 1;
  for (int i = 1; i <= 20; i++) {
    f[i] = f[i - 1] * 10 % mod;
  }
  while (test--) {
    cin >> n;
    long long t;
    for (int i = 1; i <= n; i++) {
      cin >> ar[i];
      len[i] = 0;
      t = ar[i];
      while (t) {
        len[i]++;
        t /= 10;
      }
      cnt[len[i]]++;
    }
    long long ans = 0;
    for (int i = 1; i <= n; i++) {
      t = ar[i];
      for (int j = 1; j <= len[i]; j++) {
        for (int k = 1; k <= 10; k++) {
          if (k < j)
            ans = (ans + (t % 10) * 2 * f[j - 1 + k] * cnt[k]) % mod;
          else
            ans = (ans +
                   (f[2 * j - 2] + f[2 * j - 1]) % mod * (t % 10) * cnt[k]) %
                  mod;
        }
        t /= 10;
      }
    }
    cout << ans % mod << endl;
  }
  return 0;
}
