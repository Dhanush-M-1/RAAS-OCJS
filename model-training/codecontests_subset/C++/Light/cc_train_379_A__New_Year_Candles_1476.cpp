#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, ans = 0, var = 0;
  cin >> a >> b;
  while (a > 0) {
    ans += a;
    var += a % b;
    a /= b;
    if (var >= b) {
      a += var / b;
      var -= b * (var / b);
    }
  }
  cout << ans << "\n";
}
