#include <bits/stdc++.h>
using namespace std;
const long long mod = 998244353;
long long power(long long a, long long n) {
  a %= mod;
  if (n == 1) return a;
  if (n == 0) return 1;
  if (n % 2) return (a * (power((a * a) % mod, n / 2) % mod)) % mod;
  return power((a * a) % mod, n / 2) % mod;
}
const long long inf = (long long)1e18;
long long inverse(long long x) { return power(x, mod - 2) % mod; }
long long pp[40];
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  for (long long i = 0; i < 40; ++i) pp[i] = power(10, i);
  long long n, ans = 0;
  cin >> n;
  vector<pair<long long, long long> > v(n + 5);
  vector<long long> cnt(15);
  for (long long i = 1; i < n + 1; ++i) {
    cin >> v[i].second;
    long long x = v[i].second;
    while (x) {
      x /= 10;
      v[i].first++;
    }
  }
  sort(v.begin() + 1, v.begin() + n + 1);
  for (long long i = 1; i < n + 1; ++i) {
    long long x = v[i].second, pi = 0, tot = 0;
    while (x) {
      tot += (pp[pi] * (x % 10)) % mod;
      tot %= mod;
      pi += 2;
      x /= 10;
    }
    tot *= (n - i);
    tot %= mod;
    ans += tot;
    ans %= mod;
    x = v[i].second, pi = 1, tot = 0;
    while (x) {
      tot += (pp[pi] * (x % 10)) % mod;
      tot %= mod;
      pi += 2;
      x /= 10;
    }
    tot *= (n - i);
    tot %= mod;
    ans += tot;
    ans %= mod;
    cnt[v[i].first]++;
    for (long long j = 1; j < 11; ++j) {
      long long x = v[i].second, pi = 0, tot = 0;
      for (long long k = 0; k < j; ++k) {
        if (x == 0) break;
        tot += (pp[pi] * (x % 10)) % mod;
        tot %= mod;
        pi += 2;
        x /= 10;
      }
      while (x) {
        tot += (pp[pi] * (x % 10)) % mod;
        tot %= mod;
        pi++;
        x /= 10;
      }
      tot *= cnt[j];
      tot %= mod;
      ans += tot;
      ans %= mod;
      x = v[i].second, pi = 1, tot = 0;
      for (long long k = 0; k < j; ++k) {
        if (x == 0) break;
        tot += (pp[pi] * (x % 10)) % mod;
        tot %= mod;
        if (k < j - 1)
          pi += 2;
        else
          pi++;
        x /= 10;
      }
      while (x) {
        tot += (pp[pi] * (x % 10)) % mod;
        tot %= mod;
        pi++;
        x /= 10;
      }
      tot *= cnt[j];
      tot %= mod;
      ans += tot;
      ans %= mod;
    }
  }
  cout << ans;
  return 0;
}
