#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int q, l, r, d, x, y;
  cin >> q;
  for (int i = 1; i <= q; i++) {
    cin >> l >> r >> d;
    if (d < l) {
      cout << d << endl;
    } else {
      y = r / d;
      x = d * (y + 1);
      cout << x << endl;
    }
  }
}
