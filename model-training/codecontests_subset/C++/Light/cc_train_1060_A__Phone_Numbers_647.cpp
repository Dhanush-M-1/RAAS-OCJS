#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) { return b == 0 ? a : gcd(b, a % b); }
long long ppow(long long a, long long b, long long mod) {
  a %= mod;
  long long ans = 1;
  while (b) {
    if (b & 1) ans = ans * a % mod;
    a = a * a % mod;
    b >>= 1;
  }
  return ans;
}
void ac() { cout << "YES" << endl; }
void wa() { cout << "NO" << endl; }
signed main() {
  long long n;
  cin >> n;
  string s;
  cin >> s;
  long long ans = 0;
  for (auto v : s) {
    if (v == '8') {
      ans++;
    }
  }
  cout << min(ans, n / 11) << endl;
  return 0;
}
