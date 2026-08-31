#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int n = 0;
    while (b > 0 && c > 1) {
      int p = c / 2;
      int q = b;
      if (p > q) {
        b = 0;
        n += 3 * q;
        break;
      } else {
        c = 0;
        n += 3 * p;
        b -= p;
      }
    }
    while (a > 0 && b > 1) {
      int p = b / 2;
      int q = a;
      if (p > q) {
        a = 0;
        n += 3 * q;
        break;
      } else {
        b = 0;
        n += 3 * p;
        a -= p;
      }
    }
    cout << n << endl;
  }
}
