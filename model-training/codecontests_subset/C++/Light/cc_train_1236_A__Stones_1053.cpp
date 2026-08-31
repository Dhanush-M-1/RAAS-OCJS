#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, a, b, c;
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    int ans = 0;
    if (c / 2 <= b)
      ans += c / 2 * 2 + c / 2, b -= c / 2;
    else {
      cout << b * 3 << endl;
      continue;
    }
    if (b / 2 <= a)
      cout << ans + b / 2 * 2 + b / 2 << endl;
    else
      cout << ans + a * 3 << endl;
  }
}
