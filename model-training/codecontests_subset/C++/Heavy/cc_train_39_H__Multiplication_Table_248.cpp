#include <bits/stdc++.h>
#pragma GCC target("sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native")
#pragma GCC optimize("Ofast")
#pragma GCC optimize("inline")
#pragma GCC optimize("unroll-loops")
#pragma GCC optimize("-falign-jumps")
#pragma GCC optimize("-falign-loops")
#pragma GCC optimize("-falign-labels")
#pragma GCC optimize("-finline-small-functions")
#pragma GCC optimize("-ftree-switch-conversion")
#pragma GCC optimize("-foptimize-sibling-calls")
#pragma GCC optimize("-fexpensive-optimizations")
#pragma GCC optimize("-funsafe-loop-optimizations")
using namespace std;
long long gcd(long long a, long long b) {
  while (b) b ^= a ^= b ^= a %= b;
  return a;
}
long long lcm(long long a, long long b) { return a * b / gcd(a, b); }
long long bigmod(long long b, long long p, long long m) {
  long long ans = 1;
  b %= m;
  if (!b) return 0;
  while (p) {
    if (p & 1) ans = (ans * b) % m;
    p >>= 1;
    b = (b * b) % m;
  }
  return ans;
}
void recur() {}
void solve() {
  long long n;
  cin >> n;
  for (long long i = 1; i < n; i++) {
    for (long long j = 1; j < n; j++) {
      long long t = i * j;
      string s = "";
      while (t) {
        s += char('0' + t % n);
        t /= n;
      }
      reverse(s.begin(), s.end());
      cout << s;
      cout << ' ';
    }
    cout << endl;
  }
}
signed main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t = 1;
  while (t--) solve();
}
