#include <bits/stdc++.h>
using namespace std;
int t, a, b, c, x, y;
int main() {
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    x = min(b, c / 2);
    b -= x;
    y = min(a, b / 2);
    cout << 3 * (x + y) << endl;
  }
  return 0;
}
