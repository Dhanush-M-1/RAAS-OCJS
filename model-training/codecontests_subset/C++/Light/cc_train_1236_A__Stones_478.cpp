#include <bits/stdc++.h>
using namespace std;
int main() {
  int i, n, m, t, k = 0, a, b, c;
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    while (c > 1 && b > 0) {
      c -= 2;
      b -= 1;
      k += 3;
    }
    while (a > 0 && b > 1) {
      a -= 1;
      b -= 2;
      k += 3;
    }
    cout << k << endl;
    k = 0;
  }
  return 0;
}
