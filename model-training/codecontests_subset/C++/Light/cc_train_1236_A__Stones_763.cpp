#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int res = 0;
    while ((a >= 1 && b >= 2) || (b >= 1 && c >= 2)) {
      if ((b > c) && a != 0) {
        a--;
        b = b - 2;
        res += 3;
      } else {
        b--;
        c -= 2;
        res = res + 3;
      }
    }
    cout << res << endl;
  }
}
