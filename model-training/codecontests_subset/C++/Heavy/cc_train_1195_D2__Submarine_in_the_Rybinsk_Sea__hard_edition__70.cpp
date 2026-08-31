#include <bits/stdc++.h>
using namespace std;
const int N = 1e6 + 100;
const int mod = 998244353;
long long a[N];
int cnt[20];
long long pw[30];
void init() {
  pw[0] = 1;
  for (int i = 1; i <= 29; i++) pw[i] = (pw[i - 1] % mod * 10 % mod) % mod;
}
int siz[N];
int main() {
  int n;
  cin >> n;
  init();
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    long long x = a[i];
    while (x) {
      siz[i]++;
      x /= 10;
    }
    cnt[siz[i]]++;
  }
  long long ans = 0;
  for (int i = 1; i <= n; i++) {
    long long x = a[i];
    int p = 0;
    while (x) {
      int c = x % 10;
      x /= 10;
      p++;
      for (int j = 1; j <= 10; j++) {
        if (j <= p) {
          ans += (c % mod * cnt[j] % mod * pw[p + j - 1] % mod) % mod;
          ans % mod;
        } else {
          ans += (c % mod * cnt[j] % mod * pw[2 * p - 1] % mod) % mod;
          ans % mod;
        }
        if (j < p) {
          ans += (c % mod * cnt[j] % mod * pw[p + j - 1] % mod) % mod;
          ans %= mod;
        } else {
          ans += (c % mod * cnt[j] % mod * pw[2 * (p - 1)] % mod) % mod;
          ans % mod;
        }
      }
    }
  }
  cout << ans % mod << endl;
  return 0;
}
