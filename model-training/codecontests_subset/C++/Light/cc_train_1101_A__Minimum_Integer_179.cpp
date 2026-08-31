#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  cin >> q;
  while (q--) {
    int l, r, d;
    cin >> l >> r >> d;
    if (d < l)
      cout << d << endl;
    else {
      if (r % d == 0)
        cout << (r + d) << endl;
      else
        cout << (d - r % d) + r << endl;
    }
  }
  return 0;
}
