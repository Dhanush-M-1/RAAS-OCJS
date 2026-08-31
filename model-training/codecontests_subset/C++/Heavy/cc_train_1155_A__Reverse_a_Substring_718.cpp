#include <bits/stdc++.h>
using namespace std;
using namespace std::chrono;
long long M1 = 1000000007;
long long M2 = 67280421310721;
long long M3 = 998244353;
long long INF = 1e18;
long long power(long long a, long long b, long long mod) {
  long long ans = 1;
  long long prod = a;
  while (b) {
    if (b % 2) ans = (ans * prod) % mod;
    prod = (prod * prod) % mod;
    b /= 2;
  }
  return ans;
}
long long inv(long long a, long long mod) { return power(a, mod - 2, mod); }
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long fact(long long n, long long mod) {
  long long f = 1;
  for (long long i = 1; i <= n; i++) f = (f * i) % mod;
  return f;
}
long long ncr(long long n, long long r, long long mod) {
  if (mod == 1) {
    return (fact(n, mod) / fact(r, mod)) / fact(n - r, mod);
  }
  return (((fact(n, mod) * inv(fact(r, mod), mod)) % mod) *
          inv(fact(n - r, mod), mod)) %
         mod;
}
void solve() {
  long long n;
  cin >> n;
  string s;
  cin >> s;
  long long i;
  long long flag = 0;
  for (i = 1; i < n; i++) {
    if (s[i] < s[i - 1]) {
      flag = 1;
      break;
    }
  }
  if (flag == 0) {
    cout << "NO" << '\n';
  } else {
    cout << "YES" << '\n';
    cout << i << " " << i + 1 << '\n';
  }
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout << fixed << setprecision(10);
  auto start = high_resolution_clock::now();
  long long i, t = 1;
  for (i = 1; i <= t; i++) solve();
  auto stop = high_resolution_clock::now();
  auto duration = duration_cast<microseconds>(stop - start);
}
