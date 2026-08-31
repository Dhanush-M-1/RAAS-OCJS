#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, k, a, b, c, req, x;
  cin >> t;
  for (k = 0; k < t; k++) {
    cin >> a >> b >> c;
    req = 0;
    x = min(b, c / 2);
    if (b >= x) {
      req += (x * 2) + x;
      c -= (x * 2);
      b -= x;
    }
    x = min(a, b / 2);
    if (a >= x) {
      req += (x * 2) + x;
      b -= (x * 2);
      a -= x;
    }
    cout << req << "\n";
  }
}
