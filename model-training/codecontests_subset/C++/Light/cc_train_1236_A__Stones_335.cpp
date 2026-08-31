#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int ans = 0;
    ans += min(b, c / 2);
    b -= min(b, c / 2);
    ans += min(a, b / 2);
    cout << 3 * ans << '\n';
  }
}
