#include <bits/stdc++.h>
using namespace std;
const long long mod = 1e9 + 7;
const long long inf = 0x3f3f3f3f;
const long long llinf = 1e18;
const long long nax = 0;
void solve() {
  long long l, r, d;
  cin >> l >> r >> d;
  if (d < l) {
    cout << d << '\n';
    return;
  }
  cout << d * (r / d + 1) << '\n';
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie();
  cout.tie();
  int t;
  cin >> t;
  while (t--) {
    solve();
  }
}
