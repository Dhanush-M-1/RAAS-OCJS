#include <bits/stdc++.h>
using namespace std;
int t, a, b, c, ans;
int main() {
  cin >> t;
  while (t--) {
    ans = 0;
    cin >> a >> b >> c;
    ans += min(b, c / 2) * 3;
    b -= min(b, c / 2);
    ans += min(b / 2, a) * 3;
    cout << ans << "\n";
  }
}
