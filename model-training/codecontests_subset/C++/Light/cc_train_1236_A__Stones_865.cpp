#include <bits/stdc++.h>
using namespace std;
const int MX = 1e5;
int t, a, b, c;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    int ans = 0;
    while (b > 0 && c > 1) {
      ans += 3;
      b -= 1;
      c -= 2;
    }
    while (a > 0 && b > 1) {
      ans += 3;
      b -= 2;
      a -= 1;
    }
    cout << ans << endl;
  }
}
