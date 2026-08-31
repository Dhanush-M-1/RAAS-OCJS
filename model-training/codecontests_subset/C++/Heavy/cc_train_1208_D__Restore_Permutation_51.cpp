#include <bits/stdc++.h>
using namespace std;
typedef long double ld;
const long double PI =
    3.141592653589793238462643383279502884197169399375105820974944;
const long long mod = 998244353;
const long long inf = 1e18;
const long long maxn = 1e5 + 5;
struct BIT {
  vector<long long> bit;
  long long maxn;
  void init(long long n) {
    maxn = n;
    bit.assign(n + 1, 0);
  }
  void update(long long i, long long val) {
    for (; i <= maxn; i += (i & -i)) bit[i] += val;
  }
  long long sum(long long i) {
    long long res = 0;
    for (; i > 0; i -= (i & -i)) res += bit[i];
    return res;
  }
  long long rsum(long long l, long long r) { return sum(r) - sum(l - 1); }
};
long long n, a[maxn];
void solve() {
  long long n;
  cin >> n;
  BIT bit;
  bit.init(n + 5);
  long long a[n + 5];
  set<long long> s;
  for (long long i = 1; i <= n; i++) {
    cin >> a[i];
    bit.update(i, i);
    s.insert(i);
  }
  for (long long i = n; i >= 1; --i) {
    long long lb = 1, rb = n;
    while (lb < rb) {
      long long mid = (lb + rb + 1) / 2;
      if (bit.sum(mid - 1) > a[i])
        rb = mid - 1;
      else if (bit.sum(mid - 1) < a[i])
        lb = mid + 1;
      else
        lb = rb = mid;
    }
    auto it = s.lower_bound(lb);
    a[i] = *it;
    bit.update(*it, -*it);
    s.erase(it);
  }
  for (long long i = 1; i <= n; i++) cout << a[i] << " ";
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long tc = 1;
  while (tc--) {
    solve();
    cout << '\n';
  }
  return 0;
}
