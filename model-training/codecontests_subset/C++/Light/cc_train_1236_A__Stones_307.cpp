#include <bits/stdc++.h>
using namespace std;
mt19937 rng32(chrono::steady_clock::now().time_since_epoch().count());
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int ans = -1;
    for (int x = 0; x < a + 1; x++) {
      for (int y = 0; y <= c; y += 2) {
        if (y / 2 + 2 * x <= b) {
          ans = max(ans, 3 * x + y + y / 2);
        }
      }
    }
    cout << ans << '\n';
  }
}
