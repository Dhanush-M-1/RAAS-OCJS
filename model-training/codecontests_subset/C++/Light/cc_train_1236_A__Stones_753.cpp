#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, a, b, c;
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    int ans = 3 * min(b, c / 2);
    b -= ans / 3;
    ans += 3 * min(a, b / 2);
    cout << ans << endl;
  }
  return 0;
}
