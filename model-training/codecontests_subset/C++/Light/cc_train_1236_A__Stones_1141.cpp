#include <bits/stdc++.h>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t;
  cin >> t;
  for (int _i = 0; _i < t; ++_i) {
    int a, b, c;
    int ans = 0;
    cin >> a >> b >> c;
    for (int x = 0; x <= a; ++x) {
      for (int y = 0; 2 * y <= c; ++y) {
        if (2 * x + y <= b) ans = max(ans, 3 * (x + y));
      }
    }
    cout << ans << "\n";
  }
  return 0;
}
