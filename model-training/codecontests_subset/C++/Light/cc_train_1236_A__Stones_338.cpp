#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c, s = 0;
    cin >> a >> b >> c;
    if (b > 0) {
      c /= 2;
      if (b > c) {
        s += c * 3;
        b -= c;
      } else {
        s += b * 3;
        b = 0;
      }
      b = b / 2;
      if (a > b) {
        s += b * 3;
      } else {
        s += a * 3;
      }
      cout << s << endl;
    } else
      cout << 0 << endl;
  }
}
