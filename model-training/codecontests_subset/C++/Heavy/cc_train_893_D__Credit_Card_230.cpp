#include <bits/stdc++.h>
using namespace std;
void pr_init() {}
void solve() {
  long long n, d;
  cin >> n >> d;
  long long a[n], cu[n], rg[n];
  for (long long i = 0; i < n; i++) cin >> a[i];
  cu[0] = a[0];
  for (long long i = 1; i < n; i++) cu[i] = a[i] + cu[i - 1];
  rg[n - 1] = cu[n - 1];
  for (long long i = n - 2; i >= 0; i--) {
    rg[i] = max(rg[i + 1], cu[i]);
  }
  long long c = 0, cn = 0;
  for (long long i = 0; i < n; i++) {
    if (a[i] == 0) {
      if (c >= 0) continue;
      long long tg = d - rg[i] + (i != 0 ? cu[i - 1] : 0) - c;
      if (tg < 0 || c + tg < 0) {
        cout << "-1\n";
        return;
      }
      c += tg;
      cn++;
      continue;
    }
    c += a[i];
    if (c > d) {
      cout << "-1\n";
      return;
    }
  }
  cout << cn << endl;
}
int32_t main() {
  pr_init();
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  solve();
  return 0;
}
