#include <bits/stdc++.h>
using namespace std;
int main() {
  int w, x, y, z, a, b, c1, c2, d1, d2;
  cin >> a >> b;
  cin >> c1 >> c2;
  cin >> d1 >> d2;
  y = (c2 + d1 - a) / 2;
  z = b - y;
  w = c2 - y;
  x = c1 - z;
  if (w == x || w == y || w == z || x == y || x == z || y == z || w < 1 ||
      x < 1 || y < 1 || z < 1 || w > 9 || x > 9 || y > 9 || z > 9)
    cout << "-1" << endl;
  else
    cout << x << " " << w << endl << z << " " << y << endl;
  return 0;
}
