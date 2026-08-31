#include <bits/stdc++.h>
using namespace std;
long long modexpo(long long x, long long p) {
  long long res = 1;
  x = x % 1000000007;
  while (p) {
    if (p % 2) res = res * x;
    p >>= 1;
    x = x * x % 1000000007;
    res %= 1000000007;
  }
  return res;
}
long long max(long long a, long long b) { return (a > b ? a : b); }
long long min(long long a, long long b) { return (a < b ? a : b); }
struct edge {
  long long u, v, w;
  edge(long long a, long long b, long long c) {
    u = a;
    v = b;
    w = c;
  }
};
struct compare {
  bool operator()(const edge a, const edge b) const {
    if (a.u == b.u) {
      if (a.v == b.v) {
        return a.w < b.w;
      }
      return a.v < b.v;
    }
    return a.u < b.u;
  }
};
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t;
  cin >> t;
  while (t--) {
    long long l, r, d;
    cin >> l >> r >> d;
    if (d < l) {
      cout << d << "\n";
    } else if (r % d == 0) {
      cout << r + d << "\n";
    } else {
      long long x = ceil((long double)r / (long double)d);
      cout << x * d << "\n";
    }
  }
}
