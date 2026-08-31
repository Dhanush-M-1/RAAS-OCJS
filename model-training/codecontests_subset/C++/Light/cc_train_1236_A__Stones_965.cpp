#include <bits/stdc++.h>
using namespace std;
int main() {
  int t, a, b, c, sum, val;
  cin >> t;
  while (t--) {
    cin >> a >> b >> c;
    val = a + b + c;
    while (b >= 1 && c >= 2) {
      if (b - 1 >= 0 && c - 2 >= 0) {
        b -= 1;
        c -= 2;
      }
    }
    while (a >= 1 && b >= 2) {
      if (a - 1 >= 0 && b - 2 >= 0) {
        a -= 1;
        b -= 2;
      }
    }
    sum = a + b + c;
    cout << val - sum << endl;
  }
  return 0;
}
