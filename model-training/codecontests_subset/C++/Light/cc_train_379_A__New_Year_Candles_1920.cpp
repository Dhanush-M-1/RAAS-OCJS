#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b, ans = 0, d, e;
  cin >> a >> b;
  ans = a + (a / b);
  d = b;
  e = (a / b) + (a % b);
  while (true) {
    if ((e) >= d) {
      ans += (e / d);
      e = (e % d) + (e / d);
    } else {
      break;
    }
  }
  cout << ans;
  return 0;
}
