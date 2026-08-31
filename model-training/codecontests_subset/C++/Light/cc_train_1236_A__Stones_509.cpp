#include <bits/stdc++.h>
using namespace std;
void solve() {
  int a, b, c;
  cin >> a >> b >> c;
  int c1 = min(c / 2, b);
  int ans = c1 * 3;
  c -= c1 * 2;
  b -= c1;
  int c2 = min(a, b / 2);
  ans += c2 * 3;
  cout << ans << endl;
}
int main() {
  int t;
  cin >> t;
  while (t--) solve();
  return 0;
}
