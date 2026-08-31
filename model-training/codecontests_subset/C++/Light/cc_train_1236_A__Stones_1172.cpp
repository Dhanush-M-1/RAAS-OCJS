#include <bits/stdc++.h>
using namespace std;
void solve() {
  long long a, b, c, s = 0;
  cin >> a >> b >> c;
  if ((2 * b) <= c) {
    s = 3 * b;
  } else {
    b = b - c / 2;
    s = s + (3 * (c / 2));
    if ((2 * a) <= b) {
      s = s + 3 * a;
    } else {
      a = a - b / 2;
      s = s + (3 * (b / 2));
    }
  }
  cout << s << "\n";
}
signed main() {
  long long t = 1;
  cin >> t;
  while (t--) {
    solve();
  }
}
