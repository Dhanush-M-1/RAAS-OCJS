#include <bits/stdc++.h>
using namespace std;
void solve() {
  int a, b, c;
  cin >> a >> b >> c;
  int ans = 0;
  for (int x = 0; x < a + 1; x++) {
    for (int y = 0; y < c / 2 + 1; y++) {
      if (2 * x + y <= b) ans = max(3 * x + 3 * y, ans);
    }
  }
  cout << ans << "\n";
}
int main() {
  int t = 1;
  cin >> t;
  while (t--) solve();
  return 0;
}
