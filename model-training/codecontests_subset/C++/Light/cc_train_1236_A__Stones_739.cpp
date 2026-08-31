#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, a, b, c, t;
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    n = 0;
    int na = 0, nb = 0;
    if (b == 0)
      cout << 0 << endl;
    else {
      if (b >= 1 && c >= 2) {
        c = c / 2;
        if (c <= b) {
          na = (c * 2) + c;
          b = b - c;
        } else {
          na = (b * 2) + b;
          b = 0;
        }
      }
      if (b >= 2 && a > 0) {
        b = b / 2;
        if (b <= a) {
          nb = (b * 2) + b;
        } else {
          nb = (a * 2) + a;
        }
      }
      n = na + nb;
      cout << n << endl;
    }
  }
  return 0;
}
