#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  for (int i = 0; i < t; i++) {
    int a, b, c;
    cin >> a >> b >> c;
    if (b == 0) {
      cout << "0\n";
    } else if (a == 0) {
      if (b > c / 2) {
        cout << ((c / 2) * 3) << "\n";
      } else if (b <= c / 2) {
        cout << (b * 3) << "\n";
      }
    } else if (c == 0) {
      if (a > b / 2) {
        cout << ((b / 2) * 3) << "\n";
      } else if (a <= b / 2) {
        cout << (a * 3) << "\n";
      }
    } else {
      int ans = 0;
      if (b > c / 2) {
        ans += (c / 2) * 3;
        b -= c / 2;
      } else if (b <= c / 2) {
        ans += (b * 3);
        b = 0;
      }
      if (a > b / 2) {
        ans += (((b / 2) * 3));
      } else if (a <= b / 2) {
        ans += (a * 3);
      }
      cout << ans << '\n';
    }
  }
}
