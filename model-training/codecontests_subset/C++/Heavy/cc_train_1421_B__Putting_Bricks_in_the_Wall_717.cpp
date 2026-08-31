#include <bits/stdc++.h>
const unsigned long long int M = 1000000007;
using namespace std;
long long power(long long x, long long y) {
  long long res = 1;
  while (y > 0) {
    if (y & 1) res = x * res;
    y = y >> 1;
    x = x * x;
  }
  return res;
}
long long power(long long x, long long y, long long mod) {
  long long res = 1;
  while (y > 0) {
    if (y & 1) res = x * res % mod;
    y = y >> 1;
    x = x * x % mod;
  }
  return res;
}
void nik() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
}
signed main() {
  nik();
  long long test = 1;
  cin >> test;
  while (test--) {
    long long n;
    cin >> n;
    string s[n];
    for (long long i = 0; i < n; i++) cin >> s[i];
    long long a, b, c, d;
    a = s[1][0] - '0';
    b = s[0][1] - '0';
    c = s[n - 1][n - 2] - '0';
    d = s[n - 2][n - 1] - '0';
    std::vector<pair<long long, long long>> v;
    if (a == b) {
      if (c == a) v.push_back({n - 1, n - 2});
      if (d == a) v.push_back({n - 2, n - 1});
    } else if (c == d) {
      if (c == a) v.push_back({1, 0});
      if (d == b) v.push_back({0, 1});
    } else if (a == c) {
      v.push_back({1, 0});
      v.push_back({n - 2, n - 1});
    } else if (a == d) {
      v.push_back({0, 1});
      v.push_back({n - 2, n - 1});
    }
    cout << v.size() << "\n";
    for (auto it : v) {
      cout << it.first + 1 << " " << it.second + 1 << "\n";
    }
  }
  return 0;
}
