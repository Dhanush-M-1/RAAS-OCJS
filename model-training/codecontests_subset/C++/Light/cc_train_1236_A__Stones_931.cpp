#include <bits/stdc++.h>
using namespace std;
int main() {
  int T;
  cin >> T;
  while (T--) {
    int a, b, c;
    cin >> a >> b >> c;
    int ans = 0;
    if (c >= 2 * b) {
      ans += b * 3;
      b = 0;
    } else {
      ans += c / 2 * 3;
      b -= c / 2;
    }
    if (b >= 2 * a)
      ans += a * 3;
    else
      ans += b / 2 * 3;
    cout << ans << endl;
  }
}
