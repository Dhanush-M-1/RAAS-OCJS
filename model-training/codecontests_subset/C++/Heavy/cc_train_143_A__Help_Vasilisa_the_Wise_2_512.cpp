#include <bits/stdc++.h>
using namespace std;
bool inrange(int y) { return ((y >= 1) && (y <= 9)); }
int main() {
  int r1, r2, c1, c2, d1, d2;
  bool taken[9] = {false};
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int x = (r1 + r2);
  int y = (c1 + c2);
  int z = (d1 + d2);
  int w;
  if (x == y && y == z) {
    if ((r1 + c2 - d1) % 2) {
      cout << "-1\n";
      return 0;
    }
    y = (r1 + c2 - d1) / 2;
    if (!inrange(y)) {
      cout << "-1\n";
      return 0;
    }
    if (taken[y - 1]) {
      cout << "-1\n";
      return 0;
    } else
      taken[y - 1] = true;
    x = r1 - y;
    if (!inrange(x)) {
      cout << "-1\n";
      return 0;
    }
    if (taken[x - 1]) {
      cout << "-1\n";
      return 0;
    } else {
      taken[x - 1] = true;
    }
    w = d2 - y;
    if (!inrange(w)) {
      cout << "-1\n";
      return 0;
    }
    if (taken[w - 1]) {
      cout << "-1\n";
      return 0;
    } else {
      taken[w - 1] = true;
    }
    z = c2 - y;
    if (!inrange(z)) {
      cout << "-1\n";
      return 0;
    }
    if (taken[z - 1]) {
      cout << "-1\n";
      return 0;
    } else {
      taken[z - 1] = true;
    }
    cout << x << " " << y << "\n";
    cout << w << " " << z << "\n";
  } else
    cout << "-1\n";
  return 0;
}
