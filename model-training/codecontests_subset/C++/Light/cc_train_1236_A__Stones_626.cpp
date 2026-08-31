#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c, res = 0;
    cin >> a >> b >> c;
    while (b > 0 && c >= 2) {
      res += 3;
      b--;
      c -= 2;
    }
    while (a > 0 && b >= 2) {
      res += 3;
      a--;
      b -= 2;
    }
    cout << res << endl;
  }
  return 0;
}
