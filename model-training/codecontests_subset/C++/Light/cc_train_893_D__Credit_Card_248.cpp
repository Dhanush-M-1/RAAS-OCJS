#include <bits/stdc++.h>
using namespace std;
const int N = 2e5 + 5;
void solve() {
  long long n, d, a[N];
  cin >> n >> d;
  long long mx = 0, mn = 0, ans = 0;
  for (int i = 0; i < (int)n; ++i) {
    cin >> a[i];
    mx += a[i];
    mn += a[i];
    if (a[i] == 0) {
      if (mx < 0) {
        ans += 1;
        mx = d;
      }
      mn = max(mn, 0ll);
    }
    mx = min(mx, d);
    if (mn > d) {
      cout << -1 << "\n";
      return;
    }
  }
  cout << ans << "\n";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) {
    solve();
  }
}
