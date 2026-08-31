#include <bits/stdc++.h>
using namespace std;
long long t, l, r, c;
signed main() {
  cin >> t;
  while (t--) {
    cin >> l >> r >> c;
    if (c < l)
      cout << c << endl;
    else {
      if (r % c == 0)
        cout << r + c << endl;
      else
        cout << ((r / c) + 1) * c << endl;
    }
  }
  return 0;
}
