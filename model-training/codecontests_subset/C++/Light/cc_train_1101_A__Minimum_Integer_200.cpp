#include <bits/stdc++.h>
using namespace std;
signed main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  cout.tie(0);
  long long t;
  cin >> t;
  while (t--) {
    long long l, r, d;
    cin >> l >> r >> d;
    if (l <= d && d <= r) {
      cout << (r / d + 1) * d << endl;
    } else if (d > r)
      cout << d << endl;
    else if (d < l)
      cout << d << endl;
  }
}
