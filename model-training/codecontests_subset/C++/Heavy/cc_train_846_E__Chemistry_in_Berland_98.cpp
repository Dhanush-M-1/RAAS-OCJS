#include <bits/stdc++.h>
using namespace std;
const long long N = 1e5 + 10, inf = 1e16 + 10;
long long a[N], b[N], x[N], k[N];
inline bool bad(long long x, long long y) { return inf / x < y; }
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long n;
  cin >> n;
  for (long long i = 0; i < n; i++) cin >> a[i];
  for (long long i = 0; i < n; i++) cin >> b[i];
  for (long long i = 1; i < n; i++) {
    cin >> x[i] >> k[i];
    x[i]--;
  }
  for (long long i = n - 1; i > 0; i--) {
    if (a[i] >= b[i])
      a[x[i]] += a[i] - b[i];
    else {
      if (bad(k[i], b[i] - a[i]) || b[i] > inf) return cout << "NO", 0;
      b[x[i]] += k[i] * (b[i] - a[i]);
    }
  }
  cout << (a[0] < b[0] ? "NO" : "YES");
  return 0;
}
