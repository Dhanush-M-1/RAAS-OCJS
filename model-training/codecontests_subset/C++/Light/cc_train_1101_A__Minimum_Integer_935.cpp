#include <bits/stdc++.h>
using namespace std;
int main() {
  long long l, r, d, x, q;
  cin >> q;
  for (int i = 0; i < q; i++) {
    cin >> l >> r >> d;
    if (d > r) {
      cout << d << endl;
      continue;
    }
    if (d < l) {
      cout << d << endl;
      continue;
    }
    x = ((r / d) + 1) * d;
    cout << x << endl;
  }
}
