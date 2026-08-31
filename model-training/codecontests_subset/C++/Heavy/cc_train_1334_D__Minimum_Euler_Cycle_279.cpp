#include <bits/stdc++.h>
#pragma GCC optimize("O3,unroll-loops")
#pragma GCC target( \
    "sse,sse2,sse3,ssse3,sse4,popcnt,abm,mmx,avx,tune=native,avx,avx2,fma")
using namespace std;
vector<long long> v;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long a = 0, b = 0, c, d, e, f = 0, l, g, m, n, k, i, j, t, p, q, r, lo,
            hi, mid;
  cin >> t;
  while (t--) {
    cin >> n >> l >> r;
    if (l == n * (n - 1) + 1) {
      cout << 1 << '\n';
      continue;
    }
    lo = 1;
    hi = n;
    while (lo <= hi) {
      mid = (lo + hi) / 2;
      q = n - mid;
      p = q * (q + 1) + 1;
      p = n * (n - 1) + 1 - p;
      if (p >= l) {
        hi = mid - 1;
      } else {
        k = mid;
        lo = mid + 1;
      }
    }
    g = r - l + 1;
    q = n - k;
    p = q * (q + 1) + 1;
    p = n * (n - 1) + 1 - p;
    d = l - p;
    d = ceil(1.0 * d / 2.0);
    d += k;
    if (l % 2 == 0) {
      cout << d << ' ';
      if (d == n) {
        k++;
        d = k + 1;
      } else {
        d++;
      }
      l++;
    }
    for (i = l; i <= r; i++) {
      if (i % 2) {
        if (k == n) {
          cout << 1 << ' ';
        } else
          cout << k << ' ';
      } else {
        cout << d << ' ';
        if (d == n) {
          k++;
          d = k + 1;
        } else {
          d++;
        }
      }
    }
    cout << '\n';
  }
  return 0;
}
