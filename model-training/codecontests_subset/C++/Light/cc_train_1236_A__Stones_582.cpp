#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, j, n, m, t, p, x, k, ans, a, b, c;
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    ans = 0;
    x = c / 2;
    if (b >= x) {
      ans += (3 * x);
      b = b - x;
    } else {
      ans += 3 * b;
      b = 0;
    }
    x = b / 2;
    if (a >= x) {
      ans += (3 * x);
    } else {
      ans += 3 * a;
    }
    cout << ans << endl;
  }
}
