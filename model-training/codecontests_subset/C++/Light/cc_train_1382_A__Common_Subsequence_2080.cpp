#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long n, m;
  cin >> n >> m;
  vector<long long> a(n), b(m);
  for (long long &x : a) cin >> x;
  for (long long &x : b) cin >> x;
  vector<bool> vis(1005, 0);
  for (long long x : a) vis[x] = 1;
  for (long long y : b) {
    if (vis[y]) {
      cout << "YES\n1 " << y << "\n";
      return;
    }
  }
  cout << "NO\n";
}
int32_t main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0), cout.tie(0);
  long long tc = 1;
  cin >> tc;
  while (tc--) {
    solve();
  }
}
