#include <bits/stdc++.h>
using namespace std;
int main() {
  int q, l, r, d;
  cin >> q;
  while (q--) {
    cin >> l >> r >> d;
    if (d < l || d > r) {
      cout << d << endl;
    } else if (d == r) {
      cout << 2 * d << endl;
    } else if (d < r) {
      cout << ((r / d) + 1) * d << endl;
    }
  }
  return 0;
}
