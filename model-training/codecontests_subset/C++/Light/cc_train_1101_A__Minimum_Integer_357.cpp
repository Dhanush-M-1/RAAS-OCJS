#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  cin >> q;
  while (q--) {
    long long int l, r, x, y, d;
    cin >> l >> r >> d;
    if (d < l || d > r)
      cout << d << endl;
    else {
      x = (r + 1) / d;
      y = x * d;
      if (y <= r) y = (x + 1) * d;
      cout << y << endl;
    }
  }
  return 0;
}
