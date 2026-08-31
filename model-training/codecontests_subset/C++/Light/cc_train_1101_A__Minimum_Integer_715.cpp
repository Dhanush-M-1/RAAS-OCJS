#include <bits/stdc++.h>
using namespace std;
int main() {
  int q;
  cin >> q;
  while (q--) {
    int l, r, x;
    cin >> l >> r >> x;
    if (x < l or x > r)
      cout << x << endl;
    else
      cout << x - r % x + r << endl;
  }
  return 0;
}
