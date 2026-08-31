#include <bits/stdc++.h>
using namespace std;
#pragma GCC target("avx2")
#pragma GCC optimization("O3")
#pragma GCC optimization("unroll-loops")
long long modPow(long long a, long long b);
long long modInv(long long a);
void solve() {
  long long n;
  cin >> n;
  char a[n][n];
  for (long long i = 0; i < n; i++)
    for (long long j = 0; j < n; j++) cin >> a[i][j];
  vector<pair<long long, long long> > x;
  if (a[0][1] == a[1][0] && a[n - 1][n - 2] == a[n - 2][n - 1]) {
    if (a[0][1] != a[n - 2][n - 1]) {
      cout << 0 << "\n";
      return;
    } else {
      cout << 2 << "\n";
      cout << "1 2"
           << "\n"
           << "2 1"
           << "\n";
      return;
    }
  }
  if (a[0][1] == a[1][0]) {
    if (a[n - 1][n - 2] == a[0][1])
      x.push_back({n, n - 1});
    else
      x.push_back({n - 1, n});
    cout << 1 << "\n";
    cout << x[0].first << " " << x[0].second << "\n";
    return;
  }
  if (a[n - 1][n - 2] == a[n - 2][n - 1]) {
    if (a[n - 1][n - 2] == a[0][1])
      x.push_back({1, 2});
    else
      x.push_back({2, 1});
    cout << 1 << "\n";
    cout << x[0].first << " " << x[0].second << "\n";
    return;
  }
  cout << 2 << "\n";
  if (a[0][1] == '0')
    cout << "1 2"
         << "\n";
  if (a[1][0] == '0')
    cout << "2 1"
         << "\n";
  if (a[n - 1][n - 2] == '1')
    cout << n << " " << n - 1 << "\n";
  else
    cout << n - 1 << " " << n << "\n";
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long test = 1;
  cin >> test;
  while (test--) solve();
}
long long modPow(long long a, long long b) {
  if (b == 0) return 1;
  if (b % 2 == 0) {
    long long x = a * a;
    x %= 1000000007;
    return modPow(x, b / 2);
  }
  return (a * modPow(a, b - 1)) % 1000000007;
}
long long modInv(long long a) { return modPow(a, 1000000007 - 2); }
