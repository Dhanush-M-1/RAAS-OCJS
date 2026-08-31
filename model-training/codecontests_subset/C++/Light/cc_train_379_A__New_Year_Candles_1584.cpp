#include <bits/stdc++.h>
using namespace std;
int main() {
  int x, y, a = 0, z = 0;
  cin >> x >> y;
  z += x;
  while (x) {
    if (x >= y) {
      z += x / y;
      x = x / y + x % y;
    } else {
      break;
    }
  }
  cout << z;
  return 0;
}
