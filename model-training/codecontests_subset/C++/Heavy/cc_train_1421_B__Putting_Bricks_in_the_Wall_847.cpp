#include <bits/stdc++.h>
using namespace std;
long long mod(long long x) {
  return (((x % 1000000007) + 1000000007) % 1000000007);
}
long long mul(long long x, long long y) { return mod(mod(x) * mod(y)); }
long long add(long long a, long long b) { return mod(mod(a) + mod(b)); }
long long modpow(long long x, long long y) {
  if (y == 0) return 1ll;
  if (y == 1) return mod(x);
  long long res = 1;
  while (y) {
    if (y % 2 == 1) {
      res = mul(res, x);
    }
    x = mul(x, x);
    y /= 2;
  }
  return res;
}
void solve() {
  long long n;
  cin >> n;
  string s[n];
  for (long long i = 0; i < n; i++) {
    cin >> s[i];
  }
  char c = s[0][1];
  long long x = 1;
  if (s[1][0] == s[0][1]) {
    if (s[n - 1][n - 2] == s[n - 2][n - 1] && s[n - 1][n - 2] != s[0][1]) {
      cout << 0 << "\n";
    } else if (s[n - 1][n - 2] == s[n - 2][n - 1] &&
               s[n - 1][n - 2] == s[0][1]) {
      cout << 2 << "\n";
      cout << n << " " << n - 1 << "\n";
      cout << n - 1 << " " << n << "\n";
    } else if (s[n - 1][n - 2] != s[n - 2][n - 1]) {
      if (s[n - 1][n - 2] == s[0][1]) {
        cout << 1 << "\n";
        cout << n << " " << n - 1 << "\n";
      } else {
        cout << 1 << "\n";
        cout << n - 1 << " " << n << "\n";
      }
    }
  } else {
    if (s[n - 1][n - 2] == s[n - 2][n - 1]) {
      if (s[n - 1][n - 2] == s[0][1]) {
        cout << 1 << "\n";
        cout << 1 << " " << 2 << "\n";
      } else if (s[n - 1][n - 2] == s[1][0]) {
        cout << 1 << "\n";
        cout << 2 << " " << 1 << "\n";
      }
    } else {
      if (s[n - 1][n - 2] == s[0][1]) {
        cout << 2 << "\n";
        cout << 1 << " " << 2 << "\n";
        cout << n - 1 << " " << n << "\n";
      } else if (s[n - 1][n - 2] == s[1][0]) {
        cout << 2 << "\n";
        cout << 2 << " " << 1 << "\n";
        cout << n - 1 << " " << n << "\n";
      }
    }
  }
}
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long t;
  cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}
