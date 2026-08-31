#include <bits/stdc++.h>
const long long N = 1000006;
using namespace std;
const long long MOD = 1000000007LL;
template <typename T>
T gcd(T a, T b) {
  if (a == 0) return b;
  return gcd(b % a, a);
}
template <typename T>
T power(T x, T y, long long m = MOD) {
  T ans = 1;
  while (y > 0) {
    if (y & 1LL) ans = (ans * x) % m;
    y >>= 1LL;
    x = (x * x) % m;
  }
  return ans % m;
}
long long cost[N], ch[N];
int32_t main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n, m, k;
  cin >> n >> m >> k;
  for (long long(i) = (0); i < (m); i++) {
    long long x;
    cin >> x;
    ch[x] = 1;
  }
  for (long long(i) = (0); i < (k); i++) cin >> cost[i];
  vector<long long> v;
  for (long long(i) = (0); i < (n); i++) {
    if (!ch[i]) v.emplace_back(i);
  }
  long long ans = 1000111000111000111LL;
  for (long long i = 1; i <= k; i++) {
    long long tc = 0;
    bool f = 0;
    for (long long j = 0; j < n; j += i) {
      if (!ch[j]) {
        tc += cost[i - 1];
      } else {
        auto idx = lower_bound(v.begin(), v.end(), j);
        if (idx == v.begin()) {
          f = 1;
          break;
        }
        --idx;
        if (abs(*idx - j) >= i) {
          f = 1;
          break;
        }
        tc += cost[i - 1];
        j = *idx;
      }
    }
    if (f) continue;
    ans = min(ans, tc);
  }
  if (ans == 1000111000111000111LL)
    cout << "-1";
  else
    cout << ans;
}
