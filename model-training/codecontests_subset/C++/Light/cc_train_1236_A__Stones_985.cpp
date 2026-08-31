#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, a, b, c, n, s = 0;
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    n = (b - c / 2);
    if (n <= 0)
      s += b * 2, s += b;
    else {
      s += c / 2 * 2, s += c / 2;
      b -= c / 2;
      n = a - b / 2;
      if (n <= 0)
        s += a * 2, s += a;
      else {
        s += b / 2 * 2, s += b / 2;
        a -= b / 2;
      }
    }
    cout << s << endl;
    s = 0;
  }
}
