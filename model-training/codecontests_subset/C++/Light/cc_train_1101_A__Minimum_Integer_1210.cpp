#include <bits/stdc++.h>
using namespace std;
int main() {
  int q, k;
  cin >> q;
  long long l, r, d, x;
  for (k = 0; k < q; ++k) {
    cin >> l >> r >> d;
    if (d < l || d > r)
      x = d;
    else {
      if (r % d == 0)
        x = r + d;
      else
        x = r + (d - (r % d));
    }
    cout << x << endl;
  }
  return 0;
}
