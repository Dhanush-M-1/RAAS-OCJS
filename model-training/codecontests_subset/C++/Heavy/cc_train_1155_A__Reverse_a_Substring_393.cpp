#include <bits/stdc++.h>
#pragma GCC optimize(2)
#pragma GCC optimize(3)
#pragma GCC optimize("Ofast,no-stack-protector,unroll-loops,fast-math,O3")
#pragma GCC target("avx,avx2,fma")
using namespace std;
long long power(long long a, long long b) {
  long long res = 1;
  a = a % 1000000007;
  while (b > 0) {
    if (b & 1) {
      res = (res * a) % 1000000007;
    }
    a = (a * a) % 1000000007;
    b >>= 1;
  }
  return res;
}
long long fermat_inv(long long y) { return power(y, 1000000007 - 2); }
long long gcd(long long a, long long b) { return (b == 0) ? a : gcd(b, a % b); }
void solve() {
  long long n;
  cin >> n;
  string s;
  cin >> s;
  long long f = -1;
  for (long long i = 0; i < n - 1; i++) {
    if (s[i + 1] < s[i]) {
      f = i;
      break;
    }
  }
  if (f == -1) {
    cout << "NO";
  } else {
    cout << "YES\n";
    cout << f + 1 << " " << f + 2;
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  long long T = 1;
  while (T--) {
    solve();
  }
  return 0;
}
