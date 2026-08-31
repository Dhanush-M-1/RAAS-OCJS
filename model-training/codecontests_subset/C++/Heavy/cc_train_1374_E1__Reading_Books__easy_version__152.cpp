#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n, k;
  cin >> n >> k;
  long long i, j;
  vector<long long> a, b, c;
  for (i = 1; i <= n; i++) {
    long long x, y, z;
    cin >> x >> y >> z;
    if (y == 1 && z == 1) {
      c.push_back(x);
    } else if (y == 1) {
      a.push_back(x);
    } else if (z == 1) {
      b.push_back(x);
    }
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  long long x = a.size();
  long long y = b.size();
  long long z = c.size();
  for (i = 1; i < x; i++) a[i] += a[i - 1];
  for (i = 1; i < y; i++) b[i] += b[i - 1];
  for (i = 1; i < z; i++) c[i] += c[i - 1];
  long long ans = 2e18;
  for (i = 0; i <= k; i++) {
    long long take = i;
    long long atake = k - i;
    long long btake = k - i;
    if (take > z || atake > x || btake > y) continue;
    long long temp = 0;
    if (take) temp += c[take - 1];
    if (atake) temp += a[atake - 1];
    if (btake) temp += b[btake - 1];
    ans = min(ans, temp);
  }
  if (ans == 2e18) ans = -1;
  cout << ans << '\n';
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  long long tt;
  tt = 1;
  while (tt--) {
    solve();
  }
}
