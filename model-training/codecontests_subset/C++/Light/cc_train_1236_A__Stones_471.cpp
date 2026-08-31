#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, a, b, c, x;
  cin >> t;
  while (t--) {
    x = 0;
    cin >> a >> b >> c;
    if (b >= (c / 2)) {
      x = 3 * (c / 2);
      b = b - (c / 2);
      if (a >= (b / 2)) {
        x = x + 3 * (b / 2);
      } else
        x = x + (3 * a);
    } else {
      x = b * 3;
      b = 0;
    }
    cout << x << endl;
  }
}
