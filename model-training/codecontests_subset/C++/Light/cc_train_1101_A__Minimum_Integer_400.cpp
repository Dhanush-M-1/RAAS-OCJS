#include <bits/stdc++.h>
using namespace std;
int main() {
  int q, l, r, d;
  cin >> q;
  for (int i = 0; i < q; ++i) {
    cin >> l >> r >> d;
    if (d >= l && d <= r) {
      cout << d - (r % d) + r << endl;
    } else {
      cout << d << endl;
    }
  }
  return 0;
}
