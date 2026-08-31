#include <bits/stdc++.h>
using namespace std;
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long T;
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cin >> T;
  while (T--) {
    long long n, l, r;
    cin >> n >> l >> r;
    long long g = n * (n - 1) + 1;
    if (l == g - 1) {
      if (r == g)
        cout << n << " 1" << '\n';
      else
        cout << "1" << '\n';
      continue;
    }
    if (l == g) {
      cout << "1" << '\n';
      continue;
    }
    long long k = (l + 1) / 2, ls = 2, ln, p = 0;
    while (p + (n - ls + 1) < k) p += (n - ls + 1), ls++;
    ln = ls;
    while (p + 1 < k) ln++, p++;
    long long lo, los = 1, loo;
    p = 0;
    k = l / 2 + 1;
    while (p + (n - los) < k) p += (n - los), los++;
    loo = los;
    lo = n - los;
    while (p + 1 < k) p++, lo--;
    for (long long i = l; i <= r; i++) {
      if (i & 1) {
        cout << loo << " ";
        lo--;
        if (!lo) loo++, lo = n - loo;
        if (loo == n) loo = 1;
      } else {
        cout << ln << " ";
        if (ln == n) {
          ln = (++ls);
        } else
          ln++;
      }
    }
    cout << '\n';
  }
  return 0;
}
