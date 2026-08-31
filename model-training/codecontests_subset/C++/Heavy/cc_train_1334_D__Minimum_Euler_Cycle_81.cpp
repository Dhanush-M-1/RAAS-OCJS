#include <bits/stdc++.h>
using namespace std;
const long long maxn = 2e5 + 100;
const long long mod = 1e9 + 7;
const long long inf = 1e18;
long long q, n, l, r, s, t;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  ;
  cin >> q;
  while (q--) {
    cin >> n >> l >> r;
    s = 0;
    t = 1;
    for (long long i = 1; i <= n; i++) {
      s += 2 * (n - i);
      if (s >= l) {
        s -= 2 * (n - i);
        t = i;
        break;
      }
    }
    bool f = 0;
    if (r == n * (n - 1) + 1) f = 1, r--;
    while (s < r) {
      for (long long i = t + 1; i <= n; i++) {
        if (++s >= l) cout << t << " ";
        if (s == r) break;
        if (++s >= l) cout << i << " ";
        if (s == r) break;
      }
      t++;
    }
    if (f) cout << 1;
    cout << '\n';
  }
  return 0;
}
