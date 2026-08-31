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
      int w = r % d;
      cout << r + d - w << endl;
    }
  }
}
