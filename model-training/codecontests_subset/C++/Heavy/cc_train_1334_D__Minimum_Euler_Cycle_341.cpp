#include <bits/stdc++.h>
using namespace std;
const long long N = 3e5 + 5, K = 11, M = N * 4;
const long long MOD = 998244353, oo = 1e9, OO = 1e18, mod = MOD;
const double pi = acos(-1), eps = 1e-17;
long long di[] = {0, 0, 1, -1};
long long dj[] = {1, -1, 0, 0};
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  ;
  long long t;
  cin >> t;
  while (t--) {
    long long n, l, r;
    cin >> n >> l >> r;
    long long now = 0, st = 1;
    long long sum = l;
    for (long long i = n - 1; i > 0; i--) {
      now = i * 2;
      l -= now;
      r -= now;
      if (l <= 0) {
        l += now;
        r += now;
        sum = i;
        break;
      }
      st++;
    }
    long long ans = 0;
    long long p = 0;
    for (long long i = sum; "Hello"; i--) {
      long long tmp = i * 2;
      long long dor = st;
      if (st == n) dor = 1, tmp = 1;
      long long cnt = st + 1;
      while (tmp--) {
        ans++;
        if (ans >= l && ans <= r) {
          cout << dor << " ";
        }
        if (dor == st)
          dor = cnt++;
        else
          dor = st;
        if (ans > r) goto A;
      }
      st++;
      if (ans > r) goto A;
    }
  A:
    cout << endl;
  }
}
