#include <bits/stdc++.h>
#pragma GCC optimize("unroll-loops")
#pragma GCC optimize("Ofast", "no-stack-protector")
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
long long int gcd(long long int a, long long int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long int exp(long long int x, long long int y, long long int mod) {
  long long int res = 1;
  x = x % mod;
  while (y > 0) {
    if (y & 1) res = (res * x) % mod;
    y = y >> 1;
    x = (x * x) % mod;
  }
  return res;
}
long long int modinverse(long long int x, long long int mod) {
  return exp(x, mod - 2, mod);
}
using namespace std;
const long long int inf = 0x3f3f3f3f3f3f3f3fll;
void solve() {
  long long int n;
  cin >> n;
  string s[n];
  for (long long int i = 0; i < n; i++) cin >> s[i];
  if (s[0][1] == '0' && s[1][0] == '0') {
    if (s[n - 1][n - 2] == '0' && s[n - 2][n - 1] == '0') {
      cout << 2 << '\n';
      cout << n << " " << n - 1 << '\n';
      cout << n - 1 << " " << n << '\n';
    } else if (s[n - 1][n - 2] == '0' && s[n - 2][n - 1] == '1') {
      cout << 1 << '\n';
      cout << n << " " << n - 1 << '\n';
    } else if (s[n - 1][n - 2] == '1' && s[n - 2][n - 1] == '0') {
      cout << 1 << '\n';
      cout << n - 1 << " " << n << '\n';
    } else
      cout << 0 << '\n';
  } else if (s[0][1] == '1' && s[1][0] == '0') {
    if (s[n - 1][n - 2] == '0' && s[n - 2][n - 1] == '0') {
      cout << 1 << '\n';
      cout << 2 << " " << 1 << '\n';
    } else if (s[n - 1][n - 2] == '0' && s[n - 2][n - 1] == '1') {
      cout << 2 << '\n';
      cout << 2 << " " << 1 << '\n';
      cout << n - 1 << " " << n << '\n';
    } else if (s[n - 1][n - 2] == '1' && s[n - 2][n - 1] == '0') {
      cout << 2 << '\n';
      cout << 2 << " " << 1 << '\n';
      cout << n << " " << n - 1 << '\n';
    } else {
      cout << 1 << '\n';
      cout << 1 << " " << 2 << '\n';
    }
  } else if (s[0][1] == '0' && s[1][0] == '1') {
    if (s[n - 1][n - 2] == '0' && s[n - 2][n - 1] == '0') {
      cout << 1 << '\n';
      cout << 1 << " " << 2 << '\n';
    } else if (s[n - 1][n - 2] == '0' && s[n - 2][n - 1] == '1') {
      cout << 2 << '\n';
      cout << 2 << " " << 1 << '\n';
      cout << n << " " << n - 1 << '\n';
    } else if (s[n - 1][n - 2] == '1' && s[n - 2][n - 1] == '0') {
      cout << 2 << '\n';
      cout << 2 << " " << 1 << '\n';
      cout << n - 1 << " " << n << '\n';
    } else {
      cout << 1 << '\n';
      cout << 2 << " " << 1 << '\n';
    }
  } else {
    if (s[n - 1][n - 2] == '0' && s[n - 2][n - 1] == '0')
      cout << 0 << '\n';
    else if (s[n - 1][n - 2] == '0' && s[n - 2][n - 1] == '1') {
      cout << 1 << '\n';
      cout << n - 1 << " " << n << '\n';
    } else if (s[n - 1][n - 2] == '1' && s[n - 2][n - 1] == '0') {
      cout << 1 << '\n';
      cout << n << " " << n - 1 << '\n';
    } else {
      cout << 2 << '\n';
      cout << n << " " << n - 1 << '\n';
      cout << n - 1 << " " << n << '\n';
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  long long int t;
  cin >> t;
  while (t--) solve();
  return 0;
}
