#include <bits/stdc++.h>
using namespace std;
const long long INF = 1e9;
const long long MOD = 1e9 + 7;
long long power(long long a, long long b, long long m = MOD) {
  long long ans = 1;
  while (b > 0) {
    if (b & 1) ans = (ans * a) % m;
    a = (a * a) % m;
    b >>= 1;
  }
  return ans;
}
long long dir[] = {-1, 0, 1, 0, -1};
long long dx[] = {1, 1, 0, -1, -1, -1, 0, 1};
long long dy[] = {0, 1, 1, 1, 0, -1, -1, -1};
void solve() {
  long long i, ans = 2, n;
  cin >> n;
  vector<long long> x(n), h(n);
  for (i = 0; i < n; i++) cin >> x[i] >> h[i];
  if (n <= 2) {
    cout << n << "\n";
    return;
  }
  for (i = 1; i < n - 1; i++) {
    if (x[i] - h[i] > x[i - 1])
      ans++;
    else if (x[i] + h[i] < x[i + 1]) {
      ans++;
      x[i] = x[i] + h[i];
    }
  }
  cout << ans << "\n";
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t;
  t = 1;
  while (t--) solve();
}
