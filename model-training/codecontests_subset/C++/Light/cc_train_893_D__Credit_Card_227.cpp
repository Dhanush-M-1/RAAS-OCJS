#include <bits/stdc++.h>
using namespace std;
const long long maxn = 100100, mod = 1e9 + 7, maxa = 3e6 + 100, maxb = 27,
                base = 737, base2 = 3079, mod2 = 242121643;
const long long inf = 2e18 + 13;
long long max(long long x, long long y) { return (x > y ? x : y); }
long long min(long long x, long long y) { return (x < y ? x : y); }
long long ps[maxn];
long long pmx[maxn];
long long a[maxn];
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long n, d;
  cin >> n >> d;
  for (int i = 0; i < n; i++) {
    cin >> a[i];
  }
  long long fj = 0;
  for (int i = 0; i < n; i++) {
    ps[i] = a[i] + fj;
    fj = ps[i];
  }
  for (int i = 0; i < n; i++) {
    if (ps[i] > d) {
      cout << -1;
      return 0;
    }
  }
  pmx[n] = -inf;
  for (int i = n - 1; i >= 0; i--) {
    pmx[i] = max(pmx[i + 1], ps[i]);
  }
  long long tmp = 0;
  long long ans = 0;
  for (int i = 0; i < n; i++) {
    if (a[i] != 0) {
      continue;
    }
    if (ps[i] + tmp < 0) {
      long long val = ps[i] + tmp;
      long long mx = d - (pmx[i] + tmp);
      if (val + mx < 0) {
        cout << -1;
        return 0;
      }
      tmp += mx;
      ans++;
    }
  }
  cout << ans << endl;
  return 0;
}
