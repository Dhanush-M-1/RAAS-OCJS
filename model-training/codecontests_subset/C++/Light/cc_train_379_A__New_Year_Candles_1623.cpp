#include <bits/stdc++.h>
using namespace std;
int main() {
  int a, b;
  while (cin >> a >> b) {
    int ex = 0, ans = 0;
    while (true) {
      ans += a;
      a += ex;
      ex = a % b;
      a /= b;
      if (a == 0 && ex < b) break;
    }
    cout << ans << endl;
  }
  return 0;
}
