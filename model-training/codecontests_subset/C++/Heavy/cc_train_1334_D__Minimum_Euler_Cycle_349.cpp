#include <bits/stdc++.h>
using namespace std;
long long next() {
  long long x;
  cin >> x;
  return x;
}
const int maxn = 2e5 + 2, intf = 1e9;
const long long inf = 2e18, mod = 1e9;
const long double eps = 1e-6;
long long n;
void _print(long long bucket_id, long long l, long long r) {
  if (l > r) return;
  if (bucket_id == n) {
    cout << 1;
    return;
  }
  for (long long i = l; i <= r; i++) {
    if (i % 2 == 0) {
      cout << bucket_id << ' ';
    } else {
      cout << (i / 2) + 1 + bucket_id << ' ';
    }
  }
}
void solve() {
  long long l, r;
  cin >> n >> l >> r;
  l--, r--;
  long long sum = 0;
  for (long long bucket_id = 1; bucket_id <= n; bucket_id++) {
    long long cur_l = sum, cur_r = sum + 2 * (n - bucket_id) - 1;
    if (bucket_id == n) {
      if (r >= cur_l) {
        _print(bucket_id, 0, 1);
      }
      continue;
    }
    cur_l = max(cur_l, l) - sum;
    cur_r = min(cur_r, r) - sum;
    _print(bucket_id, cur_l, cur_r);
    sum += 2 * (n - bucket_id);
  }
  cout << '\n';
}
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  cout.precision(20);
  for (int t = next(); t--;) {
    solve();
  }
  return 0;
}
