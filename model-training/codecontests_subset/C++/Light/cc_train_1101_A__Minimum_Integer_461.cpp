#include <bits/stdc++.h>
using namespace std;
int main() {
  int q, i, l, r, d;
  cin >> q;
  for (i = 0; i < q; i++) {
    cin >> l >> r >> d;
    int x = r / d;
    if ((d * 1) < l)
      cout << d * 1 << endl;
    else if ((x * d) <= r)
      cout << ((x + 1) * d) << endl;
  }
  return 0;
}
