#include <bits/stdc++.h>
using namespace std;
int n, a, b, c, res, ans = 0;
int main(void) {
  ios ::sync_with_stdio(0);
  cin.tie(0);
  cin >> n >> a >> b >> c;
  for (int y = 0; y <= b; ++y) {
    for (int z = 0; z <= c; ++z) {
      res = n - y - 2 * z;
      if (res >= 0 && res * 2 <= a) {
        ++ans;
      }
    }
  }
  cout << ans << "\n";
  return 0;
}
