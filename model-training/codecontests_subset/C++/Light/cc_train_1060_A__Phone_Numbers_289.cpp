#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
long long power(long long x, long long p, long long MOD) {
  if (p == 0) return 1 % MOD;
  if (p == 1) return x % MOD;
  long long res = power(x, p / 2, MOD);
  res = (long long)res * res % MOD;
  if (p & 1) res = (long long)res * x % MOD;
  return res;
}
int32_t main() {
  long long n;
  cin >> n;
  string s;
  cin >> s;
  long long e = 0;
  for (char c : s) {
    e += c == '8';
  }
  long long ans = 0;
  for (long long i = 1; i <= e; i++) {
    ans = max(ans, min(i, (n - i) / 10));
  }
  cout << ans << endl;
}
