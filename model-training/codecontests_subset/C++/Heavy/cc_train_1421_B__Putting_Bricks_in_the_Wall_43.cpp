#include <bits/stdc++.h>
using namespace std;
long long power(long long x, long long n, long long mod) {
  long long res = 1;
  x %= mod;
  while (n) {
    if (n & 1) res = (res * x) % mod;
    x = (x * x) % mod;
    n >>= 1;
  }
  return res;
}
signed main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  long long c = 0, d = 0, i = 0, j = 0, k = 0, t = 0, n = 0, q = 0;
  cin >> t;
  while (t--) {
    cin >> n;
    pair<long long, long long> a, b;
    string s[n];
    for (long long i = 0; i < n; i++) {
      cin >> s[i];
      if (i == 1) a = make_pair(s[0][1] - '0', s[1][0] - '0');
      if (i == n - 1)
        b = make_pair(s[n - 1][n - 2] - '0', s[n - 2][n - 1] - '0');
    }
    long long ans = 0;
    if (a.first + a.second == 2) {
      if (b.first == 1) ans++;
      if (b.second == 1) ans++;
      cout << ans << "\n";
      if (b.second) cout << n - 1 << " " << n << "\n";
      if (b.first) cout << n << " " << n - 1 << "\n";
    } else if (a.first + a.second == 0) {
      if (b.first == 0) ans++;
      if (b.second == 0) ans++;
      cout << ans << "\n";
      if (b.second == 0) cout << n - 1 << " " << n << "\n";
      if (b.first == 0) cout << n << " " << n - 1 << "\n";
    } else if (a.first + a.second == 1 && b.first + b.second == 1) {
      cout << 2 << "\n";
      if (a.first == 1) cout << 1 << " " << 2 << "\n";
      if (a.second == 1) cout << 2 << " " << 1 << "\n";
      if (b.first == 0) cout << n << " " << n - 1 << "\n";
      if (b.second == 0) cout << n - 1 << " " << n << "\n";
    } else if (a.first + a.second == 1 && b.first + b.second == 0) {
      cout << 1 << "\n";
      if (a.first == 0) cout << 1 << " " << 2 << "\n";
      if (a.second == 0) cout << 2 << " " << 1 << "\n";
    } else if (a.first + a.second == 1 && b.first + b.second == 2) {
      cout << 1 << "\n";
      if (a.first == 1) cout << 1 << " " << 2 << "\n";
      if (a.second == 1) cout << 2 << " " << 1 << "\n";
    }
  }
}
