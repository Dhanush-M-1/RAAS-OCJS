#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int q;
  cin >> q;
  while (q--) {
    long long l, r, d;
    cin >> l >> r >> d;
    if (d < l) {
      cout << d << "\n";
    } else {
      cout << r + d - r % d << "\n";
    }
  }
  return 0;
}
