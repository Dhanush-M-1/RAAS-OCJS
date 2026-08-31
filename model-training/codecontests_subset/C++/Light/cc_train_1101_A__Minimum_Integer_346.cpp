#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  cin >> q;
  for (int i = 0; i < q; i++) {
    int l, r, d;
    cin >> l >> r >> d;
    if (d < l) {
      cout << d;
    } else {
      int f = d - r % d + r;
      cout << f;
    }
    if (i != q - 1) {
      cout << endl;
    }
  }
}
