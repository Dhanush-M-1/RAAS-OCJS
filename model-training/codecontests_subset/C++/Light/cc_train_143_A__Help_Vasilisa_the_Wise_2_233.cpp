#include <bits/stdc++.h>
using namespace std;
int main() {
  int r1, r2, c1, c2, d1, d2;
  cin >> r1 >> r2 >> c1 >> c2 >> d1 >> d2;
  int x1 = (d1 - r2 + c1) / 2;
  int y1 = r1 - x1;
  int x2 = c1 - x1;
  int y2 = (r2 - c1 + x1);
  if (x1 == x2 || x1 == y1 || x1 == y2 || x2 == y1 || x2 == y2 || y1 == y2) {
    cout << "-1" << endl;
  } else if (x1 == 0 || y1 == 0 || x2 == 0 || y2 == 0 || x1 > 9 || x2 > 9 ||
             y1 > 9 || y2 > 9) {
    cout << "-1" << endl;
  } else {
    cout << x1 << " " << y1 << endl;
    cout << x2 << " " << y2 << endl;
  }
  return 0;
}
