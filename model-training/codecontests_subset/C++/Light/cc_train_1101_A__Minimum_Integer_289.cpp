#include <bits/stdc++.h>
using namespace std;
int main() {
  long long int T, N, i, g, s, l, r, d, x, y, x1, y1;
  cin >> T;
  while (T--) {
    cin >> l >> r >> d;
    x = r / d;
    y = l / d;
    y1 = (y - 1) * d;
    x1 = (x + 1) * d;
    if (y == 0)
      cout << x1 << endl;
    else if (l > d)
      cout << d << endl;
    else if (l == d)
      cout << x1 << endl;
  }
  return 0;
}
