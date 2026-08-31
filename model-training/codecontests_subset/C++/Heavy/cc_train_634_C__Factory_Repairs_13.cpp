#include <bits/stdc++.h>
using namespace std;
const long long maxn = 2e5 + 10;
struct Fenwick {
  long long arr[2][maxn];
  inline long long lowbit(long long x) { return x & -x; }
  void init() { memset(arr, 0, sizeof(arr)); }
  void add(long long x, long long p, long long v) {
    for (long long i = x; i < maxn; i += lowbit(i)) arr[p][i] += v;
  }
  long long qry(long long x, long long p) {
    long long ret = 0;
    for (long long i = x; i; i -= lowbit(i)) ret += arr[p][i];
    return ret;
  }
} bit;
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  long long n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  bit.init();
  while (q--) {
    long long t;
    cin >> t;
    if (t == 1) {
      long long d, ai;
      cin >> d >> ai;
      long long qb = bit.qry(d, 0) - bit.qry(d - 1, 0),
                qa = bit.qry(d, 1) - bit.qry(d - 1, 1);
      bit.add(d, 0, min(b - qb, ai));
      bit.add(d, 1, min(a - qa, ai));
    } else {
      long long p;
      cin >> p;
      cout << bit.qry(p - 1, 0) + bit.qry(n, 1) - bit.qry(p + k - 1, 1) << endl;
    }
  }
  return 0;
}
