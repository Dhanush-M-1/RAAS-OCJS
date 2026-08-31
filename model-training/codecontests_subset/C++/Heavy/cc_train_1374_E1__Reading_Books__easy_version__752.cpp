#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long int n, k;
  cin >> n >> k;
  vector<long long int> a, b, c, d;
  a.emplace_back(0), b.emplace_back(0), c.emplace_back(0);
  for (int i = 0; i < n; i++) {
    int x, y, z;
    cin >> x >> y >> z;
    if (y + z == 2) {
      a.emplace_back(x);
    } else if (y == 1) {
      b.emplace_back(x);
    } else if (z == 1) {
      c.emplace_back(x);
    }
  }
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  sort(c.begin(), c.end());
  for (int i = 1; i < ((long long)a.size()); i++) {
    a[i] = a[i] + a[i - 1];
  }
  for (int i = 1; i < ((long long)b.size()); i++) b[i] = b[i] + b[i - 1];
  for (int i = 1; i < ((long long)c.size()); i++) c[i] = c[i] + c[i - 1];
  long long int ans = (long long int)1e18 + 7;
  for (int i = 0; i < min(k + 1, ((long long)a.size())); i++) {
    if (k - i < ((long long)b.size()) && k - i < ((long long)c.size())) {
      ans = min(ans, a[i] + b[k - i] + c[k - i]);
    }
  }
  if (ans == (long long int)1e18 + 7)
    cout << -1 << "\n";
  else
    cout << ans << "\n";
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
