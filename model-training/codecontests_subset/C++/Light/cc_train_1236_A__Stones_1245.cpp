#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int m, ans = 0;
    m = min(b, c / 2);
    ans += m * 3;
    b = b - m;
    c -= 2 * m;
    m = min(a, b / 2);
    ans += m * 3;
    cout << ans << endl;
  }
}
