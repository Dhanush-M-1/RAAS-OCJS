#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int ans = 0;
    while (b > 0 && c > 1) {
      b--;
      c -= 2;
      ans += 3;
    }
    while (a > 0 && b > 1) {
      a--;
      b -= 2;
      ans += 3;
    }
    cout << ans << endl;
  }
}
