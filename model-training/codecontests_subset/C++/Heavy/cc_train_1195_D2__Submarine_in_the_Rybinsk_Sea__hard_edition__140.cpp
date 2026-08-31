#include <bits/stdc++.h>
const long long int INF = 1e15;
using namespace std;
const long long int MAX = 1e6 + 5;
const long long int mod = 998244353;
long long int gcd(long long int a, long long int b) {
  while (b > 0) {
    a = a % b;
    swap(a, b);
  }
  return a;
}
long long int binpow(long long int a, long long int b) {
  long long int res = 1;
  while (b > 0) {
    if (b % 2 == 1) res = res * a % mod;
    a = a * a % mod;
    b /= 2;
  }
  return res % mod;
}
void solve() {
  long long int n;
  cin >> n;
  long long int ar[n];
  long long int digits[11] = {};
  long long int k;
  long long int cnt;
  for (long long int i = 0; i < n; i++) {
    cin >> ar[i];
    k = ar[i];
    cnt = 0;
    while (k) {
      cnt++;
      k /= 10;
    }
    digits[cnt]++;
  }
  long long int ans = 0;
  for (long long int i = 0; i < n; i++) {
    long long int cur = 0;
    k = ar[i];
    cnt = 0;
    while (k) {
      long long int digit = k % 10;
      for (long long int i = 1; i < cur; i++) {
        ans += (binpow(10, cur + i) * digit % mod) * digits[i] % mod;
        if (ans > mod) ans %= mod;
      }
      long long int res = 0;
      for (long long int i = cur; i < 11; i++) {
        res += digits[i];
      }
      ans += (binpow(10, 2 * cur) * digit % mod) * res % mod;
      if (ans > mod) ans %= mod;
      cur++;
      k /= 10;
    }
  }
  for (long long int i = 0; i < n; i++) {
    long long int cur = 0;
    k = ar[i];
    cnt = 0;
    while (k) {
      long long int digit = k % 10;
      for (long long int i = 1; i <= cur; i++) {
        ans += (binpow(10, cur + i) * digit % mod) * digits[i] % mod;
        if (ans > mod) ans %= mod;
      }
      long long int res = 0;
      for (long long int i = cur + 1; i < 11; i++) {
        res += digits[i];
      }
      ans += (binpow(10, 2 * cur + 1) * digit % mod) * res % mod;
      if (ans > mod) ans %= mod;
      cur++;
      k /= 10;
    }
  }
  cout << ans << "\n";
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long int t = 1;
  while (t--) {
    solve();
  }
}
