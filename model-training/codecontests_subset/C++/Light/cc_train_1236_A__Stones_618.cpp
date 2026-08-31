#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t, a, b, c;
  cin >> t;
  while (t--) {
    int ans = 0;
    cin >> a >> b >> c;
    if (b >= 1 && c >= 2) {
      int mn = min(c / 2, b);
      ans += 3 * mn;
      if (mn == b) {
        b -= mn;
        c -= 2 * mn;
      } else {
        b -= mn;
        c -= mn;
      }
    }
    if (a >= 1 && b >= 2) {
      int mn = min(b / 2, a);
      ans += 3 * mn;
      if (mn == a) {
        a -= mn;
        b -= 2 * mn;
      } else {
        a -= b / 2;
        b -= b / 2;
      }
    }
    cout << ans << "\n";
  }
}
