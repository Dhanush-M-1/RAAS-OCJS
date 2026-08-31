#include <bits/stdc++.h>
using namespace std;
const long long N = 2 * 1e5 + 3;
const long long INF = INT_MAX;
const long long NEINF = INT_MIN;
const long long MOD = 1e9 + 7;
long long Add(long long x, long long y) { return (x + y) % MOD; }
long long Mul(long long x, long long y) { return (x * y) % MOD; }
long long BinPow(long long x, long long y) {
  long long res = 1;
  while (y) {
    if (y & 1) res = Mul(res, x);
    x = Mul(x, x);
    y >>= 1;
  }
  return res;
}
long long ModInverse(long long x) { return BinPow(x, MOD - 2); }
long long Div(long long x, long long y) { return Mul(x, ModInverse(y)); }
long long GetBit(long long num, long long i) { return (num >> i) & 1; }
long long n;
long long bit[N], s[N], val[N], res[N];
void add(long long idx, long long delta) {
  while (idx <= n) {
    bit[idx] += delta;
    idx += idx & -idx;
  }
}
long long get(long long idx) {
  long long res = 0;
  while (idx > 0) {
    res += bit[idx];
    idx -= idx & -idx;
  }
  return res;
}
long long search(long long v) {
  long long l = 0, r = n - 1, res, mid;
  while (l <= r) {
    mid = (l + r) >> 1;
    long long temp = get(mid) + ((mid + 1) * mid) / 2;
    if (temp == v) {
      res = mid;
      l = mid + 1;
    } else if (temp > v)
      r = mid - 1;
    else
      l = mid + 1;
  }
  return res;
}
void Solve() {
  cin >> n;
  for (long long i = 1; i <= n; ++i) cin >> s[i];
  for (long long i = 1; i <= n; ++i) val[i] = i;
  for (long long i = n; i >= 1; --i) {
    long long pos = search(s[i]) + 1;
    res[i] = pos;
    add(pos, -pos);
  }
  for (long long i = 1; i <= n; ++i) cout << res[i] << " ";
}
signed main() {
  cin.tie(NULL);
  ios_base::sync_with_stdio(false);
  Solve();
  return 0;
}
