#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, a, b, c, ans;
  cin >> t;
  while (t--) {
    ans = 0;
    cin >> a >> b >> c;
    if (c / 2 > b)
      ans += b;
    else {
      ans += c / 2;
      if ((b - c / 2) / 2 > a)
        ans += a;
      else
        ans += (b - c / 2) / 2;
    }
    cout << 3 * ans << "\n";
  }
  return 0;
}
