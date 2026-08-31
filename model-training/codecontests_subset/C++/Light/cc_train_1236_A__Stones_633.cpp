#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, a, b, c, q = 0;
  cin >> t;
  for (int i = 0; i < t; i++) {
    q = 0;
    cin >> a >> b >> c;
    while (b >= 1 && c > 1) {
      b--;
      c = c - 2;
      q++;
    }
    if (b >= 2) {
      while (a >= 1 && b > 1) {
        a--;
        b = b - 2;
        q++;
      }
    }
    cout << 3 * q << endl;
  }
}
