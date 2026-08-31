#include <bits/stdc++.h>
using namespace std;
int main() {
  int t;
  cin >> t;
  while (t--) {
    int a, b, c;
    cin >> a >> b >> c;
    int a1 = a, b1 = b, c1 = c;
    int v = 0, h = 0;
    while (a1 > 0 && b1 > 1) {
      v += 3;
      --a1;
      b1 -= 2;
    }
    while (b1 > 0 && c1 > 1) {
      v += 3;
      --b1;
      c1 -= 2;
    }
    while (b > 0 && c > 1) {
      h += 3;
      --b;
      c -= 2;
    }
    while (a > 0 && b > 1) {
      h += 3;
      --a;
      b -= 2;
    }
    cout << max(v, h) << endl;
  }
  return 0;
}
