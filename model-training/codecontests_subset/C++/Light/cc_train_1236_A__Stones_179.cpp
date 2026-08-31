#include <bits/stdc++.h>
using std::cin;
using std::cout;
int main() {
  int t, a, b, c, res = 0;
  cin >> t;
  for (int i = 0; i < t; i++) {
    cin >> a >> b >> c;
    if (b > c / 2) {
      res += 3 * (c / 2);
      b -= c / 2;
      if (a > b / 2) {
        res += 3 * (b / 2);
      } else {
        res += 3 * a;
      }
    } else {
      res += 3 * b;
    }
    cout << res << "\n";
    res = 0;
  }
}
