#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  cin >> q;
  for (; q > 0; q--) {
    int l, r, d;
    cin >> l >> r >> d;
    if (d < l)
      cout << d << endl;
    else {
      l = r - (r % d) + d;
      cout << l << endl;
    }
  }
}
